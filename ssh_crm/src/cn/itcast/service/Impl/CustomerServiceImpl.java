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
	//�ͻ��б�
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// ��װ������
		Integer totalCount = customerDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, pageSize, totalCount);
		List<Customer> list = customerDao.getPageList(dc, pb.getIndex(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	
	//���ӿͻ�
	@Override
	public void save(Customer customer) {

		customerDao.saveOrUpdate(customer);
		
	}
	////�޸Ŀͻ��б���Ϣ
	@Override
	public Customer getById(int cust_id) {
		
		return customerDao.getById(cust_id);
	}
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	//�ͻ���ҵͳ���б�
	public List<Object[]> getIndustryCount() {
		
		return customerDao.getIndustryCount();
	}




}
