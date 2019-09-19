package com.duoweidu.model.msf;

import java.util.ArrayList;

public class OrderListData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int activity_id;
        public int activity_snapshot_id;
        public int item_snapshot_id;
        public String branch_name;
        public int amount;
        public String expire_time;
        public String redeem_time;
        public int status;
        public int article_id;
        public int item_id;
        public String item_name;
        public String item_pic;
        public int article_status;
        public String video_id;
    }
}
