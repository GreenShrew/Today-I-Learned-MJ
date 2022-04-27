const express = require('express');
const Member = require('../models/member');
const Board = require('../models/board');
const Reply = require('../models/reply');
const router = express.Router();

router.post('/login', async (req, res, next)=>{
    try{
        const luser = await Member.findOne({
            where:{ userid : req.body.userid },
        });  // 전달된 아이디와 같은 레코드 검색 후  luser 변수에 저장
        if( (luser!=null) && (luser.pwd==req.body.pwd) ){
            req.session.loginUser = luser;   // 검색결과가 있고, 비번이 같으면 세션에 검색 결과를 저장합니다
        }
        res.json( luser );  // 검색결과가 널이든 아니든  클라이언트로 검색결과를 전송합니다.
    }catch(err){
        console.error(err);
        next(err);
    }
});

module.exports = router;