package com.example.saraa.tourguidesantabarbara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        TextView beaches = (TextView) findViewById(R.id.beaches);

        // Set a click listener on that View
        beaches.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, BeachesActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        // Find the View that shows the family category
        TextView othernaturalareas = (TextView) findViewById(R.id.othernaturalareas);

        // Set a click listener on that View
        othernaturalareas.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent familyIntent = new Intent(MainActivity.this, OtherNaturalAreasActivity.class);

                // Start the new activity
                startActivity(familyIntent);
            }
        });

        // Find the View that shows the colors category
        TextView restaurants = (TextView) findViewById(R.id.restaurants);

        // Set a click listener on that View
        restaurants.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent colorsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);

                // Start the new activity
                startActivity(colorsIntent);
            }
        });

        // Find the View that shows the phrases category
        TextView landmarks = (TextView) findViewById(R.id.landmarks);

        // Set a click listener on that View
        landmarks.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, LandmarksActivity.class);

                // Start the new activity
                startActivity(phrasesIntent);
            }
        });

        // Find the View that shows the phrases category
        TextView hotels = (TextView) findViewById(R.id.hotels);

        // Set a click listener on that View
        hotels.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, HotelsActivity.class);

                // Start the new activity
                startActivity(phrasesIntent);
            }
        });
    }
}