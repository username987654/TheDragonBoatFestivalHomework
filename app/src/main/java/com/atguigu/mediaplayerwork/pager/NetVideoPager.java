package com.atguigu.mediaplayerwork.pager;

import android.view.View;
import android.widget.TextView;

import com.atguigu.mediaplayerwork.fragment.Fragment;

/**
 * Created by HaoMeng on 2017/5/25.
 */

public class NetVideoPager extends Fragment {
    private TextView tv;
    @Override
    public View initView() {
        tv = new TextView(context);
        return tv;
    }

    @Override
    public void initData() {
        tv.setText("网络视频");
    }
}
