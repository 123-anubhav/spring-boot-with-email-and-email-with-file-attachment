package codewitharjun;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	JavaMailSender mailsender;

	public void sendMailwithAttachment(String toEmail, String subject, String body, String attachment)
			throws MessagingException {

		// send email with attachment file
		// attach file to email
		MimeMessage mimemsg = mailsender.createMimeMessage();
		MimeMessageHelper mimemsghelper = new MimeMessageHelper(mimemsg, true);
		mimemsghelper.setFrom("anubhav.aa2@gmail.com");
		mimemsghelper.setTo(toEmail);
		mimemsghelper.setSubject(subject);
		mimemsghelper.setText(body);
		FileSystemResource filesystemresource = new FileSystemResource(new File(attachment));

		mimemsghelper.addAttachment(filesystemresource.getFilename(), filesystemresource);

		mailsender.send(mimemsg);
		System.out.println("mail with attachment send successfully...");

	}
}
