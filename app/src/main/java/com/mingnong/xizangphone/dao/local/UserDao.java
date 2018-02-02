package com.mingnong.xizangphone.dao.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.mingnong.xizangphone.dao.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "User".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "User";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CId = new Property(0, Long.class, "cId", true, "_id");
        public final static Property USERID = new Property(1, int.class, "USERID", false, "userId");
        public final static Property FSGUIDID = new Property(2, String.class, "FSGUIDID", false, "FSGUIDID");
        public final static Property FSCTIME = new Property(3, String.class, "FSCTIME", false, "FSCTIME");
        public final static Property FSUTIME = new Property(4, String.class, "FSUTIME", false, "FSUTIME");
        public final static Property FSUSERID = new Property(5, int.class, "FSUSERID", false, "FSUSERID");
        public final static Property FSUSERNAME = new Property(6, String.class, "FSUSERNAME", false, "FSUSERNAME");
        public final static Property FSUNITID = new Property(7, int.class, "FSUNITID", false, "FSUNITID");
        public final static Property FSUNITUSTRID = new Property(8, String.class, "FSUNITUSTRID", false, "FSUNITUSTRID");
        public final static Property FSUNITNAME = new Property(9, String.class, "FSUNITNAME", false, "FSUNITNAME");
        public final static Property FSENTERPRISEID = new Property(10, int.class, "FSENTERPRISEID", false, "FSENTERPRISEID");
        public final static Property FSENTERPRISENAME = new Property(11, String.class, "FSENTERPRISENAME", false, "FSENTERPRISENAME");
        public final static Property FSAUDIT = new Property(12, String.class, "FSAUDIT", false, "FSAUDIT");
        public final static Property FSREVIEWER = new Property(13, String.class, "FSREVIEWER", false, "FSREVIEWER");
        public final static Property FSMEMO1 = new Property(14, String.class, "FSMEMO1", false, "FSMEMO1");
        public final static Property FSMEMO2 = new Property(15, String.class, "FSMEMO2", false, "FSMEMO2");
        public final static Property FSMEMO3 = new Property(16, String.class, "FSMEMO3", false, "FSMEMO3");
        public final static Property FSDEL = new Property(17, String.class, "FSDEL", false, "FSDEL");
        public final static Property FUQUANXIAN = new Property(18, String.class, "FUQUANXIAN", false, "FUQUANXIAN");
        public final static Property FUACCOUNT = new Property(19, String.class, "FUACCOUNT", false, "FUACCOUNT");
        public final static Property FUPASSWORD = new Property(20, String.class, "FUPASSWORD", false, "FUPASSWORD");
        public final static Property FRID = new Property(21, String.class, "FRID", false, "FRID");
        public final static Property FRNAME = new Property(22, String.class, "FRNAME", false, "FRNAME");
        public final static Property FUSEEID = new Property(23, int.class, "FUSEEID", false, "FUSEEID");
        public final static Property FUSEENAME = new Property(24, String.class, "FUSEENAME", false, "FUSEENAME");
        public final static Property FUNAME = new Property(25, String.class, "FUNAME", false, "FUNAME");
        public final static Property FUSEX = new Property(26, boolean.class, "FUSEX", false, "FUSEX");
        public final static Property FUPOSITION = new Property(27, String.class, "FUPOSITION", false, "FUPOSITION");
        public final static Property FUPHONE = new Property(28, String.class, "FUPHONE", false, "FUPHONE");
        public final static Property FUEMAIL = new Property(29, String.class, "FUEMAIL", false, "FUEMAIL");
        public final static Property FUQQ = new Property(30, String.class, "FUQQ", false, "FUQQ");
        public final static Property FUCODE = new Property(31, int.class, "FUCODE", false, "FUCODE");
        public final static Property FUNUMBER = new Property(32, String.class, "FUNUMBER", false, "FUNUMBER");
        public final static Property FUPOSTCODE = new Property(33, String.class, "FUPOSTCODE", false, "FUPOSTCODE");
        public final static Property FUREMARK = new Property(34, String.class, "FUREMARK", false, "FUREMARK");
        public final static Property FUDWTYPE = new Property(35, String.class, "FUDWTYPE", false, "FUDWTYPE");
        public final static Property FULOGOFF = new Property(36, String.class, "FULOGOFF", false, "FULOGOFF");
        public final static Property FSM1 = new Property(37, String.class, "FSM1", false, "FSM1");
        public final static Property FSM2 = new Property(38, String.class, "FSM2", false, "FSM2");
        public final static Property FSM3 = new Property(39, String.class, "FSM3", false, "FSM3");
        public final static Property FSM4 = new Property(40, String.class, "FSM4", false, "FSM4");
        public final static Property FSM5 = new Property(41, String.class, "FSM5", false, "FSM5");
        public final static Property SFRID = new Property(42, String.class, "SFRID", false, "SFRID");
        public final static Property SFRNAME = new Property(43, String.class, "SFRNAME", false, "SFRNAME");
        public final static Property CODE = new Property(44, String.class, "CODE", false, "CODE");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"User\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: cId
                "\"userId\" INTEGER NOT NULL ," + // 1: USERID
                "\"FSGUIDID\" TEXT," + // 2: FSGUIDID
                "\"FSCTIME\" TEXT," + // 3: FSCTIME
                "\"FSUTIME\" TEXT," + // 4: FSUTIME
                "\"FSUSERID\" INTEGER NOT NULL ," + // 5: FSUSERID
                "\"FSUSERNAME\" TEXT," + // 6: FSUSERNAME
                "\"FSUNITID\" INTEGER NOT NULL ," + // 7: FSUNITID
                "\"FSUNITUSTRID\" TEXT," + // 8: FSUNITUSTRID
                "\"FSUNITNAME\" TEXT," + // 9: FSUNITNAME
                "\"FSENTERPRISEID\" INTEGER NOT NULL ," + // 10: FSENTERPRISEID
                "\"FSENTERPRISENAME\" TEXT," + // 11: FSENTERPRISENAME
                "\"FSAUDIT\" TEXT," + // 12: FSAUDIT
                "\"FSREVIEWER\" TEXT," + // 13: FSREVIEWER
                "\"FSMEMO1\" TEXT," + // 14: FSMEMO1
                "\"FSMEMO2\" TEXT," + // 15: FSMEMO2
                "\"FSMEMO3\" TEXT," + // 16: FSMEMO3
                "\"FSDEL\" TEXT," + // 17: FSDEL
                "\"FUQUANXIAN\" TEXT," + // 18: FUQUANXIAN
                "\"FUACCOUNT\" TEXT," + // 19: FUACCOUNT
                "\"FUPASSWORD\" TEXT," + // 20: FUPASSWORD
                "\"FRID\" TEXT," + // 21: FRID
                "\"FRNAME\" TEXT," + // 22: FRNAME
                "\"FUSEEID\" INTEGER NOT NULL ," + // 23: FUSEEID
                "\"FUSEENAME\" TEXT," + // 24: FUSEENAME
                "\"FUNAME\" TEXT," + // 25: FUNAME
                "\"FUSEX\" INTEGER NOT NULL ," + // 26: FUSEX
                "\"FUPOSITION\" TEXT," + // 27: FUPOSITION
                "\"FUPHONE\" TEXT," + // 28: FUPHONE
                "\"FUEMAIL\" TEXT," + // 29: FUEMAIL
                "\"FUQQ\" TEXT," + // 30: FUQQ
                "\"FUCODE\" INTEGER NOT NULL ," + // 31: FUCODE
                "\"FUNUMBER\" TEXT," + // 32: FUNUMBER
                "\"FUPOSTCODE\" TEXT," + // 33: FUPOSTCODE
                "\"FUREMARK\" TEXT," + // 34: FUREMARK
                "\"FUDWTYPE\" TEXT," + // 35: FUDWTYPE
                "\"FULOGOFF\" TEXT," + // 36: FULOGOFF
                "\"FSM1\" TEXT," + // 37: FSM1
                "\"FSM2\" TEXT," + // 38: FSM2
                "\"FSM3\" TEXT," + // 39: FSM3
                "\"FSM4\" TEXT," + // 40: FSM4
                "\"FSM5\" TEXT," + // 41: FSM5
                "\"SFRID\" TEXT," + // 42: SFRID
                "\"SFRNAME\" TEXT," + // 43: SFRNAME
                "\"CODE\" TEXT);"); // 44: CODE
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"User\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long cId = entity.getCId();
        if (cId != null) {
            stmt.bindLong(1, cId);
        }
        stmt.bindLong(2, entity.getUSERID());
 
        String FSGUIDID = entity.getFSGUIDID();
        if (FSGUIDID != null) {
            stmt.bindString(3, FSGUIDID);
        }
 
        String FSCTIME = entity.getFSCTIME();
        if (FSCTIME != null) {
            stmt.bindString(4, FSCTIME);
        }
 
        String FSUTIME = entity.getFSUTIME();
        if (FSUTIME != null) {
            stmt.bindString(5, FSUTIME);
        }
        stmt.bindLong(6, entity.getFSUSERID());
 
        String FSUSERNAME = entity.getFSUSERNAME();
        if (FSUSERNAME != null) {
            stmt.bindString(7, FSUSERNAME);
        }
        stmt.bindLong(8, entity.getFSUNITID());
 
        String FSUNITUSTRID = entity.getFSUNITUSTRID();
        if (FSUNITUSTRID != null) {
            stmt.bindString(9, FSUNITUSTRID);
        }
 
        String FSUNITNAME = entity.getFSUNITNAME();
        if (FSUNITNAME != null) {
            stmt.bindString(10, FSUNITNAME);
        }
        stmt.bindLong(11, entity.getFSENTERPRISEID());
 
        String FSENTERPRISENAME = entity.getFSENTERPRISENAME();
        if (FSENTERPRISENAME != null) {
            stmt.bindString(12, FSENTERPRISENAME);
        }
 
        String FSAUDIT = entity.getFSAUDIT();
        if (FSAUDIT != null) {
            stmt.bindString(13, FSAUDIT);
        }
 
        String FSREVIEWER = entity.getFSREVIEWER();
        if (FSREVIEWER != null) {
            stmt.bindString(14, FSREVIEWER);
        }
 
        String FSMEMO1 = entity.getFSMEMO1();
        if (FSMEMO1 != null) {
            stmt.bindString(15, FSMEMO1);
        }
 
        String FSMEMO2 = entity.getFSMEMO2();
        if (FSMEMO2 != null) {
            stmt.bindString(16, FSMEMO2);
        }
 
        String FSMEMO3 = entity.getFSMEMO3();
        if (FSMEMO3 != null) {
            stmt.bindString(17, FSMEMO3);
        }
 
        String FSDEL = entity.getFSDEL();
        if (FSDEL != null) {
            stmt.bindString(18, FSDEL);
        }
 
        String FUQUANXIAN = entity.getFUQUANXIAN();
        if (FUQUANXIAN != null) {
            stmt.bindString(19, FUQUANXIAN);
        }
 
        String FUACCOUNT = entity.getFUACCOUNT();
        if (FUACCOUNT != null) {
            stmt.bindString(20, FUACCOUNT);
        }
 
        String FUPASSWORD = entity.getFUPASSWORD();
        if (FUPASSWORD != null) {
            stmt.bindString(21, FUPASSWORD);
        }
 
        String FRID = entity.getFRID();
        if (FRID != null) {
            stmt.bindString(22, FRID);
        }
 
        String FRNAME = entity.getFRNAME();
        if (FRNAME != null) {
            stmt.bindString(23, FRNAME);
        }
        stmt.bindLong(24, entity.getFUSEEID());
 
        String FUSEENAME = entity.getFUSEENAME();
        if (FUSEENAME != null) {
            stmt.bindString(25, FUSEENAME);
        }
 
        String FUNAME = entity.getFUNAME();
        if (FUNAME != null) {
            stmt.bindString(26, FUNAME);
        }
        stmt.bindLong(27, entity.getFUSEX() ? 1L: 0L);
 
        String FUPOSITION = entity.getFUPOSITION();
        if (FUPOSITION != null) {
            stmt.bindString(28, FUPOSITION);
        }
 
        String FUPHONE = entity.getFUPHONE();
        if (FUPHONE != null) {
            stmt.bindString(29, FUPHONE);
        }
 
        String FUEMAIL = entity.getFUEMAIL();
        if (FUEMAIL != null) {
            stmt.bindString(30, FUEMAIL);
        }
 
        String FUQQ = entity.getFUQQ();
        if (FUQQ != null) {
            stmt.bindString(31, FUQQ);
        }
        stmt.bindLong(32, entity.getFUCODE());
 
        String FUNUMBER = entity.getFUNUMBER();
        if (FUNUMBER != null) {
            stmt.bindString(33, FUNUMBER);
        }
 
        String FUPOSTCODE = entity.getFUPOSTCODE();
        if (FUPOSTCODE != null) {
            stmt.bindString(34, FUPOSTCODE);
        }
 
        String FUREMARK = entity.getFUREMARK();
        if (FUREMARK != null) {
            stmt.bindString(35, FUREMARK);
        }
 
        String FUDWTYPE = entity.getFUDWTYPE();
        if (FUDWTYPE != null) {
            stmt.bindString(36, FUDWTYPE);
        }
 
        String FULOGOFF = entity.getFULOGOFF();
        if (FULOGOFF != null) {
            stmt.bindString(37, FULOGOFF);
        }
 
        String FSM1 = entity.getFSM1();
        if (FSM1 != null) {
            stmt.bindString(38, FSM1);
        }
 
        String FSM2 = entity.getFSM2();
        if (FSM2 != null) {
            stmt.bindString(39, FSM2);
        }
 
        String FSM3 = entity.getFSM3();
        if (FSM3 != null) {
            stmt.bindString(40, FSM3);
        }
 
        String FSM4 = entity.getFSM4();
        if (FSM4 != null) {
            stmt.bindString(41, FSM4);
        }
 
        String FSM5 = entity.getFSM5();
        if (FSM5 != null) {
            stmt.bindString(42, FSM5);
        }
 
        String SFRID = entity.getSFRID();
        if (SFRID != null) {
            stmt.bindString(43, SFRID);
        }
 
        String SFRNAME = entity.getSFRNAME();
        if (SFRNAME != null) {
            stmt.bindString(44, SFRNAME);
        }
 
        String CODE = entity.getCODE();
        if (CODE != null) {
            stmt.bindString(45, CODE);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long cId = entity.getCId();
        if (cId != null) {
            stmt.bindLong(1, cId);
        }
        stmt.bindLong(2, entity.getUSERID());
 
        String FSGUIDID = entity.getFSGUIDID();
        if (FSGUIDID != null) {
            stmt.bindString(3, FSGUIDID);
        }
 
        String FSCTIME = entity.getFSCTIME();
        if (FSCTIME != null) {
            stmt.bindString(4, FSCTIME);
        }
 
        String FSUTIME = entity.getFSUTIME();
        if (FSUTIME != null) {
            stmt.bindString(5, FSUTIME);
        }
        stmt.bindLong(6, entity.getFSUSERID());
 
        String FSUSERNAME = entity.getFSUSERNAME();
        if (FSUSERNAME != null) {
            stmt.bindString(7, FSUSERNAME);
        }
        stmt.bindLong(8, entity.getFSUNITID());
 
        String FSUNITUSTRID = entity.getFSUNITUSTRID();
        if (FSUNITUSTRID != null) {
            stmt.bindString(9, FSUNITUSTRID);
        }
 
        String FSUNITNAME = entity.getFSUNITNAME();
        if (FSUNITNAME != null) {
            stmt.bindString(10, FSUNITNAME);
        }
        stmt.bindLong(11, entity.getFSENTERPRISEID());
 
        String FSENTERPRISENAME = entity.getFSENTERPRISENAME();
        if (FSENTERPRISENAME != null) {
            stmt.bindString(12, FSENTERPRISENAME);
        }
 
        String FSAUDIT = entity.getFSAUDIT();
        if (FSAUDIT != null) {
            stmt.bindString(13, FSAUDIT);
        }
 
        String FSREVIEWER = entity.getFSREVIEWER();
        if (FSREVIEWER != null) {
            stmt.bindString(14, FSREVIEWER);
        }
 
        String FSMEMO1 = entity.getFSMEMO1();
        if (FSMEMO1 != null) {
            stmt.bindString(15, FSMEMO1);
        }
 
        String FSMEMO2 = entity.getFSMEMO2();
        if (FSMEMO2 != null) {
            stmt.bindString(16, FSMEMO2);
        }
 
        String FSMEMO3 = entity.getFSMEMO3();
        if (FSMEMO3 != null) {
            stmt.bindString(17, FSMEMO3);
        }
 
        String FSDEL = entity.getFSDEL();
        if (FSDEL != null) {
            stmt.bindString(18, FSDEL);
        }
 
        String FUQUANXIAN = entity.getFUQUANXIAN();
        if (FUQUANXIAN != null) {
            stmt.bindString(19, FUQUANXIAN);
        }
 
        String FUACCOUNT = entity.getFUACCOUNT();
        if (FUACCOUNT != null) {
            stmt.bindString(20, FUACCOUNT);
        }
 
        String FUPASSWORD = entity.getFUPASSWORD();
        if (FUPASSWORD != null) {
            stmt.bindString(21, FUPASSWORD);
        }
 
        String FRID = entity.getFRID();
        if (FRID != null) {
            stmt.bindString(22, FRID);
        }
 
        String FRNAME = entity.getFRNAME();
        if (FRNAME != null) {
            stmt.bindString(23, FRNAME);
        }
        stmt.bindLong(24, entity.getFUSEEID());
 
        String FUSEENAME = entity.getFUSEENAME();
        if (FUSEENAME != null) {
            stmt.bindString(25, FUSEENAME);
        }
 
        String FUNAME = entity.getFUNAME();
        if (FUNAME != null) {
            stmt.bindString(26, FUNAME);
        }
        stmt.bindLong(27, entity.getFUSEX() ? 1L: 0L);
 
        String FUPOSITION = entity.getFUPOSITION();
        if (FUPOSITION != null) {
            stmt.bindString(28, FUPOSITION);
        }
 
        String FUPHONE = entity.getFUPHONE();
        if (FUPHONE != null) {
            stmt.bindString(29, FUPHONE);
        }
 
        String FUEMAIL = entity.getFUEMAIL();
        if (FUEMAIL != null) {
            stmt.bindString(30, FUEMAIL);
        }
 
        String FUQQ = entity.getFUQQ();
        if (FUQQ != null) {
            stmt.bindString(31, FUQQ);
        }
        stmt.bindLong(32, entity.getFUCODE());
 
        String FUNUMBER = entity.getFUNUMBER();
        if (FUNUMBER != null) {
            stmt.bindString(33, FUNUMBER);
        }
 
        String FUPOSTCODE = entity.getFUPOSTCODE();
        if (FUPOSTCODE != null) {
            stmt.bindString(34, FUPOSTCODE);
        }
 
        String FUREMARK = entity.getFUREMARK();
        if (FUREMARK != null) {
            stmt.bindString(35, FUREMARK);
        }
 
        String FUDWTYPE = entity.getFUDWTYPE();
        if (FUDWTYPE != null) {
            stmt.bindString(36, FUDWTYPE);
        }
 
        String FULOGOFF = entity.getFULOGOFF();
        if (FULOGOFF != null) {
            stmt.bindString(37, FULOGOFF);
        }
 
        String FSM1 = entity.getFSM1();
        if (FSM1 != null) {
            stmt.bindString(38, FSM1);
        }
 
        String FSM2 = entity.getFSM2();
        if (FSM2 != null) {
            stmt.bindString(39, FSM2);
        }
 
        String FSM3 = entity.getFSM3();
        if (FSM3 != null) {
            stmt.bindString(40, FSM3);
        }
 
        String FSM4 = entity.getFSM4();
        if (FSM4 != null) {
            stmt.bindString(41, FSM4);
        }
 
        String FSM5 = entity.getFSM5();
        if (FSM5 != null) {
            stmt.bindString(42, FSM5);
        }
 
        String SFRID = entity.getSFRID();
        if (SFRID != null) {
            stmt.bindString(43, SFRID);
        }
 
        String SFRNAME = entity.getSFRNAME();
        if (SFRNAME != null) {
            stmt.bindString(44, SFRNAME);
        }
 
        String CODE = entity.getCODE();
        if (CODE != null) {
            stmt.bindString(45, CODE);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // cId
            cursor.getInt(offset + 1), // USERID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // FSGUIDID
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // FSCTIME
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // FSUTIME
            cursor.getInt(offset + 5), // FSUSERID
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // FSUSERNAME
            cursor.getInt(offset + 7), // FSUNITID
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // FSUNITUSTRID
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // FSUNITNAME
            cursor.getInt(offset + 10), // FSENTERPRISEID
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // FSENTERPRISENAME
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // FSAUDIT
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // FSREVIEWER
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // FSMEMO1
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // FSMEMO2
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // FSMEMO3
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // FSDEL
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // FUQUANXIAN
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // FUACCOUNT
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // FUPASSWORD
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // FRID
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // FRNAME
            cursor.getInt(offset + 23), // FUSEEID
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // FUSEENAME
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // FUNAME
            cursor.getShort(offset + 26) != 0, // FUSEX
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // FUPOSITION
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // FUPHONE
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // FUEMAIL
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // FUQQ
            cursor.getInt(offset + 31), // FUCODE
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // FUNUMBER
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // FUPOSTCODE
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // FUREMARK
            cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // FUDWTYPE
            cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36), // FULOGOFF
            cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37), // FSM1
            cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38), // FSM2
            cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39), // FSM3
            cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40), // FSM4
            cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41), // FSM5
            cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42), // SFRID
            cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43), // SFRNAME
            cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44) // CODE
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setCId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUSERID(cursor.getInt(offset + 1));
        entity.setFSGUIDID(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFSCTIME(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setFSUTIME(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFSUSERID(cursor.getInt(offset + 5));
        entity.setFSUSERNAME(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setFSUNITID(cursor.getInt(offset + 7));
        entity.setFSUNITUSTRID(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setFSUNITNAME(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setFSENTERPRISEID(cursor.getInt(offset + 10));
        entity.setFSENTERPRISENAME(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setFSAUDIT(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setFSREVIEWER(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setFSMEMO1(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setFSMEMO2(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setFSMEMO3(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setFSDEL(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setFUQUANXIAN(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setFUACCOUNT(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setFUPASSWORD(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setFRID(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setFRNAME(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setFUSEEID(cursor.getInt(offset + 23));
        entity.setFUSEENAME(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setFUNAME(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setFUSEX(cursor.getShort(offset + 26) != 0);
        entity.setFUPOSITION(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setFUPHONE(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setFUEMAIL(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setFUQQ(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setFUCODE(cursor.getInt(offset + 31));
        entity.setFUNUMBER(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setFUPOSTCODE(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setFUREMARK(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setFUDWTYPE(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setFULOGOFF(cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36));
        entity.setFSM1(cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37));
        entity.setFSM2(cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38));
        entity.setFSM3(cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39));
        entity.setFSM4(cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40));
        entity.setFSM5(cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41));
        entity.setSFRID(cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42));
        entity.setSFRNAME(cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43));
        entity.setCODE(cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setCId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getCId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getCId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
