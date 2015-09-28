package com.sap.innojam.scouts.dao;

import java.util.List;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.sap.innojam.scouts.entity.SensorData;

@RequestScoped
public class SensorDAO extends BaseDAO<SensorData, Integer> {
	public SensorDAO() {
		super(SensorData.class);
	}

	@SuppressWarnings("unchecked")
	public List<SensorData> findAllByDevice(String currentUser, String device) {
		return em.createQuery("SELECT s FROM SensorData s WHERE s.device = :device")
				.setParameter("device", device)
				.getResultList();

	}
}