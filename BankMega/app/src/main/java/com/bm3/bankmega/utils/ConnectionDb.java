package com.bm3.bankmega.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by myremote on 9/27/2017.
 */

public class ConnectionDb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="bankmega";
    public static final int DB_VERSION =1;
    public static final String TABLE_NAME = "employee";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
    public static final String SQL_CREATE_TABLE = "CREATE TABLE `employee` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`name`\tTEXT NOT NULL,\n" +
            "\t`address`\tTEXT,\n" +
            "\t`email`\tTEXT UNIQUE\n" +
            ");";

    public ConnectionDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
