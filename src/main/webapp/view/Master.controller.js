sap.ui.define(['jquery.sap.global',
		'sap/ui/model/json/JSONModel',
		'sap/ui/core/mvc/Controller'
		],
	function(jQuery, JSONModel, Controller) {
	"use strict";

	var CController = Controller.extend("friststep.view.Master", {
	
	onInit: function() {
		//nicht schoen
		window.user = {
				name: 'Ted',
				type: 'talent'
		};
		
		this.oInitialLoadFinishedDeferred = jQuery.Deferred();

		var oEventBus = this.getEventBus();

		//On phone devices, there is nothing to select from the list. There is no need to attach events.
		if (sap.ui.Device.system.phone) {
			return;
		}
		this.getRouter().attachRoutePatternMatched(this.onRouteMatched, this);
		oEventBus.subscribe("Master2", "NotFound", this.onNotFound, this);
		
	},
	handleHomeBtn: function(oEvent) {
		var el = oEvent.getSource();
		this.changeUser();
	},
	changeUser: function() {
		var typeOfDisplay = "none";
		var requestTitle = "My Invitation";
		if (typeof window.user != "undefined" && window.user.type == "talent") {
			window.user = {
					name: 'Scott',
					type: 'scout'
			};
		} else {
			window.user = {
					name: 'Ted',
					type: 'talent'
			};
			requestTitle = "My Request";
			typeOfDisplay = "block"
		}
		//this.getView().setModel(new JSONModel(window.user), "myuser");
		document.getElementById("__xmlview1--lblName").innerHTML = window.user.name;
		document.getElementById("__xmlview1--mediaBtn").style.display = typeOfDisplay;
		document.getElementById("__xmlview1--myMedia").style.display = typeOfDisplay;
		document.getElementById("__xmlview1--Requests-content").innerHTML = requestTitle;
		
	},
	onHandleBtn: function(oEvent) {
		var el = oEvent.getSource();
		switch(el.getId()){
			case "__xmlview1--homeBtn":
				this.getRouter().myNavToWithoutHash({
					currentView: this.getView(),
					targetViewName: "friststep.view.Welcome",
					targetViewType: "XML"
				});
				break;
			case "__xmlview1--mediaBtn":
				this.getRouter().myNavToWithoutHash({
					currentView: this.getView(),
					targetViewName: "friststep.view.Upload",
					targetViewType: "XML"
				});
				break;
			case "__xmlview1--myMedia":
				this.getRouter().myNavToWithoutHash({
					currentView: this.getView(),
					targetViewName: "friststep.view.MyMedia",
					targetViewType: "XML"
				});
				break;
			case "__xmlview1--Requests":
				this.getRouter().myNavToWithoutHash({
					currentView: this.getView(),
					targetViewName: "friststep.view.Requests",
					targetViewType: "XML"
				});
				break;
			case "__xmlview1--profileBtn":
				this.getRouter().myNavToWithoutHash({
					currentView: this.getView(),
					targetViewName: "friststep.view.Detail",
					targetViewType: "XML"
				});
				break;		
		}
	},

	onRouteMatched: function(oEvent) {
		var sName = oEvent.getParameter("name");

		if (sName !== "main") {
			return;
		}

		//Load the master2 view in desktop
		this.getRouter().myNavToWithoutHash({
			currentView: this.getView(),
			targetViewName: "friststep.view.Master2",
			targetViewType: "XML"
		});

		//Load the welcome view in desktop
		this.getRouter().myNavToWithoutHash({
			currentView: this.getView(),
			targetViewName: "friststep.view.Welcome",
			targetViewType: "XML"
		});
	},

	waitForInitialListLoading: function(fnToExecute) {
		jQuery.when(this.oInitialLoadFinishedDeferred).then(jQuery.proxy(fnToExecute, this));
	},

	onNotFound: function() {
		this.getView().byId("master1List").removeSelections();
	},

	onSearch: function() {
		// Add search filter
		var filters = [];
		var searchString = this.getView().byId("master1SearchField").getValue();
		if (searchString && searchString.length > 0) {
			filters = [new sap.ui.model.Filter("", sap.ui.model.FilterOperator.Contains, searchString)];
		}

		// Update list binding
		this.getView().byId("master1List").getBinding("items").filter(filters);
	},

	onSelect: function(oEvent) {
		// Get the list item either from the listItem parameter or from the event's
		// source itself (will depend on the device-dependent mode)
		var oList = this.getView().byId("master1List");
		this.showDetail(oEvent.getParameter("listItem") || oEvent.getSource());
		oList.removeSelections();
	},

	showDetail: function(oItem) {
		// If we're on a phone device, include nav in history
		var bReplace = jQuery.device.is.phone ? false : true;
		this.getRouter().navTo("master2", {
			from: "main",
			entity: oItem.getBindingContext().getPath().substr(1)
		}, bReplace);
	},

	getEventBus: function() {
		return sap.ui.getCore().getEventBus();
	},

	getRouter: function() {
		return sap.ui.core.UIComponent.getRouterFor(this);
	},

	onExit: function(oEvent) {
		this.getEventBus().unsubscribe("Master2", "NotFound", this.onNotFound, this);
	}
});
	return CController;

	});