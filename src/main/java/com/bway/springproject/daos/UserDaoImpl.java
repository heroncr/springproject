package com.bway.springproject.daos;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springproject.models.User;
@Repository
public class UserDaoImpl implements UserDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void signup(User u) {
		
		Session session = sessionFactory.getCurrentSession();
	//	if(u.getUsername().isEmpty()&&u.getPassword().isEmpty()){
		//session.save(u);
		
		//}else{
		
			session.save(u);
			
		//}
	}

	@Override
	public boolean login(String un, String psw) {
		
		Session  session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(User.class);
		crt.add(Restrictions.eq("username", un)).add(Restrictions.eq("password", psw));
		
		User u = (User) crt.uniqueResult();
		if(u != null)
			return true;
		
		return false;
	}

	
}
