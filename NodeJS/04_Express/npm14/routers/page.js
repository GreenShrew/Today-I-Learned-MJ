const express = require('express');
const { Post, User, Hashtag } = require('../models');
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

const router = express.Router();


router.get('/', async (req,res,next)=>{
    try{
        // 포스트 검색
        const posts = await Post.findAll({
            include : {
                model:User,
                attributes:['id', 'nick'],
            },
            order:[[ 'createdAt' , 'DESC' ]],
        });
        res.render('main', 
            { 
                title:'Nodegram',   // 타이틀
                user:req.user,      // 로그인유저의 객체
                 // 로그인유저가 없으면 0, 있으면 인원수(length-레코드 갯수)
                followerCount : req.user ? req.user.Followers.length : 0,   // 팔로워 인원수
                followingCount : req.user ? req.user.Followings.length : 0,  // 팔로잉 인원수
                followerIdList : req.user ? req.user.Followings.map(f => f.id) : [] ,
                // 팔로워들의 아이디 리스트 : 배열
                posts,              // 전체 포스팅들이 담긴 객체
            }
        );
    }catch(err){
        console.error(err);
        next(err);
    }  
});


router.get('/join',  isNotLoggedIn, (req, res, next)=>{
    res.render('join', { title: '회원가입 - Nodegram' });
});


router.get('/profile',  isLoggedIn, (req, res) => {
    res.render('profile', { 
        title: '내 정보 - Nodegram',
        user:req.user, 
        followerCount : req.user ? req.user.Followers.length : 0,   // 팔로워 인원수
        followingCount : req.user ? req.user.Followings.length : 0,  // 팔로잉 인원수
        followerIdList : req.user ? req.user.Followings.map(f => f.id) : [] ,
    });
});




router.get('/hashtag',  isLoggedIn, async (req, res, next) => {
    const query = req.query.hashtag;
    if (!query) {
        return res.redirect('/');  // 도착한 검색어가 없으면 메인으로 돌아갑니다
    }
    try {
        const hashtag = await Hashtag.findOne({ where: { title: query } });  // 해시태그 단어 검색
        let posts = [];
        if ( hashtag ) {
          posts = await hashtag.getPosts({ include: [{ model: User }] });  
          // 해당 해시태그로 외래키관계로 연결된 게시물 검색
        }
        return res.render('main', {
            title: `${query} | NodeGram`,
            posts,
            user:req.user, 
            followerCount : req.user ? req.user.Followers.length : 0,   
            followingCount : req.user ? req.user.Followings.length : 0, 
            followerIdList : req.user ? req.user.Followings.map(f => f.id) : [] ,
        });
    } catch (error) {
        console.error(error);
        return next(error);
    }
});


module.exports = router;