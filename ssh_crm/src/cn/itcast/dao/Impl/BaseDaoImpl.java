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
	//用于接收运行期泛型的类型
	private Class clazz;
	//使用注解注释需要添加,根据类型注入spring工厂中的会话工厂对象sessionFactory
	@Resource
	public void setMySessionFaction(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl() {
	//获得当前类型 带有泛型类型的父类
	ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
	//获得运行期间的泛型类型	
	 clazz = (Class) ptClass.getActualTypeArguments()[0];
	}
	
	//保存或更新
	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}
	
	//增
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
		
	}
	
	//删
	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}
	
	//删 根据ID
	@Override
	public void delete(Serializable id) {
			T t = this.getById(id);//先取后删
			getHibernateTemplate().delete(t);
		
	}
	
	//改
	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}
	
	//查 根据ID
	@Override
	public T getById(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}
	
	//查 符合条件的总记录数
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
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
		
	}
	
	//查 分页列表的数据
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer index, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, index, pageSize);
	
		
		return list;
	}
	//查 全部
	@Override
	public List<T> findAll() {
		String hql = "FROM " + clazz.getSimpleName();
		return (List<T>) getHibernateTemplate().find(hql);
	}





}
