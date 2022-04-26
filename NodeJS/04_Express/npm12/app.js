const express = require('express');
const path = require('path');
const nunjucks = require('nunjucks');


const app = express();
app.set('port', process.env.PORT || 3000);
app.use(express.json());
app.use(express.urlencoded({extended:false}));

// nunjucks 사용환경 구성
app.set('view engine', 'html');
nunjucks.configure('views',{express:app, watch:true,});
app.use(express.static(path.join(__dirname, 'public')));

// config.json 의 내부 정보로 연결하기 위한 db 객체를 require 한다.
const { sequelize } = require('./models');  // models 폴더 안의 index.js 모델이 불려져서 require된다. 이름을 안 쓰면 index라는 이름의 파일을 찾는다!

// 데이터 베이스 연결!
// 모델 제작 후 데이터베이스 연결시 해당 모델에 매핑되는 테이블이 없으면 새로 테이블을 만들라는 옵션이다. force 값이 true이면 기존 테이블도 지우고 강제로 만들게되니 주의하자!
sequelize.sync({force:false})
.then(()=>{console.log('데이터베이스 연결 성공')})
.catch((err)=>{console.error(err);});

// 라우터들을 수집(require) 한다.
const indexRouter = require('./routers');
const usersRouter = require('./routers/users');
const commentsRouter = require('./routers/comments');

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/comments', commentsRouter);


// 에러 처리 미들웨어
app.use((req, res, next)=>{
    const error = new Error(`${req.method} ${req.url} 라우터가 없습니다.`);
    error.status = 404;
    next(error);
});
app.use((err, req, res, next)=>{
    res.locals.message = err.message;
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
    res.status(err.status || 500);
    res.render('error');
    
});


app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3001번 포트에서 대기중');
});