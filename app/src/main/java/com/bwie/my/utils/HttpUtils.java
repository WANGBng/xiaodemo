package com.bwie.my.utils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * date:2018/12/5.
 * @author王丙均
 */
public class HttpUtils {
    private static final String TAG = "HttpUtils";
    public final Api api;
    private HttpUtils(){
        //                                                                  ok进行自定义拦截
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Logging()).build();
        //Retrofit进行解析
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contest.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        api = retrofit.create(Api.class);
    }
    private class Logging implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder().addHeader("soucre", "android");
            Log.e(TAG, "intercept: "+request );
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }
    private static class GetDataNet{
        public static HttpUtils httpUtils = new HttpUtils();

    }
    public static HttpUtils getInstence(){
        return GetDataNet.httpUtils;
    }
}