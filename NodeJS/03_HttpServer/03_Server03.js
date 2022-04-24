// 03_Server03.js

// 한번에 여러개의 서버를 실행한다.
// 방법은 createServer를 여러번 호출하는 방식으로 진행한다.
// 단, 두 서버의 포트를 다르게 지정해야한다. 포트번호가 충돌하면 에러가 발생한다.

const http = require('http');

const server = http.createServer( (req, res)=>{
    // 응답 내용의 본문 전송
    res.write('<h1>Hello Node Server #1!</h1>');
    // 응답 내용의 마지막 전송 : res.end 실행 후에는 더이상 응답 내용이 전송될 수 없다.
    res.end('<p>Hello Server!</p>');
} ).listen(8081, ()=>{  // 포트번호와 함께 이벤트 리스너 설정
    console.log('8081 포트에서 서버가 대기중입니다!');
});
// req, res : 내가 이전부터 알고있는 request, response 의 의미를 갖는 변수이다.
// 매개변수이고, 서버에 있는 실제 request, response 객체가 전달된다.
// 매개 변수는 그 객체를 전달받아 사용하는 것으로 변수의 이름은 자유롭게 변경이 가능하다. 다만 함수 내에서 변경된 이름을 일관되게 사용해주는게 중요하다.

http.createServer( (req, res)=>{
    // 응답 내용의 본문 전송
    res.write('<h1>Hello Node Server #2!</h1>');
    res.end('<p>Hello Server!</p>');
} ).listen(8082, ()=>{  // 포트번호와 함께 이벤트 리스너 설정
    console.log('8082 포트에서 서버가 대기중입니다!');
});