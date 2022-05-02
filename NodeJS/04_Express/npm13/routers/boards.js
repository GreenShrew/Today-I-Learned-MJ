const express = require('express');
const Member = require('../models/member');
const Board = require('../models/board');
const Reply = require('../models/reply');
// 직접 사용할 라우터파일에서 필요한  require 를 사용하는게 효율적일수 있습니다
const multer = require('multer');
const fs = require('fs');
const path = require('path');

const router = express.Router();

// upload 폴더를 public 폴더에 넣어서 사용하는 이유는, static 폴더 안에서 이미지를 로딩하기 위함입니다
// 만약 public 폴더안에 넣지 않고, 별도의 위치에 upload 를 위치한다면 static 폴더 설정이 하나더 추가되어야 합니다.
try {
    fs.readdirSync('public/upload');
} catch (error) {
    console.error('upload 폴더가 없어 upload 폴더를 생성합니다.');
    fs.mkdirSync('public/upload');
}

const upload = multer({
    storage: multer.diskStorage({
            destination(req, file, done) {
            done(null, 'public/upload/');
        },
            filename(req, file, done) {
            const ext = path.extname(file.originalname);
            done(null, path.basename(file.originalname, ext) + Date.now() + ext);
        },
    }),
    limits: { fileSize: 5 * 1024 * 1024 },
});


router.get('/', (req,res)=>{
    const loginUser = req.session.loginUser;
    res.render('main', { lUser:loginUser });
});



router.get('/boardList', async (req,res)=>{
    //  boards 테이블의 모든 내용을 id로 내림차순 조회해서  json 으로 보냅니다
    try{
        const boardList = await Board.findAll({
            order:[['id', 'DESC']],
        });
        res.json(boardList);
    }catch(err){
        console.error(err);
        next(err);
    }
});



router.get('/writeForm', (req, res, next)=>{
    const luser = req.session.loginUser;
    res.render('writeForm', {luser});
});


router.post('/writeBoard', upload.single('image') , async (req,res,next)=>{
    // 파일 업로드와 게시글 insert를 완성하세요. 
    // filename 필드명에는 서버에 저장되는 파일이름(현재 날짜와 시간이 밀리초로 변환된 값이 포함된 이름)
    // realfilename 필드명에는 원래 파일명으로 insert 해주세요.
    try{
        let board;
        if(req.file != undefined){
            board = await Board.create({
                subject:req.body.subject,
                writer:req.body.writer,
                content:req.body.text,
                filename:req.file.originalname,
                realfilename:req.file.filename,
            });
        }else{
            board = await Board.create({
                subject:req.body.subject,
                writer:req.body.writer,
                content:req.body.text,
            });
        }
        res.json(board); 
    }catch(err){
        console.error(err);
        next(err);
    }
});


router.get('/boardView/:id', async(req, res, next)=>{
    try{
        // 게시물 검색
        const result = await Board.findOne({
            attribute:['readCount'],
            where:{id:req.params.id},
        });
        // 검색한 게시물의 조회수를 추출해서 +1 연산
        const cnt = result.readCount + 1;
        // 연산결과를 게시물에  update  
        await Board.update({
            readCount:cnt,
        },{
            where:{id:req.params.id},
        });
        // 다시 게시물을 검색
        const board = await Board.findOne({
            where:{id:req.params.id},
        });
        // render 로 전송합니다(로그인유저정도, 현재시간)
        const luser = req.session.loginUser;
        const dt = new Date();
        res.render('boardView', {board , luser, dt});
    }catch(err){
        console.error(err);
        next(err); 
    }
});



router.get('/replyList/:boardnum', async (req,res,next)=>{
    try{
        const replys = await Reply.findAll({
            where:{boardnum:req.params.boardnum},
            order:[['id', 'DESC']],
        });
        res.json(replys);
    }catch(err){
        console.error(err);
        next(err);
    }
});
router.post('/addReply' , async (req, res, next)=>{
    try{
        await Reply.create({
            writer : req.body.writer,
            content : req.body.reply,
            boardnum : req.body.boardnum,
        });
        res.end();
    }catch(err){
        console.error(err);
        next(err);
    }
});





router.delete('/deleteReply/:id', async (req, res, next)=>{
    try{
        const result = await Reply.destroy({
            where : {id:req.params.id},
        });
        res.json(result);
    }catch(err){
        console.log(err);
    }
});




router.get('/replycnt/:id', async(req,res,next)=>{
    // reply 테이블에서 boardnum 필드중 전달된 id로 검색한 결과를 클라이언트에게 전달
    try{
        const result = await Reply.findAll({
            where:{boardnum:req.params.id},
        });
        //res.json(result);
        res.json({cnt:result.length});
    }catch(err){
        console.log(err);
        next(err);
    }
});



router.get('/UpdateForm/:id', async (req, res, next)=>{
    // 전달된 아이디로 게시물을 조회한후 updateForm.html 로 렌더링, 세션에 있는 유저아이디랑, 조회한 게시물과 같이 이동합니다
    console.log('updateform error')
    try{
        const board = await Board.findOne({
            where:{id:req.params.id},
        });
        const luser = req.session.loginUser;
        res.render('updateForm', {board, luser});
    }catch(err){
        console.error(err);
        next(err); 
    }

});



router.post('/update', upload.single('image'), async(req,res,next)=>{
    try{
        if( req.file != undefined ){  // 업로드된 파일이 있는경우
            await Board.update({
                subject: req.body.subject,
                content: req.body.text,
                filename : req.file.originalname,
                realfilename : req.file.filename,
            },{
                where : { id : req.body.id },
            });
        } else { // 업로드된 파일이 없는경우
            await Board.update({
                subject: req.body.subject,
                content: req.body.text,
            },{
                where : { id : req.body.id },
            });
        }
        // res.send('ok');
        res.redirect('/boards/boardView2/' + req.body.id);
    }catch(err){
        console.log(err);
        next(err);
    }
});




router.get('/boardView2/:id', async(req, res, next)=>{
    try{
        const board = await Board.findOne({
            where:{id:req.params.id},
        });
        const luser = req.session.loginUser;
        const dt = new Date();
        res.render('boardView', {board , luser, dt});
    }catch(err){
        console.error(err);
        next(err); 
    }
});





router.get('/deleteBoard/:id', async (req, res, next)=>{
    // 해당아이디로 게시물을 삭제한후 boards 로 이동해주세요
    try{
        await Board.destroy({
            where : { id:req.params.id },
        });
        res.redirect('/boards');
    }catch(err){
        console.error(err);
        next(err);
    }
});







module.exports = router;