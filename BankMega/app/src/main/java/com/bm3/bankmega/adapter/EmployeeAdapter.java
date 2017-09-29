package com.bm3.bankmega.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bm3.bankmega.R;
import com.bm3.bankmega.entity.Employee;

import java.util.List;

/**
 * Created by myremote on 9/28/2017.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Context context;
    List<Employee> listEmployee;

    public EmployeeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Employee> listEmployee) {
        super(context, resource, listEmployee);
        this.context = context;
        this.listEmployee = listEmployee;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater =
                (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_employee_layout, parent, false);

        Holder holder = new Holder();
        holder.name =  view.findViewById(R.id.nameEmp);
        holder.address = view.findViewById(R.id.addressEmp);
        holder.email = view.findViewById(R.id.emailEmp);

        holder.name.setText(listEmployee.get(position).getName().toString());
        holder.email.setText(listEmployee.get(position).getEmail().toString());
        holder.address.setText(listEmployee.get(position).getAddress().toString());

        return view;
    }

    class Holder{
        public TextView name;
        public TextView email;
        public TextView address;
    }
}
