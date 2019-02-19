package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//保存或更新
	void saveOrUpdate(T t);
	//增
	void save(T t);
	//删
	void delete(T t);
	//删 根据ID
	void delete(Serializable id);
	//改
	void update(T t);
	//查 根据ID
	T getById(Serializable id);
	//查 全部
	List<T> findAll();
	//查 符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dc);
	//查 分页列表的数据
	List<T> getPageList(DetachedCriteria dc,Integer index,Integer pageSize);

}
