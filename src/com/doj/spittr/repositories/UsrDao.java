package com.doj.spittr.repositories;

import org.springframework.stereotype.Component;

import com.doj.spittr.entities.Dusr;
import com.doj.spittr.entities.PasswordManagement;

@Component
public interface UsrDao {
	public Dusr registerUser(Dusr dusr);
	public Dusr modifyUser(Dusr dusr);
	public Dusr getUserDetail(Dusr dusr);
	public Dusr changePassword(PasswordManagement passwordManagement);
	public Dusr getUsrDetailByEmail(String email);
}
