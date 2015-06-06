package services;

import vo.Location;

/**
 * Created by Yuan on 2015/6/6.
 */
public class LocationService {

    public Location findLocationByIp(String ip)  {
        try {
            return new BaiduMapService().findLocationByIp(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Location();
    }

}
