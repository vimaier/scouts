package com.sap.innojam.scouts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Talent extends User {

	private List<Upload> uploads;

	public Talent() {
		super();
	}

	public Talent(String uid, String artistname, String firstname,
			String lastname, int age, String gender, String mail, List<TalentRequest> talreq,
			List<Upload> uploads) {
		super(uid, artistname, firstname, lastname, age, gender, mail, talreq);
		this.uploads = uploads;
	}

	public List<Upload> getUploads() {
		return uploads;
	}

	public void setUploads(List<Upload> uploads) {
		this.uploads = uploads;
	}

}
