package com.ysl.mymvp.login;

/**
 * Created by ysl on 2017/7/13.
 */
public interface LoginView {

    void loginFailed(String msg);
    void loginSuccess(String account, String passowrd);
    void codeError();
}
