package com.atguigu.mediaplayerwork.bean;

/**
 * Created by HaoMeng on 2017/5/25.
 */

public class VideoInfo {
    private String name;
    private long size;
    private String data;
    private long duration;

    public VideoInfo(String name, long size, String data, long duration) {
        this.name = name;
        this.size = size;
        this.data = data;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", data='" + data + '\'' +
                ", duration=" + duration +
                '}';
    }
}
