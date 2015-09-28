package com.sap.innojam.sample.api;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.sap.innojam.sample.dao.SensorDAO;
import com.sap.innojam.sample.entity.SensorData;

@Path("/sensor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SensorAPI {

	@Inject
	SensorDAO dao;
	
	@Context
	SecurityContext request;

	@GET
	@Path("/{device}")
	public List<SensorData> findAll(@PathParam("device") String device) {
		return dao.findAllByOwnerAndDevice(request.getUserPrincipal().getName(), device);
	}

	@POST
	@Path("/{device}")
	public SensorData create(@PathParam("device") String device, SensorData sensorParam) {
		SensorData newSensor = new SensorData(request.getUserPrincipal().getName(), device, new Date(), sensorParam.getType(),
				sensorParam.getValue());
		return dao.insert(newSensor);
	}

	@GET
	@Path("/{device}/create")
	public SensorData createRandom(@PathParam("device") String device) {
		return dao.insert(new SensorData(request.getUserPrincipal().getName(), device, new Date(), "TEST", 0.0));
	}
}
