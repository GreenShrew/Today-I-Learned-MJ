// middleware.js

exports.isLoggedIn = (req,res,next)=>{
    if( req.isAuthenticated() ){
        next();     // 참이면 다음 명령(또는 라우터)으로  이동
    } else {
        res.status(403).send('로그인이 필요합니다');
        // 거짓이면 에러내용과 함꼐 호출된곳으로 이동
    }
};


exports.isNotLoggedIn = (req, res, next) => {
    if (!req.isAuthenticated()) {
      next();
    } else {
      const message = encodeURIComponent('로그인한 상태입니다.');
      res.redirect(`/?error=${message}`);
    }
};