package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016-11-15.
 */

public class FoodAdapter extends BaseAdapter {
    List<Food> list;
    public void setList(List<Food> list){
        this.list = list;
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public FoodAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return list.size();  }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.food_item, null);
        }

        //data setting
        Food food = list.get(position);
        ImageView foodImage = (ImageView) convertView.findViewById(R.id.foodImg);
        foodImage.setImageResource(food.getImage());

        TextView foodTitle = (TextView) convertView.findViewById(R.id.foodTitle);
        foodTitle.setText(food.getTitle());

        TextView foodPrice = (TextView) convertView.findViewById(R.id.foodPrice);
        foodTitle.setText(food.getPrice());

        TextView foodContent = (TextView) convertView.findViewById(R.id.foodContent);
        foodTitle.setText(food.getContent());

        return convertView;
    }
}
