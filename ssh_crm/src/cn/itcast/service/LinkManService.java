package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);
	//联系人列表
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//修改联系人列表信息
	LinkMan getById(int lkm_id);
	

}
