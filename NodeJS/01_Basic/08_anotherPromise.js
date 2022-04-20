// 08_anotherPromise.js

// Promise 결과를  별도의 함수 안에서 활용할때 많이 사용하는 방법이다.
const condition = false;

const promise1 = new Promise((resolve, reject)=>{
    if(condition) resolve('성공');
    else reject('실패');
});

// await 를 사용한 명령은 반드시 async 로 함들어진 함수 안에서 사용해야한다.
async function abcd(){
    try{
        const result = await promise1;  // resolve에서 전달한 값을 result에 저장한다.
        // await : promis 의 비동기실행을 기다리다가 필요할때 꺼내기 위한 키워드
        console.log('1' + result);
    }catch(error){
        console.error('2' + error);
    }
}

abcd();


// 동기식 실행이 필요한 경우...
// await promise의 연속 실행
const promise = new Promise((resolve, reject)=>{    // 실패는 없다고 가정
    resolve("첫번째 리졸브");
});

async function func01(){
    try{
        const result = await promise;
        console.log(result);
        return "두번째 리졸브"; // 새로운 promise 객체에 resolve 호출
    }catch(err){
        console.log(err);
    }
}

func01().then((result2)=>{
    console.log(result2);
})
.catch((error)=>{
    console.error(error);
});

