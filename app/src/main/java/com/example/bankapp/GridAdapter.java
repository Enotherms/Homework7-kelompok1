package com.example.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] pocketName;
    String[] moneyName;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] pocketName, String[] moneyName) {
        this.context = context;
        this.pocketName = pocketName;
        this.moneyName = moneyName;
    }

    @Override
    public int getCount() {
        return pocketName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        TextView textView = convertView.findViewById(R.id.item_name);
        TextView textView2 = convertView.findViewById(R.id.item_money);

        textView.setText(pocketName[position]);
        textView.setText(moneyName[position]);

        return convertView;
    }
}
