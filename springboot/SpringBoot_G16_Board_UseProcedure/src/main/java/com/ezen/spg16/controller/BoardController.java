package com.ezen.spg16.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg16.dto.BoardVO;
import com.ezen.spg16.dto.Paging;
import com.ezen.spg16.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@RequestMapping("/main")
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser") == null)	
			mav.setViewName("loginform");
		else {
			int page=1;
			if( request.getParameter("page") != null ) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			} else if( session.getAttribute("page") != null ) {
				page = (int) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			// int count = bs.getAllCount();
			paramMap.put("cnt", 0);
			bs.getAllCount( paramMap );
			int count = (Integer) paramMap.get("cnt");
			
			paging.setTotalCount( count );
			paging.paging();			
			
			
			paramMap.put("ref_cursor", null);
			//paramMap.put("paging", paging);
			paramMap.put("startNum", paging.getStartNum() );
			paramMap.put("endNum", paging.getEndNum() );
			
			bs.selectBoard( paramMap );
			
			ArrayList< HashMap<String, Object> > list
			 = ( ArrayList< HashMap<String, Object> > ) paramMap.get("ref_cursor" );
			
			mav.addObject( "boardList", list);
			mav.addObject( "paging", paging);
			mav.setViewName("board/main");
		}
		return mav;
	}
	
	
	
	@RequestMapping("/boardView")
	public ModelAndView boardView( @RequestParam("num") int num,  
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		/*HashMap<String, Object> resultMap = bs.boardView(num);
		// bs.boardView(num); 에서  조회수 늘리고, 게시물 조회하고, 댓글리스트 조회
		BoardVO mvo = (BoardVO)resultMap.get("board");
		mav.addObject("board" ,  mvo );
		mav.addObject("replyList", resultMap.get("replyList") );*/
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor1", null);
		paramMap.put("ref_cursor2", null);
		bs.boardView( paramMap );
		ArrayList<HashMap<String, Object>> list1
		 	= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor1");
		ArrayList<HashMap<String, Object>> list2
	 		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		
		mav.addObject("board" ,  list1.get(0) );
		mav.addObject("replyList", list2 );
		mav.setViewName("board/boardView");		
		
		return mav;
	}
	
	
	
	
	@RequestMapping("/addReply")
	public String addReply(
			@RequestParam("boardnum") int boardnum, 
			@RequestParam("userid") String userid, 
			@RequestParam("content") String content, HttpServletRequest request) {
		// 댓글 추가
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid );
		paramMap.put("content", content );
		paramMap.put("boardnum", boardnum );
		
		bs.insertReply( paramMap );
		
		return "redirect:/boardViewWithoutCount?num=" + boardnum;
 	}
	
	@RequestMapping("/boardViewWithoutCount")
	public ModelAndView boardViewWithoutCount( @RequestParam("num") int num,  
			HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor1", null);
		paramMap.put("ref_cursor2", null);
		bs.boardViewWithoutCount( paramMap );   // 수정됨
		ArrayList<HashMap<String, Object>> list1
		 	= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor1");
		ArrayList<HashMap<String, Object>> list2
	 		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		mav.addObject("board" ,  list1.get(0) );
		mav.addObject("replyList", list2 );
		mav.setViewName("board/boardView");		
		return mav;
	}
	
	
	
	@RequestMapping("/deleteReply")
	public String reply_delete( @RequestParam("replynum") int replynum, 
			@RequestParam("boardnum") int boardnum,
			HttpServletRequest request) {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("replynum" , replynum);
		bs.deleteReply(paramMap);
		return "redirect:/boardViewWithoutCount?num=" + boardnum;
	}
	
	
	
	@RequestMapping("/boardEditForm")
	public String board_edit_form(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}
	
	
	@RequestMapping("/boardEdit")
	public String board_edit(@RequestParam("num") int num,
			@RequestParam("pass") String pass, 
			Model model, HttpServletRequest request) {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor", null);
		
		bs.getBoard( paramMap );
		ArrayList< HashMap<String, Object> > list 
			= (ArrayList< HashMap<String, Object> >) paramMap.get("ref_cursor");
		
		HashMap<String, Object> bvo = list.get(0);		
		model.addAttribute("num", num);
		
		if(pass.equals( bvo.get("PASS") ) ){
			return "board/boardCheckPass";
		}	else {
			model.addAttribute("message", "비밀번호가 맞지 않습니다. 확인해주세요");
			return "board/boardCheckPassForm";
		}
	}
	
	
	
	
	@RequestMapping("boardUpdateForm")
	public String board_update_form(@RequestParam("num") int num,
			Model model, HttpServletRequest request) {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor", null);
		bs.getBoard( paramMap );
		ArrayList< HashMap<String, Object> > list 
			= (ArrayList< HashMap<String, Object> >) paramMap.get("ref_cursor");
		HashMap<String, Object> bvo = list.get(0);	
		
		BoardVO dto = new BoardVO();
		//System.out.println( Integer.parseInt( String.valueOf( bvo.get("NUM") ) ) );
		// dto.setNum( num );
		dto.setNum( Integer.parseInt( String.valueOf( bvo.get("NUM") ) ) );
		dto.setPass( (String)bvo.get("PASS") );
		dto.setUserid( (String)bvo.get("USERID") );
		dto.setTitle( (String)bvo.get("TITLE") );
		dto.setContent( (String)bvo.get("CONTENT") );
		dto.setEmail((String)bvo.get("EMAIL"));
		dto.setImgfilename((String)bvo.get("IMGFILENAME"));
		
		model.addAttribute("num", num);
		model.addAttribute("dto", dto);
		return "board/boardEditForm";
	}
	
	
	
	
	@RequestMapping("/selectimg")
	public String selectimg() {
		return "board/selectimg";
	}
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/fileupload" , method = RequestMethod.POST)
	public String fileupload(Model model, HttpServletRequest request) {
		String path = context.getRealPath("/upload");		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			// 전송된 파일은 업로드 되고, 파일 이름은  모델에 저장합니다
			model.addAttribute("image", multi.getFilesystemName("image") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "board/completupload";
	}
	
	
	
	
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate( 	@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result, 
			@RequestParam("oldfilename") String oldfilename, 
			HttpServletRequest request, Model model) {
		String url = "board/boardEditForm";
		if( result.getFieldError("pass")!=null) 
			model.addAttribute("message" , "비밀번호는 게시물 수정 삭제시 필요합니다");
		else  if(result.getFieldError("title")!=null) 
			model.addAttribute("message" , "제목은 필수입력 사항입니다");
		else if(result.getFieldError("content")!=null) 
			model.addAttribute("message" , "게시물 내용은 비워둘수 없습니다.");
		else {
			if( boardvo.getImgfilename()==null || boardvo.getImgfilename().equals("") )	
				boardvo.setImgfilename(oldfilename);

			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("num", boardvo.getNum());
			paramMap.put("userid", boardvo.getUserid());
			paramMap.put("pass", boardvo.getPass());
			paramMap.put("email", boardvo.getEmail());
			paramMap.put("title", boardvo.getTitle());
			paramMap.put("content", boardvo.getContent());
			paramMap.put("imgfilename", boardvo.getImgfilename());
			
			bs.updateBoard(paramMap);
			
			// 다시 해당 번호의 게시물로 돌아간다.
			url = "redirect:/boardViewWithoutCount?num=" + boardvo.getNum();
		}	
		
		return url;
	}
	
	
	@RequestMapping("boardDeleteForm")
	public String board_delete_form(@RequestParam("num") int num,
			Model model, HttpServletRequest request) {
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}
	
	
	@RequestMapping("boardDelete")
	public String board_delete(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		
		bs.removeBoard(paramMap);
		
		return "redirect:/main";
	}
	
	
	@RequestMapping("/boardWriteForm")
	public String write_form(HttpServletRequest request) {
		
		String url = "board/boardWriteForm";
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			url = "member/loginForm";
		}
		return url;
	}
	
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String board_write(
			@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result, 
			Model model, 
			HttpServletRequest request) {
		
		String url="board/WriteForm";
		if(result.getFieldError("pass")!=null) {
			model.addAttribute("message", result.getFieldError("pass").getDefaultMessage());
		}else if(result.getFieldError("title")!=null) {
			model.addAttribute("message", result.getFieldError("title").getDefaultMessage());
		}else if(result.getFieldError("content")!=null) {
			model.addAttribute("message", result.getFieldError("content").getDefaultMessage());
		}else {
		
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			
			paramMap.put("userid", boardvo.getUserid());
			paramMap.put("pass", boardvo.getPass());
			paramMap.put("email", boardvo.getEmail());
			paramMap.put("content", boardvo.getContent());
			paramMap.put("title", boardvo.getTitle());
			paramMap.put("imgfilename", boardvo.getImgfilename());
			
			bs.insertBoard(paramMap);
			url = "redirect:/main";
		}
		
		return url;
	}
}












