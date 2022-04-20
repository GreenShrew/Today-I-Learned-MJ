// 04_Server04.js

// 이번에는 파일을 열어서 읽어낸 내용을 res.write로 보낸다!
// 뭔가 번거롭다!

const http = require('http');
const fs = require('fs').promises;


// 앞서 01_Basic의 07_Promise와 08_anotherPromise를 다시 학습해보자
const server = http.createServer( async (req, res)=>{
    try{
        // 이 promise로 실행해 읽어낸 내용이 data에 저장된다.
        const data = await fs.readFile('./04_Server.html');
        // 헤더에 필요한 내용을 실어서 보내는 역할. 현재는 한글을 위한 속성이 담겨있다.
        // 따라서 한글 인코딩을 위한 헤더 내용을 먼저 보내준다.
        res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
        res.end(data);  // data에 담긴 내용이 보내지면 전송이 끝나도록 만들었다!
        // write(일반 전송), writeHead(헤더 내용 전송), end(전송 후 종료를 위한 함수)
    }catch(err){
        console.log(err);
        res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
        res.end(err.message);
    }
} ).listen(8081, ()=>{
    console.log('8081 포트에서 서버가 대기중입니다!');
});
// http 상태 코드
// 2XX : 서버 전송 정상 완료
// 3XX : 리다이렉션(다른 페이지로 이동)을 알리는 상태
// 4XX : 요청 오류를 나타낸다. 요청 자체에 오류가 있을 때 표시된다.
// 5XX : 서버 오류 - 요청은 제대로 왔으나 서버에 오류가 생겼을 때 발생한다.