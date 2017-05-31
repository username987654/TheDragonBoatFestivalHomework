package com.atguigu.mediaplayerwork;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.atguigu.mediaplayerwork.fragment.Fragment;
import com.atguigu.mediaplayerwork.pager.NetAudioPager;
import com.atguigu.mediaplayerwork.pager.NetVideoPager;
import com.atguigu.mediaplayerwork.pager.locaAudioPager;
import com.atguigu.mediaplayerwork.pager.locaVideoPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;
    private RadioGroup rgmenu;
    private int position;
    private android.support.v4.app.FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgmenu = (RadioGroup) findViewById(R.id.rg_menu);
        setFragmentData();
        rgmenu.setOnCheckedChangeListener(new MyCheckedChamge());

    }
    class MyCheckedChamge implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_loca_video:
                    position = 0;
                    break;
                case R.id.rb_loca_audio:
                    position = 1;
                    break;
                case R.id.rb_net_video:
                    position = 2;
                    break;
                case R.id.rb_net_audio:
                    position = 3;
                    break;
            }
            Fragment fragment = fragments.get(position);
            showPager(fragment);
        }
    }

    Fragment tempFragment;
    private void showPager(Fragment fragment) {
        if(tempFragment != fragment){
            ft = getSupportFragmentManager().beginTransaction();

        }
        if(!fragment.isAdded()){
            if(tempFragment !=null){
                ft.hide(tempFragment);
            }
            ft.add(R.id.fl_frame,fragment);
        }else {
            if(tempFragment != null){
                ft.hide(tempFragment);
            }
            ft.show(fragment);
        }
        tempFragment = fragment;
        ft.commit();
    }


    private void setFragmentData() {
        fragments = new ArrayList<>();
        fragments.add(new locaVideoPager());
        fragments.add(new locaAudioPager());
        fragments.add(new NetVideoPager());
        fragments.add(new NetAudioPager());
    }
}
