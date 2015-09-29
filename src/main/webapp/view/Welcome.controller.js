sap.ui.define(['jquery.sap.global',
		'sap/ui/model/json/JSONModel',
		'sap/ui/core/mvc/Controller',
		'sap/ui/core/HTML'
		],
	function(jQuery, JSONModel, Controller, HTML) {
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
				oModel.path = "/backend/" + oModel.path;
				that.getView().setModel(oModel);
				
				
				var html1 = new HTML("html1", {
                content:
                        "<video width='50%' height='50%' autoplay>" +
                        "<source src='/backend/" + oModel.path + "' type='video/mp4'>" +
                        "Your browser does not support the video tag." +
                        "</video>"
    			});
    			
    			that.getView().getContent().append(html1);
    			
			});
			
        
		}
	});


	return CController;

});