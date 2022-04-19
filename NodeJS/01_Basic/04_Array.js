// 04_Array.js

// 배열
// 다양한 자료를 하나의 범주안에 넣고, 인덱싱(번호)을 이용해 컨트롤하는 변수
// 자바스크립트의 배열의 요소는 함수, 객체, 또다른 배열도 넣을 수 있다.
var array = [273, 'string', true, function(){}, {}, [150, 170]];
console.log(array[0]);
console.log(array[1]);
console.log(array[2]);
console.log(array[3]);
console.log(array[4]);
console.log(array[5]);
console.log(array);
console.log('\n');


// 배열에 요소 추가하기
var arr = ['a', 'b', 'c'];
console.log('변경전 : ' + arr);
arr.push('d');  // 배열의 끝에 요소를 추가
console.log('배열의 끝에 요소 추가 : ' + arr);
arr.unshift('A');   // 배열의 앞쪽에 요소를 추가
console.log('배열의 앞쪽에 요소 추가 : ' + arr);
arr.splice(2, 0, 'B');  // index 2 ('b')의 위치에 2개의 요소를 추가
console.log('index 2(\'b\')의 위치에 요소를 추가 : ' + arr);
console.log();


// 두개 한꺼번에 추가하기
arr = ['a', 'b', 'c', 'd'];  // 배열 재정의
console.log('변경전 : ' + arr);
arr.splice(2, 0, 'C', 'D');     //  index 2의 위치에 2개의 요소를 추가
console.log('변경후 (index 2의 위치에 2개의 요소를 추가) : ' + arr);
console.log('\n');



// 요소를 제거하는 여러가지 방법들
arr = ['a', 'b', 'c', 'd', 'e', 'f'];
console.log('변경전 : ' + arr);
// 배열의 첫번째 요소를 제거
var shifted = arr.shift();  // 제거한 요소를 받을 수 있다.
console.log('변경후 : ' + arr);
console.log('변경후 (배열의 첫번째 요소를 제거 & 제거한 요소 반환) : ' + shifted);
console.log('\n');

arr = ['a', 'b', 'c', 'd', 'e'];
console.log('변경전 : ' + arr);
// index 2 부터 1개의 요소('c')를 제거
arr.splice(2, 1);
console.log('변경후 (index 2 부터 1개의 요소(\'c\')를 제거) : ' + shifted);

arr = ['a', 'b', 'c', 'd', 'e'];
console.log('변경전 : ' + arr);
// index 1 부터 2개의 요소('b', 'c')를 제거
arr.splice(1, 2);
console.log('변경후 (index 1 부터 2개의 요소(\'b\', \'c\')를 제거) : ' + shifted);
console.log('\n');

// delete로 배열의 요소를 삭제할 경우 값은 삭제되고, 자리 요소는 존재한다.
arr = ['a', 'b', 'c', 'd', 'e'];
console.log('변경전 : ' + arr);
delete arr[1];
console.log('변경후 (arr[1] 삭제) : ' + arr);

// ※ splice(2, 0, 'x'); -> index 2 부터 0개를 삭제하고 x를 삽입하라
// splice(3, 2); -> index 3 부터 2개를 삭제하고 아무것도 삽입하지 말아라