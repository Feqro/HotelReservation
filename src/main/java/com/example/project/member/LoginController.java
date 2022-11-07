package com.example.project.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class LoginController {
	
	private MemberService memberService;
	
	@Autowired
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("member/kakaologin")
	public String kakao() {
		return "member/kakaologin";
	}
	@GetMapping("/fatchuser")
	public String fatchuser() {
		return "member/fatchuser";
	}
	@GetMapping("/login")
	public String getLogin(LoginInput loginInput) {
		
		log.debug("####입력아이디: " + loginInput.getId());
		log.debug("####입력비밀번호: " + loginInput.getPw());
		
		return "member/login_form";
	}
	
	@PostMapping("/login")
	public String postLogin(LoginInput loginInput, HttpSession session) {
		log.info("####입력아이디: " + loginInput.getId());
		log.info("####입력비밀번호: " + loginInput.getPw());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Member member = memberService.getMember(loginInput.getId());
		
		log.info("####member아이디: " + member.getId());
		log.info("####member비밀번호: " + member.getPw());
		
		
		
		if(encoder.matches(loginInput.getPw(), member.getPw()) == true) {
			//Member newMember = memberService.loginCheck(loginInput);
			session.setAttribute("member", member);
			
			log.info("####로그인 성공####");
			log.info("####id: " + member.getId());
			
			//return "redirect:/main";
			return "redirect:/main";
			
		}else {
			
			//return "redirect:/login";
			return "redirect:/login";
		}

	}
	
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		Member member = (Member)session.getAttribute("member");
		
		System.out.println("member :"+member);
		
		session.invalidate();
		
		return"redirect:/main";
	}
	
	@GetMapping("/logincheck")
	public String loginCheck() {
		String loginCheck = null;

		return loginCheck;
	}
	
	@GetMapping("/findId")
	public String getFindId(FindIdForm findIdForm) {
		
		return "member/findId_form";
	}
	
	@PostMapping("/findId")
	@ResponseBody
	public String postFindId(@Valid FindIdForm findIdForm) {

		Member member = memberService.getMember(findIdForm.getName(), findIdForm.getEmail());
		
		if(member == null) {
			return "아이디를 찾을 수 없습니다.";
			
			
		}else {
			
			return "아이디: " + member.getId();
		}
		
		
	}
	
	@GetMapping("/findPw")
	public String getFindPw(FindPwForm findPwForm) {
		
		return "member/findPw_form";
		
	}
	
}
