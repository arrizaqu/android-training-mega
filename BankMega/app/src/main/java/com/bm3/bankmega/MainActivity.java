package com.bm3.bankmega;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bm3.bankmega.entity.Employee;
import com.bm3.bankmega.utils.CustomeActivity;
import com.soft.mapofficelib.MapsActivity;


public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    /*Button btnSetting, btn;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity", "onCreateMain");
        setContentView(R.layout.activity_main);
    }

    //fire event
    public void getActionButton(View view){
        Log.d("log_example", "working!!!");
        if(view.getId() == R.id.btnSetting){
           Toast toast = Toast.makeText(this, "btn setting", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0 , 0);
            toast.show();
        } else if(view.getId() == R.id.btn2){
           // Intent intent = new Intent(this, com.bm3.mapapp.MapsActivity.class);
            // startActivity(intent);
            Toast.makeText(this, "btn", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.btnMap){
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }

        //CustomeActivity.customeToast(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:

                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                    /*Log.d("testMenu", "setting menu");*/
                return true;
            case R.id.accunt :
                // account activity
                Log.d("testMenu", "account menu");
                return true;
            case R.id.logout:
                // logout activity
                Log.d("testMenu", "logout menu");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity", "onStartMain");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity", "onResumeMain");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activity", "onRestartMain");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity", "onPauseMain");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity", "onStopMain");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activity", "onDestroyMain");
    }

    //untuk mentrigger ketika user menekan tombol back
    @Override
    public void onBackPressed() {
        customeDialog();
    }

    public void customeDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure exit ?");
        builder.setTitle("Exit");
        builder.setPositiveButton("Close", this);
        builder.setNegativeButton("Exit", this);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i){
            case -1:
                    finish();
                break;
            case -2:
                    dialogInterface.dismiss();
                break;
        }
        Log.d("position", "ke : "+i);
    }
}
