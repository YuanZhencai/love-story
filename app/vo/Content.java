package vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuan on 2015/6/6.
 */
public class Content {
    //    address: "北京市",   #简要地址
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

    private String address;
    // x , y
    private Map<String,String> point = new HashMap<>();

    @JsonProperty("address_detail")
    private AddressDetail  addressDetail = new AddressDetail();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, String> getPoint() {
        return point;
    }

    public void setPoint(Map<String, String> point) {
        this.point = point;
    }

    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
    }
}
