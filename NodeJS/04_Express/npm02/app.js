const express = require('express');
const path = require('path');

const app = express();

app.set('port', process.env.PORT || 3000);

app.get('/', (req, res)=>{
    // __dirname 의 내용과 index.html 파일명이 조합된 종합 결로가 만들어지고, 해당 파일의 내용으로 클라이언트에 응답할 예정이다.
    // 02_Internal_Module의 04_Path.js 를 참고하자!

    // 이번에는 파일을 열고, 내용을 꺼내서 클라이언트에 보내는게 아니다. 파일 자체를 보낸다.
    // 사용되는 메서드 res.sendFile();
    res.sendFile(path.join(__dirname,'/index.html'));   // __dirname : 현재 파일이 위치한 경로
    // path.join() 메서드와 __dirname으로 해당 이름의 html 파일을 선택, 이를 sendFile로 파일을 보낸다.
});

app.get('/users', (req, res)=>{});
// 이와 같은 함수를 라우터라고 부른다.
// 하나의 라우터에는 method 와 url이 같이 표시되어 해당 내용으로 응답을 보내준다.

app.listen(app.get('port'), ()=>{ console.log(app.get('port'), '3000번 포트에서 대기중입니다.')});