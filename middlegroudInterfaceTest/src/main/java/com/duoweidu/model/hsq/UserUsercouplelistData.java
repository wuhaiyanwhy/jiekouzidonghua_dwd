package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserUsercouplelistData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;

    public static class ListModel {
        public int id;
        public String order_id;
        public int pin_activities_id;
        public int pin_event_id;
        public int user_id;
        public int pin_event_status;
        public int type;
        public String last_update;
        public int couplePrice;
        public int marketPrice;
        public int pinActivitiesId;
        public String url;
        public int skuId;
        public String coupleTitle;
        public String skuPic;
    }
}
