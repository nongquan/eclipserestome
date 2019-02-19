package cn.itcast.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	//客户列表
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 封装总条数
		Integer totalCount = customerDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, pageSize, totalCount);
		List<Customer> list = customerDao.getPageList(dc, pb.getIndex(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	
	//增加客户
	@Override
	public void save(Customer customer) {

		customerDao.saveOrUpdate(customer);
		
	}
	////修改客户列表信息
	@Override
	public Customer getById(int cust_id) {
		
		return customerDao.getById(cust_id);
	}
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	//客户行业统计列表
	public List<Object[]> getIndustryCount() {
		
		return customerDao.getIndustryCount();
	}




}
