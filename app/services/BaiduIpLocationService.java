package services;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import play.Logger;
import play.libs.Json;
import vo.Location;

import java.io.IOException;
import java.net.URI;
import java.text.MessageFormat;

/**
 * Created by Yuan on 2015/6/6.
 */
public class BaiduIpLocationService {
    //http://developer.baidu.com/map/index.php?title=webapi/ip-api
    //http://api.map.baidu.com/location/ip?ak=9ggtsGtDC9PD4zAhsQpUVxB4&ip=202.198.16.3&coor=bd09ll

    // 用户密钥
    private static final String ak = "9ggtsGtDC9PD4zAhsQpUVxB4";
    // 输出的坐标格式
    // 可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
    private static final String coor = "bd09ll";

    // 服务地址
    private static final String WEB_SERVICE_URL = "http://api.map.baidu.com/location/ip?ak={0}&ip={1}&coor={2}";

    private String ip;

    public BaiduIpLocationService(String ip) {
        this.ip = ip;
    }

    public Location findLocation() throws Exception {
        Logger.info("[ip]" + ip);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(MessageFormat.format(WEB_SERVICE_URL, ak, ip, coor));

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
            response.setHeader("Content-Type", "application/json");
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JsonNode parse = Json.parse(result);
                return Json.fromJson(parse, Location.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new Exception("can not know the ip location");
    }


}
