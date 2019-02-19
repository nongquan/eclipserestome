	package cn.itcast.service.Impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.MD5Utils;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	//ע��
	public void register(User u) {
		User byuserCode = userDao.getByuserCode(u.getUsername());
		if(byuserCode!=null){
			throw new RuntimeException("�û����Ѵ���");
		}
		u.setPassword(MD5Utils.md5(u.getPassword()));
		userDao.save(u);
	}
	//��¼
	@Override
	public User getUserByCodepassword(User u) {
		User byuserCode = userDao.getByuserCode(u.getUsername());
		if(byuserCode==null){
			throw new RuntimeException("�û���������");
		}
		if(!byuserCode.getPassword().equals(MD5Utils.md5(u.getPassword()))){
			throw new RuntimeException("�������");
		}
		return byuserCode;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	


	
}
