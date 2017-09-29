package com.bm3.bankmega.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.bm3.bankmega.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myremote on 9/27/2017.
 */

public class SqliteCRUD {

    ConnectionDb connectionDb;
    Context context;
    //constructor
    public SqliteCRUD(Context context){
        this.context = context;
        connectionDb = new ConnectionDb(context, null, null, 0);
    }
    //save
    public void save(Employee employee){
        try{
            SQLiteDatabase db = connectionDb.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", employee.getName());
            contentValues.put("email", employee.getEmail());
            contentValues.put("address", employee.getAddress());
            db.insert("employee", null, contentValues);
            Toast.makeText(this.context, "save OK", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this.context, "save failed!", Toast.LENGTH_LONG).show();
        }

    }
    //get data
    public List<Employee> getDataEmployee(){
        List<Employee> dataList = new ArrayList<>();
        String sql = "select * from employee";
        SQLiteDatabase db = connectionDb.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        //extract ke list employee
        int iName = cursor.getColumnIndex("name");
        int iAddress = cursor.getColumnIndex("address");
        int iEmail = cursor.getColumnIndex("email");

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            Employee employee = new Employee();
            employee.setName(""+cursor.getString(iName));
            employee.setEmail(""+cursor.getString(iEmail));
            employee.setAddress(""+cursor.getString(iAddress));

            dataList.add(employee);
        }

        return dataList;
    }
    //update
    //delete

}
