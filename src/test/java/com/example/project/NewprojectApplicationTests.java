package com.example.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewprojectApplicationTests {

	@Test
	void contextLoads() {
		String input = "admin";
		
		Pattern p = Pattern.compile("^(?!)(admin)*$");
		Matcher m = p.matcher(input);
		
		
		if(m.find() == false) {
			System.out.println(input);
		}
		
		
	}

}
