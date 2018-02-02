package com.mingnong.xizangphone.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wyw on 2017/5/11.
 */

public class DBManager extends SQLiteOpenHelper {
    private static final String DB_NAME = "picture.db";
    private static final int  VERSION =1;
    private final Context mContext;
    private volatile static DBManager sInstance = null;
    public DBManager(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.mContext = context;
    }

    public static final synchronized DBManager getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new DBManager(context.getApplicationContext());
        }
        return sInstance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        PictureDB.getInstance(mContext).onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        PictureDB.getInstance(mContext).onUpgrade(db,oldVersion,newVersion);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        PictureDB.getInstance(mContext).onDowngrade(db,oldVersion,newVersion);
    }

    public interface DBOperatorListener{
        void onFailure(Exception e);
    }
}
