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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView lightList;
 // private List<Light> list;
    private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        lightList = (ListView)findViewById(R.id.lightView);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final Light light = (Light)lightAdapter.getItem(position);
                  //light.setImageLarge((getBitmap(light.getImageLargeFileName()))); 파일이름은 굳이 메모리 넣을 필요가 없다
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(light.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);
                            }
                        });
                    }
                };
                thread.start();
                //  imageLarge.setImageBitmap(getBitmap(light.getImageLargeFileName())); //메모리는 가지고 있지 않으면서 원하는 작업을 처리한다
                //imageLarge.setImageResource(light.getImageLarge());
                //어댑터 불러오기도 가능
            }
        });

        fillItems();
    }

    public void fillItems() {
        //HTTP 통신 코드
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.50:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 연결 객체만 얻는다
                    conn.connect();  // connect 해야 연결

                    // 주소가 잘못되면 404 , 서버 에러 500,  정상이 200
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream is = conn.getInputStream(); // 본문에 있는것을 얻으려면
                        Reader reader = new InputStreamReader(is); // 본문이 문자기에 read
                        BufferedReader br = new BufferedReader(reader); // 버퍼를 달았다
                        String strJson = "";
                        while(true) { // 계속 읽는 작업
                            String data = br.readLine(); // 한 행씩 읽겠다
                            if(data == null) break;
                            strJson += data; // 한 행씩 읽은것을 strJson에 저장
                        }
                        br.close(); reader.close(); is.close();
                        final List<Light> list = parseJson(strJson); // 별도로 메소드 작성이 필요없이 여기서 바로 만들어도 상관이 없다
                        lightList.post(new Runnable() { // 이것 좀 넘겨달라는 것 post메소드  메인이 만든 어떤 뷰가 와도 된다(lightList)
                            @Override
                            public void run() {
                                lightAdapter = new LightAdapter(MainActivity.this); // 메인 스레드에서 이것만 실행하게 어떻게 만들까
                                lightAdapter.setList(list);
                                lightList.setAdapter(lightAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                        Log.i("mylog", strJson);
                    }

                    conn.disconnect(); // 연결 해제
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
            }
        };
        thread.start();

    }

    public List<Light> parseJson(String strJson) {
        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson); // 처음에 [] 이기 때문에 Array로 파싱
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i); // {}가 json Object
                Light light = new Light();
                light.setImage(getBitmap(jsonObject.getString("image"))); // 매개변수로 그림파일 이름 = light1.png
                if(i==0) {
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                light.setImageFileName(jsonObject.getString("image"));
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }

        return list;
    }

    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        try {
            URL url = new URL("http://192.168.0.50:8080/myandroid/getImage?fileName=" + fileName);
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