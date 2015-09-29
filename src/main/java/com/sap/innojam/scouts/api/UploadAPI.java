package com.sap.innojam.scouts.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import com.sap.innojam.scouts.entity.FilterData;
import com.sap.innojam.scouts.entity.Like;
import com.sap.innojam.scouts.entity.Talent;
import com.sap.innojam.scouts.entity.TalentCategory;
import com.sap.innojam.scouts.entity.Upload;
import com.sap.security.um.user.PersistenceException;
import com.sap.security.um.user.UnsupportedUserAttributeException;
import com.sap.security.um.user.User;
import com.sap.security.um.user.UserProvider;

@Path("/upload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UploadAPI {

	@Inject
	SensorDAO dao;

	@Context
	SecurityContext request;

	@Inject
	UserProvider userProvider;
	
	@GET
	@Path("/{uid}")
	public Upload getUpload(@PathParam("uid") String uploadId) {
		// TODO: add stub Upload. Media transport, not JSON!
		// return dao.findAllByOwnerAndDevice(request.getUserPrincipal().getName(), device);

		// parse uploadId
		long uid = -1;
		try {
			uid = Long.parseLong(uploadId);
		} catch (NumberFormatException e) {
			return null;
		}

		// get dummy upload
		for (Upload u : DummyData.dummyData) {
			if (uid == u.getId())
				return u;
		}
		return null;
	}

	@GET
	@Path("/random")
	public Upload getRandom() {
		List<Long> history = DummyData.scott.getHistory();
		
		Random random = new Random();
		for(int i=0; i<1000; i++){
		
			int rnd = random.nextInt(DummyData.dummyData.size());
			Upload u = DummyData.dummyData.get(rnd);
			if(!history.contains(u.getId())){
				history.add(u.getId());
				return u;
			}
		}
		
		history.clear();
		int rnd = random.nextInt(DummyData.dummyData.size());
		Upload u = DummyData.dummyData.get(rnd);
		return u;
	}

	@GET
	@Path("")
	public List<Upload> getAll() {
		return DummyData.dummyData;
	}

	@POST
	@Path("/create")
	public void create(Upload uploadParam) {
		// SensorData newSensor = new SensorData(request.getUserPrincipal().getName(), device, new Date(),
		// sensorParam.getType(),
		// sensorParam.getValue());
		// return dao.insert(newSensor);
		// TODO: create an upload
	}

	@POST
	@Path("/dislike/{upid}")
	public Upload getRandomNext(FilterData filterData) {
		// TODO: get the next random upload. Use scoutId for history tracking and filterData to get only filtered
		// uploads.
		return null;
	}

	@GET
	@Path("/like/{upid}")
	public List<Like> like(@PathParam("upid") String upId) {
		List<Like> likes = new ArrayList<Like>();
		likes.add(DummyData.dummyLike1);
		likes.add(DummyData.dummyLike2);
		likes.add(DummyData.dummyLike3);
		return likes;
	}
	
	private void likeOrDislike(boolean dislike){
		User currentUser;
		try {
			currentUser = userProvider.getCurrentUser();
			String userId = currentUser.getAttribute("userid");
			
			//todo...
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedUserAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
