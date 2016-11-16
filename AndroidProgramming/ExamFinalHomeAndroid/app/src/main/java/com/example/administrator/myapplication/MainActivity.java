package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView lightList;
    private List<Light> list;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);


        lightList = (ListView)findViewById(R.id.lightView);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Light light = list.get(position);
                imageLarge.setImageBitmap(light.getImageLarge());
                //어댑터 불러오기도 가능
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
                    url = new URL("http://192.168.0.50:8080/myandroid/foodList");
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
                        lightList.post(new Runnable() {
                            @Override
                            public void run() {
                                LightAdapter = new FoodAdapter(SecondActivity.this);
                                LightAdapter.setList(list);
                                lightList.setAdapter(LightAdapter);
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
            /*
        list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2", "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large,"인테리어 조명3", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));

        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2", "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명3", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));

        LightAdapter lightAdapter = new LightAdapter(this);
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
    }
    */
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
            url = new URL("http://192.168.0.50:8080/myandroid/getImage?fileName=" + fileName);
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
