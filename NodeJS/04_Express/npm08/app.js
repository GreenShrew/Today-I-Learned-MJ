// path, fs가 어떤 Module인지 배웠는데....
// 다시 확인해

// 참고로 여기에서 모듈 설정하는 내용들은 계속 사용할 내용이다
// 기억하던가 외우던가!
const express = require('express');
const path = require('path');
const fs = require('fs');
const multer = require('multer');

const app = express();
app.set('port', process.env.PORT || 3000);

app.use(express.json());
app.use(express.urlencoded({extended:false}));


app.use('/', express.static(path.join(__dirname, 'uploads')));


// 폴더가 없으면 만들어주는 명령
// 폴더가 없으면 에러가 발생하므로 try~catch로 묶어주자.
try{
    fs.readdirSync('uploads');
}catch(err){
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');    // 폴더 생성
}


// 파일 이름, 목적지, 중복 이름 설정
const upload = multer({
    storage:multer.diskStorage(
        {
            destination(req, file, done){
                done(null, 'uploads/');
            },  // 업로드될 파일이 담길 폴더 지정
            filename(req,file,done){
                const ext = path.extname(file.originalname);
                done(null, path.basename(file.originalname, ext) + Date.now() + ext);
            },  // 업로드될 파일 이름 지정
        }  
    ),
    limits:{
        fileSize:5*1024*1024
    },
});





app.get('/', (req, res)=>{
    res.sendFile(path.join(__dirname, 'fileUpload.html'));
});

// 이미지를 업로드하고 들어온 데이터를 리턴하는 라우터
app.post('/upload', upload.single('image'), (req, res)=>{
    // 하단의 console들은 굳이 없어도 된다.
    console.log(req.file);  // 파일 정보를 객체 형태로 콘솔에 보여주는 내용
    console.log(req.body.title);
    console.log(req.body.description);
    console.log(req.body.price);
    console.log(req.file.filename);

    // 객체 형식으로 보낸다.
    return res.json({
        title:req.body.title,
        description:req.body.description,
        price:req.body.price,
        img:req.file.filename   // img라는 이름으로 보냈으니 html에서 img 로 써야한다.
    });
});





app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.')
});