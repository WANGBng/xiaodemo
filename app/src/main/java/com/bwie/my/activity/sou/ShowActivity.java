package com.bwie.my.activity.sou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.R;
import com.bwie.mvp.presenter.SouPresenter;
import com.bwie.mvp.view.sou.SouView;
import com.bwie.my.adapter.sou.SouSuoAdapter;
import com.bwie.my.bean.sou.SouBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShowActivity extends AppCompatActivity implements SouView{

    @BindView(R.id.show_recyclerView)
    RecyclerView showRecyclerView;
    Unbinder unbinder;

    private SouPresenter souPresenter;
    private String string;
    // private String string1;
    private List<SouBean.ResultBean> data;
    private SouSuoAdapter souSuoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        unbinder = ButterKnife.bind(this);

        souPresenter = new SouPresenter();
        souPresenter.attachView(this);
        string = getIntent().getStringExtra("sousuo");
        souPresenter.SouloadDataFromNet(string, 1);
        showRecyclerView.setLayoutManager(new LinearLayoutManager(ShowActivity.this, LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onSuccess(SouBean souBean) {

       data = souBean.getResult();
        souSuoAdapter = new SouSuoAdapter(ShowActivity.this,data);
        showRecyclerView.setAdapter(souSuoAdapter);

    }
}
