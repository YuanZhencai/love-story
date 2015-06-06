package vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by Yuan on 2015/6/6.
 */
public class Location {
//    {
//        address: "CN|北京|北京|None|CHINANET|1|None",   #地址
//        content:       #详细内容
//        {
//            address: "北京市",   #简要地址
//            address_detail:      #详细地址信息
//            {
//                city: "北京市",        #城市
//                city_code: 131,       #百度城市代码
//                district: "",           #区县
//                province: "北京市",   #省份
//                street: "",            #街道
//                street_number: ""    #门址
//            },
//            point:               #百度经纬度坐标值
//            {
//                x: "116.39564504",
//                        y: "39.92998578"
//            }
//        },
//        status: 0     #返回状态码
//    }

    private int status;
    private String address;
    private String message;
    private Content content = new Content();
    private String ip;
    @JsonIgnore
    private Date date = new Date();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
