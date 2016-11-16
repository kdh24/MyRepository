package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import static android.R.id.list;

public class SecondActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private Button button2;
    private ListView foodList;
    private List<Food> list;

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
                Food food = list.get(position);
                imageLarge.setImageResource(food.getImageLarge());
            }
        });

        fillItems();
    }

    public void fillItems() {
        list = new ArrayList<>();
        list.add(new Food(R.drawable.food01, R.drawable.food01_large, "푸드1", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food02, R.drawable.food02_large, "푸드2", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food03, R.drawable.food03_large, "푸드3", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food04, R.drawable.food04_large, "푸드4", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food05, R.drawable.food05_large, "푸드5", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));

        list.add(new Food(R.drawable.food01, R.drawable.food01_large, "푸드1", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food02, R.drawable.food02_large, "푸드2", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food03, R.drawable.food03_large, "푸드3", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food04, R.drawable.food04_large, "푸드4", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food05, R.drawable.food05_large, "푸드5", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));

        FoodAdapter foodAdapter = new FoodAdapter(this);
        foodAdapter.setList(list);

        foodList.setAdapter(foodAdapter);
    }

    public void onClickButton1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}