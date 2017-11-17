package com.ysl.mymvp.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ysl on 2017/9/8.
 */

public class User4 {

    /**
     * serialno : 1
     * tagname : 7月份投顾比赛冠军
     */

    private String serialno;
    private String tagname;

    public static User4 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), User4.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
}
