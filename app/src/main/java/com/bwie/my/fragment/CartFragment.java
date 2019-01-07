package com.bwie.my.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.R;

/**
 * date:2018/12/5.
 * Created by 王丙均
 */

public class CartFragment extends Fragment {
    public static final String BUNDLE_TITLE = "title";

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate( R.layout.cart_fragment_layout,container,false);
        }
        ViewGroup parent = (ViewGroup)view.getParent();
        if(parent != null){
            parent.removeView(view);
        }

        return view;
    }

    public static CartFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        CartFragment fragment = new CartFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
