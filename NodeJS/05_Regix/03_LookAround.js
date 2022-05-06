// 03_LookAround.js  - 전후방위 탐색  or  정방탐색


// #### 정방 탐색 
// 정규표현식으로 구분해 내고 매칭한 결과내용 중, 정규표현식에 사용되었던 글자를 제외한 나머지를 결과로 얻고자 할때,   예를 들어 http://www.naver.com   에서 '글자들이 반복되고 : 으로 끝남'   이라는 정규식이 있다면 결과는  http: 가 될테지만 원하는 결과가 ':' 을 제외한 'http' 만을 목적할때 사용하는 방식입니다

let a = 'http://www.naver.com';
// '.' : \n 이 아닌 모든 글자
let b = a.match(/.+:/g);
console.log(b);

a = 'https://www.naver.com';
b = a.match(/.+:/g);
console.log(b);


// 정방탐색을 사용한 예
// 정규식 : (?=정규식 또는 글자)
// 조건에 매칭이 된 후, 해당(?= 뒤로 이어진) 정규식에 있는 글자는 소모하지 않는다(취하지 않는다)
a = 'http://www.naver.com';
b = a.match(/.+(?=:)/g);
console.log(b);

a = 'https://www.naver.com';
b = a.match(/.+(?=:)/g);
console.log(b);




// 긍정형 전방위 탐색
// (?=정규식 또는 글자)  -> 정규식 또는 글자와 매칭되는 패턴 검색

// 부정형 전방위 탐색
// (?!정규식 또는 글자)  -> 정규식 또는 글자를 제외한 매칭 검색

// 긍정형, 부정형 모두 검색 결과에서 검색된 내용을 취하지 않습니다. 위 예제는 마지막 글자가 ':' 인결과를 검색하되 ':' 는 검색결과로 취하지 않은 결과입니다

// 전방위 탐색
// 앞에서 정방탐색이라는 이름으로 매칭하고자 할때, 버릴 문자와 취할 문자들을 앞, 또는 뒤에서 검색하는것을 말합니다. 전방위 탐색은 검색하고 버릴 문자를 앞쪽에서 검색합니다
// ?<=정규식

// 후방위 탐색
// 검색후 버릴 문자를 뒤에서 검색합니다
// ?=정규식 : 기존 방식과 동일 


a = '<html>\n\
<head>\n\
<title>안녕하세요 방갑습니다</title>\n\
</head>\n\
<body>\n\
<div>웹사이트에서 내용을 발췌합니다</div>\n\
</body>\n\
</html>';

console.log(a);
console.log();
b = a.match(/<div>.+<\/div>/g);
console.log(b);
console.log();
b = a.match(/(?<=<div>).+(?=<\/div>)/g);
console.log(b);


// 위의 a변수의 내용중 타이틀내용을 발췌해서 출력하세요
b = a.match(/(?<=<title>).+(?=<\/title>)/g);
console.log(b);


// 종합 : 여러가지 정규표현식의 예 실습

a = '일반텍스트 파일 : abc.txt , 자동실행파일 : autoexec.bat , 데이터분석파일 : bigdata.ai , 더미파일 : gfreag , 알수없는 파일 : korea.bar ';

// a변수에서  파일이름.확장자명 으로 구성된 파일명만 골라서 출력하세요.
let c = a.match(/\b\w*[.]\w+\b/g);   
// 빈칸으로 시작 , 글자반복후 . 포함, 다시 글자 반복, 마지막 빈칸으로 끝나는 내용 매칭
console.log(c);

a = '일반텍스트 파일 : abc.txt, 자동실행파일 : autoexec.bat, 데이터분석파일 : bigdata.ai, 더미파일 : gfreag, 알수없는 파일 : korea.bar';
c = a.match(/\b\w*[.]\w+/g);   
// 빈칸으로 시작 , 글자반복후 . 포함, 다시 글자 반복 매칭
console.log(c);


a = '일반텍스트 파일 : abc.txt , 자동실행파일 : autoexec.bat , 데이터분석파일 : bigdata.ai , 더미파일 : gfreag , 알수없는 파일 : korea.bar ';
// 파일의 확장자가 b로 시작하는 파일을 찾아서 출력해주세요
// 메타 캐릭터 '^' : [  ] 안에서 해당 내용을 제외하는 패턴으로 사용됩니다
c = a.match(/\b\w*[.]b\w+/g);   
console.log(c);
// 파일의 확장자가 b로 시작하지 않는 파일을 찾아서 출력해주세요
c = a.match(/\b\w*[.][^b]\w+/g);   
console.log(c);

// b로 시작하거나, a로 시작하는 확장자의 파일
c = a.match(/\b\w*[.]([b|a])\w+/g);   
console.log(c);
// b로 시작하지 않거나, a로 시작하는 확장자의 파일
c = a.match(/\b\w*[.]([^b]|a])\w+/g);   
console.log(c);


a = '박길동 : park@naver.com , 김하나 : kim@daum.net , 이두울 : ee@myhome.co.kr , 웹사이트 : http://abcdefg.co.kr';
// 이메일주소만 골라서 출력하세요
c = a.match(/\w*[@]\w*([.]\w*){1,2}/g);   
console.log(c);

// 이메일 주소중 .net 과 .com 만 골라서 줄력하세요
c = a.match(/\w*[@]\w*[.](com|net)/g);   
console.log(c);

a = '현재 접속중인 외부 아이피는 121.66.42.195  이며, 내부아이피는 192.168.0.2 입니다';
// 위 내용에서 아이피 주소만 매칭하여 출력해주세요
c = a.match(/\d{1,3}[.]\d{1,3}[.]\d{1,3}[.]\d{1,3}/g);
console.log(c);
// c = a.match(/[012][0-9][0-9][.]......./g);