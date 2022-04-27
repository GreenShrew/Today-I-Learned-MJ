// id(자동생성), subject(100), content(1000), readCount, createdAt, filename(100), realfilename(100)
// Writer 필드 -> Member 테이블의 userid 와 1:N 관계로 복사 & 생성예정
// 이전 프로젝트 내용을 참조해서 관계설정(associate)도 진행주세요
const Sequelize = require('sequelize');
module.exports = class Board extends Sequelize.Model {
    static init(sequelize){
        return super.init({
            subject: {
                type: Sequelize.STRING(100),  allowNull: false,
            },
            content: {
                type: Sequelize.STRING(1000),  allowNull: false,
            },
            readCount:{
                type: Sequelize.INTEGER.UNSIGNED,   allowNull: false,
                defaultValue:0,
            },
            created_at: {
                type: Sequelize.DATE,    allowNull:true,
                defaultValue: Sequelize.NOW,
            },
            filename: {
                type: Sequelize.STRING(100),   allowNull: true,
            },
            realfilename: {
                type: Sequelize.STRING(100),    allowNull: true,
            },
        },{
            sequelize,
            timestamps: false,
            modelName: 'Board',
            tableName: 'boards',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        });
    }
    static associate(db) {
        db.Board.belongsTo( db.Member, { foreignKey:'writer', targetKey:'userid'  } );
        db.Board.hasMany( db.Reply, {foreignKey:'boardnum', sourceKey:'id', onDelete:'cascade' } );
    }
};