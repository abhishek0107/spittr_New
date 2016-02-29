package com.doj.spittr.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.doj.spittr.entities.Dusr;
@Component
public interface LoginDao {
	public  List<Dusr> getUserDetail(String email);
	
}
