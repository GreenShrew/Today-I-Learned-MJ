const express = require('express');
const Member = require('../models/member');
const Board = require('../models/board');
const Reply = require('../models/reply');
const router = express.Router();

router.get('/', (req, res, next)=>{
    try{
        res.render('login', {});
    }catch(err){
        console.error(err);
        next(err);
    }
});

module.exports = router;