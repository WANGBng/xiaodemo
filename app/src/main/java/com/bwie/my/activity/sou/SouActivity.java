package com.bwie.my.activity.sou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author wangbingjun
 */
public class SouActivity extends AppCompatActivity {

    @BindView(R.id.sou)
    ImageView sou;
    @BindView(R.id.sou_edit_sou)
    EditText souEditSou;
    @BindView(R.id.customView)
    CustomView liuShi;
    Unbinder unbinder;
    private ViewGroup.MarginLayoutParams layoutParams;
    private List<String> list;
    private String string;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou);
        unbinder = ButterKnife.bind(this);

        souEditSou.setCursorVisible(true);
        souEditSou.setFocusable(true);
        souEditSou.setFocusableInTouchMode(true);

        layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin =40;
        layoutParams.rightMargin = 40;
        list = new ArrayList<>();
    }

    @OnClick(R.id.sou)
    public void onViewClicked() {
        liuShi.removeAllViews();//将原有的视图先去除掉
        string = souEditSou.getText().toString();
        list.add(string);
        for (int i = list.size()-1;i > -1; i--) {
            textView = new TextView(SouActivity.this);
            textView.setText(list.get(i));
            textView.setGravity(Gravity.CENTER);
            //将上面定义的间距添加进
            textView.setLayoutParams(layoutParams);
            liuShi.addView(textView);
        }
        if (string.length()>0){
            //将搜索的值传给展示视图也就是传给ShowActivity
            Intent intent = new Intent(SouActivity.this,ShowActivity.class);
            intent.putExtra("sousuo",string);
            startActivity(intent);
        }else if (string==null){
            Toast.makeText(this,"不能是空的",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
