package com.nick.bsdiff;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBt1;
    private Button mBt2;
    private String mPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }


    private void assignViews() {
        mBt1 = (Button) findViewById(R.id.bt_1);
        mBt2 = (Button) findViewById(R.id.bt_2);
        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_1:
                Diffutils.generateDiffApk(ApkUtils.extract(this), mPath + "app2.apk", mPath + "app3.patch");
                break;
            case R.id.bt_2:
                Diffutils.mergeDiffApk(ApkUtils.extract(this), mPath + "app1.apk", mPath + "app3.patch");
                break;
        }
    }
}
