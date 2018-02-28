package com.ysl.mymvp.bean;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * Created by ysl on 2017/11/30.
 */

public class UserInfo  implements Parcelable,Comparator<UserInfo>{

    Intent intent;

    protected UserInfo(Parcel in) {
        intent = in.readParcelable(Intent.class.getClassLoader());
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public void inten(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(intent, flags);
    }

    @Override
    public int compare(UserInfo o1, UserInfo o2) {
        return 0;
    }
}

