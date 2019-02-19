package cn.itcast.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.SaleVisitDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService{
	private SaleVisitDao saleVisitDao;
	
	

	//修改客户列表信息
	public SaleVisit getById(String visit_id) {
		return saleVisitDao.getById(visit_id);
	}

	
	//新增客户拜访
	public void save(SaleVisit saleVisit) {
		saleVisitDao.saveOrUpdate(saleVisit);
		
	}
	

	
	//客户列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 封装总条数
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		System.out.println(totalCount);
		PageBean pb = new PageBean(currentPage, pageSize, totalCount);
		List<SaleVisit> list = saleVisitDao.getPageList(dc, pb.getIndex(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}




	
}
