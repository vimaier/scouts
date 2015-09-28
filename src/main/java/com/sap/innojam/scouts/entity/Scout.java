package com.sap.innojam.scouts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Scout extends User {

	//private List<Like> likes;

	public Scout() {
		super();
	}

	public Scout(String uid, String artistname, String firstname,
			String lastname, int age, String gender, String mail,
			List<TalentRequest> talreq, List<Like> likes) {
		super(uid, artistname, firstname, lastname, age, gender, mail, talreq);
		//this.likes = likes;
	}

	// public List<Like> getLikes() {
	// return likes;
	// }

}
