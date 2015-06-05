package services;

import vo.Location;

/**
 * Created by Yuan on 2015/6/6.
 */
public class LocationService {

    public Location findLocationByIp(String ip)  {
        Location location = new Location(ip);
        return location;
    }

}
