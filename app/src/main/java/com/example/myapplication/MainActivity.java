package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.RealmModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // create recyclerView in LinearLayout

        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);


        /*Realm.init(this);
        realm = Realm.getDefaultInstance();

        RealmResults<InsertPage> realmResults = realm.where(InsertPage.class).findAllAsync();

        for(InsertPage insertPage : realmResults){
            recipe.add(new InsertPage(insertPage.getTitle(), insertPage.getDesc()));
            myAdapter = new MyAdapter(MainActivity.this, recipe);
            mRecyclerView.setAdapter(myAdapter);

        }*/

        Button buttonInsert = (Button)findViewById(R.id.add_button);
        buttonInsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), InsertPage.class);
                startActivityForResult(intent, 1);
            }
        });


        }

       /* @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode, resultCode, data);

            if(resultCode == RESULT_OK){

                String title = data.getStringExtra("title");
                String desc = data.getStringExtra("desc");
                Toast.makeText(this, title + "," + desc, Toast.LENGTH_SHORT).show();

                realm.beginTransaction();
                model_main = realm.createObject(Model.class);
                model_main.setTitle(title);

                realm.commitTransaction();

                RealmResults<Model> realmResults = realm.where(Model.class)
                        .equalTo("title", title).findAllAsync();

                recipe.add(new Model(title));
                myAdapter = new MyAdapter(MainActivity.this, recipe);
                mRecyclerView.setAdapter(myAdapter);

            }
        }*/



    private ArrayList<Model> getMyList(){

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("#SEVENTEEN");
        m.setDescription("singer : sharon van etten");
        m.setImg(R.drawable.seventeen);
        models.add(m);

        m = new Model();
        m.setTitle("#MOONLIGHT");
        m.setDescription("singer : 92914");
        m.setImg(R.drawable.moonlight);
        models.add(m);

        m = new Model();
        m.setTitle("#BEDROOM TALKS");
        m.setDescription("singer : Fazerdaze");
        m.setImg(R.drawable.bedroom);
        models.add(m);

        m = new Model();
        m.setTitle("#GOODIE BAG");
        m.setDescription("singer : Still Woozy");
        m.setImg(R.drawable.goodie);
        models.add(m);

        m = new Model();
        m.setTitle("#WONDER");
        m.setDescription("singer : ADOY");
        m.setImg(R.drawable.wonder);
        models.add(m);

        m = new Model();
        m.setTitle("#LONG DREAM");
        m.setDescription("singer : sesoneon");
        m.setImg(R.drawable.dream);
        models.add(m);

        return models;
    }

}
