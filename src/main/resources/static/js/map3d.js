require([
	"esri/Map",
	"esri/views/SceneView",
	"esri/layers/GeoJSONLayer",
	"esri/layers/SceneLayer",
	"esri/layers/GraphicsLayer",
	"esri/Graphic",
	"esri/request",
	"esri/widgets/Slice",
    "esri/widgets/Slice/SlicePlane",
    "esri/widgets/LayerList",
    "esri/core/Collection"
], function (
	Map,
	SceneView,
	GeoJSONLayer,
	SceneLayer,
	GraphicsLayer,
	Graphic,
	esriRequest,
	Slice,
	SlicePlane,
	LayerList,
	Collection
) {
	var createGraphic = function (data) {
		return new Graphic({
			geometry: data,
			type: "simple",
			symbol: {
				type: "polygon-3d",
				symbolLayers: [
					{
						type: "extrude",
						size: 0.5,
						material: {
							color: [192, 192, 192, 1],
							outline: {
								color: [255, 255, 255],
								width: 10,
							},
						},
					},
				],
			},
		});
	};

	var createGraphicPillar = function (data) {
		return new Graphic({
			geometry: data,
			type: "simple",
			symbol: {
				type: "polygon-3d",
				symbolLayers: [
					{
						type: "extrude",
						size: 4.5,
						material: {
							color: [248, 248, 255, 1],
							outline: {
								color: [255, 255, 255],
								width: 10,
							},
						},
					},
				],
			},
		});
	};

	var createGraphicRoom = function (data) {
		return new Graphic({
			geometry: data,
			type: "simple",
			symbol: {
				type: "polygon-3d",
				symbolLayers: [
					{
						type: "extrude",
						size: 5,
						material: {
							color: [248, 248, 255, 1],
							outline: {
								color: [255, 255, 255],
								width: 10,
							},
						},
					},
				],
			},
		});
	};

	var createGraphicGlass = function (data) {
		return new Graphic({
			geometry: data,
			symbol: data.symbol,
			attributes: data,
			popupTemplate: data.popupTemplate,
			size: 20,
		});
	};

	var createGraphicSole = function (data) {
		return new Graphic({
			geometry: data,
			type: "simple",
			symbol: {
				type: "polygon-3d",
				symbolLayers: [
					{
						type: "extrude",
						size: 12.5,
						material: {
							color: [248, 248, 255, 1],
							outline: {
								color: [255, 255, 255],
								width: 10,
							},
						},
					},
				],
			},
		});
	};

	const json_options = {
		query: {
			f: "json",
		},
		responseType: "json",
	};
	// Vẽ nền
	esriRequest("data.json", json_options).then(function (response) {
		var graphicsLayer = new GraphicsLayer();
		console.log(response);
		response.data.forEach(function (data) {
			graphicsLayer.add(createGraphic(data));
		});
		map.add(graphicsLayer);
	});

	//Vẽ cột
//	esriRequest("data.pillar.json", json_options).then(function (response) {
//		var graphicsLayer = new GraphicsLayer();
//		console.log(response);
//		response.data.forEach(function (data) {
//			graphicsLayer.add(createGraphicPillar(data));
//		});
//		map.add(graphicsLayer);
//	});

	//Vẽ phòng
//	esriRequest("data-room.json", json_options).then(function (response) {
//		var graphicsLayer = new GraphicsLayer();
//		console.log(response);
//		response.data.forEach(function (data) {
//			graphicsLayer.add(createGraphicRoom(data));
//		});
//		map.add(graphicsLayer);
//	});
//
//	esriRequest("data-sole.json", json_options).then(function (response) {
//		var graphicsLayer = new GraphicsLayer();
//		console.log(response);
//		response.data.forEach(function (data) {
//			graphicsLayer.add(createGraphicSole(data));
//		});
//		map.add(graphicsLayer);
//	});
	// Vẽ kính
	esriRequest("http://localhost:8080/api/faces", json_options).then(function (response) {
		var graphicsLayer = new GraphicsLayer();
		console.log(response);
		response.data.forEach(function (data) {
			graphicsLayer.add(createGraphicGlass(data));
		});
		map.add(graphicsLayer);
	});
	// geojson layer
	const geojsonLayer = new GeoJSONLayer({
		url: "data.geojson",
	});

	geojsonLayer.renderer = {
		type: "simple",
		symbol: {
			type: "polygon-3d",
			symbolLayers: [
				{
					type: "extrude",
					size: 100.0,
					material: {
						color: "#7eadf7",
					},
				},
			],
		},
	};
	const map = new Map({
		basemap: "topo-vector",
		// ground: 'world-elevation',
		layers: [], //end layers geojsonLayer
	});

	const view = new SceneView({
		container: "viewDiv",
		map: map,
		camera: {
			position: [108.22288513183594, 16.071764175013556, 200],
			heading: 0,
			tilt: 80,
		},
	});

	view.popup.defaultPopupTemplateEnabled = true;

	const slice = new Slice({
		view: view
	});

    view.ui.add(slice, {
        position: "top-right"
    });

	const excludedLayers = [];
	const sliceButton = document.getElementById("slice");
	const resetPlaneBtn = document.getElementById("reset-plane-btn");
	const clearPlaneBtn = document.getElementById("clear-plane-btn");
	const sliceOptions = document.getElementById("slice-option");
	const plane = new SlicePlane({
		position: {
			// position: [108.22288513183594, 16.071764175013556, 200],

			latitude: 16.071764175013556,
			longitude: 108.22288513183594,
			z: 417.75,
		},
		tilt: 32.62,
		width: 29,
		height: 29,
		heading: 0.46,
	});

	let sliceWidget = null;
	let doorsLayer = null;
	let sliceTiltEnabled = true;

	view.ui.add("menu", "top-right");

	resetPlaneBtn.addEventListener("click", () => {
		document.getElementById("tilt-enabled").checked = true;
		sliceTiltEnabled = true;
		sliceWidget.viewModel.tiltEnabled = sliceTiltEnabled;
		sliceWidget.viewModel.shape = plane;
	});

	clearPlaneBtn.addEventListener("click", () => {
		slice.clear();
	});

	document.getElementById("tilt-enabled").addEventListener("change", (event) => {
		sliceTiltEnabled = event.target.checked;
		sliceWidget.viewModel.tiltEnabled = sliceTiltEnabled;
	});

	document.getElementById("color").addEventListener("change", (event) => {
		if (event.target.checked) {
			// A renderer can be set on a BuildingComponentSublayer
			doorsLayer.renderer = {
				type: "simple", // autocasts as new UniqueValueRenderer()
				symbol: {
					type: "mesh-3d", // autocasts as new MeshSymbol3D()
					symbolLayers: [
						{
							type: "fill", // autocasts as new FillSymbol3DLayer()
							material: {
								color: "red",
							},
						},
					],
				},
			};
		} else {
			doorsLayer.renderer = null;
		}
	});

	// Add a layer list widget
	const layerList = new LayerList({
		view: view,
	});
});
