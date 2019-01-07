package com.bwie.base.presenter;

import com.bwie.base.view.BaseView;

/**
 * date:2018/12/4.
 * Created by 王丙均
 * 整体的BaseP层
 */
public class BasePresenter<V extends BaseView> {
    private V iv;
    public void attachView(V iv){
        this.iv = iv;
    }
    public void detachView(){
        this.iv = null;
    }
    public V getView(){
        return iv;
    }
}
