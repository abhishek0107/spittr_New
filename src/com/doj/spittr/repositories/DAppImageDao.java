package com.doj.spittr.repositories;

import org.springframework.stereotype.Component;

import com.doj.spittr.entities.DAppImage;

@Component
public interface DAppImageDao {
	public void save(DAppImage img);
	public byte[] getImage(Long id) ;

}
