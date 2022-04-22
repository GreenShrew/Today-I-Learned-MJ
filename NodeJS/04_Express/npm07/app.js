const express = require('express');
const path = require('path');
const fs = require('fs');
const multer = require('multer');

const app = express();
app.set('port', process.env.PORT || 3000);

// json을 쓰려면 이게 필요해
app.use(express.json());
app.use(express.urlencoded({extended:false}));

// Spring 프로젝트에서 정적 파일들을 보관하는 static처럼, 여기도 그러한 폴더를 지정할 필요가 있다!
app.use('/', express.static(path.join(__dirname, 'uploads')));

// 파일을 업로드 하려면 업로드된 파일이 저장될 폴더를 지정해야한다.
// 지난 Spring 프로젝트처럼 폴더를 직접 만들지는 않는다. fs 모듈을 이용하여 이용하려는 폴더가 있다면 그 폴더를 사용하고, 없다면 새로 생성하는 기능을 이용한다!
// 파일 폴더와 같은 외부의 리소르를 다루는 작업은 명령 오류와 상관 없이 디스크 상태에 따라 오류가 발생할 수 있으므로 예외처리를 해준다. 특히나 지금은 readirSync 가 실행될때 해당 폴더가 없다면 에러가 발생하므로 그에 대한 처리로 예외처리를 해준다.
try{
    fs.readdirSync('uploads');
}catch(err){
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');    // 폴더 생성
}   // 이 코드를 작성하고 서버를 실행하면 해당 폴더가 있는지 확인하고, 이를 만든다.


// 현재 프로젝트에서 사용할 multer 객체를 생성한다. 객체 이름은 upload
// 마치 const app = express(); 로 express 객체를 만들어 사용하듯 만든다.
// multer 함수에 전달인수로 객체 하나를 전달하는데, 그 객체에는 storage 와 limits 라는 속성이 포함된다.
// const upload = multer({storage:multer.diskStorage(), limits:{}, });  // 표본, 안의 내용은 {키:밸류}의 객체 형식으로 넣는다.
const upload = multer({
    storage:multer.diskStorage( // 파일 이름, 목적지 등이 들어간다.
        {
            destination(req, file, done){
                done(null, 'uploads/'); // 폴더 설정
                // 첫번째 인수 null 은 현재 파일(file)의 경로와 이름을 그대로 사용한다는 것.
                // (즉, 변경 및 추가 없음 상태이다.)
            },
            filename(req,file,done){
                const ext = path.extname(file.originalname);    // 확장자 추출
                // 확장자를 뺀 파일 이름 + 오늘 날짜(밀리초) + 추출된 확장자로 저장파일명을 변경한다.
                done(null, path.basename(file.originalname, ext) + Date.now() + ext);
                // abc.jpg -> 'abc' + 123456483 + '.jpg' -> abc123456483.jpg
                // 업로드 파일명이 같은 경우 cos 처럼 처리할 객체가 없고, 위와 같은 방법으로 파일명의 충돌을 방지한다.(오늘날짜시간의 밀리초 값)
            }
        }  
    ),
    limits:{
        fileSize:5*1024*1024
    },
});




app.get('/', (req, res)=>{
    res.sendFile(path.join(__dirname, 'multer.html'));
});


app.post('/upload', upload.single('image'), (req, res)=>{
    console.log(req.file);
    console.log(req.body.title);
    return res.json({title:req.body.title, filename:req.file.filename});
    // 전달받은 파일 title과 이름을 return 해준다.
})



app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.')
});