// 02_Regix02.js


// 메타캐릭터(메타문자) : ^, $, | 등의 글자로 패턴을 표현한 글자들

// | : or 의 의미로 사용. a|b 은 a 또는 b 의 의미

/*
let a = "Hello World";
let b = a.match(/Hello|Crow/g);
console.log(b);

a = "Welcome Crow";
b = a.match(/Hello|Crow/g);
console.log(b);

a = "Hello World Welcome Crow";
b = a.match(/Hello|Crow/g);
console.log(b);
*/



// ^ : ^abc 는 abc로 시작하는 의미의 정규식
// $ : abc$는 abc로 끝나는 의미의 정규식
a = "Life is too short";
b = a.match(/^Life/g);
console.log(b);

a = "Life is too short";
b = a.match(/short$/g);
console.log(b);


// * \b : Word Boundary 의미로   whitespace 로 식별되는 메타 문자입니다
// * 원래 문자열 안에 사용하는 \b 는 백스페이스의 역할을 하는 이스케이프 문자 이지만
// * 정규표현식에서는  공백을 의미하도록 사용됩니다/

a = "no class are all classa";
b = a.match(/\bclass\b/g);
console.log(b);

a = "the declassified algrithm";
b = a.match(/\bclass\b/g);
console.log(b);

a = "one subclass is'";
b = a.match(/\bclass\b/g);
console.log(b);



// \B : whitespace 로 구분되지 않은 , 그 외 다른 글자로 구분되는 정규식
a = "no class are all classa";
b = a.match(/\Bclass\B/g);
console.log(b);

a = "the declassified algrithm";
b = a.match(/\Bclass\B/g);
console.log(b);

a = "one subclass is'";
b = a.match(/\Bclass\B/g);
console.log(b);


























