package com.doj.spittr.service;

import org.springframework.stereotype.Component;

import com.doj.spittr.entities.DAppImage;
@Component
public interface DAppImgService {
	public void save(DAppImage img);
	public byte[] getImage(Long id);
}
