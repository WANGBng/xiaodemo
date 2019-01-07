package com.bwie.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.activity.myactivity.My_AddressActivity;
import com.bwie.my.activity.myactivity.My_CircleActivity;
import com.bwie.my.activity.myactivity.My_DataActivity;
import com.bwie.my.activity.myactivity.My_FootprintsActivity;
import com.bwie.my.activity.myactivity.My_WalletActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/5.
 * Created by 王丙均
 */

public class MineFragment extends Fragment {
    public static final String BUNDLE_TITLE = "title";

    View view;
    @BindView(R.id.personal_Data)
    TextView personalData;
    @BindView(R.id.personal_circle)
    TextView personalCircle;
    @BindView(R.id.personal_footprints)
    TextView personalFootprints;
    @BindView(R.id.personal_wallet)
    TextView personalWallet;
    @BindView(R.id.personal_address)
    TextView personalAddress;
    @BindView(R.id.wodexiaojiejie)
    SimpleDraweeView wodexiaojiejie;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.mine_fragment_layout, container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public static MineFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        MineFragment fragment = new MineFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.personal_Data, R.id.personal_circle, R.id.personal_footprints, R.id.personal_wallet, R.id.personal_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_Data:
                //跳转到个人资料
                Intent intent_My_Data_Activity = new Intent(getActivity(),My_DataActivity.class);
                startActivity(intent_My_Data_Activity);
                break;
            case R.id.personal_circle:
                //跳转到我的圈子
                Intent intent_My_circle_Activity = new Intent(getActivity(),My_CircleActivity.class);
                startActivity(intent_My_circle_Activity);
                break;
            case R.id.personal_footprints:
                //跳转到我的足迹
                Intent intent_My_footprints_Activity = new Intent(getActivity(),My_FootprintsActivity.class);
                startActivity(intent_My_footprints_Activity);
                break;
            case R.id.personal_wallet:
                //跳转到我的钱包
                Intent intent_My_wallet_Activity = new Intent(getActivity(),My_WalletActivity.class);
                startActivity(intent_My_wallet_Activity);
                break;
            case R.id.personal_address:
                //跳转到地址
                Intent intent_My_address_Activity = new Intent(getActivity(),My_AddressActivity.class);
                startActivity(intent_My_address_Activity);
                break;
            default:
                break;
        }
    }
}
