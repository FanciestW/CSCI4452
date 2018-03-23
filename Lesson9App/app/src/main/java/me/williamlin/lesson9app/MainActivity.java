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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button downloadImageBtn;
    private ImageView imageView;
    private TextView captionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView1);
        captionText = (TextView) findViewById(R.id.text_file);
        downloadImageBtn = (Button) findViewById(R.id.MyButton);
        downloadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownload();
            }
        });
    }

    protected void startDownload() {
        DownloadFileAsync downloader = new DownloadFileAsync();
        downloader.execute("http://www.ottophoto.com/kirlian/kirlian_1/kirlian12.jpg");
    }

    private class DownloadFileAsync extends AsyncTask<String, Integer, Drawable> {

        String resp;

        @Override
        protected Drawable doInBackground(String... params) {
            // TODO::Complete
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
            captionText.setText("Getting Image");
        }

        @Override
        protected void onPostExecute(Drawable result) {
            imageView.setImageDrawable(result);
            captionText.setText("Got Image");
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
}
