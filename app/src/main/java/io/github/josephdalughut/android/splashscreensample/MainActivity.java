package io.github.josephdalughut.android.splashscreensample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the "OPEN SECOND ACTIVITY BUTTON" from our activity's xml layout file (R.layout.activity_main)
        Button openSecondActivityButton = findViewById(R.id.openSecondActivityButton);

        // add an 'onClickListener' to open the second activity once the button is clicked.
        openSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // here, we create a new intent to open the new activity.
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is a toast", Toast.LENGTH_SHORT).show();
            }
        });
    }

}