/**
 * 
 */
package com.doj.spittr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doj.spittr.entities.Dusr;
import com.doj.spittr.repositories.DflwrDao;

/**
 * @author Abhishek
 *
 * 
 */
@Service
@Transactional
public class DflwrServiceImpl implements DflwrService{
	@Autowired
	private DflwrDao DflwrDao;

	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DflwrService#getAllUser()
	 */
	@Override
	public List<Dusr> getAllUser(@ModelAttribute("loginUser") Dusr loginUsr) {
		// TODO Auto-generated method stub
		return this.DflwrDao.getAllUser(loginUsr);
	}

	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DflwrService#follow(com.doj.spittr.entities.Dusr, java.lang.String)
	 */
	@Override
	public void follow(Dusr loginUsr, String followingId) {
		this.DflwrDao.follow(loginUsr, followingId);
	}

	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DflwrService#getFollowingUser(com.doj.spittr.entities.Dusr)
	 */
	@Override
	public List<Dusr> getAllUserFollwoedByLoginUser(Dusr loginUsr) {
		System.out.println("in getFollowinguser detail");
		// TODO Auto-generated method stub
		return this.DflwrDao.getAllUserFollwoedByLoginUser(loginUsr);
	}

	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DflwrService#getMyFollower(com.doj.spittr.entities.Dusr)
	 */
	@Override
	public List<Dusr> getMyFollower(Dusr loginUsr) {
		// TODO Auto-generated method stub
		return this.DflwrDao.getMyFollower(loginUsr);
	}

}
