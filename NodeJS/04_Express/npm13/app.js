const express = require('express');
const nunjucks = require('nunjucks');
const path = require('path');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const dateFilter = require('nunjucks-date-filter'); // 넌적스에서 사용할 날짜 양식 필터 사용을 위한 모듈

const indexRouter = require('./routers');
const membersRouter = require('./routers/members');
const boardsRouter = require('./routers/boards');


const app = express();
app.set('port', process.env.PORT || 3000);

app.use(express.static(path.join(__dirname, 'public')));

app.set('view engine', 'html');
let env = nunjucks.configure('views', {   express: app,   watch: true,   });
env.addFilter('date', dateFilter);

app.use(cookieParser());
app.use(session({
    resave:false,
    saveUninitialized:false,
    secret:"rkdgmlwns", 
}));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/', indexRouter);
app.use('/members', membersRouter);
app.use('/boards', boardsRouter);


const { sequelize } = require('./models');
sequelize.sync({force:false})
.then(()=>{ console.log('데이터베이스 연결성공');})
.catch((err)=>{ 
    console.error(err);
});




// 에러처리 미들웨어
app.use((req, res, next) => {
    const error = new Error(`${req.method} ${req.url} 라우터가 없습니다.`);
    error.status = 404;
    next(error);
});
app.use((err, req, res, next) => {
    res.locals.message = err.message;
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
    res.status(err.status || 500);
    res.render('error');
});


app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기 중');
});