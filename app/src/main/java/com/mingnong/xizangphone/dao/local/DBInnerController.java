package com.mingnong.xizangphone.dao.local;

import android.content.Context;

import com.mingnong.xizangphone.MyApplication;


/**
 * 外部数据库控制类
 */
public class DBInnerController
{
    private static DaoMaster daoMasterEcmc;
    
    private static DaoMaster daoMasterSchool;
    
    // 默认DB
    private static DaoSession daoSessionDefault;
    
    // 拷贝的db
    private static DaoSession daoSchoolSession;
    
    public static final String DATABASE_NAME = "inner.db";
    

    private static DaoMaster obtainMaster(Context context, String dbName)
    {
        return new DaoMaster(new DaoMaster.DevOpenHelper(context, dbName, null).getWritableDatabase());
    }
    
    private static DaoMaster getDaoMaster(Context context, String dbName)
    {
        if (dbName == null)
            return null;
        if (daoMasterEcmc == null)
        {
            daoMasterEcmc = obtainMaster(context, dbName);
        }
        return daoMasterEcmc;
    }
    
    private static DaoMaster getSchoolDaoMaster(Context context, String dbName)
    {
        if (dbName == null)
            return null;
        if (daoMasterSchool == null)
        {
            daoMasterSchool = obtainMaster(context, dbName);
        }
        return daoMasterSchool;
    }
    
    /**
     * 取得DaoSession
     *
     * @return
     */
    public static DaoSession getDaoSession(String dbName)
    {
        
        if (daoSchoolSession == null)
        {
            daoSchoolSession = getSchoolDaoMaster(MyApplication.getContext(), dbName).newSession();
        }
        return daoSchoolSession;
    }
    
    /**
     * 默认操作localdata数据库
     */
    public static DaoSession getDaoSession()
    {
        
        if (daoSessionDefault == null)
        {
            daoSessionDefault = getDaoMaster(MyApplication.getContext(), DATABASE_NAME).newSession();
        }
        return daoSessionDefault;
    }

}
