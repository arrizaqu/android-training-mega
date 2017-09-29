package com.bm3.bankmega.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bm3.bankmega.R;

/**
 * Created by myremote on 9/26/2017.
 */

public class CustomeActivity {

    /*private Activity context;
    public CustomeActivity(Activity context){
        this.context = context;
    }*/

    public static void customeToast(Activity context){

        //mengambil layout custome_toast.xml
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custome_toast, (ViewGroup) context.findViewById(R.id.myToast));

        Toast toast = new Toast(context);
//        Toast.makeText(this, "haloo", Toast.LENGTH_LONG );
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
}
