package services;

import vo.Location;

/**
 * Created by Yuan on 2015/6/6.
 */
public class BaiduMapService {

    public Location findLocationByIp(String ip) throws Exception {
        BaiduIpLocationService baiduIpLocationService = new BaiduIpLocationService(ip);
        return baiduIpLocationService.findLocation();
    }

}
