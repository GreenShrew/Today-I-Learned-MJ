const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';  // 현재 development로 연결하겠다...
const config = require(__dirname + '/../config/config.json')[env];  // 어떤 development에? config.json이라는 파일의 development!
const db = {};  // 내용이 key값, value값인 객체로 저장된다.

const User = require("./user"); // user.js에서 DB 환경 구성을 하고 여기에다가 require 해서 쓴다.
const Comment = require("./comment");

// 여기에다가 써도 되지만, 복잡하므로 따로 써두고 require한다.

let sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;   // DB에 연결하기 위한 연결객체를 위에 있는 db 객체에 담는다.
db.Sequelize = Sequelize;   // 현재 파일에서 require 한 Sequelize 를 db 객체에 담는다.
// db = {sequelize:sequelize, Sequelize:Sequelize}; 
// db = {sequelize, Sequelize};

// require 한 user 모델과 comment 모델도 db에 담는다.
db.User = User;
db.Comment = Comment;

// 모델 객체를 초기화하는 함수와 관계 형성 함수를 실행한다.
User.init(sequelize);
Comment.init(sequelize);
User.associate(db);
Comment.associate(db);

// 여기까지의 코드가 테이블이 생성되는 내용이 구성되는 코드이다.
// 밑에 코드처럼 db가 exports 되고, app.js 에 require 되면,
// require된 db에서 sequelize를 꺼내서 sync 함수를 실행하게 되고, 이때 테이블도 생성한다.


// 그리고 마지막으로 정보를 담은 db를 exports 한다.
module.exports = db;
