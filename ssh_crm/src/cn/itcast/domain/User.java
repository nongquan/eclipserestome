package cn.itcast.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int userid;
	private String username;
	private String password;
	
	private Set<SaleVisit> saleVisit = new HashSet<SaleVisit>();
	
	
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Set<SaleVisit> getSaleVisit() {
		return saleVisit;
	}
	public void setSaleVisit(Set<SaleVisit> saleVisit) {
		this.saleVisit = saleVisit;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
