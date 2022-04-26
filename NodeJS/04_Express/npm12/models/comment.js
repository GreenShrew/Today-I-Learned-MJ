// comment.js
const Sequelize = require('sequelize');

// comment 테이블에는 어떤 필드를 구성할것인가?
// 필드 : comment(String(100), null 허용안됨), created_at(DATE, null 허용)
// 테이블 옵션은 User와 똑같이 한다. 다만, modelName:'Comment', talbeName:'comments' 로 설정한다.
// 위 두개의 필드를 가지는 Comment 모델(클래스)를 만들고 exports 해보자.

module.exports = class Comment extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            // comment 를 누가 썼는지 알려주는 필드가 없다...? 원래라면 user 테이블에서 해당 값을 참조해서 넣었을텐데?
            // id 필드는  현재 테이블의 기본키로 자동 생성된다(값도 자동증가)
            // 누가 댓글을 썼는지에 대한 필드 : commenter 정도의 이름으로 만들어질 필드이다.
            // 외래키 설정시 역시 자동 생성된다! -> users 테이블의 id가 복사되어져서, 현재 테이블의 필드로 삽입생성된다!
            // 외래키로 설정될 필드는 따로 기술하지 않고, 외래키에서 설정함과 동시에 자동 생성되도록 한다!
            // 따라서 여기에 따로 user_id를 따로 써줄 필요가 없다!
            // 이 작업을 어디서 할까? 하단의 associate에서 한다!
            // 단, 한쪽만 한다고 되는게 아니다. 둘다 만드는것도 아니고, 주는쪽에서 만들어서 받는쪽으로 준다고 생각하자.
            // user_id를 설정하기 위해 user.js의 associate로 가자.
            comment:{
                type:Sequelize.STRING(100),
                allowNull:false,
            },
            created_at:{
                type:Sequelize.DATE,
                allowNull:true,
                defaultValue:Sequelize.NOW, // mysql에서 설정할 수도 있지만, 이를 여기서 설정하여 사용한다!
            }
        },
        {
            sequelize,
            timestamp:false,
            underscored:false,
            modelName:'Comment',
            tableName:'comments',
            paranoid:false,
            charset:'utf8mb4',
            collate:'utf8mb4_general_ci',
        });
    }
    static associate(db){
        // #2.
        db.Comment.belongsTo(db.User, {foreignKey:'commenter', targetKey:'id'});      // db에 있는 User 모델을 참조하고 있다는 명령
        // Comment 모델의 commenter 필드가 User 모델의 id 필드를 참조하면서 복사&생성된다.
        
        // 이렇게 하면 두개의 테이블간의 설정이 완료된다.
    }
};
