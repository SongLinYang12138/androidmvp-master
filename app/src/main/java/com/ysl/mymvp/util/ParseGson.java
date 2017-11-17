package com.ysl.mymvp.util;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ysl on 2017/9/8.
 */

public class ParseGson {

    public static void pareJson() {
        String jsonString = "{\"code\":1001,\"msg\":\"success\",\"data\":{\"pageSize\":10,\"pageNum\":1,\"offSet\":0,\"totalPages\":1,\"totalCount\":4,\"items\":[{\"subscription\":{\"serialid\":1,\"attentionuserstate\":1,\"attentiontime\":\"2017-09-08 09:15:25\"},\"statisticFans\":{\"fansnum\":1,\"statistictime\":\"2017-09-08 09:15:25\"},\"user\":{\"userid\":2017080309000100002,\"nickname\":\"建超\",\"realname\":\"\",\"profilephotopath\":\"\",\"certificateauthstatus\":0,\"realnameauthstatus\":0},\"userLogin\":{\"username\":\"15138490976\"},\"tag\":{\"serialno\":1,\"tagname\":\"7月份投顾比赛冠军\"}},{\"subscription\":{\"serialid\":3,\"attentionuserstate\":1,\"attentiontime\":\"2017-09-08 10:04:49\"},\"statisticFans\":{\"fansnum\":\"\",\"statistictime\":\"\"},\"user\":{\"userid\":2017090809560438187,\"nickname\":\"\",\"realname\":\"\",\"profilephotopath\":\"\",\"certificateauthstatus\":0,\"realnameauthstatus\":0},\"userLogin\":{\"username\":\"13621756691\"},\"tag\":\"\"},{\"subscription\":{\"serialid\":4,\"attentionuserstate\":0,\"attentiontime\":\"2017-09-08 10:04:51\"},\"statisticFans\":{\"fansnum\":\"\",\"statistictime\":\"\"},\"user\":{\"userid\":2017090809561913950,\"nickname\":\"\",\"realname\":\"\",\"profilephotopath\":\"\",\"certificateauthstatus\":0,\"realnameauthstatus\":0},\"userLogin\":{\"username\":\"13621756692\"},\"tag\":{\"serialno\":1,\"tagname\":\"7月份投顾比赛冠军\"}},{\"subscription\":{\"serialid\":6,\"attentionuserstate\":\"\",\"attentiontime\":\"\"},\"statisticFans\":{\"fansnum\":\"\",\"statistictime\":\"\"},\"user\":{\"userid\":2017090809560438187,\"nickname\":\"\",\"realname\":\"\",\"profilephotopath\":\"\",\"certificateauthstatus\":0,\"realnameauthstatus\":0},\"userLogin\":{\"username\":\"13621756691\"},\"tag\":\"\"}]},\"token\":\"\"}";

        try {
            JSONObject object = new JSONObject(jsonString);
            JSONObject object1 = object.getJSONObject("data");
            JSONArray array = object1.getJSONArray("items");

            Gson gson = new Gson();
            for (int i = 0; i < array.length(); ++i) {
                JSONObject childJson = array.getJSONObject(i);

                String str1 = childJson.getString("subscription");
                String str2 = childJson.getString("statisticFans");
                String str3 = childJson.getString("user");
                String str4 = childJson.getString("userLogin");
                String str5 = childJson.getString("tag");

                if (CommonUtil.isNotEmpty(str1)) {
                    User user = gson.fromJson(str1, User.class);
                }

                if (CommonUtil.isNotEmpty(str2)) {
                    User1 user1 = gson.fromJson(str2, User1.class);
                }

                if (CommonUtil.isNotEmpty(str3)) {
                    User2 user2 = gson.fromJson(str3, User2.class);
                }
                if (CommonUtil.isNotEmpty(str4)) {
                    User3 user3 = gson.fromJson(str4, User3.class);
                }
                if (CommonUtil.isNotEmpty(str5)) {
                    User4 user4 = gson.fromJson(str5, User4.class);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
