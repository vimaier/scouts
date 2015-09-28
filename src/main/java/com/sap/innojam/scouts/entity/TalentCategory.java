package com.sap.innojam.scouts.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class TalentCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String name;
	private TalentCategory parent;

	protected TalentCategory() {
	}

	public TalentCategory(String name) {
		this.name = name;
	}
	
	public TalentCategory(String name, TalentCategory parent){
		this(name);
		this.parent = parent;
	}

	@XmlTransient
	public long getId() {
		return id;
	}

	@XmlTransient
	public String getName() {
		return name;
	}

	@XmlTransient
	public TalentCategory getParent() {
		return parent;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
