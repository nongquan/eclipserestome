package cn.itcast.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	//客户行业统计列表
	public List<Object[]> getIndustryCount() {
		
		return 	getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				String hql ="SELECT b.dict_item_name,COUNT(*) FROM cst_customer c,base_dict b WHERE c.cust_industry=b.dict_id GROUP BY c.cust_industry";
				//Query query = session.createQuery(hql);
				SQLQuery query = session.createSQLQuery(hql);
				List<Object[]> list = query.list();
				return list;
			}
		});
		
	}
//获得总条数

/*	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数  总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前的聚合函数
		dc.setProjection(null);
		if(list!=null&&list.size()>0){
			Long totalCount = list.get(0);
			return totalCount.intValue();
		}else{
			return null;
		}
		
	}*/
	
	//获得当前页的商品数量
/*
	public List<Customer> getPageList(DetachedCriteria dc, int index, Integer PageSize) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, index, PageSize);
		
		return list;
	}*/
	
/*	public void save(Customer customer) {
		System.out.println(customer.getCust_level().getDict_id()+":"+customer.getCust_mobile());
		getHibernateTemplate().save(customer);
	
		
	}*/



}
