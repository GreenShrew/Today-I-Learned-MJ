// 03_OS.js

// 자바에서 import 해서 쓰던 클래스 -> 자바스크립트에서는 Module 을 require 한다고 표현한다.
const os = require('os');
// os 모듈의 기능을 담고 있는 객체를 불러와서 os 변수(const 형 변수)에 저장하고 사용하겠다! 라는 뜻이다.

console.log('운영체제 정보 ------------------------------------------------------');
console.log('os.arch() : ', os.arch());     // 현재 운영체제 설계 및 운영 방식 출력
console.log('os.platform() : ', os.platform());     // 운영체제 기반 플랫폼 출력
console.log('os.type() : ', os.type());     // 운영체제 종류 출력
console.log('os.uptime() : ', os.uptime());     // 운영체제 부팅 후 흐른 시간 출력
console.log('os.hostname() : ', os.hostname());     // 컴퓨터 이름 출력
console.log('os.release() : ', os.release());     // 운영체제 버젼 출력

console.log('경로 ------------------------------------------------------');
console.log('os.homedir() : ', os.homedir());   // 현재 사용자의 홈 디렉토리(폴더)
console.log('os.tmpdir() : ', os.tmpdir());     // 현재 사용자의 임시 디렉토리(폴더)

console.log('cpu 정보 ------------------------------------------------------');
console.log('os.cpus() : ', os.cpus());     // cpu 정보
console.log('os.cpus().length : ', os.cpus().length);   // cpu 코어 갯수

console.log('메모리 정보 ------------------------------------------------------');
console.log('os.freemem() : ', os.freemem());       // 사용 가능 메모리
console.log('os.totalmem() : ', os.totalmem());     // 전체 메모리