package com.mooremaking.config;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class WebUtils {

	private JavaMailSender sender;

	@Autowired
	public WebUtils(JavaMailSender sender) {
		super();
		this.sender = sender;
	}

	public void sendMail(String to, String msg, String subject) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(to);
			helper.setText(msg);
			helper.setSubject(subject);
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.send(message);


	}

}
