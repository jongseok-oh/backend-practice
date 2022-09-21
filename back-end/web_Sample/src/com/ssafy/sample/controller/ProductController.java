package com.ssafy.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.PageInfo;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;

public class ProductController {
	private ProductService productService = new ProductService();
	
	public PageInfo ProductStateControll(HttpServletRequest request, HttpServletResponse response) {
		
		String url = request.getServletPath();
		PageInfo pageInfo = null;
		
		if(url.equals("/product/readAll.do")) {
			pageInfo = readAll(request, response);
		}else if(url.equals("/product/read.do")) {
			pageInfo = readAll(request, response);
		}else if(url.equals("/product/create.do")) {
			pageInfo = readAll(request, response);
		}else if(url.equals("/product/update.do")) {
			pageInfo = readAll(request, response);
		}else if(url.equals("/product/delete.do")) {
			pageInfo = readAll(request, response);
		}
		return pageInfo;
	}
	
	private PageInfo readAll(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = productService.getProductAll();
		
		request.setAttribute("productList", products);
		return new PageInfo(true, "/product/list.jsp");
	}
	
	private PageInfo read(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = productService.getProductAll();
		
		request.setAttribute("productList", products);
		return new PageInfo(true, "/product/list.jsp");
	}
	
}
