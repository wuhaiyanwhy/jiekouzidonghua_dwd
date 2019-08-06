package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class MarketPinactivitiesuserlistData {

    public ArrayList<ListModel> list;
    public int type;
    public int totalCnt;
    public int totalPage;
    public int countLimit;
    public int joinCount;
    public int restCount;

    public static class ListModel {
        public String userAvatar;
        public int userId;
        public boolean isOwner;
    }
}
