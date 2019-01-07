package com.bwie.my.activity.myactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bwie.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class My_CircleActivity extends AppCompatActivity {


    @BindView(R.id.circle1_delete)
    ImageView circle1Delete;
    @BindView(R.id.circle1_delete_rec)
    RecyclerView circle1DeleteRec;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__circle);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.circle1_delete)
    public void onViewClicked() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
