package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.SaleVisit;
import cn.itcast.utils.PageBean;

public interface SaleVisitService {
	//新增客户拜访
	void save(SaleVisit saleVisit);
	//联系人列表
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//修改客户列表信息
	SaleVisit getById(String visit_id);

}
