// 구조분해 할당으로 변수 초기화
// require 로 얻어오면서 바로 구조분해 시켰다.
const{ odd, even } = require('./var');
// const {odd:odd, even:even}  이름이 같아서 줄일 수 있었다!

// require 로 얻어온 값을 이용한 함수 제작
function checkOddOrEven(number){
    if(number % 2){
        return odd;
    }else{
        return even;
    }
}

// 모듈을 이용하면, 함수도 export 해서 다른 파일에서 사용이 가능하다.
module.exports = checkOddOrEven;