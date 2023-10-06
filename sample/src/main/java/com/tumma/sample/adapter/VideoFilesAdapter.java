package com.tumma.sample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tumma.sample.R;
import com.tumma.sample.model.VideoFile;
import com.tumma.sample.RecyclerViewClickInterface;

import java.util.ArrayList;
import java.util.List;

public class VideoFilesAdapter extends RecyclerView.Adapter<VideoFilesAdapter.ViewHolder> {

    private final RecyclerViewClickInterface recyclerViewClickInterface;
    private List<VideoFile> listData = new ArrayList<>();

    public VideoFilesAdapter(RecyclerViewClickInterface onItemClick,List<VideoFile> listData) {
        this.recyclerViewClickInterface = onItemClick;
        this.listData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.layout_video_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem, recyclerViewClickInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VideoFile fileData = listData.get(position);
            holder.txtName.setText(fileData.getName());
            holder.txtExtension.setText(fileData.getExtension().toUpperCase().replace(".", ""));
            Glide.with(holder.itemView.getContext())
                    .load("file://" + fileData.getPath())
                    .centerCrop()
                    .placeholder(R.drawable.thumbnailimage)
                    .into(holder.imgThumbnail);

       // }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtExtension;
        public ImageView imgThumbnail;

        public ViewHolder(View itemView, RecyclerViewClickInterface recyclerViewClickInterface) {
            super(itemView);
            this.txtName =  itemView.findViewById(R.id.txt_title);
            this.txtExtension =  itemView.findViewById(R.id.txt_format);
            this.imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (recyclerViewClickInterface != null) {
                            recyclerViewClickInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}

