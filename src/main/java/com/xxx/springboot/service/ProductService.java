package com.xxx.springboot.service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.springboot.bean.Pager;
import com.xxx.springboot.dao.ProductMapper;
import com.xxx.springboot.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	public int save(Product product) {
		product.setCreateDate(new Date());
		product.setModifyDate(new Date());
		return productMapper.save(product);
	}
	
	public int update(Product product) {
		product.setModifyDate(new Date());
		return productMapper.update(product);
	}
	
	public Pager<Product> findByPager(int page,int size){
		//Page<Product> page2 = PageHelper.startPage(page, size);
		Map<String, Object> params = new HashMap<>();
		params.put("page", (page-1)*size);
		params.put("size", size);
		List<Product> list = productMapper.findByPager(params);
		Pager<Product> pager = new Pager<>();
		pager.setRows(list);
		pager.setTotal(productMapper.count());
		return pager;
	}
	
	public Product findById(Integer id) {
		return productMapper.findById(id);
	}
}
