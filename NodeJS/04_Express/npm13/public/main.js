getBoard_list();

// 데이터베이스에서 게시물들을 읽어와서  table 의 tbody 에 tr 과 td로 삽입해넣는 함수
async function getBoard_list(){
    try{
        const res = await axios.get('/boards/boardList');
        const boards = res.data;

        // 테이블의 tbody 안을 비웁니다
        const tbody = document.querySelector('#board-list tbody');
        tbody.innerHTML='';

        boards.map( async function(board){
            const row = document.createElement('tr');

            row.addEventListener('click', ()=>{
                location.href="/boards/boardView/" + board.id;
            });

            let td = document.createElement('td');
            td.textContent = board.id;
            td.id = 'boardnum';
            row.appendChild( td );

            td = document.createElement('td');
            // 현재 게시물의 댓글 갯수를 조회해서 제목옆에 추가로 표시합니다.  갯수:조회된 댓글객체의 length(객체.length)
            let tContent = board.subject;

            try{
                const result  = await axios.get(`/boards/replycnt/${board.id}`);
                const data  = result.data;
                let cnt = data.cnt;
                if(cnt!=0){
                    tContent = tContent + ' <span style="color:red;font-weight:bold">[' + cnt + ']</span>'; 
                } 
            }catch(err){
                console.error(err);
            }

            td.innerHTML = tContent;
            row.appendChild(td);

            td = document.createElement('td');  
            td.textContent = board.writer; 
            td.id = 'writer';
            row.appendChild(td);

            td = document.createElement('td');  
            td.textContent = board.readCount; 
            td.id = 'readCount';
            row.appendChild(td);

            tbody.appendChild(row); 
        });

    }catch(err){

    }
}