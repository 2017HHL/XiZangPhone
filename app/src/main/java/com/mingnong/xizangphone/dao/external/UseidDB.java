package com.mingnong.xizangphone.dao.external;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mingnong.xizangphone.bean.UploadBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyw on 2017/5/19.
 */

public class UseidDB {
    private static volatile UseidDB instance;
    private MyDBHelper manager;

    private UseidDB(Context mContext) {
        manager = MyDBHelper.getInstance(mContext);
    }

    public static UseidDB getInstance(Context mContext) {
        if (instance == null) {
            synchronized (UseidDB.class) {
                if (instance == null) {
                    instance = new UseidDB(mContext);
                }
            }
        }
        return instance;
    }
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PrintInfoColumns.TABLE_NAME);
        onCreate(db);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                PrintInfoColumns.TABLE_NAME + " (" +
                PrintInfoColumns.USER_ID + " CHAR NOT NULL);");
    }

//    public long insert(UploadBean bean) {
//        return insert(bean.getUserId(), bean.getTableName(), bean.getJson());
//    }

    public long insert(String userId) {
        ContentValues values = new ContentValues();
        values.put(PrintInfoColumns.USER_ID,userId);
        return manager.getWritableDatabase().insert(PrintInfoColumns.TABLE_NAME,null,values);
    }

    public List<String> query() {
        List<String> list = new ArrayList<>();
        SQLiteDatabase db = manager.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(PrintInfoColumns.TABLE_NAME, null, null, null, null, null, null, null);
            if (cursor.getCount() == 0) return null;
            if (cursor.moveToFirst()) {
                do {
                    list.add(cursor.getString(cursor.getColumnIndex(PrintInfoColumns.USER_ID)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            return null;
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return list;
    }

    public int delete(String printId) {
        String whereClause = PrintInfoColumns.USER_ID + " = ? ";
        String[] whereArgs = new String[]{printId};
        return manager.getWritableDatabase().delete(PrintInfoColumns.TABLE_NAME, whereClause, whereArgs);
    }

    public interface PrintInfoColumns {
        /* Table name */
        String TABLE_NAME = "user_Id";
        String USER_ID = "user_id";
    }
}
