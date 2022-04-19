// 03_Object.js


// 1. 자바 스크립트의 객체 생성
// { } 중괄호 안에 key(요소의 이름) 와 value(요소의 값)이 ':'(콜론) 으로 구분되어서 존재하는 값들의 집합이다.
var product = {name:'냉장고', 제조사:'대한민국'};
// 변수 하나 안에 한개 이상의 키와 값이 조합되어 데티어를 넣어 사용한다.
// 객체 안에 있는 키와 값의 조합 하나를 속성이라고 하며, 각 속성은 콤마(,) 로 구분한다.

// 객체 내의 키를 이용한 값을 출력 (멤버변수의 key값으로 value를 불러올 수 있다.)
console.log(product['제조사']);
console.log(product.name);

const product2 = {};    // 아무것도 없으나, 이것 또한 객체이다.
console.log(product2);

// 자바스크립트의 객체는 별도의 클래스 선언 없이, { } 중괄호 안에 직접 속성들을 넣은 순간 객체(Object)로 인식되어 사용되어진다.


// 2. 객체의 속성과 메서드
// - 속성 : 객체 내부에 있는 하나하나의 값.
// - 객체의 속성이 가질 수 있는 자료형.
var object = {
    useNumber:273,
    useString:'문자열',
    useBoolean:true,
    useArray:[52,385,103,58],
    // 메서드 : 객체의 속성 중 함수 자료형인 속성.
    method:function(){      // method는 익명함수의 이름이다.
        console.log('멤버 함수를 실행합니다.');
    }
};
object.method();    // 함수의 이름에 괄호를 붙여서 함수의 내용을 실행한다.
console.log(object.method);     // 변수만 출력할 경우, 해당 메소드의 정보인 [function:method] 이 출력된다.
console.log(object.method());   // 함수의 내부에 있는 console.log('멤버 함수를 실행합니다.'); '멤버 함수를 실행합니다.' 출력. 그리고 console.log(object.method()); 의 console.log는 undefined를 출력한다.
console.log(object.useNumber); 
console.log(object.useArray);



// 멤버함수에 매개변수가 존재할 수 있다.
var person  = {
    name:'홍길동',
    eat:function(food){
        console.log('음식 : ' + food);
    }
};
console.log(person.name);
person.eat('스파게티');



// 멤버 함수가 멤버 변수로의 접근
// - this 키워드 : 자바스크립트는 멤버변수에 접근을 위해서 반드시 this 키워드를 써야한다.
var person2 = {
    name:'홍길동',
    eat:function(food){
        // console.log(this.name + '이/가 ' + food + '을/를 먹었습니다.');
        console.log(`'${this.name}'이/가 '${food}'을/를 먹었습니다.'`);
    }
};
person2.eat('김밥');


console.log();  // 줄바꿈
// 3. 객체와 반복문
var product3 = {
    name:'Eclipse & Tomcat',
    price:'Free',
    language:'한국어',
    supportOS:'win32/64',
    subscription:true
};

console.log(product3['name']);  // 이름을 출력하기 위한 명령
console.log(product3.name);
console.log();

// 객체 이름을 반복문에 대입하여 각 멤버 변수들의 값에 접근 가능하다.
for(var key in product3){
    var output = `${key} : ${product3[key]}`;
    console.log(key, '-', output);
}
// ${key}는 key값을, ${product3[key]}는 해당 key의 value를 출력한다.
// product3 객체에 있는 모든 멤버변수 이름을 key라는 변수에 저장하면서 반복실행(멤버변수 갯수만큼)
// product[key] : key 값을 이용한 멤버변수 값들에 접근 -> 출력




// 4. 객체와 관련된 키워드
var student = {
    이름 : '홍길동',
    국어 : 92,
    수학 : 98,
    영어 : 96,
    과학 : 98
};

// - in : 해당 키(멤버변수)가 객체 안에 있는지 확인한다.
console.log('이름' in student);
console.log('성별' in student);


