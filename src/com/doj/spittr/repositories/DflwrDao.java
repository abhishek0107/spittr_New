/**
 * 
 */
package com.doj.spittr.repositories;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doj.spittr.entities.Dusr;

/**
 * @author Abhishek
 *
 * 
 */
@Component
public interface DflwrDao {
	public List<Dusr> getAllUser(@ModelAttribute("loginUser") Dusr loginUsr);
	public void follow(@ModelAttribute("loginUser") Dusr loginUsr,String followingId);
	public List<Dusr> getAllUserFollwoedByLoginUser(@ModelAttribute("loginUser") Dusr loginUsr);
	public List<Dusr> getMyFollower(@ModelAttribute("loginUser") Dusr loginUsr);
}
