package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class UserMyincomeData {
    public int commission_accum_amount;
    public ArrayList<ListModel>list;
    public static class ListModel {
        public int id;
        public int user_id;
        public int order_id;
        public String item_name;
        public int pay_amount;
        public int commission_amount;
        public String nickname;
        public int commission_type;
        public int row_status;
        public String created_at;
        public String order_created_at;
        public int item_id;
        public int activity_id;
        public String item_image;
    }
    public int total_cnt;
    public int total_page;
}
