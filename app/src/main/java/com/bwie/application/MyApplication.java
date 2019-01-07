package com.bwie.application;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.WindowManager;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
/**
 * date:2018/12/4.
 * Created by 王丙均
 * 全局初始化变量
 * 1,Fresco图片的缓存
 * 2,全局的屏幕适配
 */
public class MyApplication extends Application {
    //绘制页面时参照的设计图宽度
    public final static float DESIGN_WIDTH = 750;

    @Override
    public void onCreate() {
        super.onCreate();
        //图形的展示
        DiskCacheConfig.Builder builder = DiskCacheConfig.newBuilder(this);
        builder.setBaseDirectoryPath(getCacheDir());
        DiskCacheConfig diskCacheConfig = builder.build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        //图片加载
        Fresco.initialize(this,config);

        /*
//        用于第三方的登陆
        UMConfigure.init(this,"5bee9b04b465f59645000020"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        UMConfigure.setLogEnabled(true);*/
    }
    //全局屏幕
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();//这个方法重写也是很有必要的
    }
    public void resetDensity(){
        Point size = new Point();
        ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        getResources().getDisplayMetrics().xdpi = size.x/DESIGN_WIDTH*72f;
    }
}
