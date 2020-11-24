package com.dongzz.android.lv;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.dongzz.android.lv.adapter.MyZListViewAdapter;
import com.dongzz.android.lv.model.BlogData;
import com.dongzz.android.zlv.ZListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 自定义 ZListView 控件
 */
public class MainActivity extends AppCompatActivity {

    private ZListView zlv; // ZListView
    private boolean b; // 刷新 是否成功

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zlv = findViewById(R.id.zlv);
        zlv.setPullLoadEnable(true);
        zlv.setPullRefreshEnable(true);
        zlv.setZListViewListener(new MyZlvListener()); //监听
        zlv.setAdapter(new MyZListViewAdapter(this, getVirtualData())); //适配器

    }

    /**
     * ZListView 监听器
     */
    private class MyZlvListener implements ZListView.IZListViewListener {

        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    zlv.stopRefresh(b);
                    b = !b;
                }
            }, 2000);
        }

        @Override
        public void onLoadMore() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    zlv.stopLoadMore();
                }
            }, 2000);
        }

    }


    /**
     * 模拟 加载数据
     *
     * @return
     */
    private List<BlogData> getVirtualData() {
        List<BlogData> blogs = new ArrayList<>();
        blogs.add(new BlogData(1, "Jetpack架构组件，带你快速上手", "Zbc521"));
        blogs.add(new BlogData(2, "Android 深入理解 RecyclerView 缓存机制", "Zbc521"));
        blogs.add(new BlogData(3, "Android 状态栏处理", "Zbc521"));
        blogs.add(new BlogData(4, "MVP架构 快速上手", "Zbc521"));
        blogs.add(new BlogData(5, "AIDL 进程间通信机制", "Zbc521"));
        return blogs;
    }
}
