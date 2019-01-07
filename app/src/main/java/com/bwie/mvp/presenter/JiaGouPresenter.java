package com.bwie.mvp.presenter;

import com.bwie.base.presenter.BasePresenter;
import com.bwie.mvp.model.JiaModel;
import com.bwie.mvp.view.sou.JiaView;
import com.bwie.my.bean.sou.JiaGouBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 */

public class JiaGouPresenter extends BasePresenter<JiaView> {
    private final JiaModel jiaModel;
    public JiaGouPresenter(){
        jiaModel = new JiaModel();
    }
    public void getJiaGou(String uid,String pid){
        jiaModel.getJiGou(uid,pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiaGouBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(JiaGouBean jiaGouBean) {
                        if (jiaGouBean!=null){
                            getView().onJiaSuccess(jiaGouBean);
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
