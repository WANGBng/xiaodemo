package com.bwie.mvp.model;

import android.util.Log;

import com.bwie.my.bean.circle.CircleBean;
import com.bwie.my.bean.home.HomeCommodityBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observable;
/**
 * date:2018/12/8.
 * Created by 王丙均
 * @author wangbingjun 圈子的所有Model
 */
public class CircleModel {
   /**
    * 圈子
    */
    public Observable<CircleBean> getCircleB(){
        Observable<CircleBean> circle = HttpUtils.getInstence().api.getCircle();
        Log.e("TAG","getCircleB: "+circle);
        return circle;
    }
}
