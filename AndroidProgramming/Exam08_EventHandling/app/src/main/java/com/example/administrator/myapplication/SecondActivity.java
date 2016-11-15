package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        itemContainer = (LinearLayout)findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();
        fillItems();
    }

    public void fillItems() {

        int[] arrImage = {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };

        String[] arrTitle = {
                "Name1",
                "Name2",
                "Name3",
                "Name4",
                "Name5"
        };

        String[] arrPrice= {
                "35,000",
                "35,000",
                "35,000",
                "35,000",
                "35,000"
        };

        String[] arrContent = {
                "어쩌구 저쩌구1",
                "어쩌구 저쩌구2",
                "어쩌구 저쩌구3",
                "어쩌구 저쩌구4",
                "어쩌구 저쩌구5"
        };
        for (int i = 0; i < 5; i++) {
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.food_item, null);

            ImageView foodImg = (ImageView) itemLayout.findViewById(R.id.foodImg);
            foodImg.setImageResource(arrImage[i]);

            TextView foodTitle = (TextView) itemLayout.findViewById(R.id.foodTitle);
            foodTitle.setText(arrTitle[i]);

            TextView foodPrice = (TextView) itemLayout.findViewById(R.id.foodPrice);
            foodTitle.setText(arrPrice[i]);

            TextView foodContent = (TextView) itemLayout.findViewById(R.id.foodContent);
            foodTitle.setText(arrContent[i]);

            itemContainer.addView(itemLayout);

        }
    }
}
