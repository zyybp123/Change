package cn.xysxtzq.audiolibrary.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import cn.xysxtzq.audiolibrary.bean.FileInfo;

import static cn.xysxtzq.audiolibrary.interf.FileType.IMAGE_LIST;
import static cn.xysxtzq.audiolibrary.interf.FileType.VIDEO_LIST;


/**
 * Created by Administrator on 2017/12/14.
 * 从数据库获取出对应类型的文件
 */

public class ScanAllFiles {
    private static final String TAG = "ScanAllFiles";
    /**
     * 文件外部存储Uri
     */
    private static final Uri FILE_URI_EXTERNAL = MediaStore.Files.getContentUri("external");
    /**
     * 文件内部存储Uri
     */
    private static final Uri FILE_URI_INTERNAL = MediaStore.Files.getContentUri("internal");
    /**
     * 视频外部Uri
     */
    private static final Uri VIDEO_URI_EXTERNAL = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    /**
     * 视频内部Uri
     */
    private static final Uri VIDEO_URI_INTERNAL = MediaStore.Video.Media.INTERNAL_CONTENT_URI;
    /**
     * 音频外部Uri
     */
    private static final Uri AUDIO_URI_EXTERNAL = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    /**
     * 音频内部Uri
     */
    private static final Uri AUDIO_URI_INTERNAL = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
    /**
     * 图片外部Uri
     */
    private static final Uri IMAGE_URI_EXTERNAL = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    /**
     * 图片内部Uri
     */
    private static final Uri IMAGE_URI_INTERNAL = MediaStore.Images.Media.INTERNAL_CONTENT_URI;



    /**
     * 获取数据库音频文件
     *
     * @param mContext 上下文
     * @return 返回包装了相关信息的数据实体集合
     */
    public static ArrayList<FileInfo> scanMusicFile(Context mContext) {
        //要查询的参数列表
        String[] columns = {MediaStore.Audio.Media._ID,
                //文件名
                MediaStore.Audio.Media.DISPLAY_NAME,
                //不带扩展名的文件名
                MediaStore.Audio.Media.TITLE,
                //资源时长
                MediaStore.Audio.Media.DURATION,
                //艺术家
                MediaStore.Audio.Media.ARTIST,
                //专辑封面
                MediaStore.Audio.Media.ALBUM,
                //年代
                MediaStore.Audio.Media.YEAR,
                //文件的类型
                MediaStore.Audio.Media.MIME_TYPE,
                //文件大小
                MediaStore.Audio.Media.SIZE,
                //文件的路径
                MediaStore.Audio.Media.DATA};
        //获取对应的游标
        Cursor cursor = mContext.getContentResolver().query(
                //uri路径
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                //要查询的参数
                columns,
                //只查询大小超过1M的音频文件
                "_size>?", new String[]{1024 * 1024 + ""},
                //排序条件
                null);
        ArrayList<FileInfo> fileList = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor
                        .getString(cursor
                                .getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                String type = cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE));

