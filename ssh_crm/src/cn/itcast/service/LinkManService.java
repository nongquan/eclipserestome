package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);
	//��ϵ���б�
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//�޸���ϵ���б���Ϣ
	LinkMan getById(int lkm_id);
	

}
