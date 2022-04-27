const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};

const User = require("./user");
const Comment = require("./comment");

let sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;   // 데이터베이스에 연결하기위한 연결객체를 db 객체에 담습니다
db.Sequelize = Sequelize;   // 현재파일에서  require 한 Sequelize 를 db 객체에 담습니다
// db = { sequelize:sequelize,  Sequelize:Sequelize };
// db = { sequelize,  Sequelize };

// require 한  user 모델과 comment  모델도 db 에 담습니다
db.User = User;
db.Comment = Comment;

// 모델객체를 초기화하는 함수와 관계 형성 함수를 실행합니다
User.init(sequelize);
Comment.init(sequelize);
User.associate(db);
Comment.associate(db);

// 여기까지의 코드가 테이블이 생성되는 내용을 구성되는 코드입니다.
// 밑에 코드처럼    db가 exports 되고,  app.js에  require 되면, 
// equire된 db 에서 sequelize 를 꺼내어서  sync 함수를 실행하게 되고 이때 테이블도 생성합니다.

module.exports = db;
