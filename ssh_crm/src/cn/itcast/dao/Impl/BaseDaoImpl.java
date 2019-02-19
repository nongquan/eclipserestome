package cn.itcast.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.BaseDao;
import cn.itcast.domain.Customer;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	//���ڽ��������ڷ��͵�����
	private Class clazz;
	//ʹ��ע��ע����Ҫ���,��������ע��spring�����еĻỰ��������sessionFactory
	@Resource
	public void setMySessionFaction(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl() {
	//��õ�ǰ���� ���з������͵ĸ���
	ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
	//��������ڼ�ķ�������	
	 clazz = (Class) ptClass.getActualTypeArguments()[0];
	}
	
	//��������
	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}
	
	//��
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
		
	}
	
	//ɾ
	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}
	
	//ɾ ����ID
	@Override
	public void delete(Serializable id) {
			T t = this.getById(id);//��ȡ��ɾ
			getHibernateTemplate().delete(t);
		
	}
	
	//��
	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}
	
	//�� ����ID
	@Override
	public T getById(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}
	
	//�� �����������ܼ�¼��
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
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
		
	}
	
	//�� ��ҳ�б������
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer index, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, index, pageSize);
	
		
		return list;
	}
	//�� ȫ��
	@Override
	public List<T> findAll() {
		String hql = "FROM " + clazz.getSimpleName();
		return (List<T>) getHibernateTemplate().find(hql);
	}





}
