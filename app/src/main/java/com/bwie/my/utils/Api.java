package com.bwie.my.utils;

import com.bwie.my.bean.circle.CircleBean;
import com.bwie.my.bean.home.HomeBannerBean;
import com.bwie.my.bean.home.HomeCommodityBean;
import com.bwie.my.bean.login_regbean.LoginBean;
import com.bwie.my.bean.login_regbean.RegisBean;
import com.bwie.my.bean.sou.GoodsInfoBean;
import com.bwie.my.bean.sou.JiaGouBean;
import com.bwie.my.bean.sou.SouBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * date:2018/12/4.
 * @author 王丙均
 * @param
 * @parampage
 * @return Return
 */

public interface Api {

    /**
     * 登陆
     */
    @POST("user/v1/login")
    Observable<LoginBean> getLogin(@Query("phone") String phone,@Query("pwd")String pwd);
    /**
     * 注册
     */
    @POST("user/v1/register")
    Observable<RegisBean> getReg(@Query("phone") String phone, @Query("pwd")String pwd);

/**
 * 这是首页的
 */
    @GET("commodity/v1/bannerShow")
    Observable<HomeBannerBean> getBanner();
    /**
     * 展示数据
     */
    @GET("commodity/v1/commodityList")
    Observable<HomeCommodityBean> getCommodity();
//搜索
    @GET("commodity/v1/findCommodityByKeyword")
    Observable<SouBean> sousuo(@Query("keyword") String keyword, @Query("page")int page);

//详情
    @GET("commodity/v1/findCommodityDetailsById")
    Observable<GoodsInfoBean> queryGoodsByPid(@Query("commodityId") int commodityId);

//加入购物车
    @GET("order/verify/v1/syncShoppingCart")
    Observable<JiaGouBean> jiaCar(@Query("userId") String uid, @Query("sessionId") String pid);

//    这是圈子的
//    http://172.17.8.100/small/circle/v1/findCircleList?userId=1010&sessionId=15320748258726&page=1&count=5
//    @GET("commodity/v1/findCircleList")
//    Observable<CircleBean> getCircle(@Query("userId") String userId, @Query("sessionId")String sessionId,@Query("page")String page,@Query("count")String count);
    @GET("circle/v1/findCircleList?userId=1010&sessionId=15320748258726&page=1&count=5")
    Observable<CircleBean> getCircle();
//    @GET("circle/verify/v1/addCircleGreat")
//    Observable<CircleBean> getAddCircle();

}
