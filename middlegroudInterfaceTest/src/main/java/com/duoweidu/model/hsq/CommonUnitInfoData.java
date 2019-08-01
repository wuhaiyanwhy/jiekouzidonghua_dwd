package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonUnitInfoData {

    public ArrayList<PackagesModel> packages;

    public static class PackagesModel {
        public String id;
        public String version;
        public String url;
        public String type;
    }
}
