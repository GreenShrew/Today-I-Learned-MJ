// 06_Cookie_Server02.js

const http = require('http');
const fs = require('fs').promises;

const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie='')=>  // 중괄호 없이 이를 쓸 수 있는 경우가...01_Basic에서 다시 확인해!
    cookie
        .split(';')
        // cookie1=test1;cookie2=test2  ';'으로 구분되어 전달된 쿠키를 분리한다!

        .map(v=>v.split('='))   // 분리된 쿠키를 v에 담고, 이를 분리된 값이 없을때까지 반복실행한 뒤 다시 v에 저장한다.
        // v : cookie1 test1, v : cookie2 test2
        // 분리된 쿠키들이 v에 전달되어 그들을 다시 '='로 분리한다.
        // v에 분리된 쿠키가 저장된다!
        
        .reduce((acc,[k, v])=>{
            acc[k.trim()] = decodeURIComponent(v);
            return acc
        }, { });
        // 그렇게 분리된 둘은 k와 v에 전달되어 객체 형태를 이루고, acc에 저장되어 최종적으로 객체 형태의 데이터로 리턴된다!
        // 마지막 { } : 분리된 쿠키들이 [k, v] 형태로 변형되어 "객체로 저장취함된다"는 의미이다.



http.createServer( async (req, res)=>{
    // 요청을 받을때마다 쿠키를 얻어낼 수 있다.
    // 다만 요청마다 키값, 밸류값을 따로 얻기 위해서는 가공을 해야한다. 별도로 이걸 따로 떼주는 함수는 없다...
    const cookies = parseCookies(req.headers.cookie);    // 전달된 쿠키 객체에서 각 쿠키들은 키:밸류 로 전부 가공해서 객체 형식으로 변환 후 cookies 변수에 저장했다.  
    console.log(cookies);   // parseCookies 함수로 가공된 쿠키를 출력해본다.

//    res.writeHead(200, {'Set-Cookie': 'mycookie=test'});
//    res.end('Hellow Cookie'); 이건 확인용...
    if(req.url.startsWith('/login')){   // url이 '/login'으로 시작하는 경우

        // 쿼리스트링 분리
        const {query} = url.parse(req.url); // 저번에 공부했던 보내지는 주소 파싱하는 방법이다. 이걸 이용해서 parameter를 알아낸다.
        // http://127.0.0.1:8090/login?name=홍길동 에서
        // 'name=홍길동' 을 분리해서 query라는 변수에 저장!
        console.log(query);

        const {name} = qs.parse(query);
        // 쿠키 유효 시간을 위한 현재 날짜시간 데이터 생성
        const expires = new Date();
        // 쿠키의 유효시간을 현재 시간 +1 분으로 설정한다.
        expires.setMinutes(expires.getMinutes() + 1);
        
        res.writeHead(302,{
            Location: '/',
            'Set-Cookie': `name=${encodeURIComponent(name)}; Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
        }); // 경로 및 위치/, Expires 유효시간, HttpOnly 쿠키의 접근을 http 방식으로만으로 제한

        res.end();

    }else if(cookies.name){  // 로그인이 되서 현재 name 세션값이 존재하는 경우
        res.writeHead(500, {'Content-Type':'text/plain; charset=utf-8'});
        res.end(`${cookies.name}님 안녕하세요`)

    }else{  // 이도저도 아닌 경우, 현재 아무도 로그인하지도 않고 url도 /login이 아닌 경우
        try{
            const data = await fs.readFile('./06_Cookie_page.html');
            // res.writeHead(200, {'Set-Cookie': 'mycookie=test'}); 처음에 예시 보여준다고 만든 코드. 만든 쿠키를 보내준다.
            res.end(data);
        }catch(err){
            res.writeHead(500, {'Context-Type':'text/plain; charset=utf-8'});
            console.error(err.message);
        }
    }
    
}).listen(8090, ()=>{
    console.log('8090 포트에서 서버가 대기중입니다!');
});