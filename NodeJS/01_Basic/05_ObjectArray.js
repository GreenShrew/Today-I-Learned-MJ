// 05_ObjectArray.js

function Student(name, korean, math, english, science){
    this.name = name;
    this.kor = korean;
    this.math = math;
    this.english = english;
    this.science = science;

    this.getSum = function(){
        return this.kor + this.math + this.english + this.science;
    }
    this.getAvg = function(){
        return this.getSum() / 4;
    }
    this.toString = function(){
        return this.name + ',  ' + this.getSum() + ',  ' + this.getAvg();
    }
}


let students = [];  // 비어있는 배열을 생성
let obj1 = new Student('홍길동', 80, 65, 98, 78);   // Student 객체를 생성
students.push(obj1);    // students 배열에 obj1 객체를 추가

// 이런식으로도 배열에 밀어넣을 수 있지만...
obj1 = new Student('홍길서', 65, 87, 89 ,87);
students.push(obj1);

// 이렇게 바로 배열에 객체를 넣을 수 있다.
students.push(new Student('홍길남', 88, 88, 99, 77));
students.push(new Student('홍길북', 88, 88, 99, 77));
students.push(new Student('김길동', 88, 88, 99, 77));
students.push(new Student('이길동', 88, 88, 99, 77));
students.push(new Student('박길동', 88, 88, 99, 77));

// 배열이 for 문에 사용되면 객체처럼 멤버변수들이 아니라 '인덱스값'들이 i에 전달되어 반복실행이 진행된다.
for(var i in students){
    console.log(students[i].toString());
}
console.log();





// 객체에 문자열 연선과 함수와 변수를 활용
let sayNode = function(){
    console.log('Node');
}

let myName = 'NodeJs';
let oldObject = {
    // myName : 'NodeJs'    함수에 myName이라는 key 값, value는 NodeJs로 넣으려고 했는데 이미 myName 변수가 있다. 이를 사용할 수 있다.
    // myName : myName,    // 첫번째 myName : 멤버변수, 두번째 myName : 일반변수
    // 멤버변수와 대입될 값을 저장하고 있는 일반변수의 이름이 같다면, 아래와 같이 한번만 써서 표현할 수 있다.
    myName, // 이렇게 한번만 쓰면 함수의 멤버변수 이름은 myName이고, 그 값은 일반 변수 myName이 가진 'NodeJs' 로 만들 수 있다.

    // 멤버 메서드를 만들어본다.
    sayJS:function(){
        console.log('JS');
    },
//    sayNode:function(){     // 근데 위에 sayNode라는 이름이 같은 함수가 저장되어있다!
//        console.log('Node');
//    }
//    sayNode : sayNode,   // 따라서 메서드 또한 이렇게 써도 되고
    sayNode,    // 이렇게 써도 된다!
};  // 키(멤버변수) 이름과 밸류변수 이름이 같으면 한번만 써도(:생략) 무방하다
console.log(oldObject.myName);
oldObject.sayNode();
oldObject.sayJS();



// 멤버변수 생성하기
let es = 'ES';
oldObject[es + '6'] = 'Fantastic';
// 'ES6' 이라는 멤버변수를 생성. 문자열 연산에 의해 변수 이름을 조합한 예
console.log(oldObject.ES6);

// const 변수로 객체 생성
const newObject = {
    myName,
    sayJS() {console.log('JS');},
    sayNode,
    [es + 6] : 'fantastic',
};
console.log(newObject.myName);  // myName
newObject.sayNode();    // Node
newObject.sayJS();  // JS
console.log(newObject.ES6); // Fantastic




console.log();
// 객체의 구조분해
// : 객체 내부의 멤버변수 또는 멤버 메서드를 별도의 변수에 따로 저장하여 별도로 사용하기 위한 문법
const sayJ = newObject.sayJS;   // 객체 내의 함수를 별도의 변수에 저장
sayJ();
const sayN = newObject.sayNode;
sayN();
console.log(newObject.ES6);
console.log(es6);




console.log();
// 객체의 구조분해를 하지 말아야 하는 경우 - this를 사용하는 객체는 구조분해를 하지 않는것이 좋다.
const candyMachine = {
    status : {
        name : 'node',
        count : 5,
    },
    getCandy(){
        this.status.count--;
        return this.status.count;
    },
};
console.log(candyMachine.getCandy());
var getCandy = candyMachine.getCandy;
var count = candyMachine.status.count;
// getCandy();  // 에러 - Cannot read properties of undefined (reading 'count')
console.log(count);

// 객체 내의 메서드가 구조분해 되는 순간 안에 있던 this를 사용할 수 없게 된다! this가 가르키는 것이 어느것인지 알 수 없기 때문이다.
// 따라서 그 안의 count 또한 없는 변수가 되어 에러를 발생한다.





const newObject1 = {
    myName1 : 'NODE.JS',
    [es + 2] : 'Fantastic',
    sayJS : function() {console.log('JS')},
    sayNo : function() {console.log('NODE')},
};

// 객체의 구조분해를 한번에 실행
const{myName1, ES2, sayJS, sayNo} = newObject1;
// 객체의 안의 변수 이름을 그대로 사용하는것이 보통이다.
console.log(myName1);
console.log(ES2);
sayNo();
sayJS();

// const{getCandy, status:{count}} = candyMachine;
// console.log(getCandy()); // 에러
// 위와 같이 한번에 구조분해를 하기 위해서는 중괄호 { } 안의 변수 이름을 맞춰서 분해한다.
// 분해하지 않으려고 하는 멤버는 중괄호 안에 쓰지 않아서 분해에서 제외할 수 있다.

// 이는 아래와 같이 배열에 여러 자료를 넣어놓고 인덱스를 이용하여 따로따로 추출하는 것과 한번에 추출하는 모양과 같은 형식으로 사용한다.
// 하나의 변수에 하나씩 추출
let array1 = ['nodejs', {}, 10, true];
let node1 = array1[0];
let obj3 = array1[1];
let bool1 = array1[3];
console.log(node1, obj3, bool1);
console.log();
// 한번에 추출
const array2 = ['nodejs2', {}, 20, false];
const [node2, obj2, , bool2] = array2;
console.log(node2, obj2, bool2);

