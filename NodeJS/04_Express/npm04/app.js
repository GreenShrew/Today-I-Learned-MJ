const express = require('express');
const path = require('path');

// Express 설정
const app = express();
app.set('port', process.env.PORT || 3000);


// 추가 설치 모듈 require -------------------------
// 필요에 의해 추가적으로 설치하는 모듈!
// 각각의 요청과 응답에 대한 필요 정보를 보기 위한 모듈 -> GET / 500 22.895 ms - 1673 이런식으로 출력된다.
const morgan = require('morgan');
// 쿠키 사용을 http 서버때보다 간결하게 사용하기 위한 모듈
const cookieParser = require('cookie-parser');
// 세션 사용을 http 서버때보다 간결하게 사용하기 위한 모듈
const session = require('express-session');
// 요청의 본분을 해석 및 구분하는 모듈
const bodyParser = require('body-parser');
// ------------------------------------------------


// 공통 미들웨어 설정 ------------------------------
// 설치하고 require 한다고 바로 쓸 수 있는게 아니다!
app.use(morgan('dev'));
// 실행 결과 : GET / 200 5.316 ms - 165
// method 방식, 응답 결과 코드, 요청과 실행에 걸린 시간 등등...이런걸 보여준다.
// app.use(morgan('combined)); 명령으로 더 자세한 내용을 볼 수도 있다.

app.use(cookieParser());
app.use(express.json());    // 바디파서 json : json 사용을 위한 모듈
app.use(express.urlencoded({extended:true}));   // 바디파서 폼 데이터 모듈
// app.use(body-Parser.json()); // 일단 안 쓰기 때문에 주석처리
// app.use(body-bodyParser.urlencoded({extended:false}));   // 일단 안 쓰기 때문에 주석처리
app.use(session({
    resave:false,
    saveUninitialized:false,
    secret:"KMJ",
}));    // 세션을 활용한 미들웨어
// 이렇게 준비를 해야 세션도 쓰고, 쿠기도 쓰고, 전달된 내용을 body-parser로 값을 추출하고 할 수 있다...
// ----------------------------------------------





app.get('/', (req, res)=>{

    // http 서버에서 쿠키를 얻어 오거나 저장하는 방식
    // 기존에 HTTP 서버에서 만드는 방식
    /*
    console.log(req.url, req.headers.cookie);
    res.writeHead(200, {'Set-Cookie':'mycookie=test'});
    res.writeHead(302,{Location:'/', 'Set-cookie':`name=${encodeURIComponent(name)}; Expires=${expires.toGmtString()}; HttpOnly, path=/`,});
    */

    // express 서버에서 쿠키를 읽어오거나 저장하는 방식
    /*
    1. 저장된 쿠키를 불러와서 활용할 변수 req.cookies
    console.log(req.cookies);
    2. 새로운 쿠키의 저장
    const name = 'HongGildong';
    res.cookie('name', encodeURIComponent(name), {
        expires:new Date(),
        httpOnly:true,
        path:'/'
    });
    3. 쿠키의 삭제
    res.clearCookie('name', encodeURIComponent(name), {
        httpOnly:true,
        path:'/'
    });
    */

    console.log(req.cookiew); // 쿠키들을 모두 읽어서 출력
    console.log(req.cookies.test);  // 쿠키들 중에서 test 만 출력
    res.cookie('test', 'cookietest',{   // 쿠키에 특정값을 저장
        httpOnly:true,
        path:'/'
    });

    // id 라는 이름의 쿠키가 있으면 OOO님 반갑습니다 를 send 한다.
    if(req.cookies.id){
        res.send(`${req.cookies.id}님 안녕하세요 <br><a href="logout">로그아웃</a>`);
    }else{
        res.sendFile(path.join(__dirname, '/index.html'))
    }

});


app.post('/login', (req, res)=>{
    // localhost:3000/login?id=hong 이런식으로 전달될 것이다. 물론 post 방식이라 주소에는 안 보인다.
    // http 서버에서 전달 파라미터를 분해하는 과정
    // const {query} = url.parse(req.url);
    // const {name} = qs.parse(query);

    // express 서버에서 전달 파라미터를 활용하는 과정
    // console.log(req.body.name);  한줄로 끝난다!
    const name = req.body.name;

    const expires = new Date();
    expires.setMinutes(expires.getMinutes()+1);

    // 위에 주석으로 써둔 Express 서버에서 새로운 쿠키를 저장하는 방법이다.
    res.cookie('id', name, {
        expires:expires,
        httpOnly:true,
        path:'/'
    }); // 파라미터 내용을 쿠키로 추가

    res.redirect('/');  // redirect('/'); : 특정 리퀘스트로 이동시킨다.
});


// id 쿠키를 지우고, / 로 리다이렉트 하는 라우터를 만들어보자.
app.get('/logout', (req, res)=>{
    res.clearCookie('id', req.cookies.id, {
        httpOnly:true,
        path:'/'
    });

    res.redirect('/');
});


app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.')
});