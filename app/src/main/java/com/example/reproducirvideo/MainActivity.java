package com.example.reproducirvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button btPlay;
    VideoView vwPlayer;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPlay = findViewById(R.id.btPlay);
        vwPlayer = findViewById(R.id.vwPlayer);
        mediaController= new MediaController(this);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aleatorio = (int) Math.floor(Math.random() * 2);
                int identificadorRecurso;

                if (aleatorio == 0) {
                    identificadorRecurso = R.raw.saigon;
                } else identificadorRecurso = R.raw.coffee;

                String rutaVideo = "android.resource://com.example.reproducirvideo/" + identificadorRecurso;

                Uri uri = Uri.parse(rutaVideo);

                vwPlayer.setVideoURI(uri);
                vwPlayer.setMediaController(mediaController);
                mediaController.setAnchorView(vwPlayer);
                vwPlayer.start();
            }
        });

        vwPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }
        });

    }
}