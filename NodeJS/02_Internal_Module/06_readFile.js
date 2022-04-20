// 06_readFile.js

// 파일 읽기 쓰기를 위한 모듈
const fs = require('fs');

// (경로, 옵션)
fs.readFile( './readMe.txt' , (err, data)=>{    // 에러 발생시 err에 값이 들어가고, 아니라면 data에 경로에 쓴 파일 내용이 들어간다.
    if(err){    // 파일을 읽어오는데 에러가 발생해서 err 변수가 null이 아니라면
        throw err;
    }
    console.log(data);  // 글자가 16진수로 나온다.
    console.log(data.toString());   // 문자열로 변환
} );

// err : 파일 읽기에 실패했을 때 전달되는 값을 받는 매개변수
// data : 파일 읽기에 성공했을 때 읽어온 파일 내용 데이터