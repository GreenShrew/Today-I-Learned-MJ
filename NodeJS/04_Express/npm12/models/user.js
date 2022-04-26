// node가 sequelize를 이용해서 mysql에 테이블을 생성하거나 조작할 수 있는 "테이블모델"을 만든다.
const Sequelize = require('sequelize');

// 아래의 형태로 만들어진 객체를 exports 하고, index.js에서 가져다 쓸 예정이다.
// user.js -> index.js - > app.js 이 방향으로 require 된다.

// 데이터베이스의 테이블을 만들기 위한 클래스
// 본래 {} 는 객체를 만드는 것 아닌가? 이지만 Sequelize 로 인해 클래스로 만들어진다.

// 순서!
// class User{}
// class User extends Sequelize.Model {}
// module.exports = class User extends Sequelize.Model {}

/* 테이블을 생성하고 관계를 설정하는 클래스의 구조는 아래와 같다!
module.exports = class User extends Sequelize.Model {
    // 테이블을 생성하고 초기화하는 함수
    static init(sequelize){}
    // 테이블간 관계 설정 함수
    static associate(db){}
};
*/

/* init 함수 내부에는 객체 2개가 들어간다! 첫 객체는 필드명과 필드 옵션, 두번째는 테이블의 옵션들이 멤버 형식으로 정의된다.
module.exports = class User extends Sequelize.Model {
    // 테이블을 생성하고 초기화하는 함수
    static init(sequelize){
        return super.init({

        },
        {

        });
    }
    // 테이블간 관계 설정 함수
    static associate(db){}
};
*/


// 어디에선가 User.init 이렇게 호출이 된다! (static 함수니깐!)
// 외부에서 user를 require 하고, User.init(Sequelize); 이와 같이 호출될 예정이다.

module.exports = class User extends Sequelize.Model {
    // 테이블을 생성하고 초기화하는 함수
    static init(sequelize){ // sequelize 이 매개변수 이름은 바꿔도 무방
        return super.init({
            // init 함수에 각 필드의 이름(키)과 객체 속성들(값)이 매칭된 객체가 전달된다.
            // 테이블의 각 필드를 객체 멤버 형식으로 나열한다!
            // 각 멤버들의 값들도 객체이다.
            name:{    // 이 안에는 자료형, null 허용 여부
                type:Sequelize.STRING(20),
                allowNull:false,    // not null
                unique:false,   // 동명이인이 있을 수 있따.

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
            created_at:{    // 레코드의 insert 시점(날짜 시간)을 기록
                type:Sequelize.DATE,
                allowNull:true,
            },
            // 첫번째 필드 : id 필드는 따로 기술하지 않아도 자동 증가 필드로 추가된다.
        },
        {   // 여기는 테이블의 옵션들이 멤버 형식으로 정의된다.
            sequelize,
            timestamp:false,    // 이 속성이 true 이면, createdAt, updatedAt 필드를 자동 생성한다. 레코드를 생성한 시간, 수정한 시간을 기록하는 필드!
            // 이걸 쓰지 않고 위에 created_at으로 만들어두었다..
            underscored:false,  // 이 속성이 true이면, createdAt, updatedAt 필드의 이름이 created_at, updated_at으로 바뀐다.
            modelName:'User',   // sequelize 가 사용할 model(테이블)의 이름
            tableName:'users',  // 데이터베이스의 자체 테이블의 이름
            paranoid:false,     // 이 멤버가 true이면, deletedAt 필드가 생성된다.
            // deletedAt : 원래 delete 하면 레코드가 사라지는데, 이건 delete 명령을 내린 시점을 저장하고, 레코드가 마치 사라진것처럼 만든다. 레코드는 삭제되지 않고 그대로 남아있다!
            charset:'utf8mb4',
            collate:'utf8mb4_general_ci',

            // createdAt : 레코드 insert 된 시간
            // updateAt : 레코드 수정 update 된 시간
            // deletedAt : 레코드 삭제 시간 - 실제 데이터는 삭제되지 않고 삭제 명령을 내린 시간만 기록된다. 
        });
    }
    // 테이블간 관계 설정 함수...근데 지금은 user 테이블만 있어서 관계설정 할게 없다!
    static associate(db){
        // #1.
        db.User.hasMany(db.Comment, {foreignKey:'commenter', sourceKey:'id'}); // 현재 db의 User 모델과 Comment 모델 사이에 관계를 설정한다.
        // User 모델의 필드값이 Comment 모델에 같은 필드값으로 여러번 나오도록 설정( 1:N 관계! )
        // User 모델의 id 필드를 Commnet 모델에 commenter 필드로 복사하고, 관계를 설정한다.
        // 여기까지 쓰고 comment.js로...
    }
};