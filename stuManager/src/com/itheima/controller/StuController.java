package com.itheima.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StuController {
	@RequestMapping(value="/edit")
	private String editStuScore(HttpServletRequest request,
			HttpServletResponse response,Model model){
		if(true){
			model.addAttribute("msg","successfully edit");
			return"success";
		}else{
			model.addAttribute("msg","error");
			return"error";
		}
	}
}
