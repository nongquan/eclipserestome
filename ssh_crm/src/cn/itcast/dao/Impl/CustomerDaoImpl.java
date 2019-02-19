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

	//�ͻ���ҵͳ���б�
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
//���������

/*	public Integer getTotalCount(DetachedCriteria dc) {
		//���ò�ѯ�ľۺϺ���  �ܼ�¼��
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//���֮ǰ�ľۺϺ���
		dc.setProjection(null);
		if(list!=null&&list.size()>0){
			Long totalCount = list.get(0);
			return totalCount.intValue();
		}else{
			return null;
		}
		
	}*/
	
	//��õ�ǰҳ����Ʒ����
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
