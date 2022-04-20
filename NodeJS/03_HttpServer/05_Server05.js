// 05_Server05.js

const http = require('http');
const fs = require('fs').promises;

const users = {};   // 서버가 종료될때까지 없어지지 않고 값도 유지되는 변수이다.

http.createServer( async(req, res)=>{
    try{
        // 용도에 따라 request를 어떤 방식으로 받는지 달라진다.
        if(req.method == 'GET'){    // 주로 조회(select) 용도로 사용한다.
            if(req.url === '/'){ // localhost:8090의 req.method - 'GET' req.url - '/'
                const data = await fs.readFile('./05_Front.html'); // 첫 페이지! html 파일을 보내다가 웹에 출력!
                res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
                return res.end(data);
                // res.end(data) 실행 후 async (req, res)=>{} 함수가 종료
                // 함수 결과를 리턴한다는 것 보다는 함수를 끝낸다는것이 포인트!
                // return으로 끝내지 않으면 아래에 404 에러를 위해 만든 코드가 무조건 실행되기 때문이다!
            }else if(req.url === '/users'){ // localhost:8090의 req.method - 'GET' req.url - '/users'

            }
        }else if(req.method == 'POST'){  // 주로 로그인 또는 insert 용도로 사용한다.
            if(req.url === '/users'){
                
            }
        }else if(req.method == 'PUT'){  // 주로 특정 자료를 수정(update)할때 사용한다.
            
        }else if(req.method == 'DELETE'){  // 주로 delete 용도로 사용한다.
            
        }

        // 404 에러를 처리해준다.
        res.writeHead(404);
        return res.end('Not FOUND');

    }catch(err){    // 서버 실행상의 에러 - url이 존재하지 않아서 생기는 404 에러는 catch에서 처리가 안 된다.
        console.log(err);
        res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
        res.end(err.message);
    }
}).listen(8090, ()=>{
    console.log('8090 포트에서 서버가 대기중입니다!');
});