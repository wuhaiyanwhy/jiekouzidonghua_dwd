package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class UserVoucherlistData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;

    public static class ListModel {
        public int id;
        public int money_types;
        public int types;
        public String order_id;
        public int user_id;
        public int active_status;
        public int amount;
        public String created_at;
        public String updated_at;
        public int source;
    }
}
