/**
 * 
 */
package com.doj.spittr.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.DAppMaster;
import com.doj.spittr.service.AppDataMasterService;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
@Transactional
public class MasterRespository implements AppDataMasterService{
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public List<DAppMaster> getMasterData(String groupName){
		Session session=this.sessionfactory.openSession();
		Query query=session.createQuery("from DAppMaster WHERE appmasgrp=:appmasgrp");
		query.setParameter("appmasgrp", groupName);
		@SuppressWarnings("unchecked")
		List<DAppMaster> dappMaster=query.list();
		return dappMaster;
	}
}
