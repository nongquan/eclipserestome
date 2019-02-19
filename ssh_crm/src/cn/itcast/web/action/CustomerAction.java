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
	// ��ǰҳ
	private Integer currentPage;
	// ÿҳ��ʾ������
	private Integer pageSize;
	//�ļ��ϴ�
	private File photo;
	//�ļ�������
	private String photoFileName;
	//�ļ�������
	private String photoContentType;
	
	//�ͻ���ҵͳ���б�
	public String count() throws Exception {
		List<Object[]> instIndustryList =  customerService.getIndustryCount();
		System.out.println(instIndustryList);
			
		ActionContext.getContext().put("instIndustryList", instIndustryList);

		return "count";
	}
	
	//�޸Ŀͻ��б���Ϣ
	public String edit() throws Exception {
		Customer c =  customerService.getById(customer.getCust_id());
			
		ActionContext.getContext().put("customer", c);

		return "edit";
	}
	
	//�����ͻ�
	public String add() throws Exception {
		if(photo!=null){System.out.println(photoContentType);
		
		photo.renameTo(new File("D:/BaiduNetdiskDownload/��ҵ��/"+photoFileName));} 

		customerService.save(customer);

		return "toList";
	}

	//�ͻ��б�
	public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNoneBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		};
		PageBean pb = customerService.getPageBean(dc,currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		System.out.println("��ǰҳ:"+pb.getCurrentPage()+"������:"+pb.getTotalCount()+"��ҳ��:"+pb.getTotalPage());
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
