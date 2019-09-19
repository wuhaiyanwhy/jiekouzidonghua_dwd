package com.duoweidu.model.msf;

public class UserSettingData {

    public String user_id;
    public String avatar;
    public int quality_user;
    public String nickname;
    public boolean nickname_revisable;
    public int gender;
    public String birthday;
    public String mobile;
    public String introduction;
    public boolean password_setted;
    public String terms_of_service;
    public String about_us;
    public ProfileStatusModel profile_status;

    public static class ProfileStatusModel {
        public boolean nickname;
        public boolean avatar;
        public boolean gender;
        public boolean birthday;
        public boolean introduction;

    }
}
