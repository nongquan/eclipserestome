package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerService {


	//�ͻ��б�
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//���ӿͻ�
	void save(Customer customer);
	//�޸Ŀͻ��б���Ϣ
	Customer getById(int cust_id);
	//�ͻ���ҵͳ���б�
	List<Object[]> getIndustryCount();

}
