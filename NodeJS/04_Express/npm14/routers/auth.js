const express = require('express');
const User = require('../models/user');
const bcrypt = require('bcrypt');
const passport = require('passport');
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

const router = express.Router();

// 일반 회원 가입
router.post('/join', isNotLoggedIn , async (req, res,next)=>{
    // const email = req.body.email;
    // const nick = req.body.nick;
    // const password = req.body.password;
    // req.body 객체 -> { email:'heejoonk@naver.com', nick:'홍길동', password:'1234' }
    const { email, nick, password } = req.body; 
    
    try{
        const exUser = await User.findOne({
            where:{email},
        });  // 전송된 이메일이 이미 회원가입된 이메일인지 검색
        if( exUser ){  // exUser 가 널이 아니라면 : 이미 회원가입이 되어 있다면
            return res.redirect('/join?error=exist');
        }

        const hash = await bcrypt.hash(password, 12);
        // 해시연산의 뜻 : 암호화와 비슷한 연산으로, 같은원본데이터라도 연산결과가 절대 같은 결과가 나오지 않게 하는 연산.
        // 12 : 해쉬화를 하기위한 복잡도 인수. 숫자가 클수록 해시화 암호화가 복잡해지고 복구시간도 오래걸립니다. 12가 약 1초 정도 시간의 실행을 해줍니다
        await User.create({
            email,
            nick,
            password:hash,
        });   // 이메일, 닉네임, 패스워드로 회원 추가
        return res.redirect('/');   // 메인 페이지로
    }catch(err){
        console.error(err);
        next(err)
    }
});



router.post('/login', isNotLoggedIn , (req,res,next)=>{
    // passport 모듈로 로그인을 구현합니다. 
    passport.authenticate('local',  ( authError, user, info )=>{
        // 로그인을 위해서 현재 미들웨어가 실행되면, 'local' 까지만 인식되고, 
        // localStategy 라는 곳으로 이동해서 로그인을 처리합니다
        // done()에의해 되돌아오면 전달된 값으로 ( authError, user, info )=>{} 가 실행됩니다

        // 로그인이 성공하면  user 에는 현재 로그인한 사람의 정보가 담깁니다
        if (authError) {   // 서버에러가 있다면 서버에러 처리
            console.error(authError);
            return next(authError);
        }
        if (!user) {  // user 가 false 라면  -> 로그인에 실패했다면
            return res.redirect(`/?loginError=${info.message}`);
        }
        // 여기서부터가 정상 로그인
        return req.login(user, (loginError) => {   
        // req.login 을 하는 순간  index.js 로 이동. 로그인 루틴 정상실행 - 실행후 복귀
            if (loginError) {    // index.js 에서 보낸 에러가 있으면  에러처리
              console.error(loginError);
              return next(loginError);
            } 
            // 현재위치에서 세션 쿠키가 브라우져로 보내어집니다
            return res.redirect('/');
        });
    })(req,res,next);  // 미들웨어 내의 미들웨어에는 (req, res, next)를 붙입니다.
});




router.get('/logout',   isLoggedIn , (req, res) => {
    req.logout();   // 세션 쿠키 삭제
    req.session.destroy();
    res.redirect('/'); 
});


router.get('/kakao', passport.authenticate('kakao'));
// 스트레지를 통해 카카오에 한번 갔다가  콜백받아서 돌아오고

router.get('/kakao/callback', passport.authenticate('kakao', {   // 그다음은 요부분 실행
    failureRedirect: '/',
  }), (req, res) => {
    res.redirect('/');
  });

module.exports = router;