const passport = require('passport');
const local = require('./localStrategy');
const User = require('../models/user');

module.exports = ()=>{
    passport.serializeUser((user, done)=>{  // 로그인이 정상 로그인 되었을때 실행
        done(null, user.id);    // 세션에 아이디만 저장하는 동작
        // 이 동작 후 세션에 아이디가 저장된다라는 것은 세션 쿠키에도 암호화된 키로 쿠키가 저장된다는 뜻이다.
        // {id:3, connection.sid:14561496165} 세션쿠키와 같은 세션 쿠키가 생성쇠면서
        // 브라우져에서 connect.sid 값이 쿠키가 관리되고 이후로는 아래 deserializeUser 로 아이디가 사용(세션값으로 복구 및 사용)된다. 
    });
    passport.deserializeUser((id, done)=>{  // 세션 쿠키를 사용할 때, 로그인 후 부터 사용된다.
        // 세션쿠키로 로그인된 사람이 req.user에 저장이 되어질텐데, 차후에 추가로 그의 정보와 팔로워 팔로잉도 조인된 결과로 저장하고 있다.
        User.findOne({
            where:{id},
        })
        .then(user => done(null, user)) // 세션에 저장된 아이디와 쿠키로 user를 복구, req.user 로 사용한다.
        // req.isAuthenticated() 함수 결과 : 로그인 되어있는 동안 true 값을 가지게 된다!
        .catch(err => done(err));
    });
    local();
};