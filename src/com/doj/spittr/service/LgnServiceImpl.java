package com.doj.spittr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.doj.spittr.entities.Dusr;
import com.doj.spittr.repositories.LoginDao;

@Service
@Transactional
public class LgnServiceImpl implements LgnService  {
		
	private LoginDao loginDao;
	@Autowired
	public void setLoginDao(LoginDao loginDao){
		this.loginDao=loginDao;
	}
	
	@Override
	public List<Dusr> getLoginDetailByUname(String Uname) {
		if(loginDao!=null){
			return  this.loginDao.getUserDetail(Uname);
		}
		return null;
	}
	

}
