package com.mingnong.xizangphone.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.mingnong.xizangphone.dao.local.CodeXDDao;
import com.mingnong.xizangphone.dao.local.DaoMaster;
import com.mingnong.xizangphone.dao.local.UnitDao;
import com.mingnong.xizangphone.dao.local.UserDao;


/**
 * Created by wyw on 2017/4/11.
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, UserDao.class, CodeXDDao.class, UnitDao.class);
//        MigrationHelper.migrate(db, UserDao.class, UnitDao.class);

    }
}