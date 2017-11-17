package com.ysl.mymvp.login;

/**
 * Created by ysl on 2017/7/13.
 */
public class LoginPresenter implements Loginterator.LoginListener{

    private LoginView loginView;
    private LoginInteratorImpl interator;


    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        interator = new LoginInteratorImpl();

    }

    public void login(String nmae,String password,String code1,String code2){

        interator.login(nmae,password,code1,code2,this);
    }


    @Override
    public void loginFailed(String msg) {

        loginView.loginFailed(msg);
    }

    @Override
    public void loginSuccess(String account,String passowrd) {

        loginView.loginSuccess(account,passowrd);
    }

    @Override
    public void verificationError() {
         loginView.codeError();
    }
}
