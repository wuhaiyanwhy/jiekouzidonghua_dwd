package com.duoweidu.model.msf;

public class UserUpdateinfoData {

    public String result;
    public boolean is_first_complete;
    public ProfileStatusModel profile_status;

    public static class ProfileStatusModel {
        public boolean nickname;
        public boolean avatar;
        public boolean gender;
        public boolean birthday;
        public boolean introduction;

    }
}
