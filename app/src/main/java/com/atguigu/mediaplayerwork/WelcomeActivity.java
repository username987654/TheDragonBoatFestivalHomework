package com.atguigu.mediaplayerwork;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wlecome);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();

            }
        }, 2000);
    }

    Handler handler = new Handler();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        handler.removeCallbacksAndMessages(null);
        startMainActivity();
        return true;
    }

    private void startMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
        super.onDestroy();
    }
}
