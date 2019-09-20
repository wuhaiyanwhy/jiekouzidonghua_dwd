package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class UserGetuserinviteinfoData {

    public UserInfoModel userInfo;
    public ArrayList<String> list;
    public int totalPage;
    public int totalCnt;
    public int inviteTotalAmount;
    public int inviteRedPacketTotalAmount;
    public String singleInviteAmount;
    public int highestAmount;

    public static class UserInfoModel {
        public int id;
        public String username;
        public String avatar;
        public String mobile;
        public String email;
        public String birthday;
        public int sex;
        public int enabled;
        public String created_at;
        public String updated_at;
        public int is_new_user;
        public int total_voucher_money;
        public int total_redpacket_money;

    }
}
