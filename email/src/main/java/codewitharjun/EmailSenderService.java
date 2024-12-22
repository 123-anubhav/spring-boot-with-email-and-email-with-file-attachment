package codewitharjun;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	JavaMailSender mailsender;

	
	public void sendMail(String toEmail, String subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("anubhav.aa2@gmail.com");
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(body);
		mailsender.send(msg);
		System.out.println("mail send successfully");

	}
}
