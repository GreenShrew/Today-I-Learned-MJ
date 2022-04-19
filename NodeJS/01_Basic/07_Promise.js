// 07_Promise.js

// 함수와 비슷한 기능을 갖고 있는 객체
// 객체 내의 익명함수의 내용을 실행하고, 결과를 보관하고 있다가, 결과가 필요할 때 전달받아 사용할수 있게 해주는 구조의 객체이다.

// const pm = new Promis( /* 익명함수 */  );    // promise 객체의 전달인수가 없는 선언문.
// promise 객체는 생성자의 전달인수로 현재 promise 객체의 기능을 갖는 익명함수를 전달하여야 생성된다.

// func = (resolve, reject) => { }
// const pm = new Promise(func);
// 또는
// const pm = new Promise( (resolve, reject) => { } );
// 객체 변수의 이름은 pm이다.


/* 하나씩 예시를 보면서 공부하려면 묶음주석을 제거하자.

// 전달인수로 전달되는 익명함수의 내용
// const condition = true;
// (resolve, reject) => {
//    if(condition) resolve('성공');
//    else PromiseRejectionEvent('실패');
//}
// 익명함수에서 실행된 결과의 값이나 상태에 따라 resolve() 함수 또는 reject() 함수를 실행한다.
// 이때 문자로 resolve 와 reject에 전달인수로 전달하여 결과가 필요한 곳에서 그 데이터를 꺼내 쓸 수 있게 한다. 위의 예는 '성공' 또는 '실패' 가 전달된다.
// 함수 안에서 반드시 resolve() 또는 reject가 호출된다.
// if 문이나 선택 실행에 적용하여 둘중 하나만 실행하여도 되고, 무조건 resolve() 나 reject() 하나만 실행하기도 한다.
let condition = false;
// condition = true;    // <- 선택사항이다.

const pm = new Promise( // 전달인수가 resolve, reject이다.
    (resolve, reject)=>{
        if(condition){
            resolve('성공');
        }else{
            reject('실패');
        }
    }
);


// - Resolve(성공 리턴 값) -> then 으로 연결
// - Reject(실패 리턴 값) -> catch 로 연결
// - finally -> 성공과 실패 리턴값에 상관없이 무조건 실행되는 영역

// then과 함께 실행할 처리 이전에 다른 코드가 작성될 수 있다.
console.log('딴짓');
console.log('딴짓');
console.log('딴짓');
// 이제 결과를 이용한 작업을 시작한다.
// then과 catch와 finally에 익명함수가 전달인수로 전달되어 실행되게 한다.
// .then((message)=>{ })
// 매개 변수의 이름은 자유롭게 정할 수 있다.
// (message)=>{ } : resolve가 호출되어 도착했을 때 실행될 익명함수이다. message 변수에 '성공' 전달
// (error)=>{ } : reject 가 호출되어 도착했을 때 실행될 익명함수이다. reject 변수에 '실패' 전달
// pm.then( (message)=>{ } ).catch( (error)=>{ } ).finally( ()=>{ } )
pm
    .then( (message)=>{
        console.log(message);   // 성공(resolve)한 경우 실행
    }).catch((error)=>{
        console.error(error);     // 실패(reject)한 경우 실행
    }).finally(()=>{
        console.log('무조건 실행'); // 성공, 실패 중 하나와 함께 반드시 실행
    });

console.log();

*/

// 하나씩 예시를 실행하고자 할때는 하나씩 주석 처리를 해두자...
/*
// promise를 사용하지 않았을 때(동기식으로 무언가를 실행 => 비동기 명령 삽입)
const printString = (string, callback) => {
    var k = Math.floor(Math.random()*10000) + 1; // 0~9초 사이의 랜덤한 시간 계산(밀리초)
    setTimeout( () => {
        console.log(string + ' ' + k);
    }, k);
    callback();
}
// printString('A', function(){ printString("B", function() { }); } );
printString('A', ()=>{printString("B", ()=>{});});
*/


