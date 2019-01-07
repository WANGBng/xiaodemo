package com.bwie.mvp.model;

import com.bwie.my.bean.sou.JiaGouBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 */

public class JiaModel {
    public Observable<JiaGouBean> getJiGou(String uid, String pid){
        Observable<JiaGouBean>  GouBeanObservable = HttpUtils.getInstence().api.jiaCar(uid, pid);
        return GouBeanObservable;
    }
}
