// 모델명 : Post, 테이블명 : posts,   
// 필드 : content(문자140, null 허용안함), img(문자200, null 허용)
// user 와 1:N 관계표시 - user 모델 생성후 설정예정
// timestamp true, underscored false, paranoid false 나머지 기존 사항 그데로

const Sequelize = require('sequelize');

module.exports = class Post extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            content:{
                type:Sequelize.STRING(200),
                allowNull:false,
            },
            img:{
                type:Sequelize.STRING(200),
                allowNull:true,
            },
        },{
            sequelize,
            timestamp:true,
            underscored:false,
            modelName:'Post',
            tableName:'posts',
            paranoid:false,
            charset:'utf8mb4',
            collate:'utf8mb4_general_ci',
        });
    }
    static associate(db){
        db.Post.belongsTo(db.User);
        db.Post.belongsToMany( db.Hashtag, {through:'PostHashtag'});
    }
};