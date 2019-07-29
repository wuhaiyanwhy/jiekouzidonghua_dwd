package com.duoweidu.model.jsz;

import java.util.ArrayList;

public class AddressSearchData {

    public int status;
    public int count;
    public int info;
    public int infocode;

    public ArrayList<PoisModel> pois;
    public static class PoisModel {
        public int id;
        public String name;
        public String type;
        public String typecode;
        public String address;
        public String location;
        public String cityname;
        public String adname;
        public String shopinfo;
        public String pname;

        public ArrayList<PhotosModel> photos;
        public static class PhotosModel {
            public String url;
        }
    }
}

