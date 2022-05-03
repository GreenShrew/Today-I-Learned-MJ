const express = require('express');
const { Post, User, Hashtag } = require('../models');

const router = express.Router();

router.get('/', (req, res, next)=>{
    // 포스트 내역을 모두 검색해서 같이 가져간다.
    try{
        // 포스트 검색
        const posts = await Post.findAll({
            include:{
                model:User,
                attributes:['id', 'nick'],
            },
            order:[['createdAt', 'DESC']],
        });
        res.render('main', {
            title:'Nodegram',       // 타이틀
            user:req.user,          // 로그인 유저의 객체
            followerCount:0,        // 팔로워 인원수
            followingCount:0,       // 팔로잉 인원수
            followerIdList:[],      // 팔로워들의 아이디 리스트 : 배열 형식
            posts,                  // 전체 포스팅 객체들...위에서 포스트 검색을 한 내용이 여기로 들어온다!
        });
    }catch(err){
        console.error(err);
        next(err);
    }
});


router.get('/join', (req, res, next)=>{
    res.render('join', {title:'회원가입 - Nodegram'});  // layout.html에 있는 title에 넣을 값을 같이 데리고 간다.
});



router.get('/profile', (req, res)=>{
    res.render('profile', {
        title:'내 정보 - Nodegram',
        user:req.user,
        followerCount:0,
        followingCount:0,
        followerIdList:[],
    });
});



router.get('/hashtag', (req, res, next)=>{
    const query = req.query.hashtag;

    if(!query){
        return res.redirect('/');    // 도착한 검색어가 없으면 메인으로 돌아간다.
    }
   
    try{
        const hashtag = await Hashtag.findOne({
            where:{title:query}
        });     // 해시태그 단어 검색
        let posts = [];
        if(hashtag){
            posts = await hashtag.getPosts({
                include:[{model:User}]
            });
            // 해당 해시태그로 외래키 관계로 연결된 게시물을 검색
        }
        return res.render('main', {
            title:`${query} | NodeGram`,
            posts,
            user:req.user,
            followerCount:0,
            followingCount:0,
            followerIdList:[],
        });

    }catch(error){
        console.error(error);
        return next(error);
    }
});



module.exports = router;