package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	//��¼
	User getUserByCodepassword(User u);
	
	//ע��
	void register(User u);


	
}
