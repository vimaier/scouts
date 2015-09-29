sap.ui.define(['jquery.sap.global',
		'sap/ui/model/json/JSONModel',
		'sap/ui/core/mvc/Controller'
		],
	function(jQuery, JSONModel, Controller) {
	"use strict";

	var CController = Controller.extend("friststep.view.Welcome", {
		
		
		
		onInit: function() {
			this.slide = 0;
			this.maxSlide = 4;
			this.loadData();
		},
		
		handleNav: function(evt) {
			// set explored app's demo model on this sample
			this.loadData();
		},
		
		loadData: function() {
			var that = this;
			jQuery.getJSON("./api/upload/random", function(data) {
				var oModel = new JSONModel(data);
				oModel.path = oModel.path;
				that.getView().setModel(oModel);
				var element = that.getView().byId("videoPlayer");
				if (data.type === "Video") {  
					element.setContent("<video width='50%' height='50%' autoplay controls src='" + data.path + "'>" +
	                        "Your browser does not support the video tag." +
	                        "</video>");
				} else if (data.type === "Audio") {
					element.setContent("<audio width='50%' height='50%' autoplay controls src='" + data.path + "'>" +
	                        "Your browser does not support the video tag." +
	                        "</audio>");
				} else if (data.type === "Image") {
					element.setContent("<img width='50%' height='50%' src='" + data.path + "'/>");
				}
    			
			});
			
        
		}
	});


	return CController;

});