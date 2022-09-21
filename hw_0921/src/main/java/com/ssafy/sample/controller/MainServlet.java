package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.PageInfo;

@WebServlet(loadOnStartup = 1, urlPatterns = {"*.do"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductController pController = new ProductController();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
		
		System.out.println("url : " + url);

		PageInfo pageInfo = null;
		
		if(url.startsWith("/product")) {
			pageInfo = pController.ProductStateControll(request, response);
			System.out.println("pControll");
		}
		
		if(pageInfo != null) {
			if(pageInfo.isForward()) request.getRequestDispatcher(pageInfo.getPage()).forward(request, response);
			else response.sendRedirect(pageInfo.getPage());
		}else response.sendRedirect(request.getContextPath()+"/error/error.jsp");
	}
}
