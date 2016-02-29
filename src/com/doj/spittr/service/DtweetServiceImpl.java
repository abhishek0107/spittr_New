/**
 * 
 */
package com.doj.spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.Dtweet;
import com.doj.spittr.entities.Dusr;
import com.doj.spittr.repositories.DtweetDao;

/**
 * @author Abhishek
 *
 * 
 */
@Service
@Transactional

public class DtweetServiceImpl implements DtweetService{
	@Autowired
	DtweetDao dtweetDao;

	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DtweetService#writeMessage()
	 */
	@Override
	public void writeMessage(Dtweet dtweet) {
		this.dtweetDao.writeMessage(dtweet);
		
		
	}

	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DtweetService#readMessage()
	 */
	@Override
	public String[] readMessage(Dusr loginUsr) {
		return this.dtweetDao.readMessage(loginUsr);
	}

	

}
