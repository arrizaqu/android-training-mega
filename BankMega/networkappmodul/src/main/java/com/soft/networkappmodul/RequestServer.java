package com.soft.networkappmodul;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by myremote on 9/29/2017.
 */

public class RequestServer extends AsyncTask<String, Void, String>{

    public final static String url = "http://172.29.129.78:8085/Perumahan/index.php/User_c";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient httpClient = new OkHttpClient();
        String result = "";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        convertToJson(s);
        Log.d("result", "hasil:"+s);
    }

    public void convertToJson(String s){
        try{
            JSONArray jsonArray = new JSONArray(s);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("username");
                String password = jsonObject.getString("password");
                String isAdmin = jsonObject.getString("isAdmin");
                String is_delete_user = jsonObject.getString("is_delete_user");

            }
        } catch (Exception e){}

    }
}






