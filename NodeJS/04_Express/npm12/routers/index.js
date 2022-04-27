const express = require('express');
// 데이터베이스 조작(inset,update,delete,select)를 위해 require
const User = require('../models/user');
const Comment = require('../models/comment');

const router = express.Router();

router.get('/', (req,res)=>{
    res.render('index', {  });   // 최초 서버 실행시 첫페이지로   sequelize.html 으로 응답
});


module.exports = router;