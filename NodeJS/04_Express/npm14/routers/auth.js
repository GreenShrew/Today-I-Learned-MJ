const express = require('express');
const User = require('../models/user');
const bcrypt = require('bcrypt');
const passport = require('passport');

const router = express.Router();


router.post('/join', async (req, res, next)=>{
    // const email = req.body.email;
    // const nick = req.body.nick;
    // const password = req.body.password;
    // req.body 객체 안에는.. {email:'hong@naver.com', nick:'홍길동', passport:'1234'} 와 같이 전달된 내용이 있을 것이다.
    // 위와 같이 따로따로 변수에 저장하는 방법도 있다.
    // 하지만 아래처럼 한번에 만드는 방법도 있다!
    const {email, nick, password} = req.body;

    try{
        // DB 체크, 중복 아이디가 있는지 확인
        const exUser = await User.findOne({
            where:{email},
        }); // 전송된 이메일이 이미 사용중인 이메일인지 검색

        if(exUser){ // exUser가 null이 아니라면 : 이미 회원가입이 되어있다면...
            return res.redirect('/join?error=exist');    // return을 통해 join.html으로 한번 돌아간다. error 값을 가져가서 script가 onload 될 때 이를 작동시키게 만든다.
        }

        // 암호화 모듈인 bcrypt를 쓴다.
        const hash = await bcrypt.hash(password, 12);
        // hash 연산의 뜻 : 암호화와 비슷한 연산의 결과로, 같은 원본 데이터라도 연산결과가 절대 같은 결과가 나오지 않게 하는 연산.
        // 예를들어, 3 사람의 비밀번호가 1234라도, 해쉬화가 되면 3인의 해쉬 암호는 셋이 전부 다르다.
        // 12 : 해쉬화를 하기 위한 복잡도 인수. 숫자가 클수록 해쉬화 암호화가 복잡해지고 복구시간도 오래 걸린다. 12가 약 1초 정도 시간의 실행을 해준다.

        await User.create({
            email,
            nick,
            password:hash,  // 해쉬화 연산을 한 암호를 레코드에 추가
        }); // 이메일, 닉네임, 패스워드로 회우너 추가
        return res.redirect('/');   // 메인 페이지로

    }catch(err){
        console.error(err);
        next(err);
    }
});


// 로그인 기능
router.post('/login', (req, res, next)=>{
    // passport 모듈로 로그인을 구현한다.
    
    passport.authenticate('local', (authError, user, info)=>{
        // 로그인을 위해서 현재 미들웨어가 실행되면, 'local'까지만 인식되고,
        // localStategy 라는 곳으로 이동해서 로그인을 처리한다.
        // 이후, localStategy.js 에서 done()에 의해 되돌아오면, 전달된 값으로 (authError, user, info)=>{} 함수가 실행된다.

        // 로그인이 성공하면 user에는 현재 로그인한 사람의 정보가 담긴다.
        if(authError){  // 서버에러가 있다면 서버에러 처리
            console.error(authError);
            return next(authError);
        }
        if(!user){  // user가 false라면 -> 로그인에 실패했다면
            return res.redirect(`/?loginError=${info.message}`);    // 전달된 메세지 출력!
        }

        // 여기서부터가 정상 로그인 성공
        return req.login(user, (loginError)=>{
            // req.login을 하는 순간, index.js로 이동한다. 로그인 루틴 정상실행 - 실행 후 복귀
            if(loginError){ //index.js에서 보낸 에러가 있다면 에러 처리
                console.error(loginError);
                return next(loginError);
            }
            // 현재 위치에서 세션 쿠키가 브라우져로 보내어진다.
            return res.redirect('/');
        });
    })(req, res, next);     // 미들웨어 내에 미들웨어를 만든다. 미들웨어 내의 미들웨어에는 (req, res, next) 를 붙인다.
});



router.get('/logout', (req, res)=>{
    req.logout();   // 세션 쿠키 삭제
    req.session.destroy();
    res.redirect('/');
});



module.exports = router;