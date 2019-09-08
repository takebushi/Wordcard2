package com.example.wordcard2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<card>mcards;
    cardadapter mcardadapter;
    ListView mListview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview =(ListView)findViewById(R.id.listView);
        mcards = new ArrayList<card>();
        mcards.add(new card(R.drawable.image,getString(R.string.voice_title),
                getString(R.string.voice_content),getString(R.string.voice_meaning)));
        mcards.add(new card(R.drawable.image,getString(R.string.sing_title),
                getString(R.string.sing_content),getString(R.string.sing_meaning)));

        mcardadapter = new cardadapter(this,R.layout.card,mcards);
        mListview.setAdapter(mcardadapter);
    }
}
