// 12_ReadFileAsyncPromise.js

// 파일을 읽는 동작도 순서대로 만들 수 있다!

const fs = require('fs').promises;

console.log('시작');

fs.readFile('./readme1.txt')    // 1번 파일을 읽고
.then((data)=>{
    console.log('1번', data.toString());    // 이를 출력하고
    return fs.readFile('./readme2.txt');    // 다음 then에 보낼 2번 파일을 읽고
})
.then((data)=>{
    console.log('2번', data.toString());    // 2번을 출력하고
    return fs.readFile('./readme3.txt');    // 다음 then에 보낼 3번 파일을 읽고
})
.then((data)=>{
    console.log('3번', data.toString());    // 3번을 출력한다.
    console.log('끝');
})
.catch((err)=>{
    console.error(err);
});