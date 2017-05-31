package com.atguigu.mediaplayerwork.pager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.mediaplayerwork.R;
import com.atguigu.mediaplayerwork.adapter.MyAdapter;
import com.atguigu.mediaplayerwork.bean.VideoInfo;
import com.atguigu.mediaplayerwork.fragment.Fragment;

import java.util.ArrayList;

/**
 * Created by HaoMeng on 2017/5/25.
 */

public class locaVideoPager extends Fragment {
    private View view;
    private ArrayList<VideoInfo> videoInfos;
    private MyAdapter myAdapter;
    private ListView listView;
    private TextView tv_nodata;

    @Override
    public View initView() {
        view = (View) View.inflate(context,R.layout.video_info_list,null);
        listView = (ListView) view.findViewById(R.id.lv);
        tv_nodata = (TextView) view.findViewById(R.id.tv_nodata);
        return view;
    }

    @Override
    public void initData() {
        new Thread(){
            @Override
            public void run() {
                videoInfos = new ArrayList<VideoInfo>();
                ContentResolver resolver = context.getContentResolver();
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,//视频名称
                        MediaStore.Video.Media.SIZE,//视频文件大小
                        MediaStore.Video.Media.DATA,//视频播放地址
                        MediaStore.Video.Media.DURATION//视频播放时间
                };
                Cursor cursor = resolver.query(uri, objs, null, null, null);
                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    long size = cursor.getLong(1);
                    String data = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
                    long duration = cursor.getLong(3);
                    videoInfos.add(new VideoInfo(name,size,data,duration));
                }
                cursor.close();
                handler.sendEmptyMessage(0);
            }
        }.start();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            myAdapter = new MyAdapter(context,videoInfos);
            listView.setAdapter(myAdapter);
            if(videoInfos != null){
                tv_nodata.setVisibility(View.GONE);
            }else {
                tv_nodata.setVisibility(View.VISIBLE);
            }

        }
    };

}