console.log();
// - with : 복잡하게 사용해야 하는 코드를 짧게 줄여 주는 키워드
// ex) .with 키워드를 사용하지 않은 경우!
var write = '';
write += '이름 : ' + student.이름 + '\n';
write += '국어 : ' + student.국어 + '\n';
write += '수학 : ' + student.수학 + '\n';
write += '영어 : ' + student.영어 + '\n';
write += '과학 : ' + student.과학 + '\n';
console.log(write);

// .with 키워드를 사용하는 경우
var write = '';
with(student){
    write += '이름 : ' + 이름 + '\n';
    write += '국어 : ' + 국어 + '\n';
    write += '수학 : ' + 수학 + '\n';
    write += '영어 : ' + 영어 + '\n';
    write += '과학 : ' + 과학 + '\n';
}
console.log(write);



// 5. 객체의 속성 추가와 제거
// - 동적 속성 추가/제거 : 처음 객체를 생성하는 시점 잏에 객체의 속성을 추가하거나 제거할 수 있다.

// 빈 객체를 생성
var student = {};

// 객체 생성 이후 동적으로 속성(멤버변수)를 추가할 수 있다.
student.이름 = '홍길동';
student.취미 = '악기';
student.특기 = '프로그래밍';
student.장래희망 = '훌륭한 프로그래머';

for(var key in student){
    console.log(`${key} : ${student[key]}`);
}

// 동적으로 메서드 추가
student.toString = function(){
    for(var key in this){   // 자신의 객체를 for 문에 적용
        if(key != 'toString'){  // 메서드 toString 이 아니라면 다른 멤버 변수의 값을 출력
            console.log(`${key} : ${student[key]}`);
        }
    }
}
student.toString();

// 객체의 속성 제거
delete(student.장래희망);
student.toString();
console.log('\n');



// 6. 생성자 함수 : new 키워드를 사용해 객체를 생성할 수 있는 함수.
// - 생성자 함수를 사용한 객체의 생성과 출력. 그냥 함수를 사용해 객체를 리턴하는 방법과 차이가 없어보인다.

var student1 = {이름:'홍길동'};
var student2 = {이름:'홍길동', 성별:'남자'};
var student3 = {이름:'홍길동', 성별:'남자', 나이:20};
// 셋은 멤버변수가 다 다르기 때문에 형태가 다른 객체이다.

// 함수 안에 this 를 이용한 변수에 값을 넣으면 그 이름의 멤버 변수가 만들어지고, 최종 그 변수들을 멤버로 하는 객체가 만들어지는 생성자 함수로 인식된다.
function Student(name, korean, math, english, science){     // 생성자 함수!
    // 속성
    this.name = name;
    this.kor = korean;
    this.math = math;
    this.english = english;
    this.science = science;

    // 메서드
    this.getSum = function(){
        return this.kor + this.math + this.english + this.science;
    }
    this.getAvg = function(){
        return this.getSum() / 4;
    }
    this.toString = function(){
        return this.name + ',  ' + this.getSum() + ',  ' + this.getAvg();
    }
}   // 객체가 만들어지기 위한 생성자 함수이다.

// 생성자 함수를 이용하여 객체 만들기
var std1 = new Student('홍길동', 88, 78, 98, 87);
var std2 = new Student('홍길남', 77, 67, 78, 76);
var std3 = new Student('홍길서', 60, 70, 90, 80);
// 서로 다른 객체 std1, std2, std3 를 만들었다.

// 생성된 객체가 가지고있는 메서드 toString 실행
console.log(std1.toString());
console.log(std2.toString());
console.log(std3.toString());
console.log('\n');




// 7. 프로토타입 (중요하고 알아두면 편리함)
// - 생성자 함수를 사용해 생성된 객체가 공통으로 가지는 공간.
// - 자바스크립트의 모든 생성자 함수는 내부의 this 변수들의 prototype을 갖는다
// 그리고 prototype은 객체이다.

function Student(name, korean, math, english, science){
    // 속성
    this.name = name;
    this.kor = korean;
    this.math = math;
    this.english = english;
    this.science = science;
}

// 위 주석을 쉽게 말하자면...
// 생성자 함수가 만들어지고, 그 안에 this 를 이용한 멤버변수가 정의되고, 초기화되면,
// 그 함수로 만들어질 객체를 위한 프로토타입이라고 하는 객체가 생성된다.
// 프로토타입은 생성될 객체의 원본이 되는 객체이며,
// 프로토타입 또한 객체 형태로 존재한다.

