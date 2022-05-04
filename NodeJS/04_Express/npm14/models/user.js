// id 는 자동생성
// email(문자 50, 널허용, 고유값 설정), nick(문자30, 널허용안함), password(문자30, 널허용 안함), provider(문자20, 널허용 안함, 기본값:'local'), snsid(문자30, 널허용)
// 모델명 : User  테이블명:users   나머지 포스트 테이블과 같은 설정을 적용하세요

const { Sequelize } = require("sequelize");

module.exports = class User extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            email:{
                type:Sequelize.STRING(50),
                allowNull:true,
                unique:true,  //널값끼리는 고유값적용을 하지 않습니다
            },
            nick:{
                type:Sequelize.STRING(30),
                allowNull:false,
            },
            password:{
                type:Sequelize.STRING(200),
                allowNull:true,
            },
            provider:{
                type:Sequelize.STRING(20),
                allowNull:false,
                defaultValue:'local',
            },
            snsid:{
                type:Sequelize.STRING(30),
                allowNull:true,
            },
        },{
            sequelize,
            timestamps:true,
            underscored:false,
            modelName:'User',
            tableName:'users',
            paranoid:true,
            charset:'utf8',
            collate:'utf8_general_ci',
        });
    }
    static associate(db){
        db.User.hasMany(db.Post);
        db.User.belongsToMany(db.User, { foreignKey:'followingId', as:'Followers', through:'Follow' });
        db.User.belongsToMany(db.User, { foreignKey:'followerId', as:'Followings', through:'Follow' });
    }
};

// 유저1이 유저2를 팔로잉한다
// 유저1(Followers) , 유저2(Followings) 로 레코드 생성
// 반대로 유저2가 유저1을 필로잉한다
// 유저2(Followers) , 유저1(Followings) 로 레코드 생성
// 유저3(Followers) , 유저1(Followings)
// 유저4(Followers) , 유저1(Followings)
// 유저4(Followers) , 유저2(Followings)

