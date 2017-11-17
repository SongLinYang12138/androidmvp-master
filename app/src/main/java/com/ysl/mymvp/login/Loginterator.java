package com.ysl.mymvp.login;

/**
 * Created by ysl on 2017/7/13.
 */
public interface Loginterator {

    interface LoginListener{

        void loginFailed(String msg);
        void loginSuccess(String account, String passowrd);
        void  verificationError();
    }

    void login(String name, String password, String code1, String code2, LoginListener listener);
}
