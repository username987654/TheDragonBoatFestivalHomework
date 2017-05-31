package com.atguigu.mediaplayerwork.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.mediaplayerwork.R;
import com.atguigu.mediaplayerwork.bean.VideoInfo;
import com.atguigu.mediaplayerwork.utils.Utils;

import java.util.ArrayList;

/**
 * Created by HaoMeng on 2017/5/25.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<VideoInfo> videoInfos;
    private Utils utils;

    public MyAdapter(Context context, ArrayList<VideoInfo> videoInfos) {
        this.context = context;
        this.videoInfos = videoInfos;
        utils = new Utils();
    }

    @Override
    public int getCount() {
        return videoInfos == null ? 0 : videoInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return videoInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView  = View.inflate(context, R.layout.video_item,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.video_name);
            viewHolder.videotime = (TextView) convertView.findViewById(R.id.vrdeotime);
            viewHolder.videosize = (TextView) convertView.findViewById(R.id.videosize);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        VideoInfo videoInfo = videoInfos.get(position);
        viewHolder.name.setText(videoInfo.getName());
        viewHolder.videosize.setText(Formatter.formatFileSize(context,videoInfo.getSize()));
        viewHolder.videotime.setText(utils.stringForTime((int) videoInfo.getDuration()));

        return convertView;
    }
    static class ViewHolder{
        TextView name;
        TextView videotime;
        TextView videosize;

    }
}
