package com.sap.innojam.scouts.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
import com.sap.innojam.scouts.entity.Talent;
import com.sap.innojam.scouts.entity.Upload;
import com.sap.security.um.user.PersistenceException;
import com.sap.security.um.user.UnsupportedUserAttributeException;
import com.sap.security.um.user.User;
import com.sap.security.um.user.UserProvider;

@Path("/talent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TalentAPI {

	Logger LOGGER = Logger.getLogger(TalentAPI.class.getName());

//	@Inject
//	SensorDAO dao;

	@Inject
	UserProvider userProvider;

	@Context
	SecurityContext request;

	@GET
	@Path("/{uid}")
	public Talent getTalent(@PathParam("uid") String userId) {
		LOGGER.info("execute getTalent with userId = " + userId);
		return DummyData.dummyTalent;
	}

	@GET
	@Path("/uploads")
	public List<Upload> getAllUploads() {
		LOGGER.info("execute getAllUploads() for currentUser");
		try {
			User currentUser = userProvider.getCurrentUser();
			String userId = currentUser.getAttribute("userid");
			LOGGER.info("***** execute getAllUploads for user = " + userId);
		} catch (PersistenceException | UnsupportedUserAttributeException e) {
			e.printStackTrace();
		}
		List<Upload> ret = new ArrayList<Upload>();
		ret.add(DummyData.dummyUploadAudio);
		ret.add(DummyData.dummyUploadImg);
		ret.add(DummyData.dummyUploadVideo);
		return ret;
	}

	@POST
	@Path("/create")
	public boolean createTalent(@PathParam("talent") Talent talent) {
		LOGGER.info("execute createTalent for currentUser");
		// not important for prototype
		return false;
	}

	@GET
	@Path("/accept/{scoutid}")
	public void acceptScoutRequest(@PathParam("scoutid") String scoutId) {
		LOGGER.info("execute acceptScoutRequest for currentUser+ " + scoutId);
		// not important for prototype
	}

	@GET
	@Path("/reject/{scoutid}")
	public JsonResponse rejectScoutRequest(@PathParam("scoutid") String scoutId) {
		LOGGER.info("execute rejectScoutRequest for currentUser+ " + scoutId);
		// not important for prototype
		return null;
	}
}
