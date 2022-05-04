const passport = require('passport');
const local = require('./localStrategy');
const User = require('../models/user');
const kakao = require('./kakaoStrategy');

module.exports = ()=>{
    passport.serializeUser( (user, done)=>{    // 로그인이 정상 로그인되었을때 실행
        done(null, user.id);   // 세션에 아이디만 저장하는 동작. 

        // 이동작후 세션에 아이디가 저장된다라는건 세션쿠키에도 암호화된 키로 쿠키가 저장된다는 뜻입니다
        // { id:3, 'connenct.sid : 14561496165 }  세션쿠키   와 같은 세션쿠키가 생성되면서   
        // 브라우져에서 connect.sid 값이 쿠키가 관리되고  이후로는 아래 디시리얼아리즈유저로 아이디가 사용 (세션값으로 복구 및 사용) 됩니다
    });
    passport.deserializeUser((id, done)=>{ // 세션 쿠키 사용할때.. 로그인 이후 부터 사용됩니다. 
        // 세션 쿠키로 로그인 된 사람이 req.user 에 저장이 되어질텐데, 차후에 후가로 그의 정보와 팔로워 팔로잉도 조인된 결과로 저장할예정입니다
        User.findOne({
            where:{ id },
            include: [{
                model: User,
                attributes: ['id', 'nick'],
                as: 'Followers',
            }, {
                model: User,
                attributes: ['id', 'nick'],
                as: 'Followings',
            }],
        })
        .then(user => done(null, user)) // 세션에 저장된 아이디와 쿠키로  user 를 복구 req.user로 사용  
        // req 내장함수 : req.isAuthenticated() 함수 결과 : 로그인 되어 있는 동안 트루값을 갖게 됩니다
        .catch(err => done(err));
    });
    local();
    kakao();
};