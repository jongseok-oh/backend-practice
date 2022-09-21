package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDao;

public class ProductService {
	private ProductDao productDao = new ProductDao();
	
	public boolean registerProduct(Product product) {
		return productDao.insertDept(product) > 0;
	}
	
	public List<Product> getProductAll(){
		// 부서리스트 조회
		return productDao.selectProducts();
	}
	public Product getProduct(String code){
		// 부서조회
		return productDao.selectProduct(code);
	}
	
	public boolean modifyProduct(Product product) {
		return productDao.modifyProduct(product) != 0;
	}
	
	public boolean deleteProduct(String code) {
		return productDao.deleteProduct(code) != 0;
	}
}
