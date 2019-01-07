package com.bwie.mvp.presenter;

import com.bwie.base.presenter.BasePresenter;
import com.bwie.mvp.model.LoginModel;
import com.bwie.mvp.view.login_view.LoginView;
import com.bwie.my.bean.login_regbean.LoginBean;
import com.bwie.my.bean.login_regbean.RegisBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/14.
 * @author 王丙均
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginModel loginModel;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }

    //    登陆
    public void getLo(String phone, String pwd) {
        loginModel.getLogi(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        if (loginBean != null) {
                            getView().onLoginSuccess(loginBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    //    注册
    public void regData(String phone, String pwd) {
        loginModel.getReg(phone, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegisBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisBean regisBean) {
                        if (regisBean != null) {
                            getView().onRegSuccess(regisBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}