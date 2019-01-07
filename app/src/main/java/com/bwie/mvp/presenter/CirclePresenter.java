package com.bwie.mvp.presenter;

import android.util.Log;

import com.bwie.base.presenter.BasePresenter;
import com.bwie.mvp.model.CircleModel;
import com.bwie.mvp.view.circleview.CircleView;
import com.bwie.mvp.view.homeview.HomeBannerView;
import com.bwie.my.bean.circle.CircleBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/7.
 * Created by 王丙均
 *
 */

public class CirclePresenter extends BasePresenter<CircleView> {
    private static final String TAG = "CirclePresenter";
    private final CircleModel circleModel;
    public CirclePresenter(){
        circleModel= new CircleModel();
    }

    public void getCir(){
        circleModel.getCircleB()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CircleBean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(CircleBean circleBean) {
                getView().onCircleSuccess(circleBean);
                Log.e(TAG, "onNext: "+circleBean);
            }

            @Override
            public void onError(Throwable e) {
                getView().OnCircleFailed(e);
            }
            @Override
            public void onComplete() {
            }
        });
    }
}