var std1 = new Student('홍길서', 87, 98, 87, 45);
// 위 명령이 실행되는 순간 프로토타입의 사본이 std1에 저장되면서 새로운 객체를 이룬다.

// 만약 생성자함수에 추가로 멤버변수 또는 멤버 메서드를 추가하려고 한다면,
Student.prototype.basicLanguage = 100;  // 멤버변수 추가!
Student.prototype.getSum = function(){
    return this.kor + this.math + this.english + this.science + this.basicLanguage;
}
Student.prototype.getAvg = function(){
    return this.getSum() / 5;
}
Student.prototype.toString = function(){
    return this.name + ',  ' + this.getSum() + ',  ' + this.getAvg();
}
console.log();
// 새로 추가된 멤버변수 basicLanguage 변수의 값을 전달 인수로 전달해서 초기화할수는 없다.
std1 = new Student('홍길서', 95, 87, 98, 99);   // basicLanguage의 값은 100이다.
console.log(std1.toString());

// 프로토타입은 생성자 안에서 새로 만들어지는 객체에 복사되기 위해 준비되고 있는 공간이다.
// 그 안에 새로 만들어질 객체의 모습을 갖춘 객체이다.
// 생성자에 멤버변수와 멤버메서드를 추가하려면, 반드시 이 프로토타입을 이용하자!


// 객체를 생성후에 멤버메서드를 추가하느냐, 프로토타입에 메서드를 추가하고 객체를 만드느냐는 선택적으로 사용할 수 있다.

// (1). 객체 먼저 만들고, 그 객체에 toString 멤버메서드 추가
var std1 = new Student('홍길동', 88, 99, 77, 66);
std1.toString = function(){  }
// 결과 : 현재 객체에만 toString 추가

// (2). 생성자에 toString 추가하고 객체 생성
Student.prototype.toString = function(){  }
var std1 = new Student('홍길동', 88, 99, 77, 66);
// 결과 : 앞으로 Student 생성자를 이용해서 만들어지는 모든 객체에 toString 추가




// 9. 상속
function Rectangle(w, h){
    var width = w;
    var height = h;
    this.getWidth = function() {return width;}
    this.getHeight = function() {return height;}
    this.setWidth = function(value) {width = value;}
    this.setHeight = function(value) {height = value;}
}

// 프로토타입으로 메서드 추가
Rectangle.prototype.getArea = function() {
    return this.getWidth() * this.getHeight();
}
var rectangle = new Rectangle(5, 7);
rectangle.setWidth(8);  // 8로 가로 변경
console.log('AREA : ' + rectangle.getArea());
console.log('\n');


// Rectangle 생성자를 상속
// Square의 함수는 Rectangle 함수를 상속받아서 쓴다!
function Square(length){
    this.base = Rectangle;
    // 전달된 length 값을 base 생성자의 w, h 에 같은 값으로 전달
    this.base(length, length);
}
// 추가로 프로토타입도 복사한다.
Square.prototype = Rectangle.prototype;

// 부모 생성자로 객체 생성
var rectangle = new Rectangle(5, 7);
// 자식 생성자로 객체 생성
var square = new Square(5);

// 상속받은 메서드 실행
console.log('rectangle AREA : ' + rectangle.getArea());
console.log('square AREA : ' + square.getArea());




// 10. Object 객체
// - Object 객체의 toString() 메서드는 객체를 문자열로 변환할때 자동으로 호출한다.
var obj = new Object();
console.log(obj);   // 결과는 {}
console.log(obj.toString());    // [object Object]

// - toString() 메서드의 재정의
var student = {
    name:'홍길동',
    grade:'고등학교 1학년',
    toString:function() {return this.name+':'+this.grade;}
}
console.log(student);       // Object 객체가 갖고 있는 toString 이 모든 멤버를 출력한다.
console.log(student.toString());    // 재정의된 toString 이 함수 안의 내용을 리턴 또는 실행한다.
