package com.example.wordcard2;

import android.os.Bundle;
import android.widget.ImageView;

import io.realm.RealmObject;


public class addword extends RealmObject {
    public int addimageid;
    public String addtitle;
    public String addcontent;
    private final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;
}
