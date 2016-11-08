package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("mylog", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mylog", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mylog", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mylog", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mylog", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mylog", "onDestroy()");
    }

    public void onClickBtnSecond(View view){
        Log.i("mylog", "onClickBtnSecond()");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClickBtnThird(View view){
        Log.i("mylog", "onClickBtnThird()");
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}