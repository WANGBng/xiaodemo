package com.bwie.mvp.model;

import com.bwie.my.bean.login_regbean.LoginBean;
import com.bwie.my.bean.login_regbean.RegisBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * date:2018/12/14.
 * @author王丙均
 */
    public class LoginModel {
        //登陆的M
        public Observable<LoginBean> getLogi(String phone, String pwd){
            Observable<LoginBean> data = HttpUtils.getInstence().api.getLogin(phone, pwd);
            return data;
        }
        //注册的M
        public Observable<RegisBean> getReg(String phone, String pwd){
        Observable<RegisBean> data = HttpUtils.getInstence().api.getReg(phone, pwd);
        return data;
    }
}