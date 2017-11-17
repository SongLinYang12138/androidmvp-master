package com.ysl.mymvp.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ysl on 2017/9/8.
 */

public class User1 {



    private String fansnum;
    private String statistictime;


    public String getFansnum() {
        return fansnum;
    }

    public void setFansnum(String fansnum) {
        this.fansnum = fansnum;
    }

    public String getStatistictime() {
        return statistictime;
    }

    public void setStatistictime(String statistictime) {
        this.statistictime = statistictime;
    }
}
