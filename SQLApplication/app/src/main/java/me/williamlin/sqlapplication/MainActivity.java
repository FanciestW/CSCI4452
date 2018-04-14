package me.williamlin.sqlapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText rollno, name, marks;
    TextView textView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollno=(EditText)findViewById(R.id.rollno);
        name=(EditText)findViewById(R.id.name);
        marks=(EditText)findViewById(R.id.marks);
        textView=(TextView)findViewById(R.id.textView1);

        textView=(TextView)findViewById(R.id.textView1);
        textView.setMovementMethod(new ScrollingMovementMethod());

        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");
    }

    public void onClickInsertStudents(View view){
        db.execSQL("INSERT INTO student VALUES('"+rollno.getText()+"','"+name.getText()+"','"+marks.getText()+"');");
        rollno.setText("");
        name.setText("");
        marks.setText("");
    }

    public void onClickDeleteStudents(View view){
        db.execSQL("DELETE FROM student WHERE rollno='"+rollno.getText()+"'");
    }

    public void onClickRetrieveStudent(View view) {
        String query=
                "SELECT * FROM student WHERE rollno='"+rollno.getText()+"'";
        Cursor c=db.rawQuery(query, null);
        if(c.moveToFirst())
        {
            name.setText(c.getString(1));
            marks.setText(c.getString(2));
        }
    }

    public void onClickUpdateStudents(View view){
        db.execSQL("UPDATE student SET name='"+name.getText()+"', marks='"+marks.getText()+"' WHERE rollno='"+rollno.getText()+"'");
    }

    public void onClickRetrieveStudents(View view) {
        Cursor c = db.rawQuery("SELECT * FROM student", null);
        if (c.getCount() == 0) {
            textView.setText("Error, No records found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append("Rollno: " + c.getString(0) + "\n");
            buffer.append("Name: " + c.getString(1) + "\n");
            buffer.append("Marks: " + c.getString(2) + "\n\n");
        }
        textView.setText(buffer.toString());
    }

    public void onClickDeleteDatabase(View view){
        this.deleteDatabase("StudentDB");
    }


}
