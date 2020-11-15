package com.example.animal_farm_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerViewApapter myRecyclerViewApapter;
    List<String> animals;
    ArrayList<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animals=new ArrayList<String>();
        images=new ArrayList<Integer>();
        recyclerView=findViewById(R.id.recyclerView);
        animals.add("Cattle");
        animals.add("Sheep");
        animals.add("Chicken");
        animals.add("Goat");
        animals.add("Horse");
        animals.add("Dog");
        animals.add("Pig");
        animals.add("Cat");
        animals.add("Duck");
        animals.add("Rabbit");

        images.add(R.drawable.cattle);
        images.add(R.drawable.sheep);
        images.add(R.drawable.chicken);
        images.add(R.drawable.goat);
        images.add(R.drawable.horse);
        images.add(R.drawable.dog);
        images.add(R.drawable.pig);
        images.add(R.drawable.cat);
        images.add(R.drawable.duck);
        images.add(R.drawable.rabbit);
        myRecyclerViewApapter =new MyRecyclerViewApapter(animals,images);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myRecyclerViewApapter);


        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


    }
}