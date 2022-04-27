getUsers();
getComments();


// 회원 추가 : 사용자 등록 - user-from 이 submit 이벤트를 일으키면 실행
document.getElementById('user-form').addEventListener('submit', async (e)=>{
    e.preventDefault();
    // 이름 , 나이, 결혼여부를 변수에 저장
    const name = e.target.username.value;
    const age = e.target.age.value;
    const married = e.target.married.checked;

    if (!name) {  return alert('이름을 입력하세요');  }
    if (!age) { return alert('나이를 입력하세요'); }

    try{
        await axios.post('/users', {name, age, married});
        // 레코드를 추가하고 되돌아 오면,  user들을 모두 조회해서 user-list 테이블에 모두 행단위로 표시합니다
        // user 들을 조회해서 user-list 에 행단위로 추가하는 함수 호출
        getUsers();
    }catch(err){
        console.error(err);
    }
    e.target.username.value = '';
    e.target.age.value = '';
    e.target.married.checked = false;
});

// 댓글 등록 : comment-form 이 submit 이벹느를 일으키면 실행
document.getElementById('comment-form').addEventListener('submit', async (e)=>{
    e.preventDefault();
    const id = e.target.userid.value;
    const comment = e.target.comment.value;
    if (!id){ return alert('아이디를 입력하세요');  }
    if (!comment){ return alert('댓글을 입력하세요');  }
    try {
        await axios.post('/comments', { id, comment });
        getComments();
    } catch (err) {
        console.error(err);
    }
    e.target.userid.value = '';
    e.target.comment.value = '';
});


async function getComments(){
    try{
        const res = await axios.get('/comments');
        const comments = res.data;
        const tbody = document.querySelector('#comment-list tbody');
        tbody.innerHTML = '';

        comments.map(function(comment){
            const row = document.createElement('tr');
            let td = document.createElement('td');
            td.textContent = comment.id;
            row.appendChild(td);
            td = document.createElement('td');
            td.textContent = comment.User.name; // 코멘트 포함된  user 모델의 필드를 표시
            // td.textContent = comment.commenter
            row.appendChild(td);
            td = document.createElement('td');
            td.textContent = comment.comment;
            row.appendChild(td);
             // 수정 버튼
            const edit = document.createElement('button');
            edit.textContent = '수정';

            // 수정버튼에 이벤트리스너 설정
            edit.addEventListener('click', async ()=>{
                // 댓글 id(일련번호)와 입력받은 내용으로  comment를 수정하시고, 다시 댓글들을 검색하여 댓글을 표시해주세요
                const newComment = prompt('바꿀 내용을 입력하세요');
                if (!newComment) { return alert('내용을 반드시 입력하셔야 합니다'); }

                try{
                    // http://localhost:3000/comments/3
                    await axios.patch(`/comments/update/${comment.id}` , {comment:newComment} );
                    getComments();
                }catch(err){
                    console.error(err);
                }

            });

              // 삭제버튼
            const remove = document.createElement('button');
            remove.textContent = '삭제';

            // 삭제버튼 이벤트 리스너 설정
            remove.addEventListener('click', async () => {
                try {
                    await axios.delete(`/comments/delete/${comment.id}`);
                    getComments();
                } catch (err) {
                    console.error(err);
                }
            });


            td = document.createElement('td');  // td 생성
            td.appendChild(edit);  // 버튼을 td 에 추가
            row.appendChild(td);  // 버튼이 든 td 를 tr 에 추가
            td = document.createElement('td');
            td.appendChild(remove);
            row.appendChild(td);
            tbody.appendChild(row);
        });
    }catch(err){
        
    }
}


async function getUsers(){
    // 모든 user 를 조회해서 user-list 테이블에 표시합니다
    try{
        // '/users' 의  get 방식으로 모든 사용자 정보를 조회하고 리턴된 데이터를 res  에 저장합니다
        const res = await axios.get('/users');
        // 결과를 사용하기 위하여 변수만들고 데이터를 추출합니다
        const users = res.data;

        const tbody = document.querySelector('#user-list tbody');
        tbody.innerHTML='';

        // users 에 있는 user들을 하나씩 user 변수(함수의 매개변수)에 넣으면서  인원수만큼 반복실행합니다
        users.map(function(user){
            const row = document.createElement('tr'); // tr 태그 생성
            
            let td = document.createElement('td');  // td 태그 생성
            td.textContent = user.id; // 생성된 태그에 user 의 id 삽입
            row.appendChild(td);  // tr 안에 td  삽입

            td = document.createElement('td'); 
            td.textContent = user.name;
            row.appendChild(td); 

            td = document.createElement('td'); 
            td.textContent = user.age;
            row.appendChild(td); 

            td = document.createElement('td'); 
            td.textContent = user.married ? '기혼' : '미혼';
            row.appendChild(td); 

            row.addEventListener( 'click', ()=>{
                getCommentOne(user.id);
            });

            tbody.appendChild(row); // 완성된 tr 을  tbody 에 추가
        });

    }catch(err){

    }
}


async function getCommentOne(id){
    try{
        const res = await axios.get(`/comments/search/${id}`);
        const comments = res.data;
        const tbody = document.querySelector('#comment-list tbody');
        tbody.innerHTML = '';
        comments.map(function(comment) {
            const row = document.createElement('tr');
            let td = document.createElement('td');
            td.textContent = comment.id;
            row.appendChild(td);
            td = document.createElement('td');
            td.textContent = comment.User.name;
            row.appendChild(td);
            td = document.createElement('td');
            td.textContent = comment.comment;
            row.appendChild(td);

            // 수정 버튼
            const edit = document.createElement('button');
            edit.textContent = '수정';
            td = document.createElement('td');  // td 생성
            td.appendChild(edit);  // 버튼을 td 에 추가
            row.appendChild(td);  // 버튼이 든 td 를 tr 에 추가

            // 삭제버튼
            const remove = document.createElement('button');
            remove.textContent = '삭제';
            td = document.createElement('td');
            td.appendChild(remove);
            row.appendChild(td);

            tbody.appendChild(row);
        });
    }catch(err){

    }
}