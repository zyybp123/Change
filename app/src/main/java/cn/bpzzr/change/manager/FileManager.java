package cn.bpzzr.change.manager;

import android.content.Context;

import java.io.File;

/**
 * Created by Administrator on 2018/3/8.
 * 文件管理类
 * 对path的整合
 */

public class FileManager {
    private Context mContext;

    public FileManager(Context mContext) {
        this.mContext = mContext;
    }

    public void getInternalDir(){
        if (mContext != null){
            File filesDir = mContext.getFilesDir();
        }
    }
}
