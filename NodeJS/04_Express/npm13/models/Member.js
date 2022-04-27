// userid,  pwd, name, phone, email, created_at 들을 필드로한 모델을 만들어주세요
// board 의 writer 하고    member 의 userid 하고  N:1  관계를 설정해주세요(저랑 같이 진행)
// 기타의 설정은  이전 프로젝트를 참고하여 같은 설정이거나 맞춰서 설정합니다.

// userid 에 기본키 설정하면 자동으로 생성되는 id(일련번호)필드는 생성되지 않습니다.
const Sequelize = require('sequelize');

module.exports = class Member extends Sequelize.Model{
    static init( sequelize ){
        return super.init({
            userid:{
                type:Sequelize.STRING(30),
                allowNull:false,
                primaryKey:true,
                unique:true,
            },
            pwd:{
                type:Sequelize.STRING(30),
                allowNull:false,
            },
            name:{
                type:Sequelize.STRING(30),
                allowNull:false,
            },
            phone:{
                type:Sequelize.STRING(20),
                allowNull:false,
            },
            email:{
                type:Sequelize.STRING(50),
                allowNull:true,
            },
            created_at:{
                type:Sequelize.DATE,
                allowNull:false,
                defaultValue:Sequelize.NOW,
            },
        },{
            sequelize,
            timestamps: false, 
            modelName: 'Member',
            tableName: 'members',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        });
    }
    static associate(db){
        db.Member.hasMany( db.Board, { foreignKey:'writer', sourceKey:'userid', onDelete:'cascade' } );
    }
};