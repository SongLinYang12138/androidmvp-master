package com.ysl.mymvp.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ysl on 2017/9/8.
 */

public class User2 {


    /**
     * userid : 2017080309000100000
     * nickname : 建超
     * realname :
     * profilephotopath :
     * certificateauthstatus : 0
     * realnameauthstatus : 0
     */

    private String userid;
    private String nickname;
    private String realname;
    private String profilephotopath;
    private String certificateauthstatus;
    private String realnameauthstatus;

    public static User2 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), User2.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getProfilephotopath() {
        return profilephotopath;
    }
}
