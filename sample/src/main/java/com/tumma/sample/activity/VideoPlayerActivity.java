package com.tumma.sample.activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.tumma.sample.R;
import com.tumma.sample.model.VideoFile;
import com.tumma.sample.utils.AppConstants;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class VideoPlayerActivity extends AppCompatActivity {

    VideoFile file;
    Bundle bundle=null;

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
         bundle = getIntent().getExtras();
        file = bundle.getParcelable(AppConstants.OBJECT_FILE);
        Log.e("filefilefile", String.valueOf(file));
        init();

    }

    private void init() {
         videoView =(VideoView)findViewById(R.id.vdVw);

        if (bundle != null) {
            if (file != null) {
                Uri mediaUri = Uri.parse("file://" + file.getPath());
                MediaController mediaController= new MediaController(this);
                mediaController.setAnchorView(videoView);
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(mediaUri);
                videoView.requestFocus();
                videoView.start();
            }
        }

    }

    @Override
    public void onBackPressed() {
        finish();
//       if (videoView.isPlaying()){
//           Toast.makeText(this, "video is playing..", Toast.LENGTH_SHORT).show();
//       }else {
//           onBackPressed();
//       }
    }
}