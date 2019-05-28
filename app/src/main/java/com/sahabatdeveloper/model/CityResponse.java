package com.sahabatdeveloper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityResponse {
    @Expose
    @SerializedName("rajaongkir")
    private Rajaongkir rajaongkir;

    public Rajaongkir getRajaongkir() {
        return rajaongkir;
    }

    public class Rajaongkir {
        @Expose
        @SerializedName("results")
        private List<Results> results;
        @Expose
        @SerializedName("status")
        private Status status;
        @Expose
        @SerializedName("query")
        private List<String> query;

        public List<Results> getResults() {
            return results;
        }

        public Status getStatus() {
            return status;
        }

        public List<String> getQuery() {
            return query;
        }
    }

    public class Results {
        @Expose
        @SerializedName("postal_code")
        private String postal_code;
        @Expose
        @SerializedName("city_name")
        private String city_name;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("province")
        private String province;
        @Expose
        @SerializedName("province_id")
        private String province_id;
        @Expose
        @SerializedName("city_id")
        private String city_id;

        public String getPostal_code() {
            return postal_code;
        }

        public String getCity_name() {
            return city_name;
        }

        public String getType() {
            return type;
        }

        public String getProvince() {
            return province;
        }

        public String getProvince_id() {
            return province_id;
        }

        public String getCity_id() {
            return city_id;
        }
    }

    public class Status {
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("code")
        private int code;

        public String getDescription() {
            return description;
        }

        public int getCode() {
            return code;
        }
    }
}
