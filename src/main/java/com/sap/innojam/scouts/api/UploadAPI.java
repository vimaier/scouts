package com.sap.innojam.scouts.api;

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
import com.sap.innojam.scouts.entity.Upload;

@Path("/upload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UploadAPI {

	@Inject
	SensorDAO dao;
	
	@Context
	SecurityContext request;

	@GET
	@Path("/{uid}")
	public Upload getUpload(@PathParam("uid") String uploadId) {
		//TODO: add stub Upload. Media transport, not JSON!
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
	public void create(Upload uploadParam) {
//		SensorData newSensor = new SensorData(request.getUserPrincipal().getName(), device, new Date(), sensorParam.getType(),
//				sensorParam.getValue());
//		return dao.insert(newSensor);
		// TODO: create a upload
	}

}
