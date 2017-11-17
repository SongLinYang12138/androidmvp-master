package com.ysl.mymvp.ui.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.ysl.mymvp.R;
import com.ysl.mymvp.login.LoginPresenter;
import com.ysl.mymvp.login.LoginView;
import com.ysl.mymvp.ui.view.RandomTextView;
import com.ysl.mymvp.util.CommonUtil;
import com.ysl.mymvp.util.ParseGson;
import com.ysl.mymvp.util.ServerClass;

public class LoginActivity extends BaseActivity implements LoginView {

    private LoginPresenter presenter;
    private Button tvLogin;
    private EditText etAccount, etPassowrd,etCode;
    private RandomTextView tvRandom;
    private SharedPreferences shreadUser;
    private final String ACCOUNT = "account";
    private final String PASSWORD = "password";


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etAccount = (EditText) findViewById(R.id.et_account);
        etPassowrd = (EditText) findViewById(R.id.et_password);
        tvLogin = (Button) findViewById(R.id.tv_login);
        tvRandom = (RandomTextView) findViewById(R.id.tv_random);
        etCode = (EditText) findViewById(R.id.et_random);

        shreadUser = this.getSharedPreferences("user", Context.MODE_PRIVATE);
        String account = shreadUser.getString(ACCOUNT, "");
        String password = shreadUser.getString(PASSWORD, "");

        if (CommonUtil.isNotEmpty(account) && CommonUtil.isNotEmpty(password)) {

            etAccount.setText(account);
            etPassowrd.setText(password);
        }


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                Logger.i(path+"   小米");


                ParseGson.pareJson();
                String pass = etPassowrd.getText().toString();
                String account = etAccount.getText().toString();

                if (CommonUtil.isNotEmpty(pass) && CommonUtil.isNotEmpty(account)) {

                    String code1 = etCode.getText().toString();
                    if (CommonUtil.isEmpty(code1)){

                        CommonUtil.showShort(LoginActivity.this,"请输入验证码");
                        return;
                    }

                    presenter.login(account, pass,code1,tvRandom.getText());
                } else {

                    CommonUtil.showShort(LoginActivity.this, "请输入用户名或密码");
                }


            }
        });
        etPassowrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

//                if (CommonUtil.isNotEmpty(s.toString()))
//                    showPopWindow();

            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter = new LoginPresenter(this);


    }

    @Override
    public void loginFailed(String msg) {

        CommonUtil.showLong(this, msg);
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginSuccess(String account, String passowrd) {
        CommonUtil.showLong(this, account + " 登录成功");

        SharedPreferences.Editor edit = shreadUser.edit();
        edit.putString(ACCOUNT,account);
        edit.putString(PASSWORD,passowrd);
        edit.commit();
        edit.clear();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

    }

    @Override
    public void codeError() {

        Toast.makeText(LoginActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
    }

    PopupWindow popupWindow;

    private void showPopWindow() {

        if (popupWindow != null)
            popupWindow.dismiss();
        View view = LayoutInflater.from(this).inflate(R.layout.popupwindow_fragmen1_layout, null);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        popupWindow.setWidth(300);
        popupWindow.setHeight(400);

        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        popupWindow.showAsDropDown(etPassowrd);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    shreadUser = null;
    }
}
