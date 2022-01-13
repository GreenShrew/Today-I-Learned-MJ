package com.ezen.upload;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class multiFileUpload
 */
@WebServlet("/upload2.do")
public class multiFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public multiFileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath("upload");
		
		try {	// 파일을 넣지 않거나 등등의 이유로 나오는 에러를 잡는다. 지금은 수동으로 넣지만 나중에 배울 도구에서는 자동으로 넣어준다.
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		// form 안에 있던 <input type="file">의 파일들은 MultipartRequest 객체 생성시 한번에 업로드 된다.
		
		// 한번에 전달된 파일 이름들은 Enumeration을 사용하여 전달받고, 하나씩 꺼내서 사용한다.
		Enumeration files = multi.getFileNames();	// 파일들을 Enumeration에 저장
		
			int i = 1;
			while(files.hasMoreElements()) {		// 다음 데이터가 있으면 true, 없으면 false를 리턴하는 메소드
				String file = (String) files.nextElement();	// 파일 요소를 하나씩 추출하는 메소드
				
				// 업로드된 파일 이름 추출
				String file_name = multi.getFilesystemName(file);
				
				// DefaultFileRenamePolicy 에 의해 구분된 실제 파일 이름 추출
				String ori_file_name = multi.getOriginalFileName(file);
	
				// 원래 파일의 이름 추출
				request.setAttribute("file_name" + i, file_name);
				request.setAttribute("ori_file_name" + i, ori_file_name);
				// 02_Upload에서는 3개의 파일을 올릴거니깐 6개의 request가 발생할것이다.
				i++;
			}
		}catch(Exception e) {
			System.out.println("파일 업로드 실패 : " + e);
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("02_result.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
