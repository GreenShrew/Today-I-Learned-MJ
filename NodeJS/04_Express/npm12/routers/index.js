const express = require('express');
const User = require('../models/user');  // 데이터베이스 조작(insert, update, delete, select)를 위해 require 한다.
const Comment = require('../models/comment');

const router = express.Router();

router.get('/', (req, res)=>{
    // nunjucks를 쓰고있기 때문에 render로 보낸다.
    res.render('index', { });   // 최초 서버 실행시 첫 페이지로 index.html으로 응답한다.
});



module.exports = router;