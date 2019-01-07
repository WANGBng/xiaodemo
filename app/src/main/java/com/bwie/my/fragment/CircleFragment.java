package com.bwie.my.fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.R;
import com.bwie.mvp.presenter.CirclePresenter;
import com.bwie.mvp.view.circleview.CircleView;
import com.bwie.my.adapter.circleadapter.CircleAdapter;
import com.bwie.my.bean.circle.CircleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * date:2018/12/5.
 * Created by 王丙均
 * @author wangbingjun
 */
public class CircleFragment extends Fragment implements CircleView {
    public static final String BUNDLE_TITLE = "title";
    public static final String TAG = "CircleFragment";

    View view;
    @BindView(R.id.circe_rec)
    RecyclerView circeRec;

    Unbinder unbinder;
    CirclePresenter circlePresenter;
    CircleAdapter circle_Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.circle_fragment_layout, container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        unbinder = ButterKnife.bind(this, view);

        circlePresenter = new CirclePresenter();
        circlePresenter.attachView(this);
        circlePresenter.getCir();

        return view;
    }

    @Override
    public void onCircleSuccess(CircleBean circleBean) {
        List<CircleBean.ResultBean> result = circleBean.getResult();
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        circeRec.setLayoutManager(manager);
        circle_Adapter = new CircleAdapter(getActivity(),result);
        circeRec.setAdapter(circle_Adapter);
        circle_Adapter.notifyDataSetChanged();
//        long createTime = circleBean.getResult().get(0).getCreateTime();
//        Log.e(TAG, "onCircleSuccesswww: "+result);
//        Log.e(TAG, "onCircleSuccessaaa: "+createTime);
//        Toast.makeText(getActivity(),"sssssssss",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnCircleFailed(Throwable throwable) {

    }

    public static CircleFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        CircleFragment fragment = new CircleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    /**
     * 防止内存泄漏,造成手机的内存消耗过大
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        circlePresenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }
}
