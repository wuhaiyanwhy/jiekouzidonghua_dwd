package com.duoweidu.model.iqg;

import java.util.ArrayList;

public class AddressInfoData {
    public ArrayList<CbdModel>cbd;
    public static class CbdModel {
        public String name;
        public String lat;
        public String lng;
    }
}
