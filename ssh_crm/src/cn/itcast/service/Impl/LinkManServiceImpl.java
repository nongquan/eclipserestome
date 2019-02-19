package cn.itcast.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao;
	
	//修改联系人列表信息
	@Override
	public LinkMan getById(int lkm_id) {
		
		return linkManDao.getById(lkm_id);
	}
	
	//客户列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 封装总条数
		Integer totalCount = linkManDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, pageSize, totalCount);
		List<LinkMan> list = linkManDao.getPageList(dc, pb.getIndex(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	//增加联系人
	@Override
	public void save(LinkMan linkMan) {
		linkManDao.saveOrUpdate(linkMan);
		
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}



	
}