                String data = cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                Log.e(TAG, "Name,Type,data--->" + name + " ," + type + ", " + data);
                FileInfo file = new FileInfo(name, type, data);
                fileList.add(file);

            }
        }
        return fileList;
    }

    /**
     * 返回指定类型的文件
     */
    public ArrayList<FileInfo> scanAllFile(Context mContext, String[] selectionArg) {
        //要查询的列
        String[] columns = new String[]{
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.TITLE,
                MediaStore.Files.FileColumns.DATA,
                MediaStore.Files.FileColumns.MIME_TYPE,
                MediaStore.Files.FileColumns.DATE_MODIFIED,
                MediaStore.Files.FileColumns.SIZE
        };
        //查询SD卡
        Uri uri = MediaStore.Files.getContentUri("external");
        //查询条件的拼接
        //SELECT * FROM Persons WHERE (mime_type) IN ('args[0]','arg[1]')
        //按时间降序排序
        String order = MediaStore.Images.Media.DATE_MODIFIED + " DESC";
        String selections = "";
        if (selectionArg != null) {
            for (String aSelectionArg : selectionArg) {
                if (!TextUtils.isEmpty(aSelectionArg)) {
                    selections = selections + "\'" + aSelectionArg + "\'" + ",";
                }
            }
            if (selections.length() > 1 && selections.endsWith(",")) {
                selections = selections.substring(0, selections.length() - 1);
            }
        }
        String selection = MediaStore.Files.FileColumns.MIME_TYPE + ") IN (" + selections;
        //游标
        Cursor c = null;
        ArrayList<FileInfo> fileList = new ArrayList<>();
        try {
            c = mContext.getContentResolver().query(uri, columns, selection, null, order);
            if (c != null) {
                while (c.moveToNext()) {
                    String fileId = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID));
                    String title = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.TITLE));
                    String data = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA));
                    String type = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE));
                    long dateModify = c.getLong(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATE_MODIFIED));
                    long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE));
                    FileInfo file = new FileInfo(fileId, title, type, data, dateModify, size);
                    fileList.add(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "...文件....数据获取异常....." + e.getMessage());
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return fileList;
    }

    /**
     * 返回指定类型的文件，jpeg,jpg,png
     */
    public ArrayList<FileInfo> scanImageFile(Context mContext) {
        //要查询的列
        String[] columns = new String[]{
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.TITLE,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.MIME_TYPE,
                MediaStore.Images.ImageColumns.DATE_MODIFIED,
                MediaStore.Images.ImageColumns.SIZE
        };
        //查询图片的uri
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        //查询条件
        String selection = MediaStore.Images.Media.MIME_TYPE + "=? or "
                + MediaStore.Images.Media.MIME_TYPE + "=?";
        //按时间排序
        String order = MediaStore.Images.Media.DATE_MODIFIED + " DESC";
        //游标
        Cursor c = null;
        ArrayList<FileInfo> fileList = new ArrayList<>();
        try {
            c = mContext.getContentResolver().query(uri, columns, selection, IMAGE_LIST, order);
            if (c != null) {
                while (c.moveToNext()) {
                    String fileId = c.getString(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID));
                    String title = c.getString(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.TITLE));
                    String data = c.getString(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA));
                    String type = c.getString(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.MIME_TYPE));
                    long dateModify = c.getLong(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATE_MODIFIED));
                    long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.SIZE));
                    FileInfo file = new FileInfo(fileId, title, type, data, dateModify, size);
                    fileList.add(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "....图片...数据获取异常....." + e.getMessage());
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return fileList;
    }

    /**
     * 返回指定类型的文件，mp4,avi,swf,flv
     */
    public ArrayList<FileInfo> scanVideoFile(Context mContext) {
        //要查询的列
        String[] columns = new String[]{
                MediaStore.Video.VideoColumns._ID,
                MediaStore.Video.VideoColumns.TITLE,
                MediaStore.Video.VideoColumns.DATA,
                MediaStore.Video.VideoColumns.MIME_TYPE,
                MediaStore.Video.VideoColumns.DATE_MODIFIED,
                MediaStore.Video.VideoColumns.SIZE
        };
        //查询视频的uri
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        //查询条件
        String selection = MediaStore.Video.Media.MIME_TYPE + "=?";
        //按时间排序
        String order = MediaStore.Video.Media.DATE_MODIFIED + " DESC";
        //游标
        Cursor c = null;
        ArrayList<FileInfo> fileList = new ArrayList<>();
        try {
            c = mContext.getContentResolver().query(uri, columns, selection, VIDEO_LIST, order);
            if (c != null) {
                while (c.moveToNext()) {
                    String fileId = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns._ID));
                    String title = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.TITLE));
                    String data = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.DATA));
                    String type = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.MIME_TYPE));
                    long dateModify = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.DATE_MODIFIED));
                    long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.SIZE));
                    FileInfo file = new FileInfo(fileId, title, type, data, dateModify, size);
                    fileList.add(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "....视频...数据获取异常....." + e.getMessage());
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return fileList;
    }

    private String fileDate = "";
    ArrayList<FileInfo> list = new ArrayList();

    /**
     * 按文件后缀名递归查找某路径下的所有文件
     *
     * @param path 文件夹路径
     */
    private void doSearch(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArray = file.listFiles();
                for (File f : fileArray) {
                    if (f.isDirectory()) {
                        doSearch(f.getPath());
                    } else {
                        if (f.getName().endsWith(".ppt") || f.getName().endsWith(".pptx") || f.getName().endsWith(".docx")
                                || f.getName().endsWith(".xls") || f.getName().endsWith(".doc")) {
                            FileInputStream fis = null;
                            try {
                                fis = new FileInputStream(f);
                                FileInfo detail = new FileInfo(f.getName(), "",
                                        f.getAbsolutePath(), f.lastModified(), f.length());
                                list.add(detail);
                                fileDate += f.getAbsolutePath() + ",";

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
