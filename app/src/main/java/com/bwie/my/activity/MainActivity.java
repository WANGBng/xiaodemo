package com.bwie.my.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.bwie.R;
import com.bwie.my.fragment.CartFragment;
import com.bwie.my.fragment.CircleFragment;
import com.bwie.my.fragment.GoodsListFragment;
import com.bwie.my.fragment.HomeFragment;
import com.bwie.my.fragment.MineFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//主体的F布局,使用的是ViewPager
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.mViewPager)
    ViewPager mViewPger;

    Unbinder unbinder;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaTabsIndicator;

    private final int ITEM_ONE=0;
    private final int ITEM_TWO=2;
    private final int ITEM_THRE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //全屏沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定,在后面的这个都是一个绑定,没有做全局变量,,做成全局变量后有时会出现找不到xml的id值
        unbinder = ButterKnife.bind(this);

        //自定义内部适配器
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator.setViewPager(mViewPger);

      //这是我的Number数量,也就是我们经常看到的消息的数量,看自己的定义,我这里是将他注释掉了,等项目完成后进行展示
//        alphaTabsIndicator.getTabView(0).showNumber(6);
//        alphaTabsIndicator.getTabView(1).showNumber(888);
//        alphaTabsIndicator.getTabView(2).showNumber(88);
//        alphaTabsIndicator.getTabView(3).showPoint();
       // 最后一个是重新绘画,也就是没有消息,在哪个页面都可以使用
        alphaTabsIndicator.getTabView(0);
        alphaTabsIndicator.getTabView(1);
        alphaTabsIndicator.getTabView(2);
        alphaTabsIndicator.getTabView(3);
//        initDataDiBu();
    }

    //底部导航
    class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{
        List<Fragment> fragments = new ArrayList<>();
        String[] titles={"首页","圈子","购物车","订单","我的"};
        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(HomeFragment.newInstance(titles[0]));
            fragments.add(CircleFragment.newInstance(titles[1]));
            fragments.add(GoodsListFragment.newInstance(titles[2]));
            fragments.add(CartFragment.newInstance(titles[3]));
            fragments.add(MineFragment.newInstance(titles[4]));
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            这里是在页面滑动的时候进行的一个动画的效果,根据自己的喜好去设计


        }

        @Override
        public void onPageSelected(int position) {
//            当滑动时我们几个F进行的交换
            if (ITEM_ONE == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (ITEM_TWO == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (ITEM_THRE == position) {
                alphaTabsIndicator.removeAllBadge();
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //改变时发生的状态,还在等我去进行一个整体的效果

        }
    }

  @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == Activity.RESULT_FIRST_USER) {
            if (requestCode == RESULT_CANCELED) {

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
