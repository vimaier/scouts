package com.sap.innojam.sample.dao;

import java.util.List;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.sap.innojam.sample.entity.SensorData;

@RequestScoped
public class SensorDAO extends BaseDAO<SensorData, Integer> {
	public SensorDAO() {
		super(SensorData.class);
	}

	@SuppressWarnings("unchecked")
	public List<SensorData> findAllByOwnerAndDevice(String currentUser, String device) {
		return em.createQuery("SELECT s FROM SensorData s WHERE s.owner = :owner AND s.device = :device")
				.setParameter("owner", currentUser)
				.setParameter("device", device)
				.getResultList();

	}
}