package com.bwie.mvp.view.circleview;

import com.bwie.base.view.BaseView;
import com.bwie.my.bean.circle.CircleBean;
/**
 * date:2018/12/11.
 * Created by 王丙均
 * 圈子的V层
 */
public interface CircleView extends BaseView{
    void onCircleSuccess(CircleBean circleBean);
    void OnCircleFailed(Throwable throwable);
}
