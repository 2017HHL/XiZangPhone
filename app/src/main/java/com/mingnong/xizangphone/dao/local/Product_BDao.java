package com.mingnong.xizangphone.dao.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.mingnong.xizangphone.dao.Product_B;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ProductB".
*/
public class Product_BDao extends AbstractDao<Product_B, Long> {

    public static final String TABLENAME = "ProductB";

    /**
     * Properties of entity Product_B.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property TId = new Property(0, Long.class, "tId", true, "_id");
        public final static Property Glid = new Property(1, int.class, "glid", false, "GLID");
        public final static Property Id = new Property(2, String.class, "Id", false, "id");
        public final static Property Shipper = new Property(3, String.class, "Shipper", false, "SHIPPER");
        public final static Property Product_name = new Property(4, String.class, "Product_name", false, "PRODUCT_NAME");
        public final static Property Product_name1 = new Property(5, String.class, "Product_name1", false, "PRODUCT_NAME1");
        public final static Property Product_name2 = new Property(6, String.class, "Product_name2", false, "PRODUCT_NAME2");
        public final static Property Product_name3 = new Property(7, String.class, "Product_name3", false, "PRODUCT_NAME3");
        public final static Property PQuantity = new Property(8, String.class, "PQuantity", false, "PQUANTITY");
        public final static Property PQuantityDW = new Property(9, String.class, "PQuantityDW", false, "PQUANTITY_DW");
        public final static Property CD = new Property(10, String.class, "CD", false, "CD");
        public final static Property SCDWMC = new Property(11, String.class, "SCDWMC", false, "SCDWMC");
        public final static Property DZ = new Property(12, String.class, "DZ", false, "DZ");
        public final static Property MDD = new Property(13, String.class, "MDD", false, "MDD");
        public final static Property JYBZH = new Property(14, String.class, "JYBZH", false, "JYBZH");
        public final static Property Remark = new Property(15, String.class, "Remark", false, "REMARK");
        public final static Property DateQF = new Property(16, String.class, "DateQF", false, "DATE_QF");
        public final static Property TZGFSYQZ = new Property(17, String.class, "TZGFSYQZ", false, "TZGFSYQZ");
        public final static Property Zt = new Property(18, String.class, "zt", false, "ZT");
        public final static Property FSmemo1 = new Property(19, String.class, "FSmemo1", false, "FSMEMO1");
        public final static Property FSmemo2 = new Property(20, String.class, "FSmemo2", false, "FSMEMO2");
        public final static Property FSmemo3 = new Property(21, String.class, "FSmemo3", false, "FSMEMO3");
    }


    public Product_BDao(DaoConfig config) {
        super(config);
    }
    
    public Product_BDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ProductB\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: tId
                "\"GLID\" INTEGER NOT NULL ," + // 1: glid
                "\"id\" TEXT," + // 2: Id
                "\"SHIPPER\" TEXT," + // 3: Shipper
                "\"PRODUCT_NAME\" TEXT," + // 4: Product_name
                "\"PRODUCT_NAME1\" TEXT," + // 5: Product_name1
                "\"PRODUCT_NAME2\" TEXT," + // 6: Product_name2
                "\"PRODUCT_NAME3\" TEXT," + // 7: Product_name3
                "\"PQUANTITY\" TEXT," + // 8: PQuantity
                "\"PQUANTITY_DW\" TEXT," + // 9: PQuantityDW
                "\"CD\" TEXT," + // 10: CD
                "\"SCDWMC\" TEXT," + // 11: SCDWMC
                "\"DZ\" TEXT," + // 12: DZ
                "\"MDD\" TEXT," + // 13: MDD
                "\"JYBZH\" TEXT," + // 14: JYBZH
                "\"REMARK\" TEXT," + // 15: Remark
                "\"DATE_QF\" TEXT," + // 16: DateQF
                "\"TZGFSYQZ\" TEXT," + // 17: TZGFSYQZ
                "\"ZT\" TEXT," + // 18: zt
                "\"FSMEMO1\" TEXT," + // 19: FSmemo1
                "\"FSMEMO2\" TEXT," + // 20: FSmemo2
                "\"FSMEMO3\" TEXT);"); // 21: FSmemo3
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ProductB\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Product_B entity) {
        stmt.clearBindings();
 
        Long tId = entity.getTId();
        if (tId != null) {
            stmt.bindLong(1, tId);
        }
        stmt.bindLong(2, entity.getGlid());
 
        String Id = entity.getId();
        if (Id != null) {
            stmt.bindString(3, Id);
        }
 
        String Shipper = entity.getShipper();
        if (Shipper != null) {
            stmt.bindString(4, Shipper);
        }
 
        String Product_name = entity.getProduct_name();
        if (Product_name != null) {
            stmt.bindString(5, Product_name);
        }
 
        String Product_name1 = entity.getProduct_name1();
        if (Product_name1 != null) {
            stmt.bindString(6, Product_name1);
        }
 
        String Product_name2 = entity.getProduct_name2();
        if (Product_name2 != null) {
            stmt.bindString(7, Product_name2);
        }
 
        String Product_name3 = entity.getProduct_name3();
        if (Product_name3 != null) {
            stmt.bindString(8, Product_name3);
        }
 
        String PQuantity = entity.getPQuantity();
        if (PQuantity != null) {
            stmt.bindString(9, PQuantity);
        }
 
        String PQuantityDW = entity.getPQuantityDW();
        if (PQuantityDW != null) {
            stmt.bindString(10, PQuantityDW);
        }
 
        String CD = entity.getCD();
        if (CD != null) {
            stmt.bindString(11, CD);
        }
 
        String SCDWMC = entity.getSCDWMC();
        if (SCDWMC != null) {
            stmt.bindString(12, SCDWMC);
        }
 
        String DZ = entity.getDZ();
        if (DZ != null) {
            stmt.bindString(13, DZ);
        }
 
        String MDD = entity.getMDD();
        if (MDD != null) {
            stmt.bindString(14, MDD);
        }
 
        String JYBZH = entity.getJYBZH();
        if (JYBZH != null) {
            stmt.bindString(15, JYBZH);
        }
 
        String Remark = entity.getRemark();
        if (Remark != null) {
            stmt.bindString(16, Remark);
        }
 
        String DateQF = entity.getDateQF();
        if (DateQF != null) {
            stmt.bindString(17, DateQF);
        }
 
        String TZGFSYQZ = entity.getTZGFSYQZ();
        if (TZGFSYQZ != null) {
            stmt.bindString(18, TZGFSYQZ);
        }
 
        String zt = entity.getZt();
        if (zt != null) {
            stmt.bindString(19, zt);
        }
 
        String FSmemo1 = entity.getFSmemo1();
        if (FSmemo1 != null) {
            stmt.bindString(20, FSmemo1);
        }
 
        String FSmemo2 = entity.getFSmemo2();
        if (FSmemo2 != null) {
            stmt.bindString(21, FSmemo2);
        }
 
        String FSmemo3 = entity.getFSmemo3();
        if (FSmemo3 != null) {
            stmt.bindString(22, FSmemo3);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Product_B entity) {
        stmt.clearBindings();
 
        Long tId = entity.getTId();
        if (tId != null) {
            stmt.bindLong(1, tId);
        }
        stmt.bindLong(2, entity.getGlid());
 
        String Id = entity.getId();
        if (Id != null) {
            stmt.bindString(3, Id);
        }
 
        String Shipper = entity.getShipper();
        if (Shipper != null) {
            stmt.bindString(4, Shipper);
        }
 
        String Product_name = entity.getProduct_name();
        if (Product_name != null) {
            stmt.bindString(5, Product_name);
        }
 
        String Product_name1 = entity.getProduct_name1();
        if (Product_name1 != null) {
            stmt.bindString(6, Product_name1);
        }
 
        String Product_name2 = entity.getProduct_name2();
        if (Product_name2 != null) {
            stmt.bindString(7, Product_name2);
        }
 
        String Product_name3 = entity.getProduct_name3();
        if (Product_name3 != null) {
            stmt.bindString(8, Product_name3);
        }
 
        String PQuantity = entity.getPQuantity();
        if (PQuantity != null) {
            stmt.bindString(9, PQuantity);
        }
 
        String PQuantityDW = entity.getPQuantityDW();
        if (PQuantityDW != null) {
            stmt.bindString(10, PQuantityDW);
        }
 
        String CD = entity.getCD();
        if (CD != null) {
            stmt.bindString(11, CD);
        }
 
        String SCDWMC = entity.getSCDWMC();
        if (SCDWMC != null) {
            stmt.bindString(12, SCDWMC);
        }
 
        String DZ = entity.getDZ();
        if (DZ != null) {
            stmt.bindString(13, DZ);
        }
 
        String MDD = entity.getMDD();
        if (MDD != null) {
            stmt.bindString(14, MDD);
        }
 
        String JYBZH = entity.getJYBZH();
        if (JYBZH != null) {
            stmt.bindString(15, JYBZH);
        }
 
        String Remark = entity.getRemark();
        if (Remark != null) {
            stmt.bindString(16, Remark);
        }
 
        String DateQF = entity.getDateQF();
        if (DateQF != null) {
            stmt.bindString(17, DateQF);
        }
 
        String TZGFSYQZ = entity.getTZGFSYQZ();
        if (TZGFSYQZ != null) {
            stmt.bindString(18, TZGFSYQZ);
        }
 
        String zt = entity.getZt();
        if (zt != null) {
            stmt.bindString(19, zt);
        }
 
        String FSmemo1 = entity.getFSmemo1();
        if (FSmemo1 != null) {
            stmt.bindString(20, FSmemo1);
        }
 
        String FSmemo2 = entity.getFSmemo2();
        if (FSmemo2 != null) {
            stmt.bindString(21, FSmemo2);
        }
 
        String FSmemo3 = entity.getFSmemo3();
        if (FSmemo3 != null) {
            stmt.bindString(22, FSmemo3);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Product_B readEntity(Cursor cursor, int offset) {
        Product_B entity = new Product_B( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // tId
            cursor.getInt(offset + 1), // glid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Shipper
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Product_name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Product_name1
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Product_name2
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // Product_name3
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // PQuantity
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // PQuantityDW
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // CD
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // SCDWMC
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // DZ
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // MDD
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // JYBZH
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // Remark
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // DateQF
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // TZGFSYQZ
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // zt
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // FSmemo1
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // FSmemo2
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21) // FSmemo3
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Product_B entity, int offset) {
        entity.setTId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGlid(cursor.getInt(offset + 1));
        entity.setId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setShipper(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setProduct_name(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setProduct_name1(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setProduct_name2(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setProduct_name3(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPQuantity(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPQuantityDW(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCD(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setSCDWMC(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDZ(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setMDD(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setJYBZH(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setRemark(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setDateQF(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setTZGFSYQZ(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setZt(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setFSmemo1(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setFSmemo2(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setFSmemo3(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Product_B entity, long rowId) {
        entity.setTId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Product_B entity) {
        if(entity != null) {
            return entity.getTId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Product_B entity) {
        return entity.getTId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
