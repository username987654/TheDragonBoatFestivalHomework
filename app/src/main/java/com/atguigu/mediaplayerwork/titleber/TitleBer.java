package com.atguigu.mediaplayerwork.titleber;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.mediaplayerwork.R;

/**
 * Created by HaoMeng on 2017/5/25.
 */

public class TitleBer extends LinearLayout implements View.OnClickListener {
    private TextView tvssk;
    private RelativeLayout rlgame;
    private ImageView ivrecord;
    private Context context;
    public TitleBer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvssk = (TextView) getChildAt(1);
        rlgame = (RelativeLayout) getChildAt(2);
        ivrecord  = (ImageView) getChildAt(3);

        tvssk.setOnClickListener(this);
        rlgame.setOnClickListener(this);
        ivrecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_ssk:
                Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_game:
                Toast.makeText(context, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_record:
                Toast.makeText(context, "记录", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
