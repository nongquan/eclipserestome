package cn.itcast.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleVisit {
	private String visit_id;
	
	private String visit_detail;
	private String visit_interviewee;
	private String visit_addr;
	private Date visit_time;
	private Date visit_nexttime;
	
	private Customer customer;
	private User user;
	
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public String getVisit_detail() {
		return visit_detail;
	}
	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}
	public String getVisit_interviewee() {
		return visit_interviewee;
	}
	public void setVisit_interviewee(String visit_interviewee) {
		this.visit_interviewee = visit_interviewee;
	}
	public String getVisit_addr() {
		return visit_addr;
	}
	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}
	
	//----------------------------------------------------
	
	public Date getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}

	public Date getVisit_nexttime() {
		return visit_nexttime;
	}
	public void setVisit_nexttime(Date visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}
	
	public static String transfeiDate(Date data,String fomat){
		SimpleDateFormat sdf = new SimpleDateFormat(fomat);
		return sdf.format(data);
		
	}
	public String getVisit_nexttime_s(){
		return transfeiDate(visit_nexttime,"yyyy-MM-dd");};

	//----------------------------------------------------
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
