sap.ui.define([ 'jquery.sap.global', 'sap/ui/model/json/JSONModel',
		'sap/ui/core/mvc/Controller' ],
		function(jQuery, JSONModel, Controller) {
			"use strict";

			var CController = Controller.extend("friststep.view.Requests", {

				onInit : function() {
					var that = this;

					jQuery.getJSON("./api/upload/like/5", function(data) {
						var oModel = new JSONModel({
							RequestCollection : data
						});
						that.getView().setModel(oModel);
					});

				},
				onHandleBtn : function(oEvent) {
					this.getRouter().myNavToWithoutHash({
						currentView : this.getView(),
						targetViewName : "friststep.view.ScottProfile",
						targetViewType : "XML"
					});
				}
			});

			return CController;

		});