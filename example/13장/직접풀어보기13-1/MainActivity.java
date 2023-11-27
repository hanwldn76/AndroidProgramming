package com.cookandroid.p13_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ListView listViewMP3;
    Button btnPlay, btnPause, btnStop;
    TextView tvMP3;
    ProgressBar pbMP3;

    ArrayList<String> mp3List;
    String selectedMP3;
    int nowPosition;
    boolean PAUSED = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        tvMP3 = (TextView) findViewById(R.id.tvMP3);
        pbMP3 = (ProgressBar) findViewById(R.id.pbMP3);
        mp3List = new ArrayList<String>();

        final String[] mp3Name = {"song1.mp3", "song2.mp3", "song3.mp3"};
        final Integer[] mp3ID = {R.raw.song1, R.raw.song2, R.raw.song3};

        for(int i = 0; i<mp3Name.length; i++){
            mp3List.add(mp3Name[i]);
        }

        listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);
        listViewMP3.setItemChecked(0, true);

        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMP3 = mp3List.get(i);
                nowPosition = i;
            }
        });
        selectedMP3 = mp3List.get(0);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, mp3ID[nowPosition]);
                mediaPlayer.start();
                btnPlay.setClickable(false);
                btnPause.setClickable(true);
                btnStop.setClickable(true);
                tvMP3.setText("실행중인 음악:"+selectedMP3);
                pbMP3.setVisibility(View.VISIBLE);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PAUSED==false){
                    mediaPlayer.pause();
                    btnPause.setText("이어듣기");
                    PAUSED = true;
                    pbMP3.setVisibility(View.INVISIBLE);
                }else{
                    mediaPlayer.start();
                    PAUSED = false;
                    btnPause.setText("일시정지");
                    pbMP3.setVisibility(View.VISIBLE);
                }
            }
        });

        btnPause.setClickable(false);

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                btnPlay.setClickable(true);
                btnPause.setClickable(false);
                btnStop.setClickable(false);
                tvMP3.setText("실행중인 음악: 없음");
                pbMP3.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}