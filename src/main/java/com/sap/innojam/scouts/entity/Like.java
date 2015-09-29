package com.sap.innojam.scouts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private User liker;
	@NotNull
	private Upload upload;
	private boolean isDisliked;

	protected Like() {
	}

	public Like(User liker, Upload upload, boolean isDisLiked) {
		this.liker = liker;
		this.upload = upload;
		this.isDisliked = isDisLiked;
	}

	public long getId() {
		return id;
	}

	public User getLiker() {
		return liker;
	}

	public Upload getUpload() {
		return upload;
	}
	
	public boolean isDisliked(){
		return isDisliked;
	}
}
