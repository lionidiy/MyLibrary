function layerService() { }

layerService.prototype.getLayertile = function (params) {
    tmpLeft = params.left;
    tmpRight = params.right;
    tmpTop = params.top;
    tmpBottom = params.bottom;
    var pixelMeter = 40075016.69 / 255;
    var Extent = ol.proj.transformExtent([tmpLeft, tmpBottom, tmpRight, tmpTop], 'EPSG:4326', 'EPSG:3857');

    var xLen = (Extent[2] - Extent[0]) / 255;
    var yLen = (Extent[3] - Extent[1]) / 255;
    var layerLevel = 0
    var xlayerLevel = 0;
    while (true) {
        xlayerLevel++;
        if (xLen < pixelMeter && xLen > pixelMeter / 2) {
            break;
        }
        pixelMeter /= 2;
        
    }
    
    var ylayerLevel = 0;
    pixelMeter = 40075016.69 / 255;
    while (true) {
        ylayerLevel++;
        if (yLen < pixelMeter && yLen > pixelMeter / 2) {
            break;
        }
        pixelMeter /= 2;
    }

    if (xlayerLevel> ylayerLevel){
        layerLevel = ylayerLevel;
    }else{
        layerLevel = xlayerLevel;
    }
    alert(layerLevel);
};
var params = { left: 102.54, right: 104.53, top: 31.26, bottom: 30.05 };
var layerObj = new layerService();
layerObj.getLayertile(params);
