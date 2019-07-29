package com.example.farahjabeen.wq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView load;
    Animation fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        load=(ImageView) findViewById(R.id.load);

        fromtop=AnimationUtils.loadAnimation(this,R.anim.fromtop);
        load.setAnimation(fromtop);

        Thread thread = new Thread()
        {
            @Override

            public void run()
            {
                try {
                    sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {

                    Intent mainIntent = new Intent(getApplicationContext() ,StartingScreenActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        };

        thread.start();
    }

}
