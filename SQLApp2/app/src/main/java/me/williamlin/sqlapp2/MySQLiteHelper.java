package me.williamlin.sqlapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_DATA = "Student";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATA1 = "rollno";
    public static final String COLUMN_DATA2 = "name";
    public static final String COLUMN_DATA3 = "marks";

    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_DATA + "( " + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_DATA1+ " varchar,"

            + COLUMN_DATA2+ " varchar,"

            + COLUMN_DATA3+ " varchar);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    void DeleteDatabase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
        onCreate(db);
    }

}