package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.JsonResult;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm");
		return "user/joinForm";
	}
	
	@RequestMapping(value = "/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVO vo) {
		if(service.userInsert(vo) > 0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		return "user/joinSuccess";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login() {
		System.out.println("UserController.login");
		return "user/loginForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult idCheck(@RequestParam("id") String id) {
		System.out.println("UserController.idCheck");
		JsonResult js = new JsonResult();
		boolean data = service.getIdCheck(id);
		js.success(data);
		return js;
	}
	
	
}