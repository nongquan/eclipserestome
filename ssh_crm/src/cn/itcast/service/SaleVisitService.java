package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.SaleVisit;
import cn.itcast.utils.PageBean;

public interface SaleVisitService {
	//�����ͻ��ݷ�
	void save(SaleVisit saleVisit);
	//��ϵ���б�
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//�޸Ŀͻ��б���Ϣ
	SaleVisit getById(String visit_id);

}
