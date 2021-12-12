require([
    'esri/Map',
    'esri/views/SceneView',
    'esri/layers/SceneLayer',
    'esri/layers/GraphicsLayer',
    'esri/Graphic',
    'esri/request',
], function (
    Map,
    SceneView,
    SceneLayer,
    GraphicsLayer,
    Graphic,
    esriRequest
) {
    const host = 'http://localhost:8080'
    const createGraphicPolygon = (data,{ size, colorMaterial, haveOutline = true, haveEdges = false }) => {
        return new Graphic({
            geometry: data,
            type: 'simple',
            symbol: {
            type: 'polygon-3d',
            symbolLayers: [{
                type: 'extrude',
                size: size,
                material: {
                    color: colorMaterial,
                    outline: {
                        color: haveOutline ? [255, 255, 255] : [255, 255, 255, 0],
                        width: 10,
                    },
                },
                edges: {
                    type: 'solid',
                    color: haveEdges ? [50, 50, 50, 0.5] : [50, 50, 50, 0],
                },
                },],
            },
        });
    };

    const createGraphicLine = (data, { width }) => {
        return new Graphic({
            geometry: data,
            type: 'simple',
            symbol: {
                type: 'line-3d',
                symbolLayers: [{
                    type: 'path',
                    profile: 'circle',
                    width: width,
                    material: {
                        color: [248, 248, 255]
                    },
                },],
            },
        });
    };

    var createGraphicFloor5_34_Glass = function (data, option = {}) {
        return new Graphic({
            geometry: data,
            symbol: data.symbol,
            attributes: data,
            popupTemplate: data.popupTemplate,
            size: 20,
        });
    };

    const json_options = {
        query: {
            f: 'json',
        },
        responseType: 'json',
    };
// File link = Request path
    const polygonFileList = [
        {
            fileLink: '/entrance',
            option: {
              size: 14,
              colorMaterial: [177, 176, 199, 1],
            },
        },
        {
            fileLink: '/entrance_top',
                option: {
                    size: 4.5,
                    colorMaterial: [205, 133, 63, 1],
                },
        },
        {
            fileLink: '/entrance_columns',
            option: {
                size: 9,
                colorMaterial: [207, 207, 207, 1],
            },
        },
        {
            fileLink: '/eaves',
            option: {
                size: 0.5,
                colorMaterial: [181, 181, 181, 1],
            },
        },
        {
            fileLink: '/floor_1_3_right',
            option: {
                size: 13.5,
                colorMaterial: [7, 58, 148, 0.8],
            },
        },
        {
            fileLink: '/floor_1_3_left',
            option: {
                size: 13.5,
                colorMaterial: [248, 248, 255, 1],
                haveOutline: false,
            },
        },
        {
            fileLink: '/floor_1_3_columns',
            option: {
                size: 14,
                colorMaterial: [241, 241, 249, 1],
                haveEdges: true,
            },
        },
        {
            fileLink: '/floor_2_3',
            option: {
                size: 9.5,
                colorMaterial: [205, 133, 63, 1],
            },
        },
        {
            fileLink: '/floor_2',
            option: {
                size: 5,
                colorMaterial: [248, 248, 255, 1],
            },
        },
        {
            fileLink: '/floor_1_3_roof',
            option: {
                size: 0.5,
                colorMaterial: [192, 192, 192],
            },
        },
        {
            fileLink: '/floor_roof_c',
            option: {
                size: 1,
                colorMaterial: [248, 248, 255],
                haveOutline: false,
            },
        },
        {
            fileLink: '/floor_4',
            option: {
                size: 1,
                colorMaterial: [248, 248, 255, 1],
            },
        },
        {
            fileLink: '/floor_4_columns',
            option: {
                size: 19.5,
                colorMaterial: [248, 248, 255, 1],
            },
        },
        {
            fileLink: '/floor_5_34',
            option: {
                size: 0.5,
                colorMaterial: [192, 192, 192, 1],
            },
        },
    ];

    const lineFileList = [
        {
            fileLink: '/line_columns',
            option: { width: 0.4 },
        },
        {
            fileLink: '/line',
            option: { width: 0.3 },
        },
    ];
// Vẽ nền
    polygonFileList.forEach((polygon) => {
        esriRequest(host + "/api/body/" + polygon.fileLink, json_options).then(function (response) {
            var graphicsLayer = new GraphicsLayer();
            console.log(response);
            response.data.forEach(function (data) {
              graphicsLayer.add(createGraphicPolygon(data, polygon.option));
            });
            map.add(graphicsLayer);
        });
    });

// Vẽ line
    lineFileList.forEach((line) => {
        esriRequest(host + "/api/body/" + line.fileLink, json_options).then(function (response) {
            var graphicsLayer = new GraphicsLayer();
            console.log(response);
            response.data.forEach(function (data) {
              graphicsLayer.add(createGraphicLine(data, line.option));
            });
            map.add(graphicsLayer);
        });
    });

// Vẽ kính
    esriRequest(host + '/api/body/floor_5_34_glass', json_options).then(
        function (response) {
            var graphicsLayer = new GraphicsLayer();
            console.log(response);
            response.data.forEach(function (data) {
              graphicsLayer.add(createGraphicFloor5_34_Glass(data));
            });
            map.add(graphicsLayer);
        }
    );

    const map = new Map({
        basemap: 'topo-vector',
        // ground: 'world-elevation',
        layers: [], //end layers geojsonLayer
    });

    const view = new SceneView({
        container: 'viewDiv',
        map: map,
        camera: {
            position: [108.22288513183594, 16.071764175013556, 200],
            heading: 0,
            tilt: 80,
        },
    });

    view.popup.defaultPopupTemplateEnabled = true;
});
