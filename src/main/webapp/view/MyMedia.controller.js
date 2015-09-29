sap.ui.define([
		'jquery.sap.global',
		'sap/m/MessageToast',
		'sap/ui/core/mvc/Controller',
		'sap/ui/model/json/JSONModel'
	], function(jQuery, MessageToast, Controller, JSONModel) {
	"use strict";

	var ListController = Controller.extend("friststep.view.MyMedia", {

		onInit: function () {
			// set explored app's demo model on this sample
			this.loadData();
		},

		onListItemPress: function (evt) {
			MessageToast.show("Pressed : " + evt.getSource().getTitle());
		},
		
		loadData: function(id) {
			var that = this;
			jQuery.getJSON("./api/talent/uploads", function(data) {
				var oModel = new JSONModel(data);
				
				// Adapt the data for frontend
				for(var i=0; i < oModel.oData.length ;++i) {
					var elem = oModel.oData[i];
					elem.categoryname = elem.category.name;
					if (elem.likes)
						elem.numlikes = elem.likes.length;
					else
						elem.numlikes = 0;
				}
				
				oModel.oData = {"uploads": oModel.oData};
				console.log(oModel.oData);
				that.getView().setModel(oModel);
			});
		}
	});


	return ListController;

});