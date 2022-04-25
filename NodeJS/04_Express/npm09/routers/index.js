const express = require('express');

// const app = express(); 이건 여기서 필요 없다.
const router = express.Router();

// 기존에는...
// app.get('/', (req, res)=>{}); 이런식으로 라우터를 만들었다.

// 이제는 불려져서 사용할 라우터를 만들 것이다!
router.get('/', (req, res)=>{
    res.send("<h1>Hello, Express router - index - '/'</h1>")
});

router.get('/about', (req, res)=>{
    res.send("<h1>Hello, Express router - index - '/about'</h1>")
});

// 위에 만들어진 라우터를 다른곳에서 가져다 쓰는 방식은 모듈을 만드는 방식과 같다.
// module.exports로 다른곳에서 require해서 쓸 수 있는 모듈로 만든다!
module.exports = router;