package com.bwie.mvp.view.sou;

import com.bwie.base.view.BaseView;
import com.bwie.my.bean.sou.JiaGouBean;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 */

public interface JiaView extends BaseView {
    void onJiaSuccess(JiaGouBean jiaGouBean);
    void onJiaError(Throwable t);
}
