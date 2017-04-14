package net.codejava.mail;

public class Mail {

	String subject;
	String address;
	String content;

	String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Mail() {
	}

	public Mail(String sub, String add, String content, String date) {
		this.subject = sub;
		this.address = add;
		this.content = content;
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}