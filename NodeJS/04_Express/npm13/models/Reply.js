// id(댓글번호-자동생성), boardnum(게시물 번호-board 테이블과의 외래키관계에 의한 자동생성), 
// writer(댓글작성자), content(댓글 내용), created_at(작성일시)
// 나머지 다른 설정들은 다른 테이블의 설정을 따르거나 맞춰서 설정합니다.
const Sequelize = require('sequelize');
module.exports = class Reply extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            writer:{
                type:Sequelize.STRING(30),
                allowNull:false,
            },
            content:{
                type:Sequelize.STRING(200),
                allowNull:false,
            },
            created_at:{
                type:Sequelize.DATE,
                allowNull:false,
                defaultValue:Sequelize.NOW
            },
        },{
            sequelize,
            timestamps: false,
            modelName: 'Reply',
            tableName: 'replys',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        });
    }
    static associate(db){
        db.Reply.belongsTo( db.Board, {foreignKey:'boardnum', targetKey:'id'} );
    }
}