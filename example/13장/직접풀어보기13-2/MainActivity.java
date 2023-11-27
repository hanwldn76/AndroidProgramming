package com.cookandroid.project13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    SeekBar pbMP3;
    Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbMP3 = (SeekBar) findViewById(R.id.pbMP3);

        switch1 = (Switch)findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switch1.isChecked()==true){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song1);
                    mediaPlayer.start();
                    makeTread();
                }else{
                    mediaPlayer.stop();
                }
            }
        });
        pbMP3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
    void makeTread(){
        new Thread(){
            @Override
            public void run() {
                while(mediaPlayer.isPlaying()){
                    pbMP3.setMax(mediaPlayer.getDuration());
                    pbMP3.setProgress(mediaPlayer.getCurrentPosition());
                    SystemClock.sleep(100);
                }
                pbMP3.setProgress(0);
            }
        }.start();
    }
}
