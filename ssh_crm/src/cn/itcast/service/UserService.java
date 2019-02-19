package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	//µÇÂ¼
	User getUserByCodepassword(User u);
	
	//×¢²á
	void register(User u);


	
}
