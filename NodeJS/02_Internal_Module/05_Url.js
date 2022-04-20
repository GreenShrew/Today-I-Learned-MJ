// 05_Url.js

const url = require('url');

const { URL } = url;
const myURL = new URL('http:www.daum.net/book/bookList.aspx?sercate1=001001000#anchor');
console.log('new URL() : ', myURL);
console.log('url.format() : ', url.format(myURL));

console.log('----------------------------------');
const parsedUrl = url.parse('http:www.daum.net/book/bookList.aspx?sercate1=001001000#anchor');
console.log('url.parse() : ', parsedUrl);
console.log('url.format() : ', url.format(parsedUrl));
// 인터넷 주소를 parse 함수로 분해해서 각각의 요소들을 따로 분리하고 사용할 수 있다.

console.log(parsedUrl.query);   // 파싱된 주소에서 쿼리만 분리하여 출력
// 위와 같이 주소를 parseUrl로 분해하고, 전달되는 파라미터 값만을 얻고싶다..하면 위와 같이 코딩한다.
// 마치 자바에서 request.getParameter 처럼....근데 여기에는 이게 없으니깐 위의 코드로 이런 역할을 하는 것이다!