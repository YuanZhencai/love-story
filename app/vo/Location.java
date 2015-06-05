package vo;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import java.util.Date;

/**
 * Created by Yuan on 2015/6/6.
 */
public class Location {

    private static final String URL_IP_LOCATION = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";

    private String ip;
    private String province;
    private String city;
    private String country;
    private Date date = new Date();


    public Location(String ip) {
        this.ip = ip;
        findLocationByIp(ip);
    }

    private void findLocationByIp(String ip) {
        F.Promise<WSResponse> promise = WS.url(URL_IP_LOCATION).setTimeout(1000).setQueryParameter("ip", ip).get();

        F.Promise<JsonNode> jsonPromise = promise.map(
                new F.Function<WSResponse, JsonNode>() {
                    public JsonNode apply(WSResponse response) {
                        JsonNode json = response.asJson();
                        setCity(json.path("city").asText());
                        setProvince(json.path("province").asText());
                        setCountry(json.path("country").asText());
                        return json;
                    }
                }
        );

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProvince() {
        return province == null ? "" : province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city == null ? "" : city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country == null ? "" : country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
