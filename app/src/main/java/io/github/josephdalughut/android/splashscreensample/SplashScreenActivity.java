package io.github.josephdalughut.android.splashscreensample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*
        A handler allows us to send messages and runnable objects along a thread.

        Put simply, you can use it to run some code using objects like 'Runnable', or to send
        message objects along threads.

        https://developer.android.com/reference/android/os/Handler
         */
        Handler delayNextActivityHandler = new Handler();

        /*
        A 'Runnable' is an object which can contain some action, or bunch of code to run/execute once called
        on a thread.

        Put simply, you can place some code in its 'run()' method, and it will run once the 'Runnable' is
        started/called/triggered by the thread its been added to. You can make use of a 'Handler' to
        post a runnable (add it to a running thread).

        https://developer.android.com/reference/java/lang/Runnable
         */
        Runnable delayNextActivityRunnable = new Runnable() {
            @Override
            public void run() {

                // This code will be run once the runnable is triggered. Here, we create a new intent
                // to our main activity and start it.

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);

                // Here, we call finish to make sure the SplashScreenActivity is destroyed.
                // This is to prevent the user from going back to it when they press the back button on
                // their phone.
                finish();

            }
        };

        // We'll delay moving to the next activity by 1 second
        long oneSecondInMillis = 1000;

        // Use the handler to post the runnable so it's run after 1 minute. When it's run this
        // SplashScreenActivity will open a new MainActivity and then close itself.
        delayNextActivityHandler.postDelayed(delayNextActivityRunnable, oneSecondInMillis);
    }
}