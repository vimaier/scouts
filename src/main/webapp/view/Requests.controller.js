sap.ui.define([ 'jquery.sap.global', 'sap/ui/model/json/JSONModel',
		'sap/ui/core/mvc/Controller' ],
		function(jQuery, JSONModel, Controller) {
			"use strict";

			var CController = Controller.extend("friststep.view.Requests", {

				onInit : function() {
					var that = this;
					console.log("qweqewqe");
					jQuery.getJSON("./api/upload/like/5", function(data) {
						var oModel = new JSONModel({
							RequestCollection : data
						});
						that.getOwnerComponent().getRouter().attachRoutePatternMatched(this.onRouteMatched, this);
						that.getView().setModel(oModel);
					});

				},
				onHandleReqBtn : function(oEvent) {
					console.log("sdfdsf");
					this.getOwnerComponent().getRouter().myNavToWithoutHash({
						currentView : this.getView(),
						targetViewName : "friststep.view.ScottProfile",
						targetViewType : "XML"
					});
				}
			});

			return CController;

		});