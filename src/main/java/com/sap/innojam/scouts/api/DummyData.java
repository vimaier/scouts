package com.sap.innojam.scouts.api;

import java.util.ArrayList;
import java.util.List;

import com.sap.innojam.scouts.entity.Scout;
import com.sap.innojam.scouts.entity.Talent;
import com.sap.innojam.scouts.entity.TalentCategory;
import com.sap.innojam.scouts.entity.Upload;

public class DummyData {

	public static Scout scott = new Scout("uid", "artistName", "Scott", "Scoutsen", 35, "m", "scott@scoutsen.com",
			null, null);
	public static List<Upload> dummyData = new ArrayList<Upload>();
	public static TalentCategory catPainting = new TalentCategory("Painting");
	public static TalentCategory catSinging = new TalentCategory("Singing");
	public static TalentCategory catDancing = new TalentCategory("Dancing");
	public static Talent dummyTalent = new Talent("ted@talent.com", "The Queen of England", "Elizabeth", "Alexandra Mary", 130,
			"female", "queen@buckingham.uk", null, null);
	public static Upload dummyUploadImg = new Upload(1, dummyTalent, catPainting, Upload.Type.Image, "jpg");
	public static Upload dummyUploadAudio = new Upload(2, dummyTalent, catSinging, Upload.Type.Audio, "mp3");
	public static Upload dummyUploadVideo = new Upload(3, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	static {
		dummyTalent.getUploads().add(dummyUploadImg);
		dummyTalent.getUploads().add(dummyUploadAudio);
		dummyTalent.getUploads().add(dummyUploadVideo);
		dummyData = dummyTalent.getUploads();
	}

}
