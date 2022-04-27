// node 가 sequelize 를 이용해서 mysql 에 테이블을 생성하거나 조작할 수 있는 "테이블모델"을 만듭니다
const Sequelize = require('sequelize');

// 아래의 형태로 만들어진 객체를 exports 하고, index.js 에서 가져다 쓸 예정
// user.js -> index.js -> app.js  이 방향으로 require 됩니다

// class User{};
// class User extends Sequelize.Model {};
// module.exports = class User extends Sequelize.Model {};

/*
module.exports = class User extends Sequelize.Model {
    // 테이블을 생성하고 초기화하는 함수
    static init( sequelize ){}
    // 테이블간 관계 설정 함수
    static associate(db){}
};
*/

/*
module.exports = class User extends Sequelize.Model {
    // 테이블을 생성하고 초기화하는 함수
    static init( sequelize ){
        return super.init({

        },
        {

        });
    }
    // 테이블간 관계 설정 함수
    static associate(db){}
};
*/


// 외부에서 User를 require 하고 , User.init( Sequelize ); 이와 같이 호출될 예정입니다
module.exports = class User extends Sequelize.Model {
    // 테이블을 생성하고 초기화하는 함수
    static init( sequelize ){
        return super.init({
            // init  함수에 각 필드의 이름(키)과 객체속성들(값)이 매칭된 객체가 전달됩니다.
            // 각 필드를 객체 멤버 형식으로 나열합니다.  
            // 각 멤버들의 값들도 객체입니다.
            name:{
                type:Sequelize.STRING(20),
                allowNull:false,
                unique:false,
            },
            age:{
                type:Sequelize.INTEGER.UNSIGNED,
                allowNull:false,
            },
            married:{
                type:Sequelize.BOOLEAN,
                allowNull:true,
            },
            comment:{
                type:Sequelize.TEXT,
                allowNull:true,
            },
            created_at:{    // 레코드의 insert 시점(날짜 시간)
                type:Sequelize.DATE,
                allowNull:true,
            },
            // 첫번째 필드 : id 필드는 따로 기술하지 않아도 자동증가 필드로 추가됩니다
        },
        {  // 테이블의 옵션들이 멤버형식으로 정의됩니다.
            sequelize,
            timestamp:false, // 이 속성이 true 이면, createdAt, updatedAt  필드를 자동생성합니다
            underscored:false, // 이속성이 true이면, createdAt, updatedAt 필드의 이름이 created_at, updated_at 으로 바뀝니다.
            modelName: 'User',   // sequelize 가 사용할 모델(테이블)의 이름
            tableName : 'users',  // 데이터베이스의 자체 테이블의 이름
            paranoid:false, // 이 멤버사  true  이면,  deletedAt 필드가 생성됩니다
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',

            // createdAt : 레코드 insert 된 시간
            // updatedAt : 레코드 수정 update 된 시간
            // deletedAt : 레코드 삭제 시간 - 실제 데이터를 삭제 되지 않고 시간만 기록
        });
    }
    // 테이블간 관계 설정 함수
    static associate(db){
        db.User.hasMany(db.Comment , {foreignKey:'commenter', sourceKey:'id'} );
        // User 모델의 필드값이 Comment 모델에 같은 필드값으로 여러번 나오도록 설정(1:N 관계)
        // User모델의 id 필드를 Comment 모델에 commenter 필드로 복사하고, 관계 설정합니다
    }
};