package hsyn.caliskan.listviewexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class ImageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);
        getSupportActionBar().setTitle(Globals.isim);
        new ImageDownloadPush().execute();
    }

    private class ImageDownloadPush extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... values) {
            try {
                return BitmapFactory.decodeStream((InputStream)new URL(Globals.urlResim).getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            ImageView iv = (ImageView)findViewById(R.id.imageView);
            iv.setImageBitmap(result);
        }

    }

}
