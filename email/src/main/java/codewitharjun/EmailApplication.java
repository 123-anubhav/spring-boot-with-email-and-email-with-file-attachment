package codewitharjun;

import java.util.concurrent.TimeUnit;

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
	public void sendMail() {
		// senderservice.sendMail(toEmail:"anubhav.aa2@gmail.com", subject:"this is
		// subject of email", body:"this is body of email");
		/*
		 * senderservice.sendMail("anubhav.aa2@gmail.com", "this is subject of email",
		 * "this is body of email"); senderservice.sendMail("anubhav.aa1@gmail.com",
		 * "testing spring boot email module developed by anubhav",
		 * "hi everyone, i am your friend anubhav in spring boot module app testing the java mail "
		 * );
		 */
		senderservice.sendMail("anubhav.aa2@gmail.com", "testing spring boot email module developed by anubhav",
				"hi anubhav.aa2, i am your friend anubhav in spring boot module app testing the java mail"
						+ "\n if u rcv email then msg me success in whatsapp"
						+ "\naise hi develope kiye the mail app ");

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
