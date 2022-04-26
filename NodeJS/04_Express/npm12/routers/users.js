const express = require('express');
const User = require('../models/user');  // 데이터베이스 조작(insert, update, delete, select)를 위해 require 한다.
const Comment = require('../models/comment');

const router = express.Router();

// sequelize.js에서 전달된 데이터를 이용해 레코드로 추가
router.post('/', async (req, res, next)=>{
    

    // 넘어온 데이터를 토대로 레코드 삽입..그리고 이건 비동기 함수이므로 await 사용해야한다.
    // 리턴값이 있는데...받아도 되고 안 받아도 된다.
    try{
        const user = await User.create({
            name:req.body.name,
            age:req.body.age,
            married:req.body.married,
        });
        // console.log(user);  // 어떤게 리턴됐는지 확인하려고 만들어봄.. 내용이 많고 복잡하니 한번 확인하면 지우자.
        res.json(user); // 다시 res로 되돌아간다. 즉, sequelize.js로 되돌아간다!
    }catch(err){
        console.error(err);
        next(err);  // 에러 루틴이 있는 라우터로 이동!
    }
});

// 전달된 값들로 레코드 추가 방법!
// 1. 레코드 삽입
// 모델명.create({
//       필드명:입력값,
//       필드명:입력값,
//       필드명:입력값,
// }); 이렇게 하면 레코드가 삽입된다.

// 레코드 추가 예시 (이건 레코드를 직접 삽입하는 것이다.)
// User.create({
//         name:'hong',
//         age:24,
//         married:false,
//         comment:'일반회원',
// });



// 모든 user 정보를 조회해서 리턴하는 라우터
// sequelize.js에서 요청받아 리턴한다.
router.get('/', async (req, res, next)=>{
    try{
        // User 객체를 통해 users 테이블의 모든 데이터 조회
        const users = await User.findAll({

        });
        // 결과를 json 형식으로 리턴해준다.
        res.json(users);
    }catch(err){
        console.error(err);
        next(err);  // 에러 루틴이 있는 라우터로 이동!
    }
});



// 2. 일반 조회 (모든 필드, 모든 레코드)
// 모델명.findAll({});
// User.findAll({});

// 3. 일부 필드만 조회 (select name, married form users)
// User.findAll({
//    attributes:['name','married'],
// });

// 4. 일부 필드 & 일부 레코드(where 조건) 조회 - select name, age from users where married=1 and age>30
// User.findAll({
//     attributes:['name', 'age'],
//     where:{
//         married:1,           조건 1 : married 필드 값이 1
//         age:{[Op.gt]:30},    조건 2 : 나이 30 이상
//     },
// });
// where 절에 두개의 조건이 별도의 언급 없이 ',' 로 이어져있다면, 그 둘은 and로 묶여있는 것이다!


// 조건에 or 를 쓰려면
// select id, name from users where married=0 or age<30
// User.findAll({
//     attributes:['name', 'age'],
//     where:{
//         [Op.or] : [ {married:1}, {age:{[Op.lt]:30}}],
//     },
// });



// 5. 레코드 정렬 방법!
// Select id, name from users order by age desc;    age 내림차순으로 정렬!
// User.findAll({
//     attributes:['id', 'name'],
//     order:[['age', 'desc']],
// });

// Select id, name from users order by age desc, id asc;    age 내림차순, id 오름차순으로 정렬!
// User.findAll({
//     attributes:['id', 'name'],
//     order:[['age', 'desc'], ['id', 'asc']],
// });


module.exports = router;