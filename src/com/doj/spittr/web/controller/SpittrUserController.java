package com.doj.spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doj.spittr.entities.Dusr;
import com.doj.spittr.entities.PasswordManagement;
import com.doj.spittr.service.DflwrService;
import com.doj.spittr.service.DtweetService;
import com.doj.spittr.service.DusrService;

@Controller
@SessionAttributes({"loginUser", "Country", "State"})
public class SpittrUserController {
	@Autowired
	DusrService duService;
	@Autowired
	DflwrService dflwrService;
	@Autowired
	DtweetService dtweetService; 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUsr(@ModelAttribute("dusr") Dusr dusr, BindingResult result, ModelAndView model) {
			if(duService.registerUser(dusr)!=null){
				model.addObject("tab", "Profile");
				model.addObject("dusr", dusr);
				model.setViewName("editProfile");
			}else{
				model.addObject("signuperror",  "<div class=\"error\" >user already registered</div>");
				model.setViewName("login");
			}		
		return model;	
	}

	
	@RequestMapping(value = "/changeProfile", method = RequestMethod.POST)
	public String modifyDetail(@ModelAttribute("dusr") Dusr dusr, BindingResult result, ModelMap model) {
		model.addAttribute("dusr", new Dusr());
		if (duService != null) {
			duService.modifyUser(dusr);
			model.put("tab", "Profile");
			model.put("dusr", dusr);
			return "viewProfile";
		}
		return "login";
	}
	@RequestMapping(value={"/myProfile"})
	public String profile(@ModelAttribute("dusr") Dusr dusr,
			BindingResult result, @ModelAttribute("loginUser") Dusr loginUser,ModelMap model
			){
		model.addAttribute("dusr", new Dusr());
		/*List<Dusr> allUser2= dflwrService.getMyFollower(loginUser);
		if(allUser2!=null && !allUser2.isEmpty()){
			model.addAttribute("NoOfFollowers", allUser2.size());
		}else{
			model.addAttribute("NoOfFollowers", 0);
		}
		List<Dusr> fUser= dflwrService.getFollowingUser(loginUser);;
		if(fUser!=null && !fUser.isEmpty()){
			model.addAttribute("NoOfFollowing", fUser.size());
		}else{
			model.addAttribute("NoOfFollowing", 0);
		}
		model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);*/
		model.put("tab", "Profile");
		return "viewProfile";
	}
	
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String editProfile(@ModelAttribute("dusr") Dusr dusr, BindingResult result, ModelMap model,@RequestParam("id") String id){
		Dusr contextUsr=new Dusr();
		contextUsr.setUsrid(Long.parseLong(id.trim()));
		contextUsr=this.duService.getUserDetail(contextUsr);
		model.addAttribute("dusr", contextUsr);
		model.put("tab", "Profile");
		return "editProfile";
	}
	@RequestMapping(value={"/editProfile"})
	public String editProfile(@ModelAttribute("dusr") Dusr dusr, BindingResult result, ModelMap model){
		model.addAttribute("dusr", dusr);
		model.put("tab", "Profile");
		return "editProfile";
	}
	@RequestMapping(value = { "/changePassword" })
	public String changePassword(ModelMap model, @ModelAttribute("dusr") Dusr dusr, BindingResult result,@RequestParam("id") String id, @ModelAttribute("passwordManagement") PasswordManagement passwordManagement) {
		dusr.setUsrid(Long.parseLong(id.trim()));
		model.addAttribute("dusr", dusr);
		model.addAttribute("passwordManagement", new PasswordManagement());
		model.put("tab", "Profile");
		return "changePassword";
	}
	@RequestMapping(value = { "/updatePassword" })
	public String updatePassword(ModelMap model, @ModelAttribute("dusr") Dusr dusr, BindingResult result, @ModelAttribute("passwordManagement") PasswordManagement passwordManagement) {
		dusr.setUsrid(passwordManagement.getUserId());
		dusr =duService.changePassword(passwordManagement);
		dusr.setUsrpwd(null);
		model.addAttribute("dusr", dusr);
		model.put("tab", "Profile");
		return "viewProfile";
	}
	
}
