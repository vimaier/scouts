package com.sap.innojam.sample.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sap.innojam.sample.ws.BaseJsonCoder;

@Entity
@XmlRootElement
public class SensorData {

	public static class Coder extends BaseJsonCoder<SensorData> {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String owner;
	private String device;
	private Date created;

	@NotNull
	private String type;

	@NotNull
	private Double value;

	@PrePersist
	public void updateTimeStamps() {
		created = new Date();
	}

	protected SensorData() {
	}

	public SensorData(String owner, String device, Date created, String type, Double value) {
		this.owner = owner;
		this.device = device;
		this.created = created;
		this.type = type;
		this.value = value;
	}

	@XmlTransient
	public long getId() {
		return id;
	}

	@XmlTransient
	public String getDevice() {
		return device;
	}

	@XmlTransient
	public String getOwner() {
		return owner;
	}

	public Date getCreated() {
		return created;
	}

	public String getType() {
		return type;
	}

	public Double getValue() {
		return value;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
