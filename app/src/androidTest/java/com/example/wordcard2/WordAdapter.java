package com.example.wordcard2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<addword> {
    public LayoutInflater layoutInflater;
    WordAdapter(Context context, int textViewResourceId, List<addword> objects){
        super(context,textViewResourceId,objects);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parant){
        addword addword = getItem(position);
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.card,null);
        }
        TextView wordText = (TextView)convertView.findViewById(R.id.wordEdeit);
        TextView meanText = (TextView)convertView.findViewById(R.id.contentEdit);
        //ImageView iconimage = (ImageView)convertView.findViewById(R.id.iconImageView);
        wordText.setText(addword.addtitle);
        meanText.setText(addword.addcontent);
        //iconimage.setImageResource(addword);//

        return convertView;

    }
}
