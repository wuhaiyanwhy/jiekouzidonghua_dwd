package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ActivityAssistanceuserskulistData {
    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;


    public static class ListModel {
        public int event_id;
        public int assistance_id;
        public int event_status;
        public int owner_id;
        public int launch_start_time;
        public int launch_end_time;
        public int join_count;
        public int booster_num;
        public String share_image_url;
        public String sub_data;
        public int sku_id;
        public String title;
        public int activity_status;
        public int status;
        public int product_id;
        public int activity_id;
        public int activity_type;
        public int activity_price;
        public int single_price;
        public String name;
        public String thunbnail;
        public String left_stock;
        public String locked_stock;
        public String activity_stock;
        public String order_id;
        public int activity_order_status;
        public int activity_event_id;
        public int can_buy;


    }

}
