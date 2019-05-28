package com.sahabatdeveloper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CostResponse {
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
        @SerializedName("destination_details")
        private Destination_details destination_details;
        @Expose
        @SerializedName("origin_details")
        private Origin_details origin_details;
        @Expose
        @SerializedName("status")
        private Status status;
        @Expose
        @SerializedName("query")
        private Query query;

        public List<Results> getResults() {
            return results;
        }

        public Destination_details getDestination_details() {
            return destination_details;
        }

        public Origin_details getOrigin_details() {
            return origin_details;
        }

        public Status getStatus() {
            return status;
        }

        public Query getQuery() {
            return query;
        }
    }

    public class Results {
        @Expose
        @SerializedName("costs")
        private List<Costs> costs;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("code")
        private String code;

        public List<Costs> getCosts() {
            return costs;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }
    }

    public static class Costs {
        @Expose
        @SerializedName("cost")
        private List<Cost> cost;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("service")
        private String service;

        public List<Cost> getCost() {
            return cost;
        }

        public String getDescription() {
            return description;
        }

        public String getService() {
            return service;
        }
    }

    public static class Cost {
        @Expose
        @SerializedName("note")
        private String note;
        @Expose
        @SerializedName("etd")
        private String etd;
        @Expose
        @SerializedName("value")
        private int value;

        public String getNote() {
            return note;
        }

        public String getEtd() {
            return etd;
        }

        public int getValue() {
            return value;
        }
    }

    public static class Destination_details {
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

    public class Origin_details {
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

    public static class Query {
        @Expose
        @SerializedName("courier")
        private String courier;
        @Expose
        @SerializedName("weight")
        private int weight;
        @Expose
        @SerializedName("destination")
        private String destination;
        @Expose
        @SerializedName("origin")
        private String origin;

        public String getCourier() {
            return courier;
        }

        public int getWeight() {
            return weight;
        }

        public String getDestination() {
            return destination;
        }

        public String getOrigin() {
            return origin;
        }
    }
}
