package com.tumma.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tumma.sample.R;
import com.tumma.sample.RecyclerViewClickInterface;
import com.tumma.sample.adapter.VideoFilesAdapter;
import com.tumma.sample.model.VideoFile;
import com.tumma.sample.utils.AppConstants;
import com.tumma.sample.utils.AppUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface {
    RecyclerView recyclerView;
    TextView txtNoFiles;
    FloatingActionButton floatingActionButton;

    private VideoFilesAdapter adapter = null;
    private List<VideoFile> videoFiles = new ArrayList<>();

    RecyclerViewClickInterface recyclerViewClickInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);
        recyclerView = findViewById(R.id.rvVideoGallery);
        txtNoFiles = findViewById(R.id.txtNoFiles);
        floatingActionButton = findViewById(R.id.fab);
        adapter = new VideoFilesAdapter(this,videoFiles);
        recyclerViewClickInterface=(RecyclerViewClickInterface)this;

        videoFiles.clear();
        videoFiles.addAll(AppUtils.listVideoFiles());
        setData(videoFiles);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VideoRecording.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }
    private void setData(List<VideoFile> videoFiles) {
        if (adapter != null && videoFiles != null & videoFiles.size() > 0) {
            //adapter.setAdapterData(videoFiles);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            txtNoFiles.setVisibility(View.GONE);
        }else {
            txtNoFiles.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        VideoFile file = videoFiles.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.OBJECT_FILE, file);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}