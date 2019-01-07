package com.bwie.my.activity.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.R;
import com.bwie.mvp.presenter.LoginPresenter;
import com.bwie.mvp.view.login_view.LoginView;
import com.bwie.my.bean.login_regbean.LoginBean;
import com.bwie.my.bean.login_regbean.RegisBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends AppCompatActivity implements LoginView{


    @BindView(R.id.te_jump)
    TextView teJump;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_code)
    EditText registerCode;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.bt_register)
    Button btRegister;
    LoginPresenter loginPresenter;
    Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        unbinder = ButterKnife.bind(this);
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
    }

    @OnClick({R.id.te_jump, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.te_jump:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_register:

                String name = registerPhone.getText().toString();
                String password = registerPwd.getText().toString();
                loginPresenter.regData(name,password);
//                EventBus.getDefault().post(new EventBusMassage(name,password));
//                finish();
                break;
                default:
                    break;
        }
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onRegSuccess(RegisBean regisBean) {
        String message = regisBean.getMessage();
        String name = registerPhone.getText().toString();
        String password = registerPwd.getText().toString();
        Toast.makeText(this, "注册成功"+regisBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (message.equals("注册成功")){

//            EventBus

            EventBus.getDefault().post(new EventBusMassage(name,password));
            finish();
        }
    }

    @Override
    public void OnLoginFailed(LoginBean loginBean) {

    }

    @Override
    public void OnRegFailed(RegisBean regisBean) {

    }
}
