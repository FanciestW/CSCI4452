package me.williamlin.sqlapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class MyDataSource {
    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_DATA1, MySQLiteHelper.COLUMN_DATA2,MySQLiteHelper.COLUMN_DATA3};

    public MyDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    void InsertStudent(String value1, String value2, String value3){
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_DATA1, value1);
        values.put(MySQLiteHelper.COLUMN_DATA2,value2);
        values.put(MySQLiteHelper.COLUMN_DATA3,value3);
        long insertId = database.insert(MySQLiteHelper.TABLE_DATA, null,values);
    }
    public void deleteStudent(long id1) {
        long id = id1;
        database.delete(MySQLiteHelper.TABLE_DATA, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }
    public void updateStudent(long id1,
                              String value1,String value2, String value3) {
        long id = id1;
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_DATA1, value1);
        values.put(MySQLiteHelper.COLUMN_DATA2,value2);
        values.put(MySQLiteHelper.COLUMN_DATA3,value3);

        database.update(MySQLiteHelper.TABLE_DATA,
                values,MySQLiteHelper.COLUMN_ID+"="+id1, null);
    }
    public MyData retrieveStudent(long id1) {
        long id = id1;
        Cursor cursor = database.query(MySQLiteHelper.TABLE_DATA,
                allColumns, null, null,
                null, null, null);
        MyData newData=null;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            newData = cursorToData(cursor);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return newData;
    }
    public String retrieveStudents() {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_DATA,
                allColumns, null, null,
                null, null, null);
        MyData newData=null;
        String result="";
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            newData = cursorToData(cursor);
            result+=newData.getId()+" "+newData.getRollno()+" "+newData.getName()+" "+newData.getMarks()+"\n";
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return result;
    }

    private MyData cursorToData(Cursor cursor) {
        MyData mydata = new MyData();
        mydata.setId(cursor.getLong(0));
        mydata.setRollno(cursor.getString(1));
        mydata.setName(cursor.getString(2));
        mydata.setMarks(cursor.getString(3));
        return mydata;
    }

    public void close() {
        dbHelper.close();
    }

    public void deleteDataBase(Context context) {
        dbHelper.DeleteDatabase(context);
    }
}

