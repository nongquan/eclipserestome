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
	
	//注册
	public void register(User u) {
		User byuserCode = userDao.getByuserCode(u.getUsername());
		if(byuserCode!=null){
			throw new RuntimeException("用户名已存在");
		}
		u.setPassword(MD5Utils.md5(u.getPassword()));
		userDao.save(u);
	}
	//登录
	@Override
	public User getUserByCodepassword(User u) {
		User byuserCode = userDao.getByuserCode(u.getUsername());
		if(byuserCode==null){
			throw new RuntimeException("用户名不存在");
		}
		if(!byuserCode.getPassword().equals(MD5Utils.md5(u.getPassword()))){
			throw new RuntimeException("密码错误");
		}
		return byuserCode;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	


	
}
