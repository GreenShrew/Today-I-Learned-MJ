// 07_readFilePromise.js

// 파일 입출력을 위한 모듈을 promise 를 포함하여 로딩한다.
const fs = require('fs').promises;

// 파일의 읽기도 에러처리를 위한 함수 없이 실행된다.
fs.readFile('./readMe.txt')
.then((data)=>{
    console.log(data);
    console.log(data.toString());
})
.catch((err)=>{
    console.error(err);
});

// Promise 는 비동기 실행이므로, 아래의 명령이 나중에 실행되도록 뒤에 기술하여도 실행속도가 빠른 명령은 먼저 실행 후, promise 결과가 출력된다.
// 즉, readFile로 파일을 읽어오는데에 에러가 발생해도 실행속도가 빠른 내용을 먼저 처리하고 속도가 느린 Promise 명령이 끝나기 때문에, 아래의 명령이 실행된 뒤 에러가 발생해 동작이 멈추게 된다. 
console.log('Promis 로 파일을 읽어왔습니다.');

// 다만, 하단의 명령이 백번 천번 쓰여있다면, 명령이 실행되다가 비동기 명령의 실행이 끝나 중간에 끊길 수 있다.