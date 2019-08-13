package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class RefundDetailData {

    public String title;
    public String content;
    public ArrayList<AuditListModel> auditList;
    public RefundInfoModel refundInfo;

    public static class AuditListModel {
        public int type;
        public int auditUserId;
        public String note;
        public String time;
        public int status;
        public String statusDesc;
        public int amount;
        public ArrayList<String> pics;

    }

    public static class RefundInfoModel {
        public int id;
        public String reason;
        public String method;
        public int refundMoney;
        public int amount;
        public String amountDesc;
        public int deliveryAmount;
        public String note;
        public String applyTime;
        public String complaintTime;
        public String complaintExpiredTime;
        public String auditExpiredTime;
        public ArrayList<String> pics;

        public int canComplaint;
        public int canAgree;
        public int type;
        public int refundType;

    }
}
