// 06_ArrowFunction.js 화살표 함수
// 자바스크립트, kotlin 에서 많이 쓰인다!

// function 함수이름(매개변수){   }    -> 화살표를 이용한 표현방법으로 사용

// 함수의 표현 방법 #1
function add1(x, y){
    return x+y;
}
console.log(add1(10, 20));


// 함수의 표현 방법 #2
let add2 = function(x, y){      // 변수에 익명함수를 넣은 방식
    return x+y;
}
console.log(add2(10, 20));






// 함수의 표현 방법 #3-1
// 화살표 함수
// function(x, y){ }
// =>      (x, y)=>{ }

// function(){} 이런식으로 쓰던걸
// =>      ()=>{} 이렇게 쓸 수 있다. 모습만 변한것.

// const add = function(x, y){ }
// const add = (x, y)=>{ }

const add3 = (x, y) => {
    return x+y;
}
// 익명함수 (x, y) => {return x+y;} 가 add3에 저장
console.log(add3(10,20));



// 함수의 표현 방법 #3-2
const add4 = (x,y) => x+y;
console.log(add4(20, 30));
// 함수의 몸체가 단순하게 매개변수들의 연산의 결과들을 return 하는 명령만 있을때 사용한다.


// 함수의 표현 방법 #3-3
const add5 = (x, y) => (x+y);
console.log(add5(20, 30));




// 함수의 표현 방법 #3-4
function not1(x){
    return !x;
}
console.log(not1(true));

// 애초에 매개변수가 하나라면 소괄호를 없앨 수 있다!
const not2 = x => !x;
// const not2 = (x) => !x;
console.log(not2(false));





// 이제 유형별로 따로 본다.

// 매개변수 없고 리턴값이 없는 함수
const func1 = () => {
    console.log('매개변수 없고 리턴값 없는 함수');
}
func1();


// 매개변수 있고 리턴값이 없는 함수
const func2 = (x, y) => {
    console.log(`매개변수(${x}, ${y}) 있고 리턴값 없는 함수`);
}
func2(10, 20);


// 매개변수 있고 리턴값이 있는 함수
const func3 = (x, y) => {
    console.log(`매개변수(${x}, ${y}) 있고 리턴값 있는 함수`);
    return x+y;
}
console.log('리턴값' + func3(10,20));


// 매개변수 없고 리턴값이 있는 함수
const func4 = () => {
    console.log(`매개변수 없고 리턴값 있는 함수`);
    return 100;
}
console.log('리턴값' + func4(10,20));


// 매개변수와 상관없이 단순 리턴값만 있는 함수 : { } 가 없는 함수
const func5 = (x, y) => x+y;
// const func5 = (x, y) => (x+y);