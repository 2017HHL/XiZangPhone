package com.mingnong.xizangphone.dao.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.mingnong.xizangphone.dao.Animal_B;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "AnimalB".
*/
public class Animal_BDao extends AbstractDao<Animal_B, Long> {

    public static final String TABLENAME = "AnimalB";

    /**
     * Properties of entity Animal_B.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FGlid = new Property(1, int.class, "FGlid", false, "FGLID");
        public final static Property AQNumber = new Property(2, String.class, "AQNumber", false, "AQNUMBER");
        public final static Property AQCargoOwner = new Property(3, String.class, "AQCargoOwner", false, "AQCARGO_OWNER");
        public final static Property AQPhone = new Property(4, String.class, "AQPhone", false, "AQPHONE");
        public final static Property AQQuantity = new Property(5, int.class, "AQQuantity", false, "AQQUANTITY");
        public final static Property AQShiQy = new Property(6, String.class, "AQShiQy", false, "AQSHI_QY");
        public final static Property AQXianQy = new Property(7, String.class, "AQXianQy", false, "AQXIAN_QY");
        public final static Property AQDiQuQy = new Property(8, String.class, "AQDiQuQy", false, "AQDI_QU_QY");
        public final static Property AQXiangQy = new Property(9, String.class, "AQXiangQy", false, "AQXIANG_QY");
        public final static Property AQCunQy = new Property(10, String.class, "AQCunQy", false, "AQCUN_QY");
        public final static Property AQPlace = new Property(11, String.class, "AQPlace", false, "AQPLACE");
        public final static Property AQTypeQy = new Property(12, String.class, "AQTypeQy", false, "AQTYPE_QY");
        public final static Property AQShiDd = new Property(13, String.class, "AQShiDd", false, "AQSHI_DD");
        public final static Property AQXianDd = new Property(14, String.class, "AQXianDd", false, "AQXIAN_DD");
        public final static Property AQXiangDd = new Property(15, String.class, "AQXiangDd", false, "AQXIANG_DD");
        public final static Property AQCunDd = new Property(16, String.class, "AQCunDd", false, "AQCUN_DD");
        public final static Property AQArr = new Property(17, String.class, "AQArr", false, "AQARR");
        public final static Property AQTypeDd = new Property(18, String.class, "AQTypeDd", false, "AQTYPE_DD");
        public final static Property AQVeterinary = new Property(19, String.class, "AQVeterinary", false, "AQVETERINARY");
        public final static Property AQEarTag = new Property(20, String.class, "AQEarTag", false, "AQEAR_TAG");
        public final static Property AQXuZhong = new Property(21, String.class, "AQXuZhong", false, "AQXU_ZHONG");
        public final static Property AQXuZhongOne = new Property(22, String.class, "AQXuZhongOne", false, "AQXU_ZHONG_ONE");
        public final static Property AQXuZhongTwo = new Property(23, String.class, "AQXuZhongTwo", false, "AQXU_ZHONG_TWO");
        public final static Property AQDanWei = new Property(24, String.class, "AQDanWei", false, "AQDAN_WEI");
        public final static Property AQYongTu = new Property(25, String.class, "AQYongTu", false, "AQYONG_TU");
        public final static Property DateQF = new Property(26, String.class, "DateQF", false, "DATE_QF");
        public final static Property IsPrant = new Property(27, String.class, "IsPrant", false, "IS_PRANT");
        public final static Property FSmemo1 = new Property(28, String.class, "FSmemo1", false, "FSMEMO1");
        public final static Property FSmemo2 = new Property(29, String.class, "FSmemo2", false, "FSMEMO2");
        public final static Property FSmemo3 = new Property(30, String.class, "FSmemo3", false, "FSMEMO3");
    }


    public Animal_BDao(DaoConfig config) {
        super(config);
    }
    
    public Animal_BDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AnimalB\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"FGLID\" INTEGER NOT NULL ," + // 1: FGlid
                "\"AQNUMBER\" TEXT," + // 2: AQNumber
                "\"AQCARGO_OWNER\" TEXT," + // 3: AQCargoOwner
                "\"AQPHONE\" TEXT," + // 4: AQPhone
                "\"AQQUANTITY\" INTEGER NOT NULL ," + // 5: AQQuantity
                "\"AQSHI_QY\" TEXT," + // 6: AQShiQy
                "\"AQXIAN_QY\" TEXT," + // 7: AQXianQy
                "\"AQDI_QU_QY\" TEXT," + // 8: AQDiQuQy
                "\"AQXIANG_QY\" TEXT," + // 9: AQXiangQy
                "\"AQCUN_QY\" TEXT," + // 10: AQCunQy
                "\"AQPLACE\" TEXT," + // 11: AQPlace
                "\"AQTYPE_QY\" TEXT," + // 12: AQTypeQy
                "\"AQSHI_DD\" TEXT," + // 13: AQShiDd
                "\"AQXIAN_DD\" TEXT," + // 14: AQXianDd
                "\"AQXIANG_DD\" TEXT," + // 15: AQXiangDd
                "\"AQCUN_DD\" TEXT," + // 16: AQCunDd
                "\"AQARR\" TEXT," + // 17: AQArr
                "\"AQTYPE_DD\" TEXT," + // 18: AQTypeDd
                "\"AQVETERINARY\" TEXT," + // 19: AQVeterinary
                "\"AQEAR_TAG\" TEXT," + // 20: AQEarTag
                "\"AQXU_ZHONG\" TEXT," + // 21: AQXuZhong
                "\"AQXU_ZHONG_ONE\" TEXT," + // 22: AQXuZhongOne
                "\"AQXU_ZHONG_TWO\" TEXT," + // 23: AQXuZhongTwo
                "\"AQDAN_WEI\" TEXT," + // 24: AQDanWei
                "\"AQYONG_TU\" TEXT," + // 25: AQYongTu
                "\"DATE_QF\" TEXT," + // 26: DateQF
                "\"IS_PRANT\" TEXT," + // 27: IsPrant
                "\"FSMEMO1\" TEXT," + // 28: FSmemo1
                "\"FSMEMO2\" TEXT," + // 29: FSmemo2
                "\"FSMEMO3\" TEXT);"); // 30: FSmemo3
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AnimalB\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Animal_B entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getFGlid());
 
        String AQNumber = entity.getAQNumber();
        if (AQNumber != null) {
            stmt.bindString(3, AQNumber);
        }
 
        String AQCargoOwner = entity.getAQCargoOwner();
        if (AQCargoOwner != null) {
            stmt.bindString(4, AQCargoOwner);
        }
 
        String AQPhone = entity.getAQPhone();
        if (AQPhone != null) {
            stmt.bindString(5, AQPhone);
        }
        stmt.bindLong(6, entity.getAQQuantity());
 
        String AQShiQy = entity.getAQShiQy();
        if (AQShiQy != null) {
            stmt.bindString(7, AQShiQy);
        }
 
        String AQXianQy = entity.getAQXianQy();
        if (AQXianQy != null) {
            stmt.bindString(8, AQXianQy);
        }
 
        String AQDiQuQy = entity.getAQDiQuQy();
        if (AQDiQuQy != null) {
            stmt.bindString(9, AQDiQuQy);
        }
 
        String AQXiangQy = entity.getAQXiangQy();
        if (AQXiangQy != null) {
            stmt.bindString(10, AQXiangQy);
        }
 
        String AQCunQy = entity.getAQCunQy();
        if (AQCunQy != null) {
            stmt.bindString(11, AQCunQy);
        }
 
        String AQPlace = entity.getAQPlace();
        if (AQPlace != null) {
            stmt.bindString(12, AQPlace);
        }
 
        String AQTypeQy = entity.getAQTypeQy();
        if (AQTypeQy != null) {
            stmt.bindString(13, AQTypeQy);
        }
 
        String AQShiDd = entity.getAQShiDd();
        if (AQShiDd != null) {
            stmt.bindString(14, AQShiDd);
        }
 
        String AQXianDd = entity.getAQXianDd();
        if (AQXianDd != null) {
            stmt.bindString(15, AQXianDd);
        }
 
        String AQXiangDd = entity.getAQXiangDd();
        if (AQXiangDd != null) {
            stmt.bindString(16, AQXiangDd);
        }
 
        String AQCunDd = entity.getAQCunDd();
        if (AQCunDd != null) {
            stmt.bindString(17, AQCunDd);
        }
 
        String AQArr = entity.getAQArr();
        if (AQArr != null) {
            stmt.bindString(18, AQArr);
        }
 
        String AQTypeDd = entity.getAQTypeDd();
        if (AQTypeDd != null) {
            stmt.bindString(19, AQTypeDd);
        }
 
        String AQVeterinary = entity.getAQVeterinary();
        if (AQVeterinary != null) {
            stmt.bindString(20, AQVeterinary);
        }
 
        String AQEarTag = entity.getAQEarTag();
        if (AQEarTag != null) {
            stmt.bindString(21, AQEarTag);
        }
 
        String AQXuZhong = entity.getAQXuZhong();
        if (AQXuZhong != null) {
            stmt.bindString(22, AQXuZhong);
        }
 
        String AQXuZhongOne = entity.getAQXuZhongOne();
        if (AQXuZhongOne != null) {
            stmt.bindString(23, AQXuZhongOne);
        }
 
        String AQXuZhongTwo = entity.getAQXuZhongTwo();
        if (AQXuZhongTwo != null) {
            stmt.bindString(24, AQXuZhongTwo);
        }
 
        String AQDanWei = entity.getAQDanWei();
        if (AQDanWei != null) {
            stmt.bindString(25, AQDanWei);
        }
 
        String AQYongTu = entity.getAQYongTu();
        if (AQYongTu != null) {
            stmt.bindString(26, AQYongTu);
        }
 
        String DateQF = entity.getDateQF();
        if (DateQF != null) {
            stmt.bindString(27, DateQF);
        }
 
        String IsPrant = entity.getIsPrant();
        if (IsPrant != null) {
            stmt.bindString(28, IsPrant);
        }
 
        String FSmemo1 = entity.getFSmemo1();
        if (FSmemo1 != null) {
            stmt.bindString(29, FSmemo1);
        }
 
        String FSmemo2 = entity.getFSmemo2();
        if (FSmemo2 != null) {
            stmt.bindString(30, FSmemo2);
        }
 
        String FSmemo3 = entity.getFSmemo3();
        if (FSmemo3 != null) {
            stmt.bindString(31, FSmemo3);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Animal_B entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getFGlid());
 
        String AQNumber = entity.getAQNumber();
        if (AQNumber != null) {
            stmt.bindString(3, AQNumber);
        }
 
        String AQCargoOwner = entity.getAQCargoOwner();
        if (AQCargoOwner != null) {
            stmt.bindString(4, AQCargoOwner);
        }
 
        String AQPhone = entity.getAQPhone();
        if (AQPhone != null) {
            stmt.bindString(5, AQPhone);
        }
        stmt.bindLong(6, entity.getAQQuantity());
 
        String AQShiQy = entity.getAQShiQy();
        if (AQShiQy != null) {
            stmt.bindString(7, AQShiQy);
        }
 
        String AQXianQy = entity.getAQXianQy();
        if (AQXianQy != null) {
            stmt.bindString(8, AQXianQy);
        }
 
        String AQDiQuQy = entity.getAQDiQuQy();
        if (AQDiQuQy != null) {
            stmt.bindString(9, AQDiQuQy);
        }
 
        String AQXiangQy = entity.getAQXiangQy();
        if (AQXiangQy != null) {
            stmt.bindString(10, AQXiangQy);
        }
 
        String AQCunQy = entity.getAQCunQy();
        if (AQCunQy != null) {
            stmt.bindString(11, AQCunQy);
        }
 
        String AQPlace = entity.getAQPlace();
        if (AQPlace != null) {
            stmt.bindString(12, AQPlace);
        }
 
        String AQTypeQy = entity.getAQTypeQy();
        if (AQTypeQy != null) {
            stmt.bindString(13, AQTypeQy);
        }
 
        String AQShiDd = entity.getAQShiDd();
        if (AQShiDd != null) {
            stmt.bindString(14, AQShiDd);
        }
 
        String AQXianDd = entity.getAQXianDd();
        if (AQXianDd != null) {
            stmt.bindString(15, AQXianDd);
        }
 
        String AQXiangDd = entity.getAQXiangDd();
        if (AQXiangDd != null) {
            stmt.bindString(16, AQXiangDd);
        }
 
        String AQCunDd = entity.getAQCunDd();
        if (AQCunDd != null) {
            stmt.bindString(17, AQCunDd);
        }
 
        String AQArr = entity.getAQArr();
        if (AQArr != null) {
            stmt.bindString(18, AQArr);
        }
 
        String AQTypeDd = entity.getAQTypeDd();
        if (AQTypeDd != null) {
            stmt.bindString(19, AQTypeDd);
        }
 
        String AQVeterinary = entity.getAQVeterinary();
        if (AQVeterinary != null) {
            stmt.bindString(20, AQVeterinary);
        }
 
        String AQEarTag = entity.getAQEarTag();
        if (AQEarTag != null) {
            stmt.bindString(21, AQEarTag);
        }
 
        String AQXuZhong = entity.getAQXuZhong();
        if (AQXuZhong != null) {
            stmt.bindString(22, AQXuZhong);
        }
 
        String AQXuZhongOne = entity.getAQXuZhongOne();
        if (AQXuZhongOne != null) {
            stmt.bindString(23, AQXuZhongOne);
        }
 
        String AQXuZhongTwo = entity.getAQXuZhongTwo();
        if (AQXuZhongTwo != null) {
            stmt.bindString(24, AQXuZhongTwo);
        }
 
        String AQDanWei = entity.getAQDanWei();
        if (AQDanWei != null) {
            stmt.bindString(25, AQDanWei);
        }
 
        String AQYongTu = entity.getAQYongTu();
        if (AQYongTu != null) {
            stmt.bindString(26, AQYongTu);
        }
 
        String DateQF = entity.getDateQF();
        if (DateQF != null) {
            stmt.bindString(27, DateQF);
        }
 
        String IsPrant = entity.getIsPrant();
        if (IsPrant != null) {
            stmt.bindString(28, IsPrant);
        }
 
        String FSmemo1 = entity.getFSmemo1();
        if (FSmemo1 != null) {
            stmt.bindString(29, FSmemo1);
        }
 
        String FSmemo2 = entity.getFSmemo2();
        if (FSmemo2 != null) {
            stmt.bindString(30, FSmemo2);
        }
 
        String FSmemo3 = entity.getFSmemo3();
        if (FSmemo3 != null) {
            stmt.bindString(31, FSmemo3);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Animal_B readEntity(Cursor cursor, int offset) {
        Animal_B entity = new Animal_B( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // FGlid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // AQNumber
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // AQCargoOwner
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // AQPhone
            cursor.getInt(offset + 5), // AQQuantity
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // AQShiQy
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // AQXianQy
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // AQDiQuQy
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // AQXiangQy
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // AQCunQy
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // AQPlace
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // AQTypeQy
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // AQShiDd
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // AQXianDd
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // AQXiangDd
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // AQCunDd
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // AQArr
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // AQTypeDd
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // AQVeterinary
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // AQEarTag
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // AQXuZhong
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // AQXuZhongOne
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // AQXuZhongTwo
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // AQDanWei
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // AQYongTu
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // DateQF
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // IsPrant
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // FSmemo1
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // FSmemo2
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30) // FSmemo3
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Animal_B entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFGlid(cursor.getInt(offset + 1));
        entity.setAQNumber(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAQCargoOwner(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAQPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAQQuantity(cursor.getInt(offset + 5));
        entity.setAQShiQy(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setAQXianQy(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAQDiQuQy(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAQXiangQy(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setAQCunQy(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAQPlace(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setAQTypeQy(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setAQShiDd(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setAQXianDd(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setAQXiangDd(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setAQCunDd(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setAQArr(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setAQTypeDd(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setAQVeterinary(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setAQEarTag(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setAQXuZhong(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setAQXuZhongOne(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setAQXuZhongTwo(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setAQDanWei(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setAQYongTu(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setDateQF(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setIsPrant(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setFSmemo1(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setFSmemo2(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setFSmemo3(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Animal_B entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Animal_B entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Animal_B entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}