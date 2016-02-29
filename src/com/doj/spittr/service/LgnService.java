package com.doj.spittr.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.doj.spittr.entities.Dusr;
@Component
public interface LgnService {
 public  List<Dusr> getLoginDetailByUname(String Uname);
}
