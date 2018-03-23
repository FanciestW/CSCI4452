package me.williamlin.asyncapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonRun, buttonCancel;
    private EditText time;
    private TextView finalResult;
    private ProgressBar progressBar;
    AsyncTaskRunner runner; // Create class AsyncTaskRunner that extends AsyncTask

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar) findViewById(R.id.determinateBar);
        time = (EditText) findViewById(R.id.in_time);
        buttonRun = (Button) findViewById(R.id.btn_run);
        buttonCancel = (Button) findViewById(R.id.btn_cancel);
        finalResult = (TextView) findViewById(R.id.tv_result);

        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runner = new AsyncTaskRunner();
                String sleepTime = time.getText().toString();
                int time = Integer.parseInt(sleepTime) * 1000;
                runner.execute(time);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runner.cancel(false);
            }
        });
    }

    private class AsyncTaskRunner extends AsyncTask<Integer, Integer, String> {

        private String resp;
        private boolean processFinish = true;

        @Override
        protected String doInBackground(Integer... params) {
            try {
                long totalSize = 0;
                while(totalSize <= 100) {
                    Thread.sleep(params[0] / 10);
                    publishProgress((int) (totalSize));
                    totalSize += 10;
                    if (isCancelled()) {
                        processFinish = false;
                        break;
                    }
                }

                if(processFinish == false) resp = "Cancelled";
                else resp = "Slept for " + (double) params[0] / 1000 / 10 + " milliseconds 10 times";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onPreExecute() {
            finalResult.setText("Wait for ....." + time.getText() + " seconds");
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            finalResult.setText(result);
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            progressBar.setProgress(progress[0]);
        }

        @Override
        protected void onCancelled(String result) {
            finalResult.setText(result);
        }

    }
}
