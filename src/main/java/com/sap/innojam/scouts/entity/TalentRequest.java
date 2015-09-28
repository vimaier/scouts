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
public class TalentRequest {
	
	public enum State {
		Accepted,
		Rejected,
		Pending
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private Talent talent;
	@NotNull
	private Scout scout;
	@NotNull
	private State state;

	protected TalentRequest() {
	}

	public TalentRequest(Talent talent, Scout scout) {
		this.talent = talent;
		this.scout = scout;
		this.state = State.Pending;
	}
	
	public TalentRequest(Talent talent, Scout scout, State state){
		this(talent, scout);
		this.state = state;
	}

	@XmlTransient
	public long getId() {
		return id;
	}

	@XmlTransient
	public Talent getTalent() {
		return talent;
	}

	@XmlTransient
	public Scout getScout() {
		return scout;
	}
	
	@XmlTransient
	public State getState() {
		return state;
	}
}
