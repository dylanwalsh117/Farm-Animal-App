package com.example.animal_farm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Secondactivity extends AppCompatActivity {
    //MediaPlayer to play mp3 sound
    MediaPlayer mPlayer;
    //buttons
    Button back,website,sound;
    //TextView to show fun fact
    TextView funfact;
    //ImageView for background image
    ImageView backimage;
    //store wikipedia url about animal
    String url;
    //store mp3 file url
    int mp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        //reference buttons and TextView
        back=findViewById(R.id.back);
        website=findViewById(R.id.website);
        sound=findViewById(R.id.sound);

        funfact=findViewById(R.id.funfact);
        backimage=findViewById(R.id.backimage);

        //Get animal name and image from first screen after user selects from the list
        String name = getIntent().getStringExtra("Name");
        int image=getIntent().getIntExtra("image",0);

        //If else to check for animal name and set funfact, background image, wiki url and mp3 file
        if (name.equals("Cattle"))
        {
            funfact.setText("Cattle stomachs have four chambers which help break down what they eat.");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/Cattle";
            mp3=R.raw.cow;
        }
        else if (name.equals("Sheep"))
        {
            funfact.setText("There are over 1 billion sheep in the world! Adult males are called Rams, whilst adult females are called Ewes");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/Sheep";
            mp3=R.raw.sheep;
        }
        else if (name.equals("Chicken"))
        {
            funfact.setText("Chickens aren't completely flightless—they can get airborne enough to make it over a fence or into a tree");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/Chicken";
            mp3=R.raw.chicken;
        }
        else if (name.equals("Goat"))
        {
            funfact.setText("Goats were one of the first animals to be tamed by humans and were being herded 9,000 years ago.");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/goat";
            mp3=R.raw.goat;
        }
        else if (name.equals("Horse"))
        {
            funfact.setText("Horses have bigger eyes than any other mammal that lives on land");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/horse";
            mp3=R.raw.horse;
        }
        else if (name.equals("Dog"))
        {
            funfact.setText("A Bloodhound's sense of smell can be used as evidence in court.");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/dog";
            mp3=R.raw.dog;
        }
        else if (name.equals("Pig"))
        {
            funfact.setText("A pig's snout is an important tool for finding food in the ground and sensing the world around them.");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/pig";
            mp3=R.raw.pig;
        }

        else if (name.equals("Cat"))
        {
            funfact.setText("Cats are believed to be the only mammals who don't taste sweetness.");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/cat";
            mp3=R.raw.cat;

        }
        else if (name.equals("Duck"))
        {
            funfact.setText("Ducks are mostly aquatic birds living in both fresh water and sea water and found on every continent except for Antarctica.");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/duck";
            mp3=R.raw.duck;
        }
        else if (name.equals("Rabbit"))
        {
            funfact.setText("Happy rabbits practice a cute behavior known as a “binky:” they jump up in the air and twist and spin around!");
            backimage.setImageResource(image);
            url="https://en.wikipedia.org/wiki/rabbit";
            mp3=R.raw.rabbit;
        }




        //back button to go to the main screen when clicked

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Secondactivity.this, MainActivity.class);
                view.getContext().startActivity(myIntent);
            }
        });

        //button to open wiki page with url
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });


        //button to play mp3
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPlayer = MediaPlayer.create(Secondactivity.this,mp3);
                mPlayer.start();
            }
        });
    }
}