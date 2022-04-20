// Var.js
// 03_OS.js에서 봤던것처럼, node.js에 내장되어있는 'os' 모듈을 require 해서 그 내부의 변수나 함수를 사용할 수 있었다면, 이번엔 내가 만든 객체를 export 해두고서 이를 require 해서 사용하는 예를 살펴볼 예정이다.

const odd = '홀수입니다.';
const even = '짝수입니다.';

// 아래처럼 객체를 만들어도 된다!
/*
{
    odd,
    even
};
*/

// 위 두개의 변수를 객체에 넣는다.
module.exports = {
    odd:odd,
    even:even,
};

// 만들어진 객체를 module.exports 에 저장하면 그 객체는 외부로 내보내진다.
// 딱히 어느 파일로 보내겠다는 방향은 없고, export 되었다 라는것을 알고있는 파일에서 require 해서 사용한다.
// module 이라는 단위로, 이름은 파일 이름인 Var로 exports 된다.