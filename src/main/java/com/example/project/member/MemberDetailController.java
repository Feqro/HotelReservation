package com.example.project.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberDetailController {

	private MemberService memberService;

	@Autowired
	public MemberDetailController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//마이페이지
	@GetMapping("/memberdetail")
	public String memberDetail(Model model, HttpSession session) {
		
		Member member = new Member();
		member = (Member)session.getAttribute("member");
		
		model.addAttribute("member", member);
	

		return "member/member_detail";
	}
	
	
	//--------------------------------------------------
	
	//비밀번호 변경
	@GetMapping("/updatePw")
	@ResponseBody
	public String getUpdatePw(@RequestParam String inputNewPw, HttpSession session) {
		
		String result = memberService.updateMemberPw(session, inputNewPw);
		
		return result;
	}
	
	//이메일 변경
	@GetMapping("/updateEmail")
	@ResponseBody
	public String getUpdateEmail(@RequestParam String inputNewEmail, HttpSession session) {
		String result = memberService.updateMemberEmail(session, inputNewEmail);
		
		
		return result;
	}
	
	//전화번호 변경
	@GetMapping("/updateTell")
	@ResponseBody
	public String getUpdateTell(@RequestParam String inputNewTell, HttpSession session) {
		String result = memberService.updateMemberTell(session, inputNewTell);
		
		
		return result;
	}

	

	
	
	
}




