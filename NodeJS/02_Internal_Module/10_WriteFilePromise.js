// 10_WriteFilePromise.js
// 파일 입출력을 위한 모듈을 promise 를 포함하여 로딩한다.
const fs = require('fs').promises;

fs.writeFile('./writeme3.txt', '안녕하세요. \n반갑습니다.')

// 아래는 파일 읽어오기 동작
.then(()=>{
    return fs.readFile('./writeme3.txt');   // 파일을 읽어오는 프라미스를 리턴
})
.then((data)=>{
    console.log(data.toString());
})
.catch((err)=>{
    console.error(err);
});