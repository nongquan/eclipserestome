package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//��������
	void saveOrUpdate(T t);
	//��
	void save(T t);
	//ɾ
	void delete(T t);
	//ɾ ����ID
	void delete(Serializable id);
	//��
	void update(T t);
	//�� ����ID
	T getById(Serializable id);
	//�� ȫ��
	List<T> findAll();
	//�� �����������ܼ�¼��
	Integer getTotalCount(DetachedCriteria dc);
	//�� ��ҳ�б������
	List<T> getPageList(DetachedCriteria dc,Integer index,Integer pageSize);

}
