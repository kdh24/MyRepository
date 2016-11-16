package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import static android.R.attr.textColorSecondaryInverseNoDisable;
import static android.R.id.list;

public class SecondActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private Button button2;
    private ListView foodList;
    private List<Food> list;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        foodList = (ListView) findViewById(R.id.foodView);
        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Food food = (Food)foodAdapter.getItem(position);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(food.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);
                            }
                        });
                    }
                };
                thread.start();
            }
        });

        fillItems();
    }

    public void fillItems() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("http://192.168.0.46:8080/myandroid/foodList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(reader);
                        String strJson = "";
                        while(true){
                            String data = br.readLine();
                            if(data == null) break;
                            strJson += data;
                        }
                        br.close(); reader.close(); is.close();
                        final List<Food> list = parseJson(strJson);
                        foodList.post(new Runnable() {
                            @Override
                            public void run() {
                                foodAdapter = new FoodAdapter(SecondActivity.this);
                                foodAdapter.setList(list);
                                foodList.setAdapter(foodAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                        Log.i("mylog", strJson);
                    }


                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
            }
        };
        thread.start();
    }

    public List<Food> parseJson(String strJson){
        List<Food> list = new ArrayList<>();

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(strJson);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Food food = new Food();
                food.setImage(getBitmap(jsonObject.getString("image")));
                if(i==0){
                    food.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                food.setImageFileName(jsonObject.getString("image"));
                food.setImageLargeFileName(jsonObject.getString("imageLarge"));
                food.setTitle(jsonObject.getString("title"));
                food.setContent(jsonObject.getString("content"));
                list.add(food);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }
        return list;
    }

    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        URL url = null;
        try {
            url = new URL("http://192.168.0.46:8080/myandroid/getImage?fileName=" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
            }

            conn.disconnect();
        } catch (Exception e) {
            Log.i("mylog", e.getMessage());
        }
        return bitmap;
    }
}