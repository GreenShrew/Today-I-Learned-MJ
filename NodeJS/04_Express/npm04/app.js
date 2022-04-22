const express = require('express');
const path = require('path');

// Express 설정
const app = express();
app.set('port', process.env.PORT || 3000);


// 추가 설치 모듈 require -------------------------
// 필요에 의해 추가적으로 설치하는 모듈!
// 각각의 요청과 응답에 대한 필요 정보를 보기 위한 모듈
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
// method 방식, 응답 결과 코드, 요청과 실행에 걸린 시간 등등...
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
    res.sendFile(path.join(__dirname,'/index.html'));
});






app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.')
});