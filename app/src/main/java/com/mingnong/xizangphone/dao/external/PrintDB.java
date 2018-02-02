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

public class PrintDB {
    private static volatile PrintDB instance;
    private MyDBHelper manager;

    private PrintDB(Context mContext) {
        manager = MyDBHelper.getInstance(mContext);
    }

    public static PrintDB getInstance(Context mContext) {
        if (instance == null) {
            synchronized (PrintDB.class) {
                if (instance == null) {
                    instance = new PrintDB(mContext);
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
                PrintInfoColumns.PRINT_ID + " CHAR NOT NULL," +
                PrintInfoColumns.USER_ID + " CHAR NOT NULL," +
                PrintInfoColumns.TABLE + " CHAR NOT NULL," +
                PrintInfoColumns.UPLOAD_JSON + " CHAR );");
    }

    public long insert(UploadBean bean) {
        return insert(bean.getUserId(), bean.getTableName(), bean.getJson());
    }

    public long insert(String userId,String tableName,String json) {
        ContentValues values = new ContentValues();
        values.put(PrintInfoColumns.PRINT_ID, String.valueOf(System.currentTimeMillis()));
        values.put(PrintInfoColumns.USER_ID,userId);
        values.put(PrintInfoColumns.TABLE,tableName);
        values.put(PrintInfoColumns.UPLOAD_JSON,json);
        return manager.getWritableDatabase().insert(PrintInfoColumns.TABLE_NAME,null,values);
    }

    public List<UploadBean> query() {
        List<UploadBean> list = new ArrayList<>();
        SQLiteDatabase db = manager.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(PrintInfoColumns.TABLE_NAME, null, null, null, null, null, null, null);
            if (cursor.getCount() == 0) return null;
            if (cursor.moveToFirst()) {
                do {
                    UploadBean bean = new UploadBean();
                    bean.setPrintId(cursor.getString(cursor.getColumnIndex(PrintInfoColumns.PRINT_ID)));
                    bean.setTableName(cursor.getString(cursor.getColumnIndex(PrintInfoColumns.TABLE)));
                    bean.setJson(cursor.getString(cursor.getColumnIndex(PrintInfoColumns.UPLOAD_JSON)));
                    bean.setUserId(cursor.getString(cursor.getColumnIndex(PrintInfoColumns.USER_ID)));
                    list.add(bean);
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
        String whereClause = PrintInfoColumns.PRINT_ID + " = ? ";
        String[] whereArgs = new String[]{printId};
        return manager.getWritableDatabase().delete(PrintInfoColumns.TABLE_NAME, whereClause, whereArgs);
    }

    public interface PrintInfoColumns {
        /* Table name */
        String TABLE_NAME = "print_info";

        String PRINT_ID = "print_id";
        String USER_ID = "user_id";
        String TABLE = "table_name";
        String UPLOAD_JSON = "upload_json";

    }
}
