const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt');
const User = require('../models/user');

// 일반 사용자의 로그인 절차를 정의한  strategy
module.exports = () => {
    passport.use( new LocalStrategy({
        usernameField:'email', // 보내온 req.body.email 의 필드이름과 일치하게 작성, 'email'
        passwordField:'password', // 보내온 req.body.password 의 필드이름과 일치하게 작성,
    }, async (email, password, done)=>{
        try{
            const exUser = await User.findOne({
                where:{email}
            });  // 전달된 email 이 user 테이블에 존재하는지 조회
            if (exUser) {  // 회원이 존재한다면 
                // 암호-해시화 된 비번들을 비교
                const result = await bcrypt.compare(password, exUser.password); 
                if (result) {  // 비번까지 같았다면
                    done(null, exUser);   
                    // localStrategy.js 가 호출된 위치의 익명함수로 이동(에러없음 null 과 로그인한 유저)
                } else {  // 비번이 틀리다면
                    done(null, false, { message: '비밀번호가 일치하지 않습니다.' });   
                    // localStrategy.js 가 호출된 위치의 익명함수로 이동(에러없음 null 과 로그인한 유저에 false, 그리고 info보내는 메세지 )
                }
            } else {   // 아이디를 검색하지 못했다면
                done(null, false, { message: '가입되지 않은 회원입니다.' });   
            }
        } catch(err){
            console.error(error);
            done(error);
        }
    }));
};