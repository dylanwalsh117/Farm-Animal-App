package com.example.animal_farm_app;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewApapter extends RecyclerView.Adapter<MyRecyclerViewApapter.ViewHolder> {
    int count=0;
    private static final String TAG="RecyclerAdapter";
    //list to store aniamls
    List<String> animals;
    //list to store images
    ArrayList<Integer> images;

    public MyRecyclerViewApapter(List<String> animals, ArrayList<Integer> images) {
        //stores animals and images list that are passed from main class
        this.animals = animals;
        this.images=images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i(TAG,"OnCreateViewHolder : " + count++);
        //creates LayoutInflater and returns viewHolder which has rows of recyclerview
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.recyclerview_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //populate rows with images and texts
        holder.textView.setText(animals.get(position));
        holder.imageView.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        //set number of rows
        return 10;
    }


    //onclick action for recycler view.
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {   ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }


        //when row is selected, animal name and image is sent to 2nd activity and second activity starts.
        @Override
        public void onClick(View view) {

            Intent myIntent = new Intent(view.getContext(), Secondactivity.class);
            myIntent.putExtra("Name", animals.get(getAdapterPosition()));
            myIntent.putExtra("image", images.get(getAdapterPosition()));
            view.getContext().startActivity(myIntent);
        }
    }
}
