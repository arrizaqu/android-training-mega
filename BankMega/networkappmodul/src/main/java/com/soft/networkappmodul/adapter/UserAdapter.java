package com.soft.networkappmodul.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.soft.networkappmodul.R;
import com.soft.networkappmodul.User;

import java.util.List;

/**
 * Created by myremote on 9/30/2017.
 */

public class UserAdapter extends ArrayAdapter<User> {
    Context context;
    List<User> listUser;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        listUser = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_user_adapter, parent, false);
        Holder holder = new Holder();
        //get textview descript from xml
        holder.textUsername = (TextView) view.findViewById(R.id.textUsername);
        holder.textPassword = (TextView) view.findViewById(R.id.textPassword);

        //set value to textview component
        holder.textUsername.setText(listUser.get(position).getName());
        holder.textPassword.setText(listUser.get(position).getPassword());
        return view;
    }

    class Holder {
        TextView textUsername;
        TextView textPassword;
    }
}
