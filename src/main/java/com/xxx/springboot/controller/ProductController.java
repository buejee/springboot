package com.xxx.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.springboot.bean.Pager;
import com.xxx.springboot.entity.Product;
import com.xxx.springboot.http.ResponseData;
import com.xxx.springboot.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Pager<Product> pager(int page,int size){
		return productService.findByPager(page, size);
	}
	
	@PostMapping
	public ResponseData save(Product product) {
		int res = productService.save(product);
		if(res>0) {
			return ResponseData.create("ok");
		}else {
			return ResponseData.create("save error", "fail");
		}
	}
	
	@PatchMapping
	public ResponseData update(Product product) {
		int res = productService.update(product);
		if(res>0) {
			return ResponseData.create("ok");
		}else {
			return ResponseData.create("save error", "fail");
		}
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable("id") Integer id) {
		return productService.findById(id);
	}
	
}
