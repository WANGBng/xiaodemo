package com.bwie.mvp.presenter;

import com.bwie.base.presenter.BasePresenter;
import com.bwie.mvp.view.sou.SouView;
import com.bwie.my.bean.sou.SouBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 *
 */

public class SouPresenter extends BasePresenter<SouView> {
    public void SouloadDataFromNet(String keyword,int page) {
        Observable<SouBean> sousuo = HttpUtils.getInstence().api.sousuo(keyword, page);
        sousuo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SouBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(SouBean souBean) {
                        if (souBean!= null){
                            getView().onSuccess(souBean);
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
