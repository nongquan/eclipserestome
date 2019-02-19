package cn.itcast.text;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Text {
	@Test
	public void run1(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		User u = new User();
		u.setUsername("hahahah");
		session.save(u);
		ts.commit();
		session.close();
		
	}
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Test
	public void run2(){
		/*Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();*/
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		User u = new User();
		u.setUsername("hdffdddh");
		session.save(u);
		ts.commit();
		session.close();
		
	}
	@Resource(name="userDao")
	private UserDao userDao;
	@Test
	public void run3(){
		User u = userDao.getByuserCode("haha");
		System.out.println(u);
		
	}
	@Resource(name="userService")
	private UserService userService;
	
/*	public void run4(){
		User u = new User();
		u.setUsername("dbsdsd");
		u.setPassword("222");
		userService.saveUser(u);
		
		
	}*/
}
