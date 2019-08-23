package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class CommonInitconfigData {

    public voucherRuleModel voucherRule;
    public String new_user_banner;
    public int has_new_user_rights;
    public defaultShareModel defaultShare;
    public String user_agreement;
    public String red_bag_mall;
    public ArrayList<String> hot_search_sug;

    public static class voucherRuleModel {
        public String title;
        public String url;
    }

    public static class defaultShareModel {
        public String title;
        public String imageUrl;
    }

}
