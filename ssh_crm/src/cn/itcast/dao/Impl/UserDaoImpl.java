package cn.itcast.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

/*	@Override
	public User getByuserCode(final String usercode) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("username", usercode));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;}
	
	}*/

	public User getByuserCode(final String usercode) {
		return	getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql="from User where username=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				User user = (User) query.uniqueResult();
				return user;
			}
		});
		
	}

	/*public void save(User u) {
		getHibernateTemplate().save(u);
		
	}*/
	
}
