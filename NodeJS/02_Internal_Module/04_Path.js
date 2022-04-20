// 04_Path.js
const path = require('path');

// path 가 아니어도 사용 가능한 경로와 파일 관련 상수
console.log(__filename);    // 현재 사용중인 파일의 이름
console.log(__dirname);     // 현재 파일이 위치한 경로
// 언더바가 두개이다!

// 현재 경로와 파일의 이름을 변수에 저장하여 별도 출력
const string = __filename;
console.log(string);

console.log();

console.log('------------------------------');

console.log('path.seq : ', path.sep);   // 경로 내부의 폴더들 구분 문자
// '\' back slash -> c:\users\java01 와 같이 사용한다.
console.log('path.delimiter : ', path.delimiter);
// 환경변수 내에서 서로 다른 경로를 같이 나타낼때 구분해주는 구분 문자 - 세미콜론 ';'
// c:\users\java01; c:\users\java01\documents; 와 같이 사용한다.

console.log();

console.log('------------------------------');

// 파일이 위치한 폴더 경로를 보여준다. - string 은 위에서 현재 파일의 이름을 저장해둔 변수이다.
console.log('path.dirname() : ', path.dirname(string));
// 파일의 확장자(.js)를 보여준다.
console.log('path.extname() : ', path.extname(string));
// 파일의 이름+확장자를 보여준다.
console.log('path.basename() : ', path.basename(string));
// 파일의 이름만 보고싶다면, 함수의 두번째 인자로 확장자를 넣어준다.
console.log('path.basename(extname 제외) : ', path.basename(string), path.extname(string));

console.log();

console.log('------------------------------');

// 파일의 경로를 root, dir, base, ext, name으로 분리한다.
console.log('path.parse() : ', path.parse(string));
// 파일의 경로와 이름, 확장자를 제공하고, 경로-파일이름-확장자로 조합한다.
console.log('path.format() : ', path.format({
    dir: 'C:\\TIL\\node_js',
    name: 'javascript_ex1',
    ext: '.js',
}));
// 파일 경로를 사용하던 중 \ 나 / 를 실수로 여러번 쓴것을 수정한다.
console.log('path.normalize() : ', path.normalize('D:///TIL\\\\node_js\\\javascript_ex1.js'));

console.log();

console.log('------------------------------');

// 파일의 경로가 절대 경로인지 상대경로인지 true false 로 표시한다.
console.log('path.isAbsolute(C:\\):', path.isAbsolute('C:\\'));
console.log('path.isAbsolute(./home):', path.isAbsolute('./home'));

// 인수로 나오는 경로와 경로 사이에 이동 경로를 표시한다.
console.log('path.relative():', path.relative('C:\\TIL\\nodejs', 'C:\\'));
// path.relative(): ..\..   -> 세번 부모 폴더로 이동

// 처음 경로부터 이후 나오는 경로로 이동한 폴더를 표시한다.
console.log(__dirname);
console.log('path.join():', path.join(__dirname, '..', '/TIL', '.', 'node_js'));
// 현재 폴더에서 부모 폴더로 이동, TIL 폴더로 이동, 현재 폴더에서, node_js 폴더로 표시 를 뜻한다.
// 결과 : C:\TIL\TIL\node_js
// 이동 경로에 해당 폴더가 없어도 경로 이름은 조합되어 결과로 나온다.


// ----------------------------------------------------------------------
// resolve 와 join 은 비슷하지만, '/' 표시를 절대경로인지, 상대경로인지 어떻게 보는지가 다르다.
// resolve는 절대경로로 보기 때문에 최종 결과 경로가 C:\node_js 가 된다.
// '/TIL' 에 의해서 C:\TIL 로 되었다가 'node_js' 에 의해서 다시 C:\node_js 로 설정된다.
console.log('path.resolve():', path.resolve(__dirname, '..', '/TIL', '.', 'node_js'));