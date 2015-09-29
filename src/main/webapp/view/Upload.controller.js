sap.ui.core.mvc.Controller.extend("friststep.view.Upload", {

	onInit: function() {
		this.oInitialLoadFinishedDeferred = jQuery.Deferred();
		console.log("Hello Upload");
		
		// Following code is for real implementation of file upload.
		// Currently we are using mocks (vimaier)
//		var layout = new sap.ui.commons.layout.MatrixLayout();
//		layout.setLayoutFixed(false);
//
//		// create the uploader and disable the automatic upload
//		var oFileUploader2 = new sap.ui.unified.FileUploader({
//			name: "upload2",
//			multiple: true,
//			maximumFileSize: 0.5,
//			mimeType: "image,text",
//			fileType: "jpg,png,txt",
//			uploadOnChange: false,
//			uploadUrl: "../../../../../upload",
//			fileSizeExceed: function (oEvent) {
//				var sName = oEvent.getParameter("fileName");
//				var fSize = oEvent.getParameter("fileSize");
//				var fLimit = oFileUploader2.getMaximumFileSize();
//				sap.ui.commons.MessageBox.show("File: " + sName + " is of size " + fSize + " MB which exceeds the file size limit of " + fLimit + " MB.", "ERROR", "File size exceeded");
//			},
//			typeMissmatch: function (oEvent) {
//				var sName = oEvent.getParameter("fileName");
//				var sType = oEvent.getParameter("fileType");
//				var sMimeType = oFileUploader2.getMimeType();
//				if (!sMimeType) {
//					sMimeType = oFileUploader2.getFileType();
//				}
//				sap.ui.commons.MessageBox.show("File: " + sName + " is of type " + sType + " .Allowed types are: "  + sMimeType + ".", "ERROR", "Wrong File type");
//			},
//			uploadComplete: function (oEvent) {
//				var sResponse = oEvent.getParameter("response");
//				if (sResponse) {
//					var m = /^\[(\d\d\d)\]:(.*)$/.exec(sResponse);
//					if (m[1] == "200") {
//						sap.ui.commons.MessageBox.show("Return Code: " + m[1] + "\n" + m[2], "SUCCESS", "Upload Success");
//					} else {
//						sap.ui.commons.MessageBox.show("Return Code: " + m[1] + "\n" + m[2], "ERROR", "Upload Error");
//					}
//				}
//			}
//		});
//		layout.createRow(oFileUploader2);
//
//		// create a second button to trigger the upload
//		var oTriggerButton = new sap.ui.commons.Button({
//			text:'Trigger Upload',
//			press:function() {
//				// call the upload method
//				oFileUploader2.upload();
//			}
//		});
//		layout.createRow(oTriggerButton);
//		layout.placeAt("uploadcontent");

	},

	
});
