package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CommonInitconfigData {

    public String aboutUs;
    public String userAgreement;
    public String serviceTel;
    public int customerId;
    public boolean wholesaleEnabled;
    public String offline_log_url;
    public String https_offline_log_url;
    public int indexCartEnabled;
    public String userProtocol;
    public boolean cacheClear;
    public boolean udeskEnabled;
    public int cartNum;
    public ArrayList<String> categoryList;
    public ArrayList<String> productionAreaOptions;
    public ArrayList<PriceOptionsModel> priceOptions;
    public ArrayList<PaymentwayModel> paymentway;
    public String customerName;
    public HotSearchModel hotSearch;
    public DefaultLocationModel defaultLocation;
    public boolean is_write_log;
    public ArrayList<LaunchPicModel> launchPic;
    public LaunchPicConfigModel launchPicConfig;
    public CouponListModel couponList;
    public DnsCheckModel dnsCheck;
    public boolean joinTaobaoConfig;
    public String bannerWH;
    public boolean voiceSearch;
    public boolean track;
    public String user_flow;


    public static class PriceOptionsModel {
        public int start;
        public int end;
    }

    public static class PaymentwayModel {
        public int id;
        public String name;
        public String icon;

    }

    public static class HotSearchModel {
        public int id;
        public String value;
        public int priority;
        public int search_cnt;
        public String url;
        public int type;
        public int status;
        public int channel;
        public int position;
    }

    public static class DefaultLocationModel {
        public int aMapId;
        public String city;
        public String province;
        public int provinceId;
        public int zoneId;
        public int cityId;
    }

    public static class LaunchPicModel {
        public String img;
        public int size;
        public int type;
        public int url;
        public String link;
        public int version;
        public int highest_version;

    }

    public static class LaunchPicConfigModel {
        public int noWifiDisplay;
        public int displayTime;
    }

    public static class CouponListModel {
        public ArrayList<ListModel> list;
        public String description;
        public int popInterval;

        public static class ListModel {
            public String title;
            public int value;
            public String schema;
            public String termOfValidity;
            public String range_type;

        }
    }

    public static class DnsCheckModel {
        public boolean isReport;
        public ArrayList<String> hosts;
    }
}
