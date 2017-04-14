package net.codejava.mail;

import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {
	public static void sendEmailWithAttachment(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message, List<File> attachedFiles)
					throws AddressException, MessagingException {
		// sets SMTP server properties
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);


		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		String s = properties.getProperty("mail.smtp.sasl.enable");
		System.out.println(s);
		System.out.println("user or pass erro");
		System.out.println(auth);
		Session session = Session.getInstance(properties, auth);
		System.out.println(session.toString());
System.out.println("erro");
		// creates a new e-mail message
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject ,"utf-8" );
		msg.setSentDate(new Date());
		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html; charset=utf-8");
		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachedFiles != null && attachedFiles.size() > 0) {
			for (File aFile : attachedFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(aFile);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(attachPart);
			}
		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);
		System.out.println("erro");
		// sends the e-mail
		Transport.send(msg);
	}
}