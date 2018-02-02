package com.mingnong.xizangphone.dao.external;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.DatabaseOpenHelper;

/**
 * Created by wyw on 2017/5/19.
 */

public class MyDBHelper extends DatabaseOpenHelper {
    public static final String DB_NAME = "store.db";
    public static final int DB_VERSION = 1;
    private Context mContext;
    private volatile static MyDBHelper sInstance = null;
    public MyDBHelper(Context context) {
        super(context, DB_NAME, DB_VERSION);
        this.mContext = context;
    }
    public static final synchronized MyDBHelper getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new MyDBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        PrintDB.getInstance(mContext).onCreate(db);
        DownloadDB.getInstance(mContext).onCreate(db);
        UseidDB.getInstance(mContext).onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        PrintDB.getInstance(mContext).onUpgrade(db,oldVersion,newVersion);
        DownloadDB.getInstance(mContext).onUpgrade(db,oldVersion,newVersion);
        UseidDB.getInstance(mContext).onUpgrade(db,oldVersion,newVersion);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        PrintDB.getInstance(mContext).onDowngrade(db,oldVersion,newVersion);
        DownloadDB.getInstance(mContext).onDowngrade(db,oldVersion,newVersion);
        UseidDB.getInstance(mContext).onDowngrade(db,oldVersion,newVersion);
    }
}
