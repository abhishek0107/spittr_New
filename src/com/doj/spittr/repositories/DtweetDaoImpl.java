/**
 * 
 */
package com.doj.spittr.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doj.spittr.entities.Dtweet;
import com.doj.spittr.entities.Dusr;

/**
 * @author Abhishek
 *
 * 
 */
@Repository
@Transactional
public class DtweetDaoImpl implements DtweetDao{
	@Autowired
	SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.doj.spittr.repositories.DtweetDao#writeMessage()
	 */
	@Override
	public void writeMessage(Dtweet tweet) {		
		Session session =this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		tweet.setActive("active");
		tweet.setCreatedate(new Date());
		tweet.setModidate(new Date());
		tweet.setIsdeleted("0");
		session.save(tweet);
		tx.commit();
		session.close();
		
	}

	/* (non-Javadoc)
	 * @see com.doj.spittr.repositories.DtweetDao#readMessage()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String[] readMessage(@ModelAttribute("loginUser") Dusr loginUsr) {
		Session session =this.sessionFactory.openSession();
		Query query= session.createSQLQuery("SELECT tweetMSG FROM DTWEET WHERE Tweetusrid= "+loginUsr.getUsrid());
		List<String> msgStr=query.list();
		String msg[]=new String[msgStr.size()];
		int i=0;
		for(String m:msgStr){
			msg[i]=m;
			i++;
		}
		return msg;
	}

}
