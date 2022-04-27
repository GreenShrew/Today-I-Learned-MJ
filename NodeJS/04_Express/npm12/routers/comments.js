const express = require('express');
const User = require('../models/user');
const Comment = require('../models/comment');

const router = express.Router();

router.post('/', async (req, res, next)=>{
    try{
        const comment = await Comment.create({
            commenter: req.body.id,
            comment: req.body.comment,
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
            },  // join 을 위해서 주인공테이블과 외래키관계(1:N)관계 테이블의 모델을 include 합니다. 
            // 이렇게해서  join효과를 볼수 있습니다
        });
        res.json(comments);
    }catch(err){
        console.error(err);
        next(err);
    }
});
// users  테이블과  comments 테이블의 조인
// User.findAll({
//     include:{
//         model:comment
//     },
// });


router.patch('/update/:id' , async (req,res)=>{
    try{
        const result = await Comment.update({
            comment:req.body.comment,
        },{
            where:{ id:req.params.id },
        });
        res.json(result);
    }catch(err){
        console.error(err);
        next(err);
    }

});
//6. 수정   update users set comment = '바꿀 내용' where id=2;
// User.update({
//     commnet:'바꿀 내용',
// },{
//     where : {id:2},
// });

// 7. 삭제
// delete from users where id=2
// User.destroy({
//     where : {id:2},
// });


router.delete('/delete/:id', async (req, res, next) => {
    try {
        const result = await Comment.destroy({ 
            where: { id: req.params.id } 
        });
        res.json(result);
    } catch (err) {
        console.error(err);
        next(err);
    }
});



router.get('/search/:id', async (req, res, next) => {
    try {
        const comments = await Comment.findAll({
            include:{
                model:User,  
            },
            where: { commenter: req.params.id },   // 조건 검색
        });
        res.json(comments);
    } catch (err) {
        console.error(err);
        next(err);
    }
});


module.exports = router;