const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const morgan = require('morgan');
const exp = require('constants');

const app = express();

app.use(morgan('dev'));
app.use(cookieParser());
app.use(express.json());
app.use(express.urlencoded({extended:true}));

app.set('port', process.env.PORT || 3000);
// 위의 코드들은 npm04에서 필요한 셋팅을 주석 떼고 가져온것들

app.get('/', (req, res)=>{
    if(req.cookies.id){
        res.send(`${req.cookies.id}님 반갑습니다.` + '<a href="/logout">로그아웃</a>');
    }else{
        res.sendFile(path.join(__dirname, '/index.html'))
    }
});


app.post('/login', (req,res)=>{
    const id = req.body.id;
    const pw = req.body.pw;

    const expires = new Date();
    expires.setMinutes(expires.getMinutes()+1); // 쿠키의 수명을 1분으로

    if(id=='scott' && pw=='tiger'){
        res.cookie('id', id, {
            expires:expires,
            httpOnly:true,
            path:'/'
        });
        // 클라이언트로 객체형식의 데이터를 보내고 싶다면 아래와 같이 쓰면 된다.
        return res.json({msg:'ok'});    // json 데이터를 갖고 호출 위치로 되돌아간다.
        // app.use(express.json()); 이걸 해뒀기 때문에 사용이 가능하다!
    }else if(id!='scott'){
        return res.json({msg:'없는 아이디입니다.'});
    }else if(pw!='tiger'){
        return res.json({msg:'비밀번호가 맞지 않습니다.'});
    }else{
        return res.json({msg:'알 수 없는 이유로 로그인이 되지 않습니다..'});
    }
    // index.html에서 res.data.msg로 msg라는 이름의 데이터를 받는다!
});


app.get('/logout', (req, res)=>{
    res.clearCookie('id', req.cookies.id, {
        httpOnly:true,
        path:'/'
    });

    res.redirect('/');
});


app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.')
});
