package com.sap.innojam.scouts.api;

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

import com.sap.innojam.scouts.dao.SensorDAO;
import com.sap.innojam.scouts.entity.SensorData;
import com.sap.innojam.scouts.entity.Upload;

@Path("/talent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TalentAPI {

	@Inject
	SensorDAO dao;
	
	@Context
	SecurityContext request;

	@GET
	@Path("/{uid}")
	public List<SensorData> getTalent(@PathParam("uid") String userId) {
		//TODO: add stub talent
//		return dao.findAllByOwnerAndDevice(request.getUserPrincipal().getName(), device);
		return null;
	}

	@GET
	@Path("/uploads")
	public List<Upload> getAllUploads() {
		//TODO: return upload ids (or better get-urls) of the user
//		return dao.findAllByOwnerAndDevice(request.getUserPrincipal().getName(), device);
		return null;
	}

//	@POST
//	@Path("/{device}")
//	public SensorData create(@PathParam("device") String device, SensorData sensorParam) {
//		SensorData newSensor = new SensorData(request.getUserPrincipal().getName(), device, new Date(), sensorParam.getType(),
//				sensorParam.getValue());
//		return dao.insert(newSensor);
//	}
	@POST
	@Path("/create")
	public SensorData createTalent(SensorData sensorParam) {
//		SensorData newSensor = new SensorData(request.getUserPrincipal().getName(), device, new Date(), sensorParam.getType(),
//				sensorParam.getValue());
//		return dao.insert(newSensor);
		// TODO: create a talent and return it
		return null;
	}

	@GET
	@Path("/accept/{scoutid}")
	public JsonResponse acceptScoutRequest(@PathParam("scoutid") String scoutId) {
		//TODO: get uid of current talent
		//TODO: check if scoutId is in list of TalentRequests of curr Talent
		//TODO: if yes change state to 'accepted'
		//TODO: send/save notification
		return null;
	}
	
	@GET
	@Path("/reject/{scoutid}")
	public JsonResponse rejectScoutRequest(@PathParam("scoutid") String scoutId) {
		//TODO: get uid of current talent
		//TODO: check if scoutId is in list of TalentRequests of curr Talent
		//TODO: if yes change state to 'rejected'
		//TODO: send/save notification
		return null;
	}
	
}
