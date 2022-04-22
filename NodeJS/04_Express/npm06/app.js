const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const morgan = require('morgan');
const session = require('express-session');

const app = express();
app.set('port', process.env.PORT || 3000);

app.use(morgan('dev'));
app.use(cookieParser());
app.use(express.json());
app.use(express.urlencoded({extended:true}));

// express-session 설정하기
app.use(session({
    resave:false,
    saveUninitialized:false,
    secret:"KMJ",   // 세션값의 암호화 코드
}));

// 세션의 저장방법
// req.session.id='hello';
// req.session.data = 'asdasd';
// 다른 미들 웨어에서 req.session.data 라는 이름으로 사용이 가능하다!(영구적 저장)


app.get('/', (req,res)=>{
    if(req.cookies.userid){
        res.send(`${req.cookies.userid}님 반갑습니다.` + '<a href="/logout">로그아웃</a>');
    }else{
        res.sendFile(path.join(__dirname, '/index.html'))
    }
});


app.post('/login', (req, res)=>{
    // 쿠키에 저장하는게 아니라 세션에 저장한다.
    const id = req.body.id;
    const pw = req.body.pw;

    if(id=='scott' && pw=='tiger'){
        req.session.userid = id;    // 세션에 받아온 id 값을 저장한다!
        return res.json({msg:'ok'});
    }else if(id!='scott'){
        return res.json({msg:'없는 아이디입니다.'});
    }else if(pw!='tiger'){
        return res.json({msg:'비밀번호가 맞지 않습니다.'});
    }else{
        return res.json({msg:'알 수 없는 이유로 로그인이 되지 않습니다..'});
    }
    // 세션으로만 만들면 정말 간단해진다! 여기에 쿠키를 연동하기 시작하는 순간 복잡해진다.
});

// 세션의 삭제!
app.get('/logout', (req, res)=>{
    req.session.destroy(function(){
        req.session;
    });
});


app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.')
});