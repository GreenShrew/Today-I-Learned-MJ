// 06_Session_Server.js

const http = require('http');
const fs = require('fs').promises;
const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie='')=> 
    cookie
        .split(';')
        .map(v=>v.split('='))
        .reduce((acc,[k, v])=>{
            acc[k.trim()] = decodeURIComponent(v);
            return acc
        }, { });

const session = {};

http.createServer(async (req, res)=>{
    // 전달된 쿠키를 찢어서 객체 형식으로 만드는 함수
    const cookies = parseCookies(req.headers.cookie);

    if(req.url.startsWith('/login')){   // 전달된 쿠키를 파싱하여 name값 얻기
        const {query} = url.parse(req.url); 
        const {name} = qs.parse(query);

        // 세션, 쿠키의 수명 계산
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 1);

        // 세션의 키값
        const uniqueInt = Date.now();   // 세션 객체에 저장하기 위한 고유 키값

        // Cookies - name = ${uniqueInt}
        // Session - ${uniqueInt} : '홍길동'
        // 세션의 값들은 서버에서 관리하되, 세션에 해당 값이 있는지 없는지는 쿠키값이 있는지 없는지를 검사해서 조회한다.

        session[uniqueInt] = {  // 고유 키값과 함께 이름과 유효시간 저장
            name,   // name:name
            expires,    // expires:expires
        };

        res.writeHead(302,{
            Location: '/',
            'Set-Cookie': `session=${uniqueInt}; Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
        }); // 쿠키에는 고유 키 값만 session이라는 키와 함께 저장한다.

        res.end();


    }else if(cookies.session && session[cookies.session].expires > new Date()){ // session이라는 이름의 쿠키가 있는지 확인 && 세션의 수명 최종 시간이 현재 시간보다 큰 값인가 확인
        res.writeHead(200, {'Content-Type':'text/plain; charset=utf-8'});
        res.end(`${session[cookies.session].name}님 안녕하세요`)
    }else{
        try{
            const data = await fs.readFile('./06_Cookie_page.html');
            // res.writeHead(200, {'Set-Cookie': 'mycookie=test'}); 처음에 예시 보여준다고 만든 코드. 만든 쿠키를 보내준다.
            res.end(data);
        }catch(err){
            res.writeHead(500, {'Context-Type':'text/plain; charset=utf-8'});
            console.error(err.message);
        }
    }

}).listen(8090, () => {
    console.log('8090 포트에서 서버 대기중입니다!');
});