package com.soft.networkappmodul.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by myremote on 9/30/2017.
 */

public class RequestServer {

    public static final String URL_SERVER = "http://172.29.129.78:8085/Perumahan/index.php/User_c";

    public static String execute(){
        OkHttpClient httpClient = new OkHttpClient();
        String result = "";
        Request request = new Request.Builder()
                .url(URL_SERVER)
                .get()
                .build();
        try {
            //Response response = httpClient.newCall(request).execute();
            // result = response.body().string();

            result = "" +
                    "[{'id':'4','username':'2222','password':'7cd24a3933af3d7asdfca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'5','username':'234','password':'7cd24a3933af3d7ca8629fafarg1ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'6','username':'2223452','password':'7cfasdfd24a3933af3d7ca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'7','username':'22wer22','password':'7cd2safds4a3933af3d7ca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'8','username':'23465s222','password':'dsf7cd24a3933af3d7ca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'9','username':'22sdgfdf22','password':'fs7cd24a3933af3d7ca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'0','username':'22ryui22','password':'fs7fcds24a3933af3d7ca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}," +
                    "{'id':'4','username':'222rte2','password':'fsd7cd24a3933af3d7ca86291ad6c3cc1b14adcc9b5','isAdmin':'0','is_delete_user':'0'}]";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

