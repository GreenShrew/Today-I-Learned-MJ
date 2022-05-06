// 04_Replace.js

// replace 함수를 이용하여 패턴으로 매칭된 텍스트를 지정한 텍스트로 치환할 수 있습니다.
let a = 'blue socks and red shocks';
let b = a.replace(/blue|white|red/g , 'color');
console.log(b);

a = 'park 010-1234-5678 , kim 010-8888-9999 , lee 010-1111-2222 ';
// 정규표현식과 replace 를 이용하여 전화번호 뒷자리를 모드 마스킹(*로 치환)해주세요
b = a.replace(/[-]\d{4}\s/g, '-****');
console.log(b);

a = '네이버 - http://www.naver.com , 다음 - http://www.daum.net , 네이트 - http://www.nate.com';
// 위  문자열에서 http 를 모두 https 로 치환해서 출력해주세요
b = a.replace( /\w+(?=:)/g , 'https' );
console.log();
console.log(b);  