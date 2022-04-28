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


router.get('/joinform', (req,res,next)=>{
    res.render( 'memberInsert', {});
});


router.post('/insertMember', async (req,res,next)=>{
    try{
        const member = await Member.create({
            userid:req.body.userid,
            name:req.body.name,
            pwd:req.body.pwd,
            phone:req.body.phone,
            email:req.body.email,
        });
        // res.json(member);
        res.end();
    }catch(err){
        console.error(err);
        next(err);
    }
});


router.get('/updateForm/:userid', async (req,res,next)=>{
    // userid 로 검색해서 검색결과를 member 라는 이름으로 같이 memberUpdateForm.html 로 이동 전송합니다
    try{
        const member = await Member.findOne({
            where:{userid:req.params.userid},
        });
        res.render('memberUpdateForm' , {member} );
    }catch(err){
        console.error(err);
        next(err);
    }
});



router.post('/update', async (req, res, next)=>{
    try{
        // 전송된 값으로 회원정보 수정
        const result = await Member.update({
            pwd : req.body.pwd,
            name : req.body.name,
            phone : req.body.phone,
            email : req.body.email,
        },{
            where: { userid : req.body.userid },
        });
        // 수정된 회원을 다시 검색 저장
        const member = await Member.findOne({
            where: { userid : req.body.userid },
        });
        // 저장된 값으로 세션값 갱신
        req.session.loginUser = member;
        // 라우터 종료
        res.json(member);  // 종료의 의미이며, 크레 의미가 없는 전송
    }catch(err){
        console.error(err);
        next(err);
    }
});

router.get('/logout' , (req, res, next)=>{
    req.session.destroy(function(){ 
        req.session;
    });
    res.redirect('/');
});


module.exports = router;