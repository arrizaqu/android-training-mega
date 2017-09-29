package com.bm3.bankmega;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bm3.bankmega.R;
import com.bm3.bankmega.entity.Employee;
import com.bm3.bankmega.utils.SqliteCRUD;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myremote on 9/27/2017.
 */

public class DataEntryActivity extends AppCompatActivity implements Validator.ValidationListener {

    SqliteCRUD sqliteCRUD;
    Validator validator;

    @NotEmpty
    EditText textName, textAddress;
    @NotEmpty
    @Email
    EditText textEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);
        sqliteCRUD = new SqliteCRUD(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

        textName = (EditText) findViewById(R.id.textName);
        textAddress = (EditText) findViewById(R.id.textAddress);
        textEmail = (EditText) findViewById(R.id.textEmail);
    }

    public void sendAction(View view){
        Log.d("ceck", ""+view.getId()+", btnSendId"+ R.id.btnSend);
        switch (view.getId()) {
            case R.id.btnSend:

                validator.validate();
                break;
            case R.id.btnView:
                Intent intent = new Intent(this, EmployeeActivity.class);
                startActivity(intent);
                break;
        }
    };

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "validate success", Toast.LENGTH_LONG).show();
        Employee employee = new Employee();
        employee.setName(textName.getText().toString());
        employee.setAddress(textAddress.getText().toString());
        employee.setEmail(textEmail.getText().toString());

        sqliteCRUD.save(employee);
        clearField();
        /*Log.d("result", textName.getText().toString());
        Log.d("result", textAddress.getText().toString());
        Log.d("result", textEmail.getText().toString());*/

        /*
        Employee employee = new Employee();
        employee.setName(textName.getText().toString());
        employee.setEmail(textEmail.getText().toString());
        employee.setAddress(textAddress.getText().toString());

        Employee employee2 = new Employee();
        employee.setName(textName.getText().toString());
        employee.setEmail(textEmail.getText().toString());
        employee.setAddress(textAddress.getText().toString());

        Employee employee3 = new Employee();
        employee.setName(textName.getText().toString());
        employee.setEmail(textEmail.getText().toString());
        employee.setAddress(textAddress.getText().toString());

        bundle.putParcelable("employee", employee);
        List<Employee> listEmp = new ArrayList<>();
        listEmp.add(employee);
        listEmp.add(employee2);
        listEmp.add(employee3);

        bundle.putParcelableArrayList("listEmp", (ArrayList<? extends Parcelable>) listEmp);*/
        /*Bundle bundle = new Bundle();
        bundle.putString("name", textName.getText().toString());
        bundle.putString("address", textAddress.getText().toString());
        bundle.putString("email", textEmail.getText().toString());
        Intent intent = new Intent(this, EmployeeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);*/
    }

    public void clearField(){
        textEmail.setText("");
        textAddress.setText("");
        textName.setText("");
    }
    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for(ValidationError error: errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if(view instanceof EditText){
                ((EditText) view).setError(message);
            }  else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
















