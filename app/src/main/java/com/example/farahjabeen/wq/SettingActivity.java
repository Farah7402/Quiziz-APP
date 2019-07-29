package com.example.farahjabeen.wq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {


    public static int bkgdchecked = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Setting");
        }

        bkgdMusicoff();
    }

    public void bkgdMusicoff()
    {
        Switch switchMusic = (Switch) findViewById(R.id.switchMusic);
        switchMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton switchMusic, boolean isChecked)
            {
                if(switchMusic.isChecked())
                {
                    bkgdchecked = 0;
                    Toast.makeText(SettingActivity.this,"Background Music ON" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    bkgdchecked = 1;
                    Toast.makeText(SettingActivity.this,"Background Music OFF" +
                            "" , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}






