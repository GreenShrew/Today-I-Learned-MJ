//hashtag.js

const Sequelize = require('sequelize');
module.exports = class Hashtag extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            title:{
                type:Sequelize.STRING(20),
                allowNull:false,
                unique:true,
            },
        },{
            sequelize,
            timestamp:false,
            underscored:false,
            modelName:'Hashtag',
            tableName:'hashtags',
            paranoid:false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        });
    }
    static associate(db){
        db.Hashtag.belongsToMany(db.Post, {through:'PostHashtag'});
    }
};

//  hashtags  테이블의 필드는 id와 title  둘 뿐입니다
// posts 테이블과 N:N 관계가 성립됩니다.

// posts 테이블
// 1번게시물  #사과 #배\
// 2번게시물  #배 #오렌지
// 3번게시물  #오렌지 #사과
// 4번게시물  #딸기
// 5버게시물  #오렌지

// 중간에 다리역할을 하는 테이블이 필요
// 1번게시물 - 1번해시테그
// 1번게시물 - 2번해시테그
// 2번게시물 - 2번해시테그
// 2번게시물 - 3번해시테그
// 3번게시물 - 1번해시테그
// 3번게시물 - 3번해시테그
// 4번게시물 - 4번해시테그
// 5번게시물 - 3번해시테그

// hashtags 테이블
// 1번해시테그 사과
// 2번해시테그 배
// 3번해시테그 오렌지
// 4번해시테그 딸기