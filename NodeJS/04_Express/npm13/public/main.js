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

            let td = document.createElement('td');
            td.textContent = board.id;
            td.id = 'boardnum';
            row.append( td );

            td = document.createElement('td');
            let tContent = board.subject;
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