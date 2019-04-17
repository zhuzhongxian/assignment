package com.itheima.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/login")
public class loginController {
	@RequestMapping(value="/toEditStuScore")
	private String toEditStuScore(HttpServletRequest request,
			HttpServletResponse response,Model model){
		return "edit_stuscore";
	}
}
