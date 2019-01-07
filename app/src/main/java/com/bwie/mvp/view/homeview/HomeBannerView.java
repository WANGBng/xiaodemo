package com.bwie.mvp.view.homeview;

import com.bwie.base.view.BaseView;
import com.bwie.my.bean.home.HomeBannerBean;
import com.bwie.my.bean.home.HomeCommodityBean;

/**
 * date:2018/12/4.
 * Created by 王丙均
 * 整个首页的V层
 */
public interface HomeBannerView extends BaseView{
    void OnHomeBannerSuccess(HomeBannerBean bannerBean);
    void OnHomeCommoditySuccess(HomeCommodityBean.ResultBean homeCommodityBean);
    void OnFailed(Throwable t);
}
