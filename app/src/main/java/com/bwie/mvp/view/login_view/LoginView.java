package com.bwie.mvp.view.login_view;

import com.bwie.base.view.BaseView;
import com.bwie.my.bean.login_regbean.LoginBean;
import com.bwie.my.bean.login_regbean.RegisBean;

/**
 * date:2018/12/14.
 * @author 王丙均
 */

public interface LoginView extends BaseView {
    void onLoginSuccess(LoginBean loginBean);
    void onRegSuccess(RegisBean regisBean);
    void OnLoginFailed(LoginBean loginBean);
    void OnRegFailed(RegisBean regisBean);

}
