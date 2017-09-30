package com.soft.networkappmodul;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.soft.networkappmodul.adapter.UserAdapter;
import com.soft.networkappmodul.network.RequestServer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;
    ListView listViewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewUser = (ListView) findViewById(R.id.listUser);
        progressDialog = new ProgressDialog(this);
        new JobRequest().execute();
    }

    public void setAdapterWaitingFromLoadingServer(String data){
        List<User> listUser = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for(int i =0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("username");
                String password = jsonObject.getString("password");
                String isAdmin = jsonObject.getString("isAdmin");
                String isDeleteUser = jsonObject.getString("is_delete_user");

                User user = new User(id, name, password, isAdmin, isDeleteUser);
                listUser.add(user);
            }

            //set to adapter listview
            UserAdapter uAdapter = new UserAdapter(this, R.layout.row_user_adapter, listUser);
            listViewUser.setAdapter(uAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class JobRequest extends AsyncTask<Void, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("waiting data form server..");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            return RequestServer.execute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setAdapterWaitingFromLoadingServer(s);
            progressDialog.dismiss();
        }
    }

}
