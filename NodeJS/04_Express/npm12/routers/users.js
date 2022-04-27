const express = require('express');
const User = require('../models/user');
const Comment = require('../models/comment');

const router = express.Router();

router.post('/', async (req, res, next)=>{
    // 전달된 값들로 레코드 추가
    try{
        const user = await User.create({
            name:req.body.name,
            age:req.body.age,
            married:req.body.married,
        });
        // console.log(user);
        res.json(user);
    }catch(err){
        console.error(err);
        next(err); //에러 루틴이 있는 라우터로 이동
    }
});

//1. 레코드 삽입
// 모델명.create({
//      필드명:입력값,
//      필드명:입력값,
//      필드명:입력값,
// });

//User.create({
//    name:'hong',
//    age:24,
//    married:false,
//    comment:'일반회원',
//});



router.get('/', async (req, res, next)=>{
    try {
        // User 객체를 통해 users 테이블의 모든 데이터 조회
        const users = await User.findAll({

        }); 
        // 결과를 json 형식으로 리턴 해줍니다
        res.json(users);
    } catch (err) {
        console.error(err);
        next(err); //에러 루틴이 있는 라우터로 이동
    }
});
//2. 일반조회(모든 필드, 모든레코드)
// 모델명.findAll({});
// User.findAll({});

//3. 일부 필드만 조회 (select name, married from users)
// User.findAll({
//      attributes:['name', 'married'],
// });

//4. 일부 필드 & 일부 레코드(where조건) 조회 - select name, age from users where married=1 and agd>30 
// User.findAll({
//      attributes:['name' , 'age' ],
//      where:{
//          married:1,
//          age:{ [Op.gt]:30 },
//      },
// });
// where 절에 두개의 조건이 별도의 언급없이 ',' 로 이어졌다면 그 둘은  and 로 묶여 있는 것입니다


// or 를 쓰려면
// select id, name from users where married=0 or age<30
// User.findAll({
//      attributes:['id' , 'name' ],
//      where:{
//          [Op.or] : [ {married:1},  {  age:{ [Op.lt]:30 }  } ],
//      },
// });



//5. Select id, name from users order by age desc;
// User.findAll({   
//      attributes:['id' , 'name; ],
//      order:[['age' , 'desc']],
// });

// Select id, name from users order by age desc, id asc;
// User.findAll({   
//      attributes:['id' , 'name; ],
//      order:[ ['age' , 'desc'], ['id', 'asc'] ],
// });


module.exports = router;