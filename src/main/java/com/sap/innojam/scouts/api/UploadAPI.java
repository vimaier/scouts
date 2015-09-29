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

@Path("/upload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UploadAPI {

	private static List<Upload> dummyData = new ArrayList<Upload>();
	static {
		TalentCategory catPainting = new TalentCategory("Painting");
		TalentCategory catSinging = new TalentCategory("Singing");
		TalentCategory catDancing = new TalentCategory("Dancing");
		Talent dummyTalent = new Talent("ted@talent.com");
		Upload dummyUploadImg = new Upload(1, dummyTalent, catPainting, Upload.Type.Image, "jpg");
		Upload dummyUploadAudio = new Upload(2, dummyTalent, catSinging, Upload.Type.Audio, "mp3");
		Upload dummyUploadVideo = new Upload(3, dummyTalent, catDancing, Upload.Type.Video, "mp4");
		dummyTalent.getUploads().add(dummyUploadImg);
		dummyTalent.getUploads().add(dummyUploadAudio);
		dummyTalent.getUploads().add(dummyUploadVideo);
		dummyData = dummyTalent.getUploads();
	}

	@Inject
	SensorDAO dao;

	@Context
	SecurityContext request;

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
		for (Upload u : dummyData) {
			if (uid == u.getId())
				return u;
		}
		return null;
	}

	@GET
	@Path("/random")
	public Upload getRandom() {
		int rnd = (new Random()).nextInt(dummyData.size());
		return dummyData.get(rnd);
	}

	@GET
	@Path("")
	public List<Upload> getAll() {
		return dummyData;
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
	@Path("/next")
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

}
