package me.williamlin.lesson9app;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button downloadImageBtn;
    private Button downloadTextBtn;
    private ImageView imageView;
    private TextView captionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView1);
        captionText = (TextView) findViewById(R.id.text_file);
        downloadImageBtn = (Button) findViewById(R.id.MyButton);
        downloadTextBtn = (Button) findViewById(R.id.MyButton2);
        downloadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startImageDownload();
            }
        });
        downloadTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextDownload();
            }
        });
    }

    protected void startImageDownload() {
        DownloadFileAsync downloader = new DownloadFileAsync();
        downloader.execute("http://www.ottophoto.com/kirlian/kirlian_1/kirlian12.jpg");
    }

    protected void startTextDownload() {
        DownloadTextAsync downloader = new DownloadTextAsync();
        downloader.execute("https://raw.githubusercontent.com/FanciestW/CSCI4547/master/quote.txt");
    }

    private class DownloadFileAsync extends AsyncTask<String, Integer, Drawable> {

        String resp;

        @Override
        protected Drawable doInBackground(String... params) {
            Drawable draw = null;
            try {
                draw = DownloadDrawable(params[0], "image.jpg");
            } catch (IOException e) {
                Log.d("Error", e.getMessage().toString());
            }

            resp = "This is an Image";
            return draw;
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Getting image", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Drawable result) {
            imageView.setImageDrawable(result);
            Toast.makeText(getApplicationContext(), "Successfully got image", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

        }

        Drawable DownloadDrawable(String url, String srcName) throws IOException {
            InputStream is = ((InputStream) new URL(url).getContent());
            Drawable draw = Drawable.createFromStream(is, srcName);
            return draw;
        }

    }

    private class DownloadTextAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return DownloadText(params[0]);
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Getting caption", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String result) {
            captionText.setText(result);
            Toast.makeText(getApplicationContext(), "Successfully got caption", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

        }

        String DownloadText(String urlPath) {
            BufferedInputStream in = null;
            String result = "";

            try {
                URL url = new URL(urlPath);

                in = new BufferedInputStream(url.openStream());

                byte data[] = new byte[1024];
                int count;
                // we read until we meet the byte -1
                while((count = in.read(data, 0, 1024)) != -1){
                    // this converts byte-s into string
                    String s = new String(data);
                    result += s;
                }
            } catch (Exception e) {
                Log.d("Error", e.getMessage());
            }

            return result;
        }
    }
}
