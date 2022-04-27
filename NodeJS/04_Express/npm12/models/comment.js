// comment.js
const Sequelize = require('sequelize');

// 필드 :  comment(String(100), null허용안됨), created_at(DATE, null허용)
// 테이블 옵션은 User 와 똑같이 합니다 다만, modelName:'Comment', tableName : 'comments' 로 설정
// 위 두개의 필드를 같는  Comment 모델(클래스)를 만들고 exports 해주세요

module.exports = class Commnet extends Sequelize.Model{
    static init( sequelize ){
        return super.init({
            // id 필드는 현재테이블의 기본키로 자동생성(값도 자동증가)
            // 누가 댓글을 썻는지에 대한 필드 : commenter 정도의 이름으로 만들어질 필드
            // 외래키 설정시 역시 자동 생성됩니다 -> users 테이블의 id 가 복사되어져서, 현재테이블의 필드로 삽입생성됩니다.
            // 외래키로 설정될 필드는 따로 기술하지 않고, 외래키에서 설정함과 동시에 자동생성되도록 합니다.
            comment:{
                type:Sequelize.STRING(100),
                allowNull:false,
            },
            created_at:{
                type:Sequelize.DATE,
                allowNull:true,
                defaultValue:Sequelize.NOW,
            },
        },
        {
            sequelize,
            timestamp:false, 
            underscored:false, 
            modelName: 'Comment',
            tableName : 'comments', 
            paranoid:false, 
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        });
    }
    static associate( db ){
        db.Comment.belongsTo( db.User , { foreignKey: 'commenter', targetKey: 'id' } );
        // Comment 모델의 commenter 필드가 User 모델의  id 필드를 참조하면서 복사&생성됩니다.
    }
};