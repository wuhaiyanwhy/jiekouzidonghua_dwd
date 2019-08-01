package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonHotsearchsugData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public String value;
        public int priority;
        public int searchCnt;
        public String url;
        public int type;
    }
}
