// const{ odd, even } = require('./var');   사실 이걸 require 할 필요는 없다. func03에서 var를 require 해서 쓰기 때문이다!
const checkNumber = require('./func03');
// checkNumber 변수에 func03.js 파일에서 exports 한 함수를 require 했다.

const result = checkNumber(15);
console.log('15는 ', result);