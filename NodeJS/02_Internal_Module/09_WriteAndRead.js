// 09_WriteAndRead.js

// wirteem2.txt 에 '안녕하세요, 반갑습니다!' 를 쓰고, 바로 읽어서 콘솔창에 출력해보자

const fs = require('fs');
const string = '안녕하세요, 반갑습니다! \n안녕히가세요, 내일 뵙겠습니다! \n안녕하세요, 또 뵙네요!';

fs.writeFile('./wirteem2.txt', string, (err)=>{
    if(err){
        throw err;
    }
});

fs.readFile('./wirteem2.txt', (err, data)=>{
    if(err){
        throw err;
    }
    console.log(data.toString());
});