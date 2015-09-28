package com.sap.innojam.scouts.entity;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
		Video, Audio, Image;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Talent uploader;

	@NotNull
	private TalentCategory category;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@NotNull
	private String extension;

	private List<Like> likes;

	protected Upload() {
	}
	
	public Upload(long id, Talent uploader, TalentCategory category, Type type, String extension) {
		this(uploader, category, type, extension);
		this.id = id;
	}
	
	public Upload(Talent uploader, TalentCategory category, Type type, String extension) {
		this.uploader = uploader;
		this.category = category;
		this.type = type;
		this.extension = extension;
	}

	public long getId() {
		return id;
	}

	public TalentCategory getCategory() {
		return category;
	}

	public Type getType() {
		return type;
	}

	public List<Like> getLikes() {
		return likes;
	}

	@XmlTransient
	public Talent getUploader() {
		return uploader;
	}
	
	public String getExtension(){
		return extension;
	}
	
	public String getPath(){
		return "uploads"+File.separator+uploader.getUid()+File.separator+String.valueOf(id)+"."+extension;
	}

}
