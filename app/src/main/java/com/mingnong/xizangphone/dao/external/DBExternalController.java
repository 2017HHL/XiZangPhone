package com.mingnong.xizangphone.dao.external;

import android.content.Context;

import com.mingnong.xizangphone.MyApplication;


/**
 * 外部数据库控制类
 */
public class DBExternalController
{
    private static DaoMasterExternal daoMasterEcmc;
    
    private static DaoMasterExternal daoMasterSchool;
    
    // 默认DB
    private static DaoSessionExternal daoSessionDefault;
    
    // 拷贝的db
    private static DaoSessionExternal daoSchoolSession;
    
    /**
     * 默认数据库名称:localdata (从外部获取的) 包含了自己创建的表
     */
    public static final String DATABASE_NAME = "userdata.dbx";
    

    private static DaoMasterExternal obtainMaster(Context context, String dbName)
    {
        return new DaoMasterExternal(new DaoMasterExternal.DevOpenHelper(context, dbName, null).getWritableDatabase());
    }
    
    private static DaoMasterExternal getDaoMaster(Context context, String dbName)
    {
        if (dbName == null)
            return null;
        if (daoMasterEcmc == null)
        {
            daoMasterEcmc = obtainMaster(context, dbName);
        }
        return daoMasterEcmc;
    }
    
    private static DaoMasterExternal getSchoolDaoMaster(Context context, String dbName)
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
    public static DaoSessionExternal getDaoSession(String dbName)
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
    public static DaoSessionExternal getDaoSession()
    {

        if (daoSessionDefault == null)
        {
            daoSessionDefault = getDaoMaster(MyApplication.getContext(), DATABASE_NAME).newSession();
        }
        return daoSessionDefault;
    }

}
