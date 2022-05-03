const passport = require('passport');
const LocalStategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt');
const User = require('../models/user');

// 일반 사용자의 로그인 절차를 정의한 strategy
module.exports = ()=>{
    passport.use(new LocalStategy({
        usernameField:'email',      // 보내온 req.body.email 의 필드이름과 일치, 'email' 이 같아야한다. 즉, 지금 내가 쓰고있는 email의 필드명을 일치시켜야한다!
        passwordField:'password',   // 보내온 req.body.password 의 필드이름과 일치하게 작성.
    }, async (email, password, done)=>{
        try{
            // 지금 로그인하려는 유저가 있는지 확인
            const exUser = await User.findOne({
               where:{email} 
            }); // 전달된 email 이 user 테이블에 있는지 확인
            
            if(exUser){ // 회원이 존재하면
                // 암호-해시화된 비밀번호들을 비교한다.
                const result = await bcrypt.compare(password, exUser.password);

                if(result){ // 비밀번호까지 같다면!
                    done(null, exUser); // localStrategy.js 가 호출된 위치의 익명함수로 이동한다. (에러없음 null과 로그인한 유저 정보가 같이 이동)
                }else{  // 비밀번호가 틀리다면
                    done(null, false, {message:'비밀번호가 일치하지 않습니다.'});
                    // localStrategy.js 가 호출된 위치의 익명함수로 이동한다. (에러없음 null과 로그인한 유저에 false, 그리고 info에 보내는 메세지와 같이 이동)
                }

            }else{  // 회원이 존재하지 않는다면
                done(null, false, {message:'가입되지 않은 회원입니다.'});
            }
        }catch(err){
            console.error(err);
            done(error);
        }
    }));
};