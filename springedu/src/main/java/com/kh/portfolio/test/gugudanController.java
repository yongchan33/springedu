package com.kh.portfolio.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gugudan")
public class gugudanController {
	private static Logger logger =
			LoggerFactory.getLogger(gugudanController.class);	//sysout보다 로거사용해서 리소스를 적게 먹음.
	
	//구구단화면
	@GetMapping("/gugudanForm")		//ex) /cal/view
	public String calView() {
		System.out.println("calview호출됨.");
		return "gugudanForm";
	}
	
	@PostMapping("")
	public String gugudan(
			//요청마라미터 이름과 지역변수명이 같으면 생략가능
		@RequestParam("dansu") String dansu,Model model){
		logger.info(dansu);
		model.addAttribute("dansu",dansu);
		
		return "gugudanForm";
		}
		
		
		
		
	}


