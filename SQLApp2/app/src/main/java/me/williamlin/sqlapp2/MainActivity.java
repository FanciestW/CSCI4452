package me.williamlin.sqlapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private MyDataSource datasource;
    EditText rollno, name, marks,searchField;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField=(EditText)findViewById(R.id.searchField);
        rollno=(EditText)findViewById(R.id.rollno);
        name=(EditText)findViewById(R.id.name);
        marks=(EditText)findViewById(R.id.marks);
        textView=(TextView)findViewById(R.id.textView1);
        textView.setMovementMethod(new ScrollingMovementMethod());

        dataBaseCreation();

    }

    void dataBaseCreation(){
        datasource = new MyDataSource(this);
        datasource.open();
    }

    public void onClickInsertStudents(View view){
        datasource.InsertStudent(rollno.getText().toString(),
                name.getText().toString(),marks.getText().toString());
        rollno.setText("");
        name.setText("");
        marks.setText("");
        rollno.setFocusable(true);
    }
    public void onClickDeleteStudents(View view){
        datasource.deleteStudent(
                Long.parseLong(searchField.getText().toString()));
        name.setText("");
        marks.setText("");
        rollno.setFocusable(true);
    }
    public void onClickUpdateStudents(View view){
        datasource.updateStudent(
                Long.parseLong(searchField.getText().toString()),
                rollno.getText().toString(),
                name.getText().toString(),
                marks.getText().toString());
        name.setText("");
        marks.setText("");
        rollno.setFocusable(true);
    }
    public void onClickRetrieveStudent(View view) {
        if( searchField.getText().toString().length()>0) {
            MyData mydata = datasource.retrieveStudent(
                    Long.parseLong(searchField.getText().toString()));
            rollno.setText(mydata.getRollno());
            name.setText(mydata.getName());
            marks.setText(mydata.getMarks());
        }
    }
    public void onClickRetrieveStudents(View view) {
        String result=datasource.retrieveStudents();
        textView.setText(result);
    }


    public void onClickDeleteDatabase(View view){
        datasource.deleteDataBase(this);
        dataBaseCreation();
    }
    public void onClickQuit(View view){
        datasource.close();


    }
    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}

