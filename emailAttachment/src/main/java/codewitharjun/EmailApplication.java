package codewitharjun;

import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class EmailApplication {

	@Autowired
	private EmailSenderService senderservice;

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	// schedular
	// @Scheduled(fixedRate = 2, initialDelay = 4, timeUnit = TimeUnit.SECONDS)

	@EventListener(ApplicationReadyEvent.class)
	public void sendMailwithAttahcment() throws MessagingException {
		// senderservice.sendMail(toEmail:"anubhav.aa2@gmail.com", subject:"this is
		// subject of email", body:"this is body of email");
		/*
		 * senderservice.sendMail("anubhav.aa2@gmail.com", "this is subject of email",
		 * "this is body of email"); senderservice.sendMail("anubhav.aa1@gmail.com",
		 * "testing spring boot email module developed by anubhav",
		 * "hi everyone, i am your friend anubhav in spring boot module app testing the java mail "
		 * );
		 */
		
		String path = "D:/documents+udemy+hk/16-1-22/New folder/SpringProject/WarehouseManagement-4.0.1.rar";
		senderservice.sendMailwithAttachment("anubhav.aa2@gmail.com",
				"send ragu project from email with attachment module developed by anubhav",
				"hi anubhav.aa2, i am your friend anubhav in spring boot module app testing the java mail+attachment with only one attachment file"
						+ "\n if u rcv email then msg me success in whatsapp suuccessful..",
				path);
		/*
		 * senderservice.sendMailwithAttachment("jkajay1994@gmail.com",
		 * "testing spring boot email with attachment module developed by anubhav",
		 * "hi anubhav.aa2, i am your friend anubhav in spring boot module app testing the java mail+attachment"
		 * + "\n if u rcv email then msg me success in whatsapp suuccessful..",
		 * "d:/Resume Boot.pdf");
		 */
		/*
		 * senderservice.sendMail("anubhav.aa1@gmail.com",
		 * "testing spring boot email module developed by anubhav",
		 * "hi anubhav.aa1, i am your friend anubhav in spring boot module app testing the java mail"
		 * + "\n if u rcv email then msg me success in whatsapp");
		 */
		/*
		 * senderservice.sendMail("rajan00131@gmail.com",
		 * "testing spring boot email module developed by anubhav",
		 * "hi rajan, i am your friend anubhav in spring boot module app testing the java mail\n if u rcv email then msg me success in whatsapp "
		 * );
		 */
	}

}
