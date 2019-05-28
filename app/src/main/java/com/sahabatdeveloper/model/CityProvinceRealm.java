package com.sahabatdeveloper.model;

import io.realm.RealmObject;

public class CityProvinceRealm extends RealmObject {
    public String province;
    public String city;
    public String cityId;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