/*
// 동기 실행
console.log('작업 시작');
console.log('작업1 : 오래 걸리는 작업');
const wakeUpTime = Date.now() + 3000;   // 현재 시간에 3초를 더한 값을 wakeUpTime 변수에 저장
while(Date.now() < wakeUpTime) {}
// 오래 걸리는 작업이 올 걸리는 것 처럼 보이게 하기 위해 일부러 시간을 이용한 반복 실행을 사용
// 계속해서 현재 시간을 wakeUpTime와 비교해서 그보다 커질때까지 반복실행
console.log('작업2 : 오래 걸리는 작업의 다음 작업');
console.log('작업1, 작업2 순서에 맞춰 작업 끝');
*/

/*
// 비동기 실행
function longRunningTask(){
    console.log('작업1의 내용 모두 종료 후 끝')
}
console.log('시작');
console.log('작업1 : 오래 걸리는 작업 시작');
console.log('작업1을 비동기 실행으로 전환')
setTimeout(longRunningTask, 3000);   // setTimeout이 3초 후에 longRunnigTask 함수를 호출한다.
// setTimeout은 비동기 함수이기 때문에 별도의 실행 스레드가 실행을 담당하고, 현재 스레드는 다음 명령으로 실행 포커스가 이동한다.
console.log('작업2 : 오래 걸리는 작업의 다음 작업 시작');
console.log('작업2 만 일단 끝');
*/


/*
// Promise로 실행
console.log('시작');
// longRunningTask 라는 이름의 Promise를 만들었다.
let longRunningTask = new Promise(
    (resolve, reject)=>{
        console.log('작업1 : 오래 걸리는 작업 시작');
        setTimeout( ()=>{ console.log('작업1 : 종료'); }, 3000);    // setTimeout으로 비동기 실행으로 전환
        resolve();
    }
);

// 그리고 제작한 Promise를 실행하는데, 
longRunningTask
    .then(
        ()=>{
            console.log("작업2 : 오래걸리는 작업의 다음 작업");
            console.log("작업2 : 종료");
        }
    );

*/

/*

// printString 함수의 리턴값을 promise 로 활용
const printString = (string) =>{    // 전송된 전달인자를 출력하는 함수
    return new Promise( (resolve, reject)=>{
        var k = Math.floor(Math.random() * 10000) + 1;
        console.log('동기실행 시작');
        setTimeout(() => {
            console.log(string + ' ' + k);
        }, k);
        resolve();  // setTimeout의 실행여부와 상관없이 printString("A").then();로 이동한다.
    } );
}

printString("A").then(
    ()=>{
        console.log('동기실행 종료1');
        printString('B');
    }).then(
        ()=>{
            console.log('동기실행 종료2');
        }
    );

*/


// promise 연습
// 숫자 하나를 변수 k에 저장하고, 짝수이면 '짝수입니다', 홀수이면 '홀수입니다' 라는 텍스트를 결과로 전달하는 프라미스를 만들고, 결과를 출력해보자.

const k = 25;

const pm = new Promise((resolve, reject) =>{
    if(k%2==0){
        console.log('짝수입니다.');
    }else{
        console.log('홀수입니다.');
    }
});

pm
    .then((message)=>{
        console.log(message);
    })
    .catch((error)=>{
        console.error(error);
    });




// 연속 Promise()의 then과 resolve 사용

const pm1 = new Promise((resolve, reject)=>{
    resolve("첫번째 리졸브");
});

pm1.
    then((msg1)=>{
        console.log(msg1);
        return new Promise((resolve, reject)=>{
            resolve("두번째 리졸브");
        });
    })
    .then((msg2)=>{
        console.log(msg2);
        return new Promise((resolve, reject)=>{
            resolve("세번째 리졸브");
        });
    })
    .then((msg3)=>{
        console.log(msg3);
    })
    .catch((error)=>{
        console.error(error);
    });