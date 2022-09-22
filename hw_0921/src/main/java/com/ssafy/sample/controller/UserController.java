package com.ssafy.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.PageInfo;
import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.service.UserService;

public class UserController {
	private UserService userService = new UserService();
	
	public PageInfo UserStateControll(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getServletPath();
		PageInfo pageInfo = null;
		
		if(url.equals("/user/login.do")) {
			pageInfo = login(request, response);
		}else if(url.equals("/user/logout.do")) {
			pageInfo = logout(request, response);
		}else if(url.equals("/user/signup.do")) {
			pageInfo = signup(request, response);
		}
		return pageInfo;
	}
	
	private PageInfo login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String pw =  request.getParameter("passWord");
		if(userService.checkUserValidation(userId, pw))
		{
			request.setAttribute("msg", "로그인에 성공했습니다!");
			request.setAttribute("userID", userId);
			
			session.setAttribute("userId", true);
		}
		else request.setAttribute("msg", "로그인에 실패했습니다 ㅜ,ㅜ");
		return new PageInfo(true,"/");
	}
	
	private PageInfo logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new PageInfo(false, request.getContextPath());
	}
	
	private PageInfo signup(HttpServletRequest request, HttpServletResponse response) {
		User user = new User(request.getParameter("userId"), request.getParameter("name"), request.getParameter("passWord"));
		boolean rs = userService.createUser(user);
		if(rs) {
			request.setAttribute("msg", "회원가입 성공!");
			return new PageInfo(true, "/user/login.jsp");
		}
		else {
			request.setAttribute("msg", "회원가입에 실패했습니다 ㅜ,ㅜ");
			return new PageInfo(true, "/");
		}
	}
}
