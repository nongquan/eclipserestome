package cn.itcast.utils;

import java.util.List;

public class PageBean {
	// ��ǰҳ
	private Integer currentPage;
	// ÿҳ��ʾ������
	private Integer pageSize;
	// ������
	private Integer totalCount;
	// ��ҳ��
	private Integer totalPage;
	// ÿҳ��ʾ����Ʒ��
	private List list;

	public PageBean(Integer currentPage, Integer pageSize, Integer totalCount) {

		this.totalCount = totalCount;

		this.pageSize = pageSize;

		this.currentPage = currentPage;
		
		if(this.currentPage == null){
			this.currentPage = 1;
		}
		
		if(this.pageSize == null){
			this.pageSize = 3;
		}


		// ��ҳ��
		this.totalPage = (int) Math.ceil(this.totalCount* 1.0 / this.pageSize );
		
		//this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		

		if(this.currentPage < 1){
			this.currentPage = 1;
		}
		if(this.currentPage > this.totalPage){
			this.currentPage = this.totalPage;
		}

	}
	
	//�����ʼ����
	public int getIndex(){
		return (this.currentPage-1)*this.pageSize;
		
	};

	public Integer getCurrentPage(){
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage){
		this.currentPage = currentPage;
	}

	public Integer getPageSize(){
		return pageSize;
	}

	public void setPageSize(Integer pageSize){
		this.pageSize = pageSize;
	}

	public Integer getTotalCount(){
		return totalCount;
	}

	public void setTotalCount(Integer totalCount){
		this.totalCount = totalCount;
	}

	public Integer getTotalPage(){
		return totalPage;
	}

	public void setTotalPage(Integer totalPage){
		this.totalPage = totalPage;
	}

	public List getList(){
		return list;
	}

	public void setList(List list){
		this.list = list;
	}

	/*
	 * public Integer getCurrentPage() { return currentPage; } public void
	 * setCurrentPage(Integer currentPage) { this.currentPage = currentPage; }
	 * public Integer getPageSize() { return pageSize; } public void
	 * setPageSize(Integer pageSize) { this.pageSize = pageSize; } public
	 * Integer getTotalCount() { return totalCount; } public void
	 * setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
	 * public Integer getTotalPage() { return totalPage; } public void
	 * setTotalPage(Integer totalPage) { this.totalPage = totalPage; } public
	 * List getList() { return list; } public void setList(List list) {
	 * this.list = list; }
	 */

	/*
	 * public PageBean(Integer currentPage, Integer pageSize, Integer totalPage)
	 * { super(); this.currentPage = currentPage; this.pageSize = pageSize;
	 * this.totalPage = totalPage; if(this.currentPage==null){
	 * this.currentPage=1; }; if(this.pageSize==null){ this.pageSize=3; };
	 * this.totalPage=(int) Math.ceil(totalCount/pageSize*1.0); }
	 */

}
