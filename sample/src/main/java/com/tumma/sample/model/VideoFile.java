package com.tumma.sample.model;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoFile implements Parcelable {

    private String name;
    private String path;
    private String extension;

    public VideoFile(String name, String path, String extension ) {
        this.name = name;
        this.path = path;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.path);
        dest.writeString(this.extension);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.path = source.readString();
        this.extension = source.readString();
    }

    protected VideoFile(Parcel in) {
        this.name = in.readString();
        this.path = in.readString();
        this.extension = in.readString();
    }

    public static final Creator<VideoFile> CREATOR = new Creator<VideoFile>() {
        @Override
        public VideoFile createFromParcel(Parcel source) {
            return new VideoFile(source);
        }

        @Override
        public VideoFile[] newArray(int size) {
            return new VideoFile[size];
        }
    };
}
