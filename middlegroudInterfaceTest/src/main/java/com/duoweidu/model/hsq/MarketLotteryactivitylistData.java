package com.duoweidu.model.hsq;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MarketLotteryactivitylistData {

    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;


    public static class ListModel {
        public int status;
        public int canBuy;
        public int canSub;
        public int canUnSub;
        public int pinActivitiesId;
        public int type;
        public String title;
        public int startTime;
        public int endTime;
        public int groupPrice;
        public int marketPrice;
        public int remindStatus;
        public int lotteryTime;
        public int hasBeenLottery;
        public ArrayList<String> lotteryPics;
    }

}
