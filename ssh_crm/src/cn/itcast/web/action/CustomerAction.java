package cn.itcast.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private CustomerService customerService;
	private Customer customer = new Customer();
	// 当前页
	private Integer currentPage;
	// 每页显示的条数
	private Integer pageSize;
	//文件上传
	private File photo;
	//文件的名称
	private String photoFileName;
	//文件的类型
	private String photoContentType;
	
	//客户行业统计列表
	public String count() throws Exception {
		List<Object[]> instIndustryList =  customerService.getIndustryCount();
		System.out.println(instIndustryList);
			
		ActionContext.getContext().put("instIndustryList", instIndustryList);

		return "count";
	}
	
	//修改客户列表信息
	public String edit() throws Exception {
		Customer c =  customerService.getById(customer.getCust_id());
			
		ActionContext.getContext().put("customer", c);

		return "edit";
	}
	
	//新增客户
	public String add() throws Exception {
		if(photo!=null){System.out.println(photoContentType);
		
		photo.renameTo(new File("D:/BaiduNetdiskDownload/就业班/"+photoFileName));} 

		customerService.save(customer);

		return "toList";
	}

	//客户列表
	public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNoneBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		};
		PageBean pb = customerService.getPageBean(dc,currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		System.out.println("当前页:"+pb.getCurrentPage()+"总条数:"+pb.getTotalCount()+"总页数:"+pb.getTotalPage());
		return "list";
	}



	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
}
