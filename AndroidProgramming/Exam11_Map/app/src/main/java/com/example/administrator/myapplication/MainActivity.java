package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ImageView imageLarge;
    private FrameLayout frameLayout;
    private ToggleButton btnList, btnMap;
 // private List<Light> list;

    private ListView lightList;
    private LightAdapter lightAdapter;

    private LinearLayout mapContainer;
    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);
        btnList = (ToggleButton) findViewById(R.id.btnList);
        btnList.setOnClickListener(buttonClickListener);
        btnMap = (ToggleButton) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(buttonClickListener);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        lightList = (ListView)findViewById(R.id.lightView);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final Light light = (Light)lightAdapter.getItem(position);
                  //light.setImageLarge((getBitmap(light.getImageLargeFileName()))); 파일이름은 굳이 메모리 넣을 필요가 없다

                AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(Void... params) {
                        return  getBitmap(light.getImageLargeFileName());
                    }
                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        imageLarge.setImageBitmap(bitmap);
                    }
                };
                asyncTask.execute();


/*                Thread thread = new Thread() {
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
                */
                //  imageLarge.setImageBitmap(getBitmap(light.getImageLargeFileName())); //메모리는 가지고 있지 않으면서 원하는 작업을 처리한다
                //imageLarge.setImageResource(light.getImageLarge());
                //어댑터 불러오기도 가능
            }
        });

        testAsyncTask();
        fillItems();

        mapContainer = (LinearLayout) findViewById(R.id.mapContainer);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapfragment);
        mapFragment.getMapAsync(this);

        btnList.setChecked(true);
        lightList.setVisibility(View.VISIBLE);
        mapContainer.setVisibility(View.INVISIBLE);

    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == btnList){
                Log.i("mylog", "btnList 클릭");
                btnMap.setChecked(false);
                lightList.setVisibility(View.VISIBLE);
                mapContainer.setVisibility(View.INVISIBLE);
            }else if(v == btnMap){
                Log.i("mylog", "btnMap 클릭");
                btnList.setChecked(false);
                lightList.setVisibility(View.INVISIBLE);
                mapContainer.setVisibility(View.VISIBLE);
            }
        }
    };

    public void testAsyncTask() {
        Log.i("mylog", "1:" + Thread.currentThread().getName());

        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {
                Log.i("mylog", "2:" + Thread.currentThread().getName());
                Log.i("mylog", params[0]);
                Log.i("mylog", params[1]);
                Log.i("mylog", params[2]);

                for(int i=0; i<= 100; i++) {
                    if(i==1) {
                        publishProgress(1);
                    }else if(i==50) {
                        publishProgress(50);
                    }else if(i==100){
                        publishProgress(100);
                    }
                }

                return "작업스레드 결과";
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                Log.i("mylog", "3:" + Thread.currentThread().getName());
                Log.i("mylog", "작업진행정도:" + values[0]);
            }

            @Override
            protected void onPostExecute(String aVoid) {
                Log.i("mylog", "4:" + Thread.currentThread().getName());
                Log.i("mylog", aVoid);
            }
        };
        asyncTask.execute("실행매개값1", "실행매개값2", "실행매개값3");
    }

    public void fillItems() {
        AsyncTask<Void, Void, List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() {
            @Override
            protected List<Light> doInBackground(Void... params) {
                List<Light> list = null;
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
                        while (true) { // 계속 읽는 작업
                            String data = br.readLine(); // 한 행씩 읽겠다
                            if (data == null) break;
                            strJson += data; // 한 행씩 읽은것을 strJson에 저장
                        }
                        br.close();
                        reader.close();
                        is.close();
                        list = parseJson(strJson); // 별도로 메소드 작성이 필요없이 여기서 바로 만들어도 상관이 없다
                    }

                    conn.disconnect();

                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Light> lights) {
                lightAdapter = new LightAdapter(MainActivity.this); // 메인 스레드에서 이것만 실행하게 어떻게 만들까
                lightAdapter.setList(lights);
                lightList.setAdapter(lightAdapter);
                imageLarge.setImageBitmap(lights.get(0).getImageLarge());
            }
        };
        asyncTask.execute();
/*
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
*/
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(37.495140, 127.122240);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("IT벤처타워");
        googleMap.addMarker(markerOptions);
    }
}