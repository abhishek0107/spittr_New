package com.doj.spittr.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.Dusr;
import com.doj.spittr.entities.PasswordManagement;
import com.doj.spittr.repositories.UsrDao;
@Service
@Transactional
public class DusrServiceImpl implements DusrService{
	private UsrDao usrDao;
	@Autowired
	public void setUsrDao(UsrDao usrDao) {
		this.usrDao = usrDao;
	}
	@Override
	public Dusr registerUser(Dusr dusr) {
		return this.usrDao.registerUser(dusr);
	}
	@Override
	public Dusr modifyUser(Dusr dusr) {
		return this.usrDao.modifyUser(dusr);
	}
	@Override
	public Dusr getUserDetail(Dusr dusr) {
		return this.usrDao.getUserDetail(dusr);
	}
	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DusrService#changePassword(com.doj.spittr.entities.PasswordManagement)
	 */
	@Override
	public Dusr changePassword(PasswordManagement passwordManagement) {
		return this.usrDao.changePassword(passwordManagement);
		
	}
	/* (non-Javadoc)
	 * @see com.doj.spittr.service.DusrService#getUsrDetailByEmail()
	 */
	@Override
	public Dusr getUsrDetailByEmail(String email) {
		return this.usrDao.getUsrDetailByEmail(email);
	}
	 
	

}
