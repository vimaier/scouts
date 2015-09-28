package com.sap.innojam.scouts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public abstract class User {

	@Id
	private String uid;
	private String artistname;
	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private String mail;

	private List<TalentRequest> talreq;

	public User() {
		super();
	}
	public User(String uid) {
		this.uid = uid;
	}

	public User(String uid, String artistname, String firstname,
			String lastname, int age, String gender, String mail,
			List<TalentRequest> talreq) {
		this(uid);
		this.artistname = artistname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.mail = mail;
		this.talreq = talreq;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<TalentRequest> getTalreq() {
		return talreq;
	}

	public void setTalreq(List<TalentRequest> talreq) {
		this.talreq = talreq;
	}

}
