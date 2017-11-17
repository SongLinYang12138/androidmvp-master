package com.ysl.mymvp.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ysl on 2017/9/8.
 */

public class User {


    /**
     * serialid : 1
     * attentionuserstate : 1
     * attentiontime : 2017-09-0809: 15: 25
     */

    private String serialid;
    private String attentionuserstate;
    private String attentiontime;



    public String getAttentiontime() {
        return attentiontime;
    }

    public void setAttentiontime(String attentiontime) {
        this.attentiontime = attentiontime;
    }
}
