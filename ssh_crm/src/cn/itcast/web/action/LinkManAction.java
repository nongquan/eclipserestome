package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.PageBean;


public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan = new LinkMan();
	private LinkManService linkManService;
	// ��ǰҳ
	private Integer currentPage;
	// ÿҳ��ʾ������
	private Integer pageSize;
	
	//�޸Ŀͻ��б���Ϣ
	public String edit() throws Exception {
		LinkMan lm =  linkManService.getById(linkMan.getLkm_id());
		System.out.println(lm.getLkm_gender());
		ActionContext.getContext().put("LinkMan", lm);

		return "edit";
	}
	
	//������ϵ��
	public String add() throws Exception {
		linkManService.save(linkMan);
		return "toList";
	}

	
	//��ϵ���б�
	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNoneBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		};
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=0){
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		};
		PageBean pb = linkManService.getPageBean(dc,currentPage, pageSize);
		
		ActionContext.getContext().put("pageBean", pb);

		return "list";
	}



	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}


	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
