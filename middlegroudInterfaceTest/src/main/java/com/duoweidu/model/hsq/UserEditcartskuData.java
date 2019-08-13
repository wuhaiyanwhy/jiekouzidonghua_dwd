package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class UserEditcartskuData {

    public String type;
    public ItemModel item;

    public static class ItemModel {
        public int id;
        public int sku_id;
        public String name;
        public String pic;
        public ArrayList<String> attrs;
        public int price;
        public int amount;
        public int max_cart_nums;
        public boolean active;

    }
}
