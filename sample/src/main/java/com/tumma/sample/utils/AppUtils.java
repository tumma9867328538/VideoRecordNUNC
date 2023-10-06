package com.tumma.sample.utils;

import android.os.Environment;


import com.tumma.sample.model.VideoFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    public static List<VideoFile> listVideoFiles() {
        List<VideoFile> videoFiles = new ArrayList<>();
        File downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        if (downloadDirectory != null && downloadDirectory.isDirectory()) {
            File[] files = downloadDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (isVideoFile(file)) {
                        videoFiles.add(new VideoFile(file.getName(),
                                file.getAbsolutePath(), AppUtils.getFileExtension(file)));
                    }
                }
            }
        }
        return videoFiles;
    }

    public static boolean isVideoFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".mp4") || name.endsWith(".3gp") || name.endsWith(".mkv") || name.endsWith(".avi") || name.endsWith(".mov") || name.endsWith(".wmv");
    }


    public static String getFileExtension(File file) {
        return file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("."));
    }

    public static boolean isIndexExist(List list, int index) {
        if (list != null) {
            if (index >= list.size() || index < 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
