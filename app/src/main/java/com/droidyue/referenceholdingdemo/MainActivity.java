package com.droidyue.referenceholdingdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String LOGTAG = "MainActivity";
    private Toolbar mToolbar;

    private Handler mHandler = new Handler() {

    };

    private Thread mThread = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(LOGTAG, "run method cause memory leaks");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThread.start();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }


}
