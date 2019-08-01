package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonTopnavigatelistData {

    public ArrayList<TopNavigateListModel> topNavigateList;

    public static class TopNavigateListModel {
        public int id;
        public int source_type;
        public int type;
        public String icon;
        public String label;
        public int jump_type;
        public String jump_url;
        public int client_type;
        public int priority;
        public int enabled;
        public String version;

    }
}
