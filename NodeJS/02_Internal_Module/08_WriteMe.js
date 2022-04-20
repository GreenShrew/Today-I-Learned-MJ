// 08_WriteMe.js

const fs = require('fs');

fs.writeFile( './writeMe.txt', '텍스트가 입력됩니다.', (err)=>{
    if(err){
        throw err;
    }
});