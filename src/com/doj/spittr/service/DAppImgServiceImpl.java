package com.doj.spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.DAppImage;
import com.doj.spittr.repositories.DAppImageDao;
@Service
@Transactional
public class DAppImgServiceImpl implements DAppImgService {

	@Autowired
	private DAppImageDao appImgDao;
	@Override
	public void save(DAppImage img) {
		this.appImgDao.save(img);
	}
	@Override
	public byte[] getImage(Long id) {
		return this.appImgDao.getImage(id);
	}

}
