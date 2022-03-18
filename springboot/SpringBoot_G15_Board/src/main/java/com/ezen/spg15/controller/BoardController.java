package com.ezen.spg15.controller;

import java.io.IOException;
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

import com.ezen.spg15.dto.BoardVO;
import com.ezen.spg15.dto.Paging;
import com.ezen.spg15.dto.ReplyVO;
import com.ezen.spg15.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping("/main")
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			mav.setViewName("loginForm");
		}else {
			// 페이징 처리
			int page = 1;
			if(request.getParameter("page") != null) {	// 전달된 페이지값이 있는지
				page = Integer.parseInt(request.getParameter("page"));	// 있다면 페이지 session에 저장해두기
				session.setAttribute("page", page);
			}else if(session.getAttribute("page") != null) {	// 이전에 저장해둔 page가 있는지
				page = (int) session.getAttribute("page");	// 있다면 페이지 가져오기
			}else {
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			int count = bs.getAllCount();
			paging.setTotalCount(count);
			paging.paging();	// 페이징 수동실행
			
			mav.addObject("boardList", bs.selectBoardAll(paging));
			mav.addObject("paging", paging);
			mav.setViewName("board/main");
		}
		return mav;
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
	
	
	@RequestMapping("/selectimg")
	public String selectimg() {
		return "board/selectimg";
	}
	
	
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String fileupload(Model model, HttpServletRequest request) {
		
		String path = context.getRealPath("/upload");
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1025*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			// 전송된 파일은 업로드 되고, 파일 이름은 모델에 저장한다.
			model.addAttribute("image", multi.getFilesystemName("image"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "board/completupload";
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
			url = "redirect:/main";
		}
		
		bs.insertBoard(boardvo);
		
		return url;
	}
	
	
	@RequestMapping("/boardView")
	public ModelAndView boareView(@RequestParam("num") int num,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		// 댓글도 받고 내용도 받기 때문에 HashMap을 사용한다.
		// HashMap에는 뭐든 다 담을 수 있으니깐!
		HashMap<String, Object> resultMap = bs.boardView(num);
		// bs.boardView(num); 에서 조회수 늘리고, 게시물 조회하고, 댓글리스트 조회
		
		// resultMap에는 Service에서 전달된 게시물 내용과 댓글들 내용이 있다.
		// 그것들을 각각 board와 replyList라는 이름으로 담는다.
		
		BoardVO bvo = (BoardVO)resultMap.get("board");
		mav.addObject("board", bvo);
		// 위의 형식으로 해서 BoardVO 형태를 살려도 되지만 아래처럼 해도 된다.
		
		mav.addObject("replyList", resultMap.get("replyList"));
		
		mav.setViewName("board/boardView");
		
		return mav;
	}
	
	
	@RequestMapping("/addReply")
	public String addReply(/* ReplyVo replyvo 이걸로 reply에 대한 정보를 전부 뭉쳐서 받을수도 있었다.*/
			@RequestParam("boardnum") int boardnum,
			@RequestParam("userid") String userid,
			@RequestParam("content") String content, HttpServletRequest request) {
		
		// 댓글을 추가
		// 우선 전달된 정보를 ReplyVO에 담는다.
		ReplyVO rvo = new ReplyVO();
		rvo.setUserid(userid);
		rvo.setContent(content);
		rvo.setBoardnum(boardnum);
		
		bs.insertReply(rvo);
		
		return "redirect:/boardViewWithoutCount?num="+ boardnum;
		
	}
	
	
	// 위의 mapping boardView와 거의 흡사하다.
	@RequestMapping("/boardViewWithoutCount")
	public ModelAndView boardViewWithoutCount(
			@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> resultMap = bs.boardViewWithoutCount(num);

		mav.addObject("board", resultMap.get("board"));
		mav.addObject("replyList", resultMap.get("replyList"));
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
	
	@RequestMapping("/deleteReply")
	public String reply_delete(@RequestParam("num") int num,
			@RequestParam("boardnum") int boardnum,
			HttpServletRequest request) {
		bs.deleteReply(num);
		return "redirect:/boardViewWithoutCount?num="+ boardnum;
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
			Model model,
			HttpServletRequest request) {
		
		BoardVO bvo = bs.getBoard(num);
		// 비밀번호가 맞던 틀리던 양쪽 다 게시글번호 num은 필요하므로 model에 넣어두었다.
		model.addAttribute("num", num);
		
		if(pass.equals(bvo.getPass())) {
			return "board/boardCheckPass";
		}else {
			model.addAttribute("message", "비밀번호가 맞지 않습니다. 확인해주세요.");
			return "board/boardCheckPassForm";
		}
	}
	
	
	@RequestMapping("boardUpdateForm")
	public String board_update_form(@RequestParam("num") int num,
			Model model, HttpServletRequest request) {
		
		BoardVO bvo = bs.getBoard(num);
		model.addAttribute("num", num);
		// 이름을 일치시켜서 쓰기 위해 dto로 만들었다.
		model.addAttribute("dto", bvo);
		
		return "board/boardEditForm";
	}
	
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(
			@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result,
			@RequestParam("oldfilename") String oldfilename,
			HttpServletRequest request, Model model) {
		
		String url = "board/boardEditForm";
		if(result.getFieldError("pass")!=null) {
			model.addAttribute("message", "비밀번호는 게시물 수정삭제시 필요합니다.");
		}else if(result.getFieldError("title")!=null) {
			model.addAttribute("message", "제목은 필수 입력사항입니다.");
		}else if(result.getFieldError("content")!=null) {
			model.addAttribute("message", "게시물 내용은 필수 입력사항입니다.");
		}else {
			if(boardvo.getImgfilename()==null || boardvo.getImgfilename().equals("")) {
				// 이미지 교체를 하지 않을경우...
				boardvo.setImgfilename(oldfilename);
			}
			
			bs.updateBoard(boardvo);
			url = "redirect:/boardViewWithoutCount?num="+ boardvo.getNum();
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
		// 이전 페이지에서 넘어온 num값 받기
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 게시글, 댓글 삭제 기능을 해야한다. 다만 두개는 Service에서 removeBoard 메소드에서 분리한다.
//		bdao.deleteBoard(num);
//		bdao.deleteReply(num);
		bs.removeBoard(num);
		
		return "redirect:/main";
	}
	
	
	
	
	
	
	
	/*
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String board_write(@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result, Model model, HttpServletRequest request) {
		
		// HttpServletRequest로는 받을 수 없기에 null이 나온다.
		System.out.println("pass : " + boardvo.getPass());
		System.out.println("title : " + boardvo.getTitle());
		System.out.println("content : " + boardvo.getContent());
		
		// null이기 때문에 내용을 넣던 넣지 않던 에러가 발생한다.
		if(result.hasErrors()) {
			System.out.println("pass :" + result.getFieldError("pass").getDefaultMessage());
			System.out.println("title :" + result.getFieldError("title").getDefaultMessage());
			System.out.println("content :" + result.getFieldError("content").getDefaultMessage());
		}
		
		
		
		// @Valid, @ModelAttribute를 포기하고 쓰는 방식
		// 예전 프로젝트에서는 이런식으로 파일 업로드를 진행했다.
		// WEB12_ShoppingMall 에서 admin쪽 AdminProductWriteAction 확인해봐
		String path = context.getRealPath("/upload");
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			BoardVO dto = new BoardVO();
			dto.setPass(multi.getParameter("pass"));
			dto.setUserid(multi.getParameter("userid"));
			dto.setEmail(multi.getParameter("email"));
			dto.setTitle(multi.getParameter("title"));
			dto.setContent(multi.getParameter("content"));
			
			model.addAttribute("dto", dto);	// 되돌아가서 dto에 입력값을 다시 전달
			
			// MultipartRequest로 전달인수를 모두 전달받은 후에, validation에 적용한다.
			if(dto.getPass()==null || dto.getPass().equals("")) {
				model.addAttribute("message", "비밀번호는 수정 삭제시 필요합니다.");
				return "board/boardWriteForm";
			}else if(dto.getTitle()==null || dto.getTitle().equals("")) {
				model.addAttribute("message", "제목을 입력하세요.");
				return "board/boardWriteForm";
			}else if(dto.getContent()==null || dto.getContent().equals("")) {
				model.addAttribute("message", "내용을 입력하세요.");
				return "board/boardWriteForm";
			}
			
			
			if(multi.getFilesystemName("image")==null) {
				dto.setImgfilename("");
			}else {
				dto.setImgfilename(multi.getFilesystemName("image"));
			}
			bs.insertBoard(dto);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return "board/boardWriteForm";
	}
*/
}
