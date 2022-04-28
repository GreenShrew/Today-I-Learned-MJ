const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};

let sequelize = new Sequelize(config.database, config.username, config.password, config );

// 각 테이블에 대한 모델  require 
const Member = require('./member');
const Board = require('./board');
const Reply = require('./reply')

db.sequelize = sequelize;
db.Sequelize = Sequelize;

//db 객체에 넣고, init, assciate  실행
db.Member = Member;
db.Board = Board;
db.Reply = Reply;
Member.init(sequelize);
Board.init(sequelize);
Reply.init(sequelize);
Member.associate(db);
Board.associate(db);
Reply.associate(db);

module.exports = db;
