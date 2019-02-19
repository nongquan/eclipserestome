package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.SaleVisit;
import cn.itcast.domain.User;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit = new SaleVisit();
	private SaleVisitService saleVisitService;
	// 当前页
	private Integer currentPage;
	// 每页显示的条数
	private Integer pageSize;
	
	//修改客户列表信息
	public String edit() throws Exception {
		SaleVisit sv =  saleVisitService.getById(saleVisit.getVisit_id());
		
		ActionContext.getContext().put("saleVisit", sv);

		return "edit";
	}
	
	//联系人列表
	public String list() throws Exception {
		
		
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		
		if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=0){
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		};
		PageBean pb = saleVisitService.getPageBean(dc,currentPage, pageSize);
	
		
		
		ActionContext.getContext().put("pageBean", pb);

		return "list";
	}
	

	
	//新增客户拜访
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		saleVisitService.save(saleVisit);
		
		return "toList";
	}



	@Override
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}



	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
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
