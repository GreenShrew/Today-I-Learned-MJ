const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');
const { Post, User, Hashtag } = require('../models');

const router = express.Router();

// 파일 업로드를 위한 폴더 찾기 및 생성
try{
    fs.readdirSync('uploads');
}catch(error){
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');
}

const upload = multer({
    storage:multer.diskStorage({
        destination(req, file, cb){
            cb(null, 'uploads/');
        },
        filename(req ,file, cb){
            const ext = path.extname(file.originalname);
            cb(null, path.basename(file.originalname, ext) + Date.now() + ext); 
        },
    }),
    limits:{
        fileSize:5*1024*1024
    },
});


router.get('/img', upload.single('img'), (req, res, next)=>{
    res.json({
        url:`/img/${req.file.filename}`
    });
}); // 그림만 업로드하고, 저장된 경로를 json 형식으로 되돌려준다.


// 아무것도 없는 multer 객체 하나 생성
const upload2 = multer();
// main.html의 form 안에 <input type="file">이 있기 때문에 submit이 동작하면 파일을 한번 더 업로드하려고 한다.
// 파일 업로드를 생략하기 위해서 비어있는 multer 객체를 만들고, upload2.none() 코드로 파일 업로드를 생략한다.
router.post('/', upload2.none(), async(req, res)=>{
    try{
        const currentPost = await Post.create({
            content:req.body.content,
            img:req.body.url,
            UserId:req.user.id,
        });

        // 게시물을 포스팅할때 같이 입력한 해시태그를 골라내서, 단어별로 처음 나온 단어를 해시태그 테이블에 insert 하고, 현재 게시물이 어떤 해시태그를 갖고 있는지의 여부를 posthashtags 테이블에 insert한다.
        
        // 해쉬태그에 해당되는 단어는 정규표현식을 이용하여 찾는다.
        const hashtags = req.body.content.match(/#[^\s#]*/g);
        // '#'으로 시작해서 빈칸과 '#'이 아닌 곳 까지를 단어로 해서 모두 검색

        if(hashtags){   // 추출한 해쉬태그가 한개 이상 있다면...
            const result = await Promise.all(
                hashtags.map((tag)=>{
                    return Hashtag.findOrCreate({
                        where:{title:tag.slice(1).toLowerCase()},
                        // title 필드값이 해시태그중 하나(tag)의 내용중 slice(1) #을 제외한 나머지 글자와 같은 조건으로 검색
                        // 같은 title 값이 있으면 지나가고, 없으면 Hashtag 테이블에 현재 해시태그로 레코드를 추가하고 그 값으로 리턴한다.
                    });
                }),
            );
            await currentPost.addHashtags(result.map((r)=>r[0]));
            // 지금 추가한 post 게시물에 대한 해시태그로 해시태그들을 posthashtags 테이블에 추가한다.
        }

        res.redirect('/');
    }catch(err){
        console.error(err);
        next(err);
    }
});


module.exports = router;