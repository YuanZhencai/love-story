package vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2015/6/6.
 */
public class AddressDetail {
//                city: "北京市",        #城市
//                city_code: 131,       #百度城市代码
//                district: "",           #区县
//                province: "北京市",   #省份
//                street: "",            #街道
//                street_number: ""    #门址

    private String city;
    @JsonProperty("city_code")
    private String cityCode;
    private String district;
    private String province;
    private String street;
    @JsonProperty("street_number")
    private String streetNumber;

    public String getCity() {
        return city == null ? "" : city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province == null ? "" : province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
