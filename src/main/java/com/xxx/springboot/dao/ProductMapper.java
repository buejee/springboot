package com.xxx.springboot.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xxx.springboot.entity.Product;
@Mapper
public interface ProductMapper {
	@Select("select * from xx_product where id = #{id}")
	public Product findById(Integer id);
	@Insert("insert into xx_product(name,price,`desc`,batchPrice,batchCount,batchAmount,stock,createDate,modifyDate)"
			+ " values(#{name},#{price},#{desc},#{batchPrice},#{batchCount},#{batchAmount},#{stock},#{createDate},#{modifyDate})")
	public int save(Product product);
	@Update("update xx_product set name = #{name} ,price=#{price} ,"
			+ " `desc` = #{desc} , batchPrice=#{batchPrice},batchCount=#{batchCount},batchAmount=#{batchAmount},"
			+ " stock=#{stock}, modifyDate = #{modifyDate}"
			+ " where id = #{id}")
	public int update(Product product);
	@Delete("delete from xx_product where id = #{id}")
	public int delete(Integer id);
	//@Select("select * from xx_product")
	@Select(value= {"select * from xx_product limit #{page} , #{size}"})
	public List<Product> findByPager(Map<String, Object> params);
	@Select("select count(1) from xx_product")
	public int count();
}
