package net.codejava.mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;


public class ReceiverMail {
	 private static final List<InBoxMail> mail = new ArrayList<InBoxMail>();
	private Properties getServerProperties(String protocol, String host, String port) {
		Properties properties = new Properties();

		// server setting
		properties.put(String.format("mail.%s.host", protocol), host);
		properties.put(String.format("mail.%s.port", protocol), port);

		// SSL setting
		properties.setProperty(String.format("mail.%s.socketFactory.class", protocol),
				"javax.net.ssl.SSLSocketFactory");
		properties.setProperty(String.format("mail.%s.socketFactory.fallback", protocol), "false");
		properties.setProperty(String.format("mail.%s.socketFactory.port", protocol), String.valueOf(port));

		return properties;
	}
	public void downloadEmails(String protocol, String host, String port, String userName, String password) throws IOException
	{	
		Properties properties = getServerProperties(protocol, host, port);
		Session session = Session.getDefaultInstance(properties);
		try {
			// connects to the message store
			Store store = session.getStore(protocol);
			store.connect(userName, password);
			Folder emailFolder = store.getFolder("Inbox");

			emailFolder.open(Folder.READ_ONLY);
			Folder[] f = store.getDefaultFolder().list();
			for (Folder fd : f) {
				System.out.println(">> " + fd.getName());
			}
			Message[] messages = emailFolder.getMessages();
			int n = messages.length;
			System.out.println("messages.length---" + messages.length);
			Message message;
	
			for (int i = n-1; i >=0; i--) {
				try {
					message = messages[i];
					Address[] fromAddress = message.getFrom();
					String from = fromAddress[0].toString();
					String subject = message.getSubject();
					String sentDate = message.getSentDate().toString();
					InBoxMail ib = new InBoxMail(i+1);
					ib.setListMail(new Mail(subject, from, getTextFromMessage(message), sentDate));
					mail.add(ib);
				} catch (ArrayIndexOutOfBoundsException aioobe) {
					break;
				}
			}
			emailFolder.close(false);
			store.close();
		} catch (NoSuchProviderException ex) {
			System.out.println("No provider for protocol: " + protocol);
			ex.printStackTrace();
		} catch (MessagingException ex) {
			System.out.println("Could not connect to the message store");
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String result = "";
	MimeMultipart mimeMultipart;

	private String getTextFromMessage(Message message) throws Exception {
		result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			mimeMultipart = (MimeMultipart) message.getContent();
			result ="<br" + getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	BodyPart bodyPart;

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				System.out.println("Xu li html");
				result = result +"\n"+ bodyPart.getContent().toString();
			}
			// else if (bodyPart.getContent() instanceof MimeMultipart) {
			// result = result + getTextFromMimeMultipart((MimeMultipart)
			// bodyPart.getContent());
			// } TODO
		}
		return result;
	}
	public static void main(String ars[]) throws IOException {
		// for POP3
		// String protocol = "pop3";
		// String host = "pop.gmail.com";
		// String port = "995";

		// for IMAP
		String protocol = "imap";
		String host = "imap.gmail.com";
		String port = "993";

		String userName = "hainguyendoshite@gmail.com";
		String password = "haibkt2k13";

		ReceiverMail receiver = new ReceiverMail();
		receiver.downloadEmails(protocol, host, port, userName, password);
	}
	public static List<InBoxMail> queryMail() {
	    return mail;
	  }

	  // Query the employees in a department.
	  public static Set<Mail> queryMail(int id) {
	    for (InBoxMail m : mail) {
	      if (id == m.getId()) {
	        return m.getMail();
	      }
	    }
	    return null;
	  }
}
