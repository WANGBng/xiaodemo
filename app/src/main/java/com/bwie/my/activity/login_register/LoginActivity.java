package com.bwie.my.activity.login_register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.R;
import com.bwie.mvp.presenter.LoginPresenter;
import com.bwie.mvp.view.login_view.LoginView;
import com.bwie.my.activity.MainActivity;
import com.bwie.my.bean.login_regbean.LoginBean;
import com.bwie.my.bean.login_regbean.RegisBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Demo class
 *
 * @author 王丙均
 * @date 2018/12/11
 * @param这是登陆页面
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG ="LoginActivity";
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_check)
    CheckBox loginCheck;
    @BindView(R.id.register_jump)
    TextView registerJump;
    @BindView(R.id.login_bt)
    Button loginBt;
    private SharedPreferences sp;

    Unbinder unbinder;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);

    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void message(EventBusMassage eventBusMassage){
        loginPhone.setText(eventBusMassage.phone);
        loginPwd.setText(eventBusMassage.pwd);
    }
//    点击事件
    @OnClick({R.id.login_check, R.id.register_jump, R.id.login_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_check:
                if (loginCheck.isChecked()) {
                    System.out.println("记住密码已选中");
                    sp.edit().putBoolean("ISCHECK", true).commit();

                } else {
                    System.out.println("记住密码没有选中");
                    sp.edit().putBoolean("ISCHECK", false).commit();
                }

                break;
            case R.id.register_jump:
                Toast.makeText(this,"前往注册",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.login_bt:
                String phone = loginPhone.getText().toString();
                String pwd = loginPwd.getText().toString();

                loginPresenter.getLo(phone,pwd);

                if (phone.length()!=0&&pwd.length()!=0){

                }else {
                    Toast.makeText(this,"手机号货密码不能是空的",Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        String status = loginBean.getStatus();
        String message = loginBean.getMessage();
        //判断成功码
        if (status.equals("0000")){
            String phoneE = loginBean.getResult().getPhone();

            Toast.makeText(this,"message"+message,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("phone",phoneE);
            intent.putExtras(bundle);
            setResult(1,intent);

            String pwd = loginPwd.getText().toString();
            String phone = loginPhone.getText().toString();
            if (phone.length()!=0&&pwd.length()!=0){
                Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent1);
            }else {
                Toast.makeText(this,"手机号货密码不能是空的",Toast.LENGTH_SHORT).show();
            }

        }
    }
    @Override
    public void onRegSuccess(RegisBean regisBean) {

    }
    @Override
    public void OnLoginFailed(LoginBean loginBean) {
        Toast.makeText(this,"登陆有问题："+loginBean.getMessage(),Toast.LENGTH_SHORT).show();
        Log.e(TAG,"登陆有问题"+loginBean.getMessage());
    }
    @Override
    public void OnRegFailed(RegisBean regisBean) {
        Toast.makeText(this,"注册有问题："+regisBean.getMessage(),Toast.LENGTH_SHORT).show();
        Log.e(TAG,"注册有问题"+regisBean.getMessage());
    }
    //防止内存溢出
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ButterKnife1解绑
        unbinder.unbind();
        loginPresenter.detachView();
//        EventBus解绑
        EventBus.getDefault().unregister(LoginActivity.this);

    }
}