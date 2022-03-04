package com.ezen.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.MemberDto;
import com.ezen.board.dto.ReplyVO;
import com.ezen.board.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/boardList")
	public String main( HttpServletRequest request , Model model) {
		
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser") == null)	
			return "member/loginform";
		else {
			ArrayList<BoardDto> list = bs.getBoardsMain();
			model.addAttribute("boardList", list);
		}		
		return "board/main";
	}
	
	
	@RequestMapping("/boardWriteForm")
	public String write_form(Model model, HttpServletRequest request) {
		String url = "board/boardWriteForm";
		
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser") == null)	
			url="loginform";		
		
		return url;
	}
	
	
	@RequestMapping(value="boardWrite", method = RequestMethod.POST)
	public String board_write(Model model, HttpServletRequest request) {
		
//		HttpSession session = request.getSession();
//		ServletContext context = session.getServletContext();
		// 기존에는 위의 방법으로 사진을 업로드 했으나, 스프링 프레임워크에서는 스프링 컨테이너에 ServletContext를 넣고 @Autowired로 쓴다.
		// 그런데, 스프링 컨테이너에 ServletContext가 이미 들어가있다! 기본적으로 제공한다!
String path = context.getRealPath("resources/upload");
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			BoardDto bdto = new BoardDto();
			bdto.setPass( multi.getParameter("pass") );
			bdto.setUserid( multi.getParameter("userid") );
			bdto.setEmail( multi.getParameter("email") );
			bdto.setTitle(  multi.getParameter("title") );
			bdto.setContent( multi.getParameter("content") );
			bdto.setImgfilename( multi.getFilesystemName("imgfilename") );
			
			bs.insertBoard( bdto );
			
		} catch (IOException e) { e.printStackTrace();
		}
		
		return "redirect:/boardList";
	}
	
	
	@RequestMapping("/boardView")
	public String boardView( Model model, HttpServletRequest request ) {
		
		int num = Integer.parseInt( request.getParameter("num") ); 
		/*
		BoardDto bdto = bs.boardView(num);
		model.addAttribute("board", bdto);
		
		ArrayList<ReplyVO> list = bs.getReplysOne(num);
		model.addAttribute("replyList", list);
		*/
		// 위의 boardView, getReplysOne 를 하나로 합쳐서 전달시키는 방법!
		// HashMap은 여러 타입의 데이터를 한꺼번에 넣을 수 있다!
//		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		// #1. HashMap을 쓰는 첫번째 방법!
/*		paramMap.compute("bdto", null);
		paramMap.compute("replyList", null);
		paramMap.put("num",num);
		bs.boardView(paramMap);	*/
		
		// #2. HashMap을 쓰는 두번째 방법! 위 방법보다 이게 더 보기 쉽다..
		HashMap<String, Object> paramMap = bs.boardView(num);
		
		// paramMap으로 가져온 데이터를 꺼낸다! 
//		BoardDto bdto = (BoardDto) paramMap.get("bdtd");	// Object 형태로 가져오기 때문에 casting 해줘야한다!
//		ArrayList<ReplyVO> list = (ArrayList<ReplyVO>) paramMap.get("replylist");
//		
//		model.addAttribute("board", bdto);
//		model.addAttribute("replyList", list);
		
		// 위 4줄을 두줄로 줄였다.
		model.addAttribute("board", (BoardDto) paramMap.get("bdto") );
		model.addAttribute("replyList", (ArrayList<ReplyVO>) paramMap.get("replylist"));
		
		return "board/boardView";
	}
	
	
	@RequestMapping(value="/addReply", method=RequestMethod.POST)
	public String add_reply(Model model, HttpServletRequest request) {
		
		String boardnum = request.getParameter("boardnum");
		ReplyVO rvo = new ReplyVO();
		
		rvo.setUserid(request.getParameter("userid"));
		rvo.setContent( request.getParameter("reply") );
		rvo.setBoardnum( Integer.parseInt(boardnum) );
		
		bs.addReply(rvo);
		return "redirect:/boardViewWithoutCount?num=" + boardnum;
	}
	
	
	@RequestMapping("/boardViewWithoutCount")
	public String boardViewWithoutCount( Model model, HttpServletRequest request ) {
		
		int num = Integer.parseInt( request.getParameter("num") ); 
		
		HashMap<String, Object> paramMap = bs.boardViewWithoutCount(num);

		model.addAttribute("board", (BoardDto) paramMap.get("bdto") );
		model.addAttribute("replyList", (ArrayList<ReplyVO>) paramMap.get("replylist"));
		
		return "board/boardView";
	}
	
	
	@RequestMapping("/deleteReply")
	public String reply_delete(Model model, HttpServletRequest request) {
		int replynum = Integer.parseInt(request.getParameter("replynum"));
		String boardnum = request.getParameter("boardnum");
		
		bs.deleteReply(replynum);	// 댓글을 지우는 메소드
		
		return "redirect:/boardViewWithoutCount?num="+boardnum;
	}
	
	
	@RequestMapping("/boardEditForm")
	public String board_edit_form(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}
	
	
	@RequestMapping("/boardEdit")
	public String board_edit(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		BoardDto bdto = bs.getBoardOne(Integer.parseInt(num));
		
		model.addAttribute("num", num);
		
		if(bdto.getPass().equals(pass)) {
			return "board/boardCheckPass";
		}else {
			model.addAttribute("message", "비밀번호가 맞지 않습니다. 확인해주세요.");
			return "board/boardCheckPassForm";
		}
	}
	
	
	@RequestMapping("/boardUpdateForm")
	public String board_update_form(Model model, HttpServletRequest request) {
		
		String num = request.getParameter("num");
		
		BoardDto bdto = bs.getBoardOne(Integer.parseInt(num));
		model.addAttribute("num", num);
		model.addAttribute("board", bdto);
		
		return "board/boardEditForm";
	}
}
