package com.example.project.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.emailAuth.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FindAccountController {
	
	private final MemberService memberService;
	private final EmailService emailService;
	
	String code = null;
	

	@GetMapping("/findId")
	public String getFindId() {
		
		return "member/findIdForm";
	}
	
	//인증 메일 전송
	@GetMapping("/getKey")
	@ResponseBody
	public void getKey(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
		Member member = memberService.getMemberByNameAndEmail(name, email);

		if(member != null) {
			code = emailService.sendEmail(email);
			log.info("####인증코드: " + code);
		}


	}
	
	//ajax로 아이디 찾기
	@GetMapping("/findIdCheck")
	@ResponseBody
	public String findIdCheck(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("keyInput") String keyInput) throws Exception{

		Member member = memberService.getMemberByNameAndEmail(name, email);
		String result;

		if(!this.code.equals(keyInput)) {
			result = "unequal";
		}else if(member == null) {
			result =  "null";
			
		}else {
			log.info("####name, email로 찾은 member: " + member.getId());
			result =  member.getId();
		}
		
		return result;
	}
	
	
	
	
	//--------------------------------------------------
	//비밀번호 찾기
	
	@GetMapping("/findPw")
	public String getFindPw() {
		
		return "member/findPwForm";
		
	}
	
	//인증 메일 전송
	@GetMapping("/getKeyPw")
	@ResponseBody
	public void getKeyPw(@RequestParam("id") String id, @RequestParam("email") String email) throws Exception {
		Member member = memberService.getMemberByIdAndEmail(id, email);

		if(member != null) {
			code = emailService.sendEmail(email);
			log.info("####인증코드: " + code);
		}


	}
	
	@GetMapping("/findPwCheck")
	@ResponseBody
	public String getFindPwCheck(@RequestParam("id") String id, @RequestParam("email") String email, 
			@RequestParam("keyInput") String keyInput, HttpSession session) throws Exception{

		Member member = memberService.getMemberByIdAndEmail(id, email);
		String result;

		if(!this.code.equals(keyInput)) {
			result = "unequal";
			
		}else if(member == null) {
			result =  "null";
			
		}else {
			log.info("####id, email로 찾은 member: " + member.getId());
			result =  member.getId();
			session.setAttribute("member", member);
		}
		
		return result;
		
	}
	
	@GetMapping("/changePw")
	public String getChangePw(HttpSession session) {
		Member sessionMember = (Member)session.getAttribute("member");
		log.info("####changePw의 session의 member: " + sessionMember.getId());
		
		return "member/changePw";
	}
	
	//비밀번호 찾기에서 변경
	@GetMapping("/changePw2")
	@ResponseBody
	public String getUpdatePw(@RequestParam String inputNewPw, 
			@RequestParam String inputNewPw2, HttpSession session) {
		
		String result = memberService.updateMemberPw(session, inputNewPw, inputNewPw2);
		
		
		return result;
	}
	
	@GetMapping("/changePwSuccess")
	public String getUpdatePw(HttpSession session) {
		session.invalidate();

		return "redirect:/login";
	}
}
