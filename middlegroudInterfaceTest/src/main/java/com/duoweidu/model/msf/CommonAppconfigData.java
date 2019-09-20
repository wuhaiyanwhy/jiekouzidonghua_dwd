package com.duoweidu.model.msf;

public class CommonAppconfigData {

    public DefaultZoneModel default_zone;
    public UpdateModel update;
    public int unread;
    public String term_of_service;
    public ProtocolsModel protocols;
    public boolean tongdun_fingerprint;
    public HoneyModel honey;

    public static class DefaultZoneModel {
        public int id;
        public int baidu_city_id;
        public int amap_city_id;
        public String name;
        public String address;
        public String lng;
        public String lat;
        public int weight;
        public int launched_at;
        public String first_pin_yin;
        public int is_hot;
        public int status;
        public String cover;
        public String province_name;
        public int zone_id;
    }

    public static class UpdateModel {
        public int id;
        public int platform;
        public String version_code;
        public String lowest_code;
        public String name;
        public String title;
        public String description;
        public String url;
        public boolean force_update;
        public int status;
        public int decode;
        public String created_at;
        public String updated_at;
        public boolean can_update;
    }

    public static class ProtocolsModel {
        public String user_service;
        public String user_privacy;
        public String about_us;
    }

    public static class HoneyModel {
        public int article_publish;
        public int article_recommend;
        public int article_interactive;
        public int article_branch_first;
        public int article_user_first;
        public int new_user_gift;

    }
}
