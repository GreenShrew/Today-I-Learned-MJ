// 11_readFileAsync.js

const fs = require('fs');

/*
// 이렇게 쓰면 순서가...
//시작
//끝
// 1번 저는 readMe1 입니다.
// 2번 저는 readMe2 입니다.
// 3번 저는 readMe3 입니다.
// 이런식으로 순서가 바뀐다.
// 왜냐하면 fs는 그 자체가 비동기이기 때문이다.
// 그리고 readMe1,2,3 은 순서가 뒤죽박죽 실행될수도 있다...
// 결국 순서, 동작의 끝을 보장할 수 없다.

console.log('시작');

fs.readFile('./readMe1.txt', (err, data)=>{
    if(err){ throw err; }
    console.log('1번', data.toString())
});

fs.readFile('./readMe2.txt', (err, data)=>{
    if(err){ throw err; }
    console.log('2번', data.toString())
});

fs.readFile('./readMe3.txt', (err, data)=>{
    if(err){ throw err; }
    console.log('3번', data.toString())
});

console.log('끝');

*/

// 시작 - 1 2 3 번 - 끝 이런식으로 강제로 만들어보자.
// 아예 하나의 비동기 함수 실행영역 안에 또 다른 비동기 함수를 넣어, 하나의 동작이 끝나면 뒤 이어서 동작하도록 하나에다가 몰아넣으면 된다!
console.log('시작');

fs.readFile('./readMe1.txt', (err, data)=>{
    if(err){ throw err; }
    console.log('1번', data.toString())

    fs.readFile('./readMe2.txt', (err, data)=>{
        if(err){ throw err; }
        console.log('2번', data.toString())

        fs.readFile('./readMe3.txt', (err, data)=>{
            if(err){ throw err; }
            console.log('3번', data.toString())
        });
    });
});

console.log('끝');
