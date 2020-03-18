package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models; // this array lis create a list of array which parameters define in model class

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null); // this line inflate our row

        return new MyHolder(view); // this will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {

        holder.mTitle.setText(models.get(position).getTitle());
        holder.mDes.setText(models.get(position).getDescription());
        holder.mImgView.setImageResource(models.get(position).getImg());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String gTitle = models.get(position).getTitle();
                String gDesc = models.get(position).getDescription(); // these object get data from previous activity
                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImgView.getDrawable(); // this will get image from drawable

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream); // it will compress image

                byte[] bytes = stream.toByteArray();

                // get our data with intent
                Intent intent = new Intent(c, AnotherActivity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc); // get data and put in intent
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
