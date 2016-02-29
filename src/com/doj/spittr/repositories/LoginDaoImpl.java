package com.doj.spittr.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.Dusr;
@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Dusr> getUserDetail(String email) {
			 
		Session session = this.sessionFactory.openSession(); 
		Query query=session.createQuery("from Dusr where usreml=:email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Dusr> dusr=query.list();
		if(dusr!=null && !dusr.isEmpty()){
			return dusr;
		}
		
		
		return null;
	}
	
}
