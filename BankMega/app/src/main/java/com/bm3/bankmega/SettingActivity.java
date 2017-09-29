package com.bm3.bankmega;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bm3.bankmega.utils.CustomeActivity;


/**
 * Created by myremote on 9/26/2017.
 */

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity", "onCreateSetting");
        setContentView(R.layout.settings);
        CustomeActivity.customeToast(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity", "onStartSetting");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity", "onResumeSetting");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activity", "onRestartSetting");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity", "onPauseSetting");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity", "onStopSetting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activity", "onDestroySetting");
    }
}
