package com.bwie.mvp.presenter;

import android.util.Log;

import com.bwie.base.presenter.BasePresenter;
import com.bwie.mvp.view.sou.InfoView;
import com.bwie.my.bean.sou.GoodsInfoBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 */

public class InfoPresenter extends BasePresenter<InfoView>{
    private static final String TAG = "InfoPresenter";
    public void loadData(int commodityId){
        HttpUtils.getInstence().api.queryGoodsByPid(commodityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(GoodsInfoBean goodsInfoBean) {
                        if (goodsInfoBean!=null){
                            getView().onSuccess(goodsInfoBean);
                        }else {
                            Log.e(TAG, "onNext: "+goodsInfoBean.toString().length() );
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