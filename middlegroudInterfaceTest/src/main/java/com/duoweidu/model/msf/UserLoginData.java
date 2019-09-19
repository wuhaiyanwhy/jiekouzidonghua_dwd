package com.duoweidu.model.msf;

public class UserLoginData {

    public String id;
    public String mobile;
    public String token;
    public String avatar;
    public String nickname;
    public String created_at;
    public String last_login;
    public boolean is_register;
    public boolean need_bind_mobile;
    public int group_id;
    public int level_id;
    public int invite_user_id;
    public OauthInfoModel oauth_info;
    public String register_time;
    public boolean is_profile_complete;
    public PermissionsModel permissions;

    public static class OauthInfoModel {

    }

    public static class PermissionsModel {
        public boolean video;
    }
}
