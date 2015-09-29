package com.sap.innojam.scouts.api;

import java.util.ArrayList;
import java.util.List;

import com.sap.innojam.scouts.entity.Like;
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
	public static Upload dummyUpload18 = new Upload(18, dummyTalent, catSinging, Upload.Type.Audio, "mp3");
	public static Upload dummyUploadVideo = new Upload(3, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Upload dummyUpload1 = new Upload(11, dummyTalent, catDancing, Upload.Type.Image, "jpg");
	public static Upload dummyUpload14 = new Upload(14, dummyTalent, catDancing, Upload.Type.Image, "jpg");
	public static Upload dummyUpload19 = new Upload(19, dummyTalent, catDancing, Upload.Type.Image, "jpg");
	public static Upload dummyUpload2 = new Upload(12, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Upload dummyUpload13 = new Upload(13, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Upload dummyUpload15 = new Upload(15, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Upload dummyUpload16 = new Upload(16, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Upload dummyUpload17 = new Upload(17, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Upload dummyUpload20 = new Upload(20, dummyTalent, catDancing, Upload.Type.Video, "mp4");
	public static Like dummyLike1 = new Like(dummyTalent, dummyUploadAudio, false);
	public static Like dummyLike2 = new Like(dummyTalent, dummyUploadImg, false);
	public static Like dummyLike3 = new Like(dummyTalent, dummyUploadVideo, false);
	static {
		dummyTalent.getUploads().add(dummyUploadImg);
		dummyTalent.getUploads().add(dummyUploadAudio);
		dummyTalent.getUploads().add(dummyUploadVideo);
		dummyTalent.getUploads().add(dummyUpload1);
		dummyTalent.getUploads().add(dummyUpload14);
		dummyTalent.getUploads().add(dummyUpload19);
		dummyTalent.getUploads().add(dummyUpload2);
		dummyTalent.getUploads().add(dummyUpload13);
		dummyTalent.getUploads().add(dummyUpload15);
		dummyTalent.getUploads().add(dummyUpload16);
		dummyTalent.getUploads().add(dummyUpload17);
		dummyTalent.getUploads().add(dummyUpload20);

		dummyData = dummyTalent.getUploads();
	}

}
