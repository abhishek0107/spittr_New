package com.doj.spittr.web.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.doj.spittr.entities.DAppImage;
import com.doj.spittr.entities.Dtweet;
import com.doj.spittr.entities.Dusr;
import com.doj.spittr.service.AppDataMasterService;
import com.doj.spittr.service.DAppImgService;
import com.doj.spittr.service.DflwrService;
import com.doj.spittr.service.DtweetService;
import com.doj.spittr.service.LgnService;
import com.doj.spittr.service.SpittrMailService;
@Controller
@SessionAttributes({"loginUser", "Country", "State"})
public class SpittrController {
	
	@Autowired
	private DflwrService dflwrService;
	@Autowired
	private LgnService lgnService;
	@Autowired
	private DAppImgService dAppImgService;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DtweetService dtweetService;
	
	@Autowired
    private SpittrMailService mailService;
	@Autowired
	private AppDataMasterService masterData;

/*	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public String login(ModelMap model,
			@ModelAttribute("dusr") Dusr dusr,
			BindingResult result) {
			model.remove("loginUser");

		String email = dusr.getUsreml();
		String password = dusr.getUsrpwd();
		String encodedString="";
		if (email != null && password != null) {
			if (lgnService != null) {
				List<Dusr> loginUser = lgnService.getLoginDetailByUname(email, password);
				if (null != loginUser) {
					model.put("tab", "Profile");
					model.addAttribute("dusr", loginUser.get(0));
					byte img[] = dAppImgService.getImage(loginUser.get(0).getUsrid());
					if(img!=null && img.length>1){
						byte[] encoded = Base64.encodeBase64(img);
						encodedString = new String(encoded);
					}
					loginUser.get(0).setUsrImg(encodedString);
					model.addAttribute("dusr", new Dusr());
					model.addAttribute("loginUser",loginUser.get(0));
					model.addAttribute("Country", masterData.getMasterData("country"));
					model.addAttribute("State", masterData.getMasterData("State"));
					model.addAttribute("tweetCount", dtweetService.readMessage(loginUser.get(0)).length);
					List<Dusr> allUser= dflwrService.getMyFollower(loginUser.get(0));
					if(allUser!=null && !allUser.isEmpty()){
						model.addAttribute("NoOfFollowers", allUser.size());
					}else{
						model.addAttribute("NoOfFollowers", 0);
					}
					List<Dusr> fUser= dflwrService.getFollowingUser(loginUser.get(0));;
					if(fUser!=null && !fUser.isEmpty()){
						model.addAttribute("NoOfFollowing", fUser.size());
					}else{
						model.addAttribute("NoOfFollowing", 0);
					}					
					
					return "viewProfile";
				}
			}
		}
		return "login";
	}
	
*/


	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login(ModelMap model,
			@ModelAttribute("dusr") Dusr dusr,
			BindingResult result) {	
		String email=getPrincipal();
		if(email!=null && !"anonymousUser".equalsIgnoreCase(email)){	
			List<Dusr> loginUser = lgnService.getLoginDetailByUname(email);
			model.addAttribute("loginUser", loginUser.get(0));
			model.put("tab", "Profile");
			return "viewProfile";
		}
		return "login";
	}
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
}
	@RequestMapping(value = { "/changePicture" })
	public String changeProfilePic(ModelMap model, @ModelAttribute("dusr") Dusr dusr,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result, @RequestParam("id") String id,@ModelAttribute("loginUser") Dusr loginUser) {
		model.addAttribute("dusr", dusr);
		String encodedString="";
		
		long usrid=id.length()>0?Long.parseLong(id):loginUser.getUsrid();	
		dusr.setUsrid(usrid);
		DAppImage dAppImage2 = new DAppImage();
		dAppImage2.setAppimgusrid(usrid);
		model.addAttribute("dAppImage", dAppImage2);
		byte img[] = dAppImgService.getImage(usrid);
		if(img!=null && img.length>1){
			byte[] encoded = Base64.encodeBase64(img);
			encodedString = new String(encoded);
		}
		loginUser.setUsrImg(encodedString);
		model.put("tab", "Profile");		
		model.put("imgData", encodedString);
		return "changePicture";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	@RequestMapping(value = { "/changePic" })
	public String changePic(ModelMap model, @ModelAttribute("dusr") Dusr dusr,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,
			@RequestParam("file") MultipartFile file) {			
		try {
			Blob blob = Hibernate.getLobCreator(this.sessionFactory.openSession()).createBlob(file.getInputStream(),
					20);
			dAppImage.setAppimgdata(blob);
			dAppImage.setAppimgtype(file.getContentType());
			dAppImgService.save(dAppImage);
			dusr.setUsrid(dAppImage.getAppimgusrid());
			dAppImage.setAppimgusrid(dAppImage.getAppimgusrid());
			byte img[] = dAppImgService.getImage(dAppImage.getAppimgusrid());
			byte[] encoded = Base64.encodeBase64(img);
			String encodedString = new String(encoded);
			model.put("imgData", encodedString);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		model.addAttribute("dusr", dusr);
		model.addAttribute("dAppImage", dAppImage);
		model.put("tab", "Profile");
		return "changePicture";
	}

	@RequestMapping(value = { "/home", "/tweets" })
	public String home(ModelMap model) {
		model.put("tab", "Home");
		return "home";
	}

	@RequestMapping("/message")
	public String writeMessage(ModelMap model, @ModelAttribute("dtweet") Dtweet dtweet,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,@ModelAttribute("loginUser") Dusr loginUser) {
		/*model.addAttribute("dtweet", dtweet);
		model.addAttribute("dtweet", dtweet);
		model.addAttribute("messageText", dtweetService.readMessage(loginUser));
		model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);
		List<Dusr> allUser= dflwrService.getMyFollower(loginUser);
		if(allUser!=null && !allUser.isEmpty()){
			model.addAttribute("NoOfFollowers", allUser.size());
		}else{
			model.addAttribute("NoOfFollowers", 0);
		}
		List<Dusr> fUser= dflwrService.getFollowingUser(loginUser);;
		if(fUser!=null && !fUser.isEmpty()){
			model.addAttribute("NoOfFollowing", fUser.size());
		}else{
			model.addAttribute("NoOfFollowing", 0);
		}*/
		model.put("tab", "Message");
		return "message";
	}
	@RequestMapping("/sendmsg")
	public String sendMessage(ModelMap model, @ModelAttribute("dtweet") Dtweet dtweet,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,@ModelAttribute("loginUser") Dusr loginUser) {
		dtweetService.writeMessage(dtweet);
		dtweetService.readMessage(loginUser);
		model.addAttribute("dtweet", dtweet);
		/*model.addAttribute("messageText", dtweetService.readMessage(loginUser));
		model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);
		List<Dusr> allUser= dflwrService.getMyFollower(loginUser);
		if(allUser!=null && !allUser.isEmpty()){
			model.addAttribute("NoOfFollowers", allUser.size());
		}else{
			model.addAttribute("NoOfFollowers", 0);
		}
		List<Dusr> fUser= dflwrService.getFollowingUser(loginUser);;
		if(fUser!=null && !fUser.isEmpty()){
			model.addAttribute("NoOfFollowing", fUser.size());
		}else{
			model.addAttribute("NoOfFollowing", 0);
		}*/
		model.put("tab", "Message");
		return "message";
	}

	@RequestMapping("/myFollowers")
	public String myFollowres(ModelMap model, @ModelAttribute("dusr") Dusr dusr,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,@ModelAttribute("loginUser") Dusr loginUser) {		
		/*List<Dusr> allUser= dflwrService.getMyFollower(loginUser);
		if(allUser!=null && !allUser.isEmpty()){
			model.addAllAttributes(allUser);
		}else{
			allUser=dflwrService.getAllUser();
			if(allUser!=null && !allUser.isEmpty()){
				model.addAllAttributes(allUser);
			}
		}
		List<Dusr> allUser2= dflwrService.getMyFollower(loginUser);
		if(allUser2!=null && !allUser2.isEmpty()){
			model.addAttribute("NoOfFollowers", allUser2.size());
		}else{
			model.addAttribute("NoOfFollowers", 0);
		}
		model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);
		List<Dusr> fUser= dflwrService.getFollowingUser(loginUser);;
		if(fUser!=null && !fUser.isEmpty()){
			model.addAttribute("NoOfFollowing", fUser.size());
		}else{
			model.addAttribute("NoOfFollowing", 0);
		}
		model.addAttribute("allUser",allUser);*/
		model.put("tab", "Followers");
		return "myFollowers";
	}

	@RequestMapping("/followers")
	public String followers(ModelMap model, @ModelAttribute("dusr") Dusr dusr,
		@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,
		@ModelAttribute("loginUser") Dusr loginUser) {
		
		List<Dusr> allUser= dflwrService.getAllUser(dusr);
		if(allUser!=null && !allUser.isEmpty()){
				model.addAllAttributes(allUser);
		}
		model.addAttribute("allUser",allUser);
		/*model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);
		List<Dusr> allUser2= dflwrService.getMyFollower(loginUser);
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
	*/	model.put("tab", "Followers");
		return "followers";
	}
	
	@RequestMapping("/following")
	public String following(ModelMap model, @ModelAttribute("dusr") Dusr dusr,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,
			@ModelAttribute("loginUser") Dusr loginUser) {
		List<Dusr> allUser= dflwrService.getAllUserFollwoedByLoginUser(loginUser);
		/*	if(allUser!=null && !allUser.isEmpty()){
				model.addAllAttributes(allUser);
			}
			model.addAttribute("allUser",allUser);
			model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);
			List<Dusr> allUser2= dflwrService.getMyFollower(loginUser);
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
			}*/
			model.put("tab", "Followers");
		return "following";
	}
	@RequestMapping(value={"/follow"})
	public String follow(ModelMap model, @ModelAttribute("dusr") Dusr dusr,
			@ModelAttribute("dAppImage") DAppImage dAppImage, BindingResult result,
			@ModelAttribute("loginUser") Dusr loginUser,@RequestParam("id") String id) {
		if(id!=null && id.length()>0){
			dflwrService.follow(loginUser,id);
			List<Dusr> allUser= dflwrService.getAllUser(dusr);
			if(allUser!=null && !allUser.isEmpty()){
				model.addAllAttributes(allUser);
			}
			model.addAttribute("allUser",allUser);

		}
		model.addAttribute("tweetCount", dtweetService.readMessage(loginUser).length);
		List<Dusr> allUser2= dflwrService.getMyFollower(loginUser);
		if(allUser2!=null && !allUser2.isEmpty()){
			model.addAttribute("NoOfFollowers", allUser2.size());
		}else{
			model.addAttribute("NoOfFollowers", 0);
		}
		List<Dusr> fUser= dflwrService.getAllUserFollwoedByLoginUser(loginUser);;
		if(fUser!=null && !fUser.isEmpty()){
			model.addAttribute("NoOfFollowing", fUser.size());
		}else{
			model.addAttribute("NoOfFollowing", 0);
		}
		model.put("tab", "Followers");
		return "followers";
	}
	
	@RequestMapping(value={"/sendMail"})
	public String sendMail(@ModelAttribute("dusr") Dusr dusr, BindingResult result){		
		boolean b=mailService.sendMail(dusr.getUsreml());
		if(b)
			return "login";
		else
			return "login";
	
	}
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}*/
	


}
