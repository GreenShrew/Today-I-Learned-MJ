const express = require('express');

const app = express();
app.set('port', process.env.PORT || 3000);

const indexRouter = require('./routers');   // 경로에 아무것도 안 쓰고 ./routers만 쓰면 index.js가 자동으로 인식된다.
const userRouter = require('./routers/users');

// 현재 파일에서 사용한 '/'와 indexRouter에 있는 '/' 이 조합이 된다.
// '//'로 조합되는데, 안쪽이 비어있으므로 '/' 로 사용이 된다!
app.use('/', indexRouter);
// indexRouter의 '/' 요청! -> http://localhost:3000/
// indexRouter의 '/about' 요청! -> http://localhost:3000/about

// 현재 파일에서 사용한 '/users'와 userRouter에 있는 '/'와 조합되어
// '/users/' 가 사용된다.
app.use('/users', userRouter);
// userRouter의 '/' 요청! -> http://localhost:3000/users
// userRouter의 '/search' 요청! -> http://localhost:3000/users/search



app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '3000번 포트에서 대기중입니다.');
});


// req 객체의 쓰임새

// req.app : req 객체를 통해 app 객체에 접근할 수 있다. req.app.get('port)와 같은 식으로 사용이 가능하다.
// req.body : body-parser 미들웨어가 만드는 요청의 본문을 해석한 객체이다.
// req.cookies : cookie-parser 미들웨어가 만드는 요청의 쿠키를 해석한 객체이다.
// req.ip : 요청의 up 주소가 담겨있다.
// req.params : 라우트 매개변수에 대한 정보가 담긴 객체이다.
// req.query : 쿼리스트링에 대한 정보가 담긴 객체이다
// req.signedCookies : 서명된 쿠키들은 req.cookies 대신 여기에 담겨있다.
// req.get(헤더 이름) : 헤더의 값을 가져오고 싶을 때 사용하는 메서드이다.


// res 객체의 쓰임새

// res.app : req.app 처럼 res 객체를 통해 app 객체에 접근할 수 있다.
// res.cookie(키, 값, 옵션) : 쿠키를 설정하는 메서드이다.
// res.clearCookie(키, 값, 옵션) : 쿠키를 제거하는 메서드이다.
// res.end() : 데이터 없이 응답을 보낸다.
// res.json(JSON) : JSON 형식의 응답을 보낸다.
// res.redirect(주소) : 리다이렉트할 주소와 함께 응답을 보낸다.
// res.render(뷰, 데이터) : 템플릿 엔진을 렌더링해서 응답할 때 사용하는 메서드이다. (다음 단원에서 학습한다.)
// res.send(데이터) : 데이터와 함께 응답을 보낸다. 데이터는 문자열일수도 있고, HTML일수도 있으며, 버퍼일수도 있고, 객체나 배열일수도 있다.
// res.sendFiel(경로) : 경로에 위치한 파일을 응답한다.
// res.setHeader(헤더, 값) : 응답의 헤더를 설정한다.
// res.status(코드) : 응답시의 HTTP 상태 코드를 지정한다.
// send sendFile render json end 등, 요청에 대한 데이터 전송은 한번에 한개, 그리고 한번만 실행하여야 한다! 또한, 하나의 라우터에서 두번 또는 두개가 실행되면 에러가 발생한다!