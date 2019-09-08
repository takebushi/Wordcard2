package com.example.wordcard2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class cardadapter extends ArrayAdapter<card> {
    List<card> mCards;
    private LayoutInflater layoutInflater;


    public cardadapter(Context context,int layoutResourceId,List<card>objects){
        super(context,layoutResourceId,objects);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mCards = objects;
    }
    
    @Override
    public int getCount(){
        return mCards.size();
    }
    @Override
    public card getItem(int position){
        return mCards.get(position);
    }
    @Override
    public View getView(final int position, View contentView, ViewGroup parent){
        final ViewHolder viewHolder;

        if (contentView == null){
            contentView = LayoutInflater.from(getContext()).inflate(R.layout.card,null);
            viewHolder = new ViewHolder(contentView);
            contentView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)contentView.getTag();
        }
        final card item=getItem(position);

        if (item !=null){
            viewHolder.iconImageView.setBackgroundResource(item.imageID);
            viewHolder.titleTextView.setText(item.title);
            viewHolder.contentTextView.setText(item.content);
            viewHolder.iconImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),item.meaning,Toast.LENGTH_SHORT).show();
                }
            });
        }
        return contentView;
    }
    public static class ViewHolder{
        ImageView iconImageView;
        TextView titleTextView;
        TextView contentTextView;

        public ViewHolder(View view){
            iconImageView =(ImageView)view.findViewById(R.id.icon);
            titleTextView =(TextView)view.findViewById(R.id.title_textview);
            contentTextView =(TextView)view.findViewById(R.id.content);
        }

    }

}
