// 01_Server01.js

// Node.js에 포함된 기능과 문법을 이용해서 웹 호스팅을 할 수 있는 서버를 구축한다.
// 내장된 모듈 중에 http 모듈을 이용한다!
const http = require('http');
// 서버 구축에 필요한 기능과 함수를 담고 있는 http 모듈을 require 한다.

// createServer 함수 : Node.js 자바스크립트로 만든 http 서버가 실행되게 하는 함수이다.
// 그냥 쓴다고 되는게 아니라 안에 익명함수를 써야 한다.
// 매개변수로 request, response 를 사용한다!
// listen 안에는 포트번호, 서버실행시 실행될 익명함수를 넣는다.

// (req, res)=>{ } : 서버에 클라이언트가 요청이 있을 때 실행할 명령들이 들어간다.
// req와 res 를 전달받은 익명함수가 클라이언트로부터 들어온 요청에 응답한다.

http.createServer((req, res)=>{ // 참고로 request, response 의 순서를 조심하자!
    // req는 요청을 받고, res는 응답을 해준다.
    res.write('<h1>Hello Node Server!!</h1>');  // 클라이언트에게 보내줄 내용
    res.write('<h2>Welcome to My Node Server!!</h2>');

}).listen( 8090, ()=>{ console.log('8090 포트에서 서버가 대기중입니다!'); } );  // 이건 개발자에게 보내줄 내용
// .listen( 8090, ()=>{} ) 에 있는 ()=>{} 는 서버가 시작되면 실행할 명령이 들어간다.
// 8090 : 클라이언트가 요청할 포트번호