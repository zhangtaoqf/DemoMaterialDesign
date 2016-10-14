package test.zt.com.demomaterialdesign;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 *
 * 放置在CoordinatorLayout布局内的控件，可以协调完成一些动画
 *      1.通过直接给CoordinatorLayout内部的控件直接添加app:layout_behavior属性即可    ---属性设置
 *      2.或者通过代码的方式给需要响应滚动控件的控件设置CoordinatorLayout.LayoutParams.setBehavior()//这个属性设置;   ----代码设置
 */
public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    RVAdapter adapter;
    FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = ((FloatingActionButton) findViewById(R.id.activity_main_floatingActionButtonId));
        recyclerView = ((RecyclerView) findViewById(R.id.activity_main_recyclerViewId));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RVAdapter(this);
        recyclerView.setAdapter(adapter);
        relativeLayout = ((RelativeLayout) findViewById(R.id.activity_main_relativeTopId));
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.setBehavior(new MBehavior());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LinearLayoutManager) recyclerView.getLayoutManager()).smoothScrollToPosition(recyclerView,null,0);
            }
        });


        loadData();
    }

    private void loadData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            datas.add("item:"+i);
        }
        adapter.addAll(datas);
    }
}
