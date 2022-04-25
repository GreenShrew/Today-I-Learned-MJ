const express = require('express');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const dotenv = require('dotenv');
const path = require('path');

const app = express();
app.set('port', process.env.PORT || 3000);

app.use(express.urlencoded({extended:false}));
app.use(session({
    resave:false,
    saveUninitialized:false,
    secret:'nodejsdotenv',  // 저장될때 사용하는 암호화키
    cookie:{
        httpOnly:true,
        secure:false,
    },
    name:'session-cookie',
}));

app.get('/', (req, res)=>{
    if(req.session.userid){
        res.send(`${req.session.userid}님 반갑습니다.` + '<a href="/logout">로그아웃</a>');
    }else{
        res.sendFile(path.join(__dirname, '/login.html'));
    }
});


app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.');
});