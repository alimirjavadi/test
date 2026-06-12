package com.example.testexam1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ReadMusic();
            } else {
                Toast.makeText(this, "Permision is not granted ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    Handler handler;
    Runnable runnable;
    Boolean isplaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String permision;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permision = Manifest.permission.READ_MEDIA_AUDIO;
        } else {
            permision = Manifest.permission.READ_EXTERNAL_STORAGE;
        }

        if (ContextCompat.checkSelfPermission(this, permision) == PackageManager.PERMISSION_GRANTED) {
            ReadMusic();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permision}, 100);
        }

    }

    public MediaPlayer mediaPlayer;


    public void ReadMusic() {
        if (getIntent().getData() != null) {
            Uri uri = getIntent().getData();
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(this, uri);
                mediaPlayer.prepare();
                mediaPlayer.start();

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
                handler.post(runnable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}