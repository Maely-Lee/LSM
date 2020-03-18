package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

//db에 넣을 객체 (primaryKey와 RealmObject 상속받음)

public class InsertPage extends RealmObject {

    //TextView mTitleEt, mDescEt; // Edit text
    //ImageView mImageEi; // Edit img

    @PrimaryKey
    String title, desc;
    Bitmap img;

    public String toString(){
        return title;
    }

    public InsertPage(){
        this.title = "NO PAGE HERE";
    }

    public InsertPage(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

//    public int getImg() {
//        return img;
//    }
//
//    public void setImg(int img) {
//        this.img = img;
//    }
}
