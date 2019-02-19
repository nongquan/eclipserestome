package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerService {


	//客户列表
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//增加客户
	void save(Customer customer);
	//修改客户列表信息
	Customer getById(int cust_id);
	//客户行业统计列表
	List<Object[]> getIndustryCount();

}
