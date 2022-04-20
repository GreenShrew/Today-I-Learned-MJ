// 02_Server02.js

const http = require('http');
// create 서버 함수로 서버 기능을 실행시킨다.
// 그리고 여기에 추가하여, 에러 처리 구문도 추가해본다.
// createServer 함수로 만든 서버 객체를 server 변수에 저장하고 기타 설정은 server 변수를 통해 별도로 실행한다.

const server = http.createServer( (req, res)=>{
    // 서버 요청시 응답 내용이 쓰여진다.
    res.write('<h1>Hello Node Server!!</h1>');
    res.write('<h2>Here is My Second Server!!</h2>');
    res.write('<h3>Welcome to My Node Server!!</h3>');
} );
server.listen(8090);
server.on('listening', ()=>{ console.log('8090 포트에서 서버가 대기중입니다!'); });
server.on('error', (error)=>{ console.error(error); });     // 기타의 설정2 에러의 내용