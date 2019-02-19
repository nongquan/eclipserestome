package cn.itcast.service.Impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.dao.Impl.BaseDaoImpl;
import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao baseDictDao;
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		List<BaseDict> list = baseDictDao.getListByTypeCode(dict_type_code);
		return list;
	}
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	
}
