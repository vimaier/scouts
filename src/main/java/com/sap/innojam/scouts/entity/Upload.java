package com.sap.innojam.scouts.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Upload {

	public enum Type {
		Video,
		Audio,
		Image
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private TalentCategory category;

	@NotNull
	private Type type;
	
	private List<Like> likes;

	protected Upload() {
	}

	public Upload(TalentCategory category , Type type) {
		this.category = category;
		this.type = type;
	}

	@XmlTransient
	public long getId() {
		return id;
	}

	@XmlTransient
	public TalentCategory getCategory() {
		return category;
	}

	@XmlTransient
	public Type getType() {
		return type;
	}
	
	@XmlTransient
	public List<Like> getLikes() {
		return likes;
	}
}
