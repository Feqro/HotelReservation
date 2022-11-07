package com.example.project.member;


import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.project.Regex;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
		
		
		public Member loginCheck(LoginInput loginInput) {
	
			Optional<Member> oMember = this.memberRepository.findByIdAndPw(loginInput.getId(), loginInput.getPw());
			if(oMember.isPresent()) {
				Member member = oMember.get();
				
				return member;
			}
			
			return null;
		}
		
		public void regMember(Member member) {
			
//			Member member = new Member();
//			
//			member.setId(id);
//			member.setPw(pw);
//			member.setName(name);
//			member.setBirth(birth);
//			member.setTell(tell);
//			member.setEmail(email);
//			
			this.memberRepository.save(member);

		}
		
		public Member getMember(String id) {

			Optional<Member> oMember = this.memberRepository.findById(id);
			if(oMember.isPresent()) {
				Member member = oMember.get();
				
				return member;
			}
			
			
			return null;
		}
		
		public Member getMember(String name, String email) {

			Optional<Member> oMember = this.memberRepository.findByNameAndEmail(name, email);
			if(oMember.isPresent()) {
				Member member = oMember.get();
				
				return member;
			}
			
			
			return null;
		}

		
		public String updateMemberPw(HttpSession session, String newPw) {
			
			Regex regex = new Regex();
			
			if(regex.regexPw(newPw) == null) {
				return "regex";
			}

			Member sessionMember = (Member)session.getAttribute("member");
			
			Member member = new Member();
			Optional<Member> oMember = memberRepository.findById(sessionMember.getId());
			
			if(oMember.isPresent()) {
				member = oMember.get();
			}
			
			if(member.getPw().equals(newPw)) {
				return "same";
			}
			

			member.setPw(newPw);
						
			this.memberRepository.save(member);
			session.setAttribute("member", member);
					
			return "true";
		}
		
		
		//이메일 변경
		public String  updateMemberEmail(HttpSession session, String newEmail) {

			Regex regex = new Regex();
			
			if(regex.regexEmail(newEmail) == null) {
				return "regex";
			}

			Member sessionMember = (Member)session.getAttribute("member");
			
			Member member = new Member();
			Optional<Member> oMember = memberRepository.findById(sessionMember.getId());
			
			if(oMember.isPresent()) {
				member = oMember.get();
			}
			
			if(member.getEmail().equals(newEmail)) {
				return "same";
			}
			

			member.setPw(newEmail);
						
			this.memberRepository.save(member);
			session.setAttribute("member", member);
					
			return "true";
				
		}
				
				
		public String updateMemberTell(HttpSession session, String newTell) {

			Regex regex = new Regex();
			
			if(regex.regexNum(newTell) == null) {
				return "regex";
			}

			Member sessionMember = (Member)session.getAttribute("member");
			
			Member member = new Member();
			Optional<Member> oMember = memberRepository.findById(sessionMember.getId());
			
			if(oMember.isPresent()) {
				member = oMember.get();
			}
			
			if(member.getTell().equals(newTell)) {
				return "same";
			}
			

			member.setPw(newTell);
						
			this.memberRepository.save(member);
			session.setAttribute("member", member);
					
			return "true";
				
		}
		

}


