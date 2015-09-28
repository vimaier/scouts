package com.sap.innojam.scouts.api;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.sap.innojam.scouts.dao.SensorDAO;
import com.sap.innojam.scouts.entity.Scout;
import com.sap.innojam.scouts.entity.Upload;

@Path("/scout")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScoutAPI {
	
	private final static Logger LOGGER = Logger.getLogger(ScoutAPI.class.getSimpleName());

	@Inject
	SensorDAO dao;
	
	@Context
	SecurityContext request;

	@GET
	@Path("/get")
	public Scout getScout() {
		//TODO: return current logged in scout (get uid from session)
		LOGGER.info(String.format("getScout() -> %s", DummyData.scott));
		return DummyData.scott;
	}

	@GET
	@Path("/uploads")
	public List<Upload> getAllUploadsOfCurrentUser() {
		//TODO: return upload ids (or better get-urls) of the user
//		return dao.findAllByOwnerAndDevice(request.getUserPrincipal().getName(), device);
		return null;
	}

}
