package com.bm3.bankmega;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bm3.bankmega.adapter.EmployeeAdapter;
import com.bm3.bankmega.entity.Employee;
import com.bm3.bankmega.utils.SqliteCRUD;

import java.util.List;


/**
 * Created by myremote on 9/27/2017.
 */

public class EmployeeActivity extends AppCompatActivity{

    SqliteCRUD sqliteCRUD;
    List<Employee> listEmployee;
    ListView listViewEmp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_layout); //view group
        listViewEmp = (ListView) findViewById(R.id.listViewEmp);
        /*String[] dataArray = {
            "jakarta", "bandung", "jogjakarta"
        };
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataArray);
        listViewEmp.setAdapter(adapter);
*/

        sqliteCRUD = new SqliteCRUD(this);
       /* Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String address = bundle.getString("address");
        String email = bundle.getString("email");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setEmail(email);*/
        //Employee employee = (Employee)bundle.getParcelable("employee");
       // this.save(employee);
        listEmployee = sqliteCRUD.getDataEmployee();
        EmployeeAdapter eAdapter = new EmployeeAdapter(this, R.layout.row_employee_layout, listEmployee);
        listViewEmp.setAdapter(eAdapter);
        /*TextView textView = new TextView(this);
        textView.setText("name : "+ name);
        setContentView(textView);
        Toast.makeText(this, "name : "+ name, Toast.LENGTH_LONG).show();*/
        registerForContextMenu(listViewEmp);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
    }

    public void save(Employee employee){
        sqliteCRUD.save(employee);
    }
}
