package com.example.project.emailAuth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmailController {
	
//	private final EmailService emailService;
//	
//	@PostMapping("/findId/mailConfirm")
//	@ResponseBody
//	public String mailConfirm(@RequestParam String email) throws Exception {
//		String code = emailService.sendEmail(email);
//		log.info("####인증코드: " + code);
//		
//		return code;
//	}
}
