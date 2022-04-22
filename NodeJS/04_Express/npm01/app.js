const express = require('express');

const app = express();  // 서버 객체를 변수에 저장

app.set('port', process.env.PORT || 3000);  // app.set : 변수 만들 때 많이 사용하는 명령이다. setter 생각하면 된다. port 라는 이름에 set 하고 get으로 쓴다.
// 서버 내에 port 라는 변수를 만들어서 현재 환경의 포트 또는 포트가 지정되지 않았다면 3000을 저장한다.

// 서버 생성... 틀리게 생겼지만 구성이 비슷하다.
app.get('/', (req, res)=>{  // url이 '/'이다. 메인 페이지.
    res.send('<h1>Hello, Express</h1>');
});

app.get('/login', (req, res)=>{

});

// Express도 요청을 대기하기 위해 listen을 만든다.
app.listen(app.get('port'), ()=>{ console.log(app.get('port'), '3000번 포트에서 대기중입니다.')});

// 서버 구동에 핵심이 되는 파일 app.js에서 사용한 중요 메서드
// app.set('port', 포트)로 서버가 실행될 포트 지정
// app.get('키워드', 익명함수) 로 GET 요청이 올 때 어떤 동작을 할지 지정
// app.listen('포트', 익명함수) 로 몇 번 포트에서 서버를 실행할지 지정

// express 서버 구동 순서 (1~3번, 6번은 터미널에 명령하는 동작이다)
// 1. npm init
// 2. npm i express
// 3. npm i -D nodemon : 개발 환경용 프로그램이므로 필수사항은 아니다.
// 4. app.js 또는 index.js 또는 main에 지정한 파일(서버의 시작파일)을 제작한다.(app.js, index.js, main 은 1번 순서에서 내가 지정한다.)
// 5. package.json의 scripts 에 "start":"nodemon app" 을 추가한다.
// 6. npm app 또는 npm run start(또는 npm start) 로 서버를 시작한다.

// nodemon을 사용하면 좋은점!
// 1. 서버구동 및 운용에 발생한 모든 과정을 로깅으로 보여준다.
// 2. 에러 수정이 용이하다.
// 3. 일정 시간이 지나거나 주요 파일이 저장되면 서버가 다시 시작되므로 수정사항이 서버 수동 재시작 없이 적용이 가능하다! (저장할 때 마다 서버가 자동으로 시작된다!) (사진 있음)