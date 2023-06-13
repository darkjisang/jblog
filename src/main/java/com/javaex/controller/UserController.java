package com.javaex.controller;

import javax.servlet.http.HttpSession;

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
		return "user/loginForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult idCheck(@RequestParam("id") String id) {
		JsonResult js = new JsonResult();
		boolean data = service.getIdCheck(id);
		js.success(data);
		return js;
	}
	
	@RequestMapping(value = "/loginSuccess", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginSuccess(@ModelAttribute UserVO vo, HttpSession session) {
		System.out.println("UserController.loginSuccess");
		System.out.println("vo : " + vo);
		UserVO userVO = service.getLoginUser(vo); 
		System.out.println("userVO : " + userVO);
		if(userVO != null) {
			System.out.println("LoginSuccess");
			session.setAttribute("user", userVO);
			return "redirect:/";
		}else {
			System.out.println("LoginFail");
			return "redirect:/user/login";
		}
	}
	
	@RequestMapping(value = "/logOut")
	public String logOut(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/";
	}
	
}