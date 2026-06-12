package com.example.testexam1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    Boolean isplaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.music);
        SeekBar prg = findViewById(R.id.seekbar);
        prg.setMax(mediaPlayer.getDuration());
        prg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        handler = new Handler();
      runnable = new Runnable() {
          @Override
          public void run() {
              prg.setProgress(mediaPlayer.getCurrentPosition());
              handler.postDelayed(runnable, 1000);
          }
      };

        ImageView btnplay = findViewById(R.id.btnplay);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isplaying == false) {
                    mediaPlayer.start();
                    isplaying = true;
                    btnplay.setImageResource(R.drawable.pause);
                    handler.post(runnable);
                } else {
                    mediaPlayer.pause();
                    isplaying = false;
                    btnplay.setImageResource(R.drawable.play);
                }
            }
        });

    }

}