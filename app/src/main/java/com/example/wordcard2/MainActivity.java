package com.example.wordcard2;

import android.app.Application;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    public Realm cardrealm;
    List<card>mcards;
    cardadapter mcardadapter;
    ListView mListview;
    public EditText wordEdittext;
    public EditText contentEdittext;
    public ImageView iconImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardrealm = Realm.getDefaultInstance();
        wordEdittext =(EditText)findViewById(R.id.wordEdeit);
        contentEdittext = (EditText)findViewById(R.id.contentEdit);
        iconImageView = (ImageView)findViewById(R.id.iconImageView);
        mListview =(ListView)findViewById(R.id.listView);
        mcards = new ArrayList<card>();
        mcards.add(new card(R.drawable.voice_pict,getString(R.string.voice_title),
                getString(R.string.voice_content),getString(R.string.voice_meaning)));
        mcards.add(new card(R.drawable.sing_pict,getString(R.string.sing_title),
                getString(R.string.sing_content),getString(R.string.sing_meaning)));

        mcardadapter = new cardadapter(this,R.layout.card,mcards);
        mListview.setAdapter(mcardadapter);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        cardrealm.close();
    }

    public void save(final String title,final String updateDate,final String content){
        cardrealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                addword addword = cardrealm.createObject(com.example.wordcard2.addword.class);
                addword.addtitle = title;
                addword.addcontent = content;
            }
        });
    }
    public void create(View view){
        String word = wordEdittext.getText().toString();
        String content = contentEdittext.getText().toString();
        Bitmap image = iconImageView.setImageBitmap(bmp);
        //bmpはアプリからの指定（未実装）//

        //save(word,content,image);
        finish();
    }
    public void setWordList(){
        RealmResults<addword>results = cardrealm.where(addword.class).findAll();
        List<addword>items = cardrealm.copyFromRealm(results);
        cardadapter adapter = new cardadapter(this,R.layout.new_card,items);
        //一旦nullにしている(最後尾)//

        mListview.setAdapter(adapter);
    }
    @Override
    protected void onResume(){
        super.onResume();
        setWordList();
    }
    public void update(View view){
        final addword addword = cardrealm(com.example.wordcard2.addword.class).equalTo
    }

}
