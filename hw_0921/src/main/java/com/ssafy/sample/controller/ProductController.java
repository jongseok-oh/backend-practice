package com.ssafy.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.PageInfo;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;

public class ProductController {
	private ProductService productService = new ProductService();
	
	public PageInfo ProductStateControll(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String url = request.getServletPath();
		PageInfo pageInfo = null;
		
		System.out.println("pControll url : " + url);
		
		if(session.getAttribute("userId") == null){
			request.setAttribute("msg", "로그인 후 이용해 주세요!");
			return new PageInfo(true,"/user/login.jsp");
		}
		
		if(url.equals("/product/readAll.do")) {
			pageInfo = readAll(request, response);
			System.out.println("ReadAll in");
		}else if(url.equals("/product/read.do")) {
			pageInfo = read(request, response);
		}else if(url.equals("/product/create.do")) {
			pageInfo = create(request, response);
		}else if(url.equals("/product/update.do")) {
			pageInfo = update(request, response);
		}else if(url.equals("/product/delete.do")) {
			pageInfo = delete(request, response);
		}
		return pageInfo;
	}
	
	private PageInfo readAll(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = productService.getProductAll();
		
		request.setAttribute("productList", products);
		return new PageInfo(true, "/product/list.jsp");
	}
	
	private PageInfo read(HttpServletRequest request, HttpServletResponse response) {
		Product product = productService.getProduct(request.getParameter("code"));
		
		request.setAttribute("product", product);
		return new PageInfo(true, "/product/detail.jsp");
	}
	
	private PageInfo create(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		Integer price = Integer.parseInt(request.getParameter("price"));
		
		PageInfo pageInfo = null;
		
		boolean res = productService.registerProduct(new Product(code, model, price));
		if(res) {
			pageInfo = new PageInfo(false,request.getContextPath());
		}else {
			request.setAttribute("msg","등록에 실패했습니다.");
			pageInfo = new PageInfo(true,request.getContextPath());
		}
		return pageInfo;
	}
	
	private PageInfo delete(HttpServletRequest request, HttpServletResponse response) {
		boolean res = productService.deleteProduct(request.getParameter("code"));
		if(res) request.setAttribute("msg", "상품 삭제에 성공하였습니다.");
		else request.setAttribute("msg", "상품 삭제에 실패하였습니다.");
		return new PageInfo(true,"/product/readAll.do");
	}
	
	private PageInfo update(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		Integer price = Integer.parseInt(request.getParameter("price"));
		
		boolean res = productService.modifyProduct(new Product(code, model, price));
		if(res) request.setAttribute("msg", "상품 수정에 성공하였습니다.");
		else request.setAttribute("msg", "상품 수정에 실패하였습니다.");
		return new PageInfo(true,"/product/readAll.do");
		
	}
}
