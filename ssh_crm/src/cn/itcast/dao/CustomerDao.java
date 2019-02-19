package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	//客户行业统计列表
	List<Object[]> getIndustryCount();


/*	List<Customer> getPageList(DetachedCriteria dc, int index, Integer pageSize);

	Integer getTotalCount(DetachedCriteria dc);
	
	void save(Customer customer);*/



}
