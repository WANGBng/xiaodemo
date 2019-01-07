package com.bwie.mvp.view.sou;

import com.bwie.base.view.BaseView;
import com.bwie.my.bean.sou.GoodsInfoBean;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 */

public interface InfoView extends BaseView {
    void onSuccess(GoodsInfoBean goodsInfoBean);
    void onError(String msg);
}
