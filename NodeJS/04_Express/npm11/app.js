const express = require('express');
const path = require('path');
const nunjucks = require('nunjucks');    // 템플릿 엔진 사용을 위한 모듈 require

const app = express();
app.set('port', process.env.PORT || 3000);
app.use(express.json());
app.use(express.urlencoded({extended:false}));

app.set('view engine', 'html');
nunjucks.configure('views',{
    express:app,
    watch:true,
});     // nunjucks 템플릿 엔진을 사용하기 위한 설정
// html 파일을 views 폴더에서 찾아온다는 설정이다!



app.get('/', (req, res)=>{
    res.render('index', {title:'Express'}); // index 라는 이름의 html 파일을 보낸다! 그리고 title이라는 이름으로 Express 라는 단어를 보낸다!
    // nunjucks 를 이용해서 html 파일을 클라이언트에 보낼때, 그 파일에 전달해줄 데이터를 위와 같이 객체 형식으로 하나 이상 같이 태워 보낼 수 있다!  스프링에서의 request.setAttribute, model.addAttribute, mav.addObject 와 비슷한 기능!
    // 파일을 클라이언트에 응답으로 보낼때는 render라는 메서드를 사용한다.
});



app.get('/include', (req, res)=>{
    res.render('main', {title:'Express'}); // 헤더푸터가 include 된 main.html 페이지로 이동
});


app.get('/extends', (req, res)=>{
    res.render('extends', {title:'Express'});
});


app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.');
});