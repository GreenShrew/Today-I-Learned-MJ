// 05_Server05.js

const http = require('http');   // http 모듈 
const fs = require('fs').promises;

let users = {};   // 서버가 종료될때까지 없어지지 않고 값도 유지되는 변수이다. 넘어온 값을 저장할 변수이다.

http.createServer( async(req, res)=>{   // 클라이언트에서 현재 서버로 요청이 들어오면 실행되는 익명함수. 저 아래의 listen에 있는 함수처럼 생략하는것은 불가능.
    try{
        // 용도에 따라 request를 어떤 방식으로 받는지 달라진다.
        if(req.method == 'GET'){    // 주로 조회(select) 용도로 사용한다.
            if(req.url === '/'){ // localhost:8090의 req.method - 'GET' req.url - '/'
                // fs.readFile('./05_Front.html').then((data)=>{}); 이런식으로 써도 되지만 await를 이용해 변수에 넣는 방식으로 깔끔하게 바꾼다.
                const data = await fs.readFile('./05_Front.html'); // 첫 페이지! html 파일을 보내다가 웹에 출력!
                res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
                return res.end(data);
                // res.end(data)는 별도 실행되고, 실행결과가 리턴되는 모습이다. 하지만 리턴되는 값은 의미 없다!
                // 함수 결과를 리턴한다는 것 보다는 함수를 끝낸다는것이 포인트!
                // res.end(data) 실행 후 return에 의해 async (req, res)=>{} 함수가 종료
                // return으로 끝내지 않으면 아래에 404 에러를 위해 만든 코드가 무조건 실행되기 때문이다!
            }else if(req.url === '/about'){ // localhost:8090의 req.method - 'GET' req.url - '/about'
                const data = await fs.readFile('./05_about.html');
                res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
                return res.end(data);
            }else if(req.url === '/users'){
                // json 데이터 전송을 위한 헤더 설정
                res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
                // users 객체 안의 내용을 json 형식으로 변경하여 전송
                return res.end(JSON.stringify(users));
                // JSON.stringify : 자바스크립트의 값을 JSON 문자열로 변환한다.
            }
        }else if(req.method == 'POST'){  // 주로 로그인 또는 insert 용도로 사용한다.
            if(req.url === '/users'){
                // req에 전송된 자료(name)을 Stream 형식으로 받아서 body 변수에 넣는다.
                let body = '';
                req.on('data', (data)=>{ // {'name' : '홍길동'}
                    console.log('data :', data.toString());
                    body += data;
                    console.log('body :', body);
                });
                // req.on() : request의 동작을 첫번째 인수로 전달된 키워드로 구분하여, 같이 전달된 익명함수를 실행한다. 
                // 'data' : 함께 전달된 자료 수신 및 처리
                // 전달된 자료가 두개 이상이어도 모두 객체 형식으로 다 받아서 처리한다.

                return req.on('end', ()=>{
                    const {name} = JSON.parse(body);    // 전달된 body에서 데이터의 값을 꺼내서 name 변수에 저장
                    const id = Date.now();  // id 변수에 날짜를 추출(오늘 날짜 현재시간을 밀리초로 얻어낸 값)
                    users[id] = name;   // 키값은 id, 밸류값은 name으로 객체에 저장. 같은 이름을 저장해도 시간이 다르게 들어가므로 key값이 다르다!
                    res.writeHead(201, {'Context-Type':'text/html; charset=utf-8'});
                    res.end('ok');   // 원래 자리로 복귀
                });
                // 마지막 전송과 끝내기 위한 리턴. 단순히 req.end()만 실행하는게 아니라 다른 동작이 함게 실행되어야 한다면, 위와 같이 익명함수를 'end' 키워드와 함께 실행해서 그 여러 실행들이 함께 실행되고 리턴&종료되게 한다.
            }
        }else if(req.method == 'PUT'){  // 주로 특정 자료를 수정(update)할때 사용한다.
            // 요청 내용 : axios.put('/user/' + key, {name});
            // console.log(req.url);    -> /user/1617773005525  숫자는 시간 밀리초... 
            // 어쨌든 startsWith는 앞 부분이 괄호 속 내용(아래에서는 /user/)인 경우를 불러온다!
            if(req.url.startsWith('/user/')){
                // 우선 /user/ 뒤에 붙은 숫자를 떼내야한다.
                const key = req.url.split('/')[2];  // /로 split 하면 /로 나눠서 배열로 저장한다. [0]은 ' ', [1]은 'user', [2]는 1617773005525 이다.
                let body = '';
                // data <- {name:실제전송된값}
                req.on('data', (data)=>{
                    body += data;
                });
                return req.on('end', ()=>{
                    users[key] = JSON.parse(body).name;
                    res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
                    return res.end('ok');
                });
            }
        }else if(req.method == 'DELETE'){  // 주로 delete 용도로 사용한다.
            if(req.url.startsWith('/user/')){
                const key = req.url.split('/')[2];
                delete users[key];
                res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
                return res.end('ok');
            }

        }

        // 원하는 url이 없거나, 웹에 표시할 파일이 없을 경우 생기는 404 에러를 처리해준다.
        // 404 에러는 catch에서 잡아주지 않기 떄문에 따로 만들어주었다.
        res.writeHead(404);
        return res.end('Not FOUND');

    }catch(err){    // 서버 실행상의 에러 - url이 존재하지 않아서 생기는 404 에러는 catch에서 처리가 안 된다.
        console.log(err);
        res.writeHead(200, {'Context-Type':'text/html; charset=utf-8'});
        res.end(err.message);
    }
}).listen(8090, ()=>{   // 서버가 처음 실행되어서 대기상태로 갈떄 한번 실행되는 익명함수, 생략 가능하다.
    console.log('8090 포트에서 서버가 대기중입니다!');
});