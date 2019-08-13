package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserAddresslistData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int user_id;
        public int province_id;
        public String province;
        public int city_id;
        public String city;
        public int district_id;
        public String district;
        public String contacter;
        public String mobile;
        public String detail_address;
        public int delivery_type;
        public int is_default;
        public String last_update;

    }
}
