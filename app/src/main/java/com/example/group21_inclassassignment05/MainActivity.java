package com.example.group21_inclassassignment05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tv_searchKeyword;
    Button btn_go;
    ImageView iv_image;
    ImageView iv_prev;
    ImageView iv_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_searchKeyword = findViewById(R.id.tv_searchKeyword);
        btn_go = findViewById(R.id.btn_go);
        iv_image = findViewById(R.id.iv_image);
        iv_prev = findViewById(R.id.iv_prev);
        iv_next = findViewById(R.id.iv_next);

        tv_searchKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("result",isConnected()+"");
                new GetTextAsync().execute("http://dev.theappsdr.com/apis/photos/keywords.php");
            }
        });
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI) ||
                (networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
            return false;
        }
        return true;
    }

    public class GetTextAsync extends AsyncTask<String, Integer, Double> {
        @Override
        protected void onPreExecute() {
            Log.d("demo","Its Here");
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
        }
        @Override
        protected Double doInBackground(String... strings) {
           HttpURLConnection connection=null;
            Log.d("result",strings[0]);
            try {
               URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                Log.d("result",isConnected()+"");

               // if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                   // String result = IOUtils.toString(connection.getInputStream(), "UTF8");
                    //Log.d("result",result);
              // }

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}

