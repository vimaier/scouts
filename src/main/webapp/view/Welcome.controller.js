sap.ui.define(['jquery.sap.global',
		'sap/ui/model/json/JSONModel',
		'sap/ui/core/mvc/Controller'
		],
	function(jQuery, JSONModel, Controller) {
	"use strict";

	var CController = Controller.extend("friststep.view.Welcome", {
		
		
		
		onInit: function() {
			this.loadData('yourasset');
			this.loadData('communityasset');
		},
		
		handleMyAssetNav: function(evt) {
			// set explored app's demo model on this sample
			this.loadData('yourasset');
		},
		
		handleMyCommunityNav: function(evt) {
			// set explored app's demo model on this sample
			this.loadData('communityasset');
		},
		like: function() {
			this.assess('like');
		},
		dislike: function() {
			this.assess('dislike');
		},
		assess: function(type) {
			jQuery.ajax("./api/upload/" + type + "/" + this.getView().getModel('communityasset').id);
			this.handleMyCommunityNav();
		},
		
		loadData: function(id) {
			var that = this;
			jQuery.getJSON("./api/upload/random", function(data) {
				var oModel = new JSONModel(data);
				that.getView().setModel(oModel, id)
				//that.getView().setModel(oModel);
				that.setMediaElement(that, id, data);
			});
		},
		setMediaElement: function(that, id, data) {
			var element = that.getView().byId(id);
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
		
		}
	});


	return CController;

});