const express = require('express');
const User = require('../models/user');  // 데이터베이스 조작(insert, update, delete, select)를 위해 require 한다.
const Comment = require('../models/comment');

const router = express.Router();

// 댓글 레코드 추가하는 라우터
router.post('/', async (req, res, next)=>{
    try{
        // insert니깐 create 메서드 이용
        const comment = await Comment.create({
            commenter:req.body.id,
            comment:req.body.comment,
        });
        res.json(comment);
    }catch(err){
        console.error(err);
        next(err);
    }
});

router.get('/', async (req, res, next)=>{
    try{
        const comments = await Comment.findAll({
            include:{
                model:User,
            },  // join을 위해서 주인공 테이블과 외래키관계(1:N) 테이블의 모델을 include 한다.
            // 이렇게 해서 join 효과를 볼 수 있다.
        });
        res.json(comments);
    }catch(err){
        console.error(err);
        next(err);
    }
});
// users 테이블과 comments 테이블의 조인
// User.findAll({
//     include:{
//         model:comment
//     },
// });






module.exports = router;