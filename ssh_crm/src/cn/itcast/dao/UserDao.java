package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao extends BaseDao<User>{
	User getByuserCode(String usercode);



	/*void save(User u);*/
}
