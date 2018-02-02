package com.mingnong.xizangphone.dao.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.mingnong.xizangphone.dao.Unit;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Unit".
*/
public class UnitDao extends AbstractDao<Unit, Long> {

    public static final String TABLENAME = "Unit";

    /**
     * Properties of entity Unit.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property UId = new Property(0, Long.class, "uId", true, "Uid");
        public final static Property UName = new Property(1, String.class, "uName", false, "uName");
        public final static Property UParent = new Property(2, String.class, "uParent", false, "UParent");
        public final static Property UCode = new Property(3, String.class, "uCode", false, "UCode");
        public final static Property TId = new Property(4, String.class, "tId", false, "tId");
        public final static Property UStrid = new Property(5, String.class, "uStrid", false, "UStrid");
        public final static Property UOrder = new Property(6, String.class, "uOrder", false, "UOrder");
    }


    public UnitDao(DaoConfig config) {
        super(config);
    }
    
    public UnitDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Unit\" (" + //
                "\"Uid\" INTEGER PRIMARY KEY ," + // 0: uId
                "\"uName\" TEXT," + // 1: uName
                "\"UParent\" TEXT," + // 2: uParent
                "\"UCode\" TEXT," + // 3: uCode
                "\"tId\" TEXT," + // 4: tId
                "\"UStrid\" TEXT," + // 5: uStrid
                "\"UOrder\" TEXT);"); // 6: uOrder
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Unit\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Unit entity) {
        stmt.clearBindings();
 
        Long uId = entity.getUId();
        if (uId != null) {
            stmt.bindLong(1, uId);
        }
 
        String uName = entity.getUName();
        if (uName != null) {
            stmt.bindString(2, uName);
        }
 
        String uParent = entity.getUParent();
        if (uParent != null) {
            stmt.bindString(3, uParent);
        }
 
        String uCode = entity.getUCode();
        if (uCode != null) {
            stmt.bindString(4, uCode);
        }
 
        String tId = entity.getTId();
        if (tId != null) {
            stmt.bindString(5, tId);
        }
 
        String uStrid = entity.getUStrid();
        if (uStrid != null) {
            stmt.bindString(6, uStrid);
        }
 
        String uOrder = entity.getUOrder();
        if (uOrder != null) {
            stmt.bindString(7, uOrder);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Unit entity) {
        stmt.clearBindings();
 
        Long uId = entity.getUId();
        if (uId != null) {
            stmt.bindLong(1, uId);
        }
 
        String uName = entity.getUName();
        if (uName != null) {
            stmt.bindString(2, uName);
        }
 
        String uParent = entity.getUParent();
        if (uParent != null) {
            stmt.bindString(3, uParent);
        }
 
        String uCode = entity.getUCode();
        if (uCode != null) {
            stmt.bindString(4, uCode);
        }
 
        String tId = entity.getTId();
        if (tId != null) {
            stmt.bindString(5, tId);
        }
 
        String uStrid = entity.getUStrid();
        if (uStrid != null) {
            stmt.bindString(6, uStrid);
        }
 
        String uOrder = entity.getUOrder();
        if (uOrder != null) {
            stmt.bindString(7, uOrder);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Unit readEntity(Cursor cursor, int offset) {
        Unit entity = new Unit( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // uId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // uName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // uParent
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // uCode
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // tId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // uStrid
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // uOrder
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Unit entity, int offset) {
        entity.setUId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUParent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUCode(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUStrid(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUOrder(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Unit entity, long rowId) {
        entity.setUId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Unit entity) {
        if(entity != null) {
            return entity.getUId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Unit entity) {
        return entity.getUId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
