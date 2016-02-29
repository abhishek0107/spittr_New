/**
 * 
 */
package com.doj.spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.doj.spittr.entities.Dusr;

/**
 * @author Abhishek
 *
 * 
 */
@Service
@Component
public class SpittrMailService {
	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	@Autowired
	private DusrService dusrService;

	/**
	 * This method will send compose and send the message
	 */
	public boolean sendMail(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Password Setting");
		Dusr dusr=dusrService.getUsrDetailByEmail(to);
		String msgText= "Dear, \n "+ " "+ dusr.getUsrfn() + "\n your password is mentioned below. please change your password immediately \n \n"+dusr.getUsrpwd();
		message.setText(msgText);
		{			
			mailSender.send(message);
			return true;
		}
	}

	/**
	 * This method will send a pre-configured message
	 */
	public void sendPreConfiguredMail(String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
}
