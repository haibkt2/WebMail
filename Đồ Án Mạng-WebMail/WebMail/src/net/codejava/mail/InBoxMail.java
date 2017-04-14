package net.codejava.mail;

import java.util.HashSet;

import java.util.Set;

public class InBoxMail {
	private int id;
	private Set<Mail> mail;

	public InBoxMail() {
	}
	public InBoxMail(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Mail> getMail() {
		return mail;
	}
	public void setMail(Set<Mail> mail) {
		this.mail = mail;
	}
	public void setListMail(Mail m) {
		if (mail == null){
			this.mail = new HashSet<Mail>();
	}this.mail.add(m);
}
}