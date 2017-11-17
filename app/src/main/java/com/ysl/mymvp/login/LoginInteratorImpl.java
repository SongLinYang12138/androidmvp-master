package com.ysl.mymvp.login;

/**
 * Created by ysl on 2017/7/13.
 */
public class LoginInteratorImpl implements Loginterator {


    @Override
    public void login(String name, String password,String cod1,String code2, LoginListener listener) {
        String msg = null;
        if (!cod1.equals(code2)){
            listener.verificationError();
            return;
        }
        if (name.equals("ysl")){

            if (password.equals("123456")){
                listener.loginSuccess(name,password);
            }else {
                msg = "密码错误";
                listener.loginFailed(msg);
            }

        }else {
            msg = "用户名错误";
        listener.loginFailed(msg);
        }


    }
}
