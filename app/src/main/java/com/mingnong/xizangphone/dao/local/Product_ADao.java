package com.mingnong.xizangphone.dao.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.mingnong.xizangphone.dao.Product_A;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ProductA".
*/
public class Product_ADao extends AbstractDao<Product_A, Long> {

    public static final String TABLENAME = "ProductA";

    /**
     * Properties of entity Product_A.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property TId = new Property(0, Long.class, "tId", true, "_id");
        public final static Property Zt = new Property(1, String.class, "zt", false, "ZT");
        public final static Property Id = new Property(2, String.class, "Id", false, "id");
        public final static Property Glid = new Property(3, int.class, "glid", false, "GLID");
        public final static Property Shipper = new Property(4, String.class, "Shipper", false, "SHIPPER");
        public final static Property Shipper_phone = new Property(5, String.class, "Shipper_phone", false, "SHIPPER_PHONE");
        public final static Property Product_name = new Property(6, String.class, "Product_name", false, "PRODUCT_NAME");
        public final static Property Product_name1 = new Property(7, String.class, "Product_name1", false, "PRODUCT_NAME1");
        public final static Property Product_name2 = new Property(8, String.class, "Product_name2", false, "PRODUCT_NAME2");
        public final static Property Product_name3 = new Property(9, String.class, "Product_name3", false, "PRODUCT_NAME3");
        public final static Property PQuantity = new Property(10, String.class, "PQuantity", false, "PQUANTITY");
        public final static Property Input_PDanWei = new Property(11, String.class, "input_PDanWei", false, "INPUT__PDAN_WEI");
        public final static Property TZGFSYQZ = new Property(12, String.class, "TZGFSYQZ", false, "TZGFSYQZ");
        public final static Property Province = new Property(13, String.class, "Province", false, "PROVINCE");
        public final static Property PUnitName = new Property(14, String.class, "PUnitName", false, "PUNIT_NAME");
        public final static Property City = new Property(15, String.class, "City", false, "CITY");
        public final static Property County = new Property(16, String.class, "County", false, "COUNTY");
        public final static Property Town = new Property(17, String.class, "Town", false, "TOWN");
        public final static Property Town1 = new Property(18, String.class, "Town1", false, "TOWN1");
        public final static Property Province1 = new Property(19, String.class, "Province1", false, "PROVINCE1");
        public final static Property City1 = new Property(20, String.class, "City1", false, "CITY1");
        public final static Property County1 = new Property(21, String.class, "County1", false, "COUNTY1");
        public final static Property Carrier = new Property(22, String.class, "Carrier", false, "CARRIER");
        public final static Property Carrier_phone = new Property(23, String.class, "Carrier_phone", false, "CARRIER_PHONE");
        public final static Property Highway = new Property(24, String.class, "Highway", false, "HIGHWAY");
        public final static Property FSmemo1 = new Property(25, String.class, "FSmemo1", false, "FSMEMO1");
        public final static Property Railway = new Property(26, String.class, "Railway", false, "RAILWAY");
        public final static Property Waterway = new Property(27, String.class, "Waterway", false, "WATERWAY");
        public final static Property Aviation = new Property(28, String.class, "Aviation", false, "AVIATION");
        public final static Property QCPYunZai = new Property(29, String.class, "QCPYunZai", false, "QCPYUN_ZAI");
        public final static Property Vehicle_mark = new Property(30, String.class, "Vehicle_mark", false, "VEHICLE_MARK");
        public final static Property Disinfect = new Property(31, String.class, "Disinfect", false, "DISINFECT");
        public final static Property ETA = new Property(32, String.class, "ETA", false, "ETA");
        public final static Property Year = new Property(33, String.class, "Year", false, "YEAR");
        public final static Property Month = new Property(34, String.class, "Month", false, "MONTH");
        public final static Property Date = new Property(35, String.class, "Date", false, "DATE");
        public final static Property DateQF = new Property(36, String.class, "DateQF", false, "DATE_QF");
        public final static Property Remark = new Property(37, String.class, "Remark", false, "REMARK");
        public final static Property PVeterinary = new Property(38, String.class, "PVeterinary", false, "PVETERINARY");
        public final static Property Supervise_Telephone = new Property(39, String.class, "Supervise_Telephone", false, "SUPERVISE__TELEPHONE");
        public final static Property NameDZ = new Property(40, String.class, "NameDZ", false, "NAME_DZ");
        public final static Property IsPrant = new Property(41, String.class, "IsPrant", false, "IS_PRANT");
        public final static Property FSmemo2 = new Property(42, String.class, "FSmemo2", false, "FSMEMO2");
        public final static Property FSmemo3 = new Property(43, String.class, "FSmemo3", false, "FSMEMO3");
    }


    public Product_ADao(DaoConfig config) {
        super(config);
    }
    
    public Product_ADao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ProductA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: tId
                "\"ZT\" TEXT," + // 1: zt
                "\"id\" TEXT," + // 2: Id
                "\"GLID\" INTEGER NOT NULL ," + // 3: glid
                "\"SHIPPER\" TEXT," + // 4: Shipper
                "\"SHIPPER_PHONE\" TEXT," + // 5: Shipper_phone
                "\"PRODUCT_NAME\" TEXT," + // 6: Product_name
                "\"PRODUCT_NAME1\" TEXT," + // 7: Product_name1
                "\"PRODUCT_NAME2\" TEXT," + // 8: Product_name2
                "\"PRODUCT_NAME3\" TEXT," + // 9: Product_name3
                "\"PQUANTITY\" TEXT," + // 10: PQuantity
                "\"INPUT__PDAN_WEI\" TEXT," + // 11: input_PDanWei
                "\"TZGFSYQZ\" TEXT," + // 12: TZGFSYQZ
                "\"PROVINCE\" TEXT," + // 13: Province
                "\"PUNIT_NAME\" TEXT," + // 14: PUnitName
                "\"CITY\" TEXT," + // 15: City
                "\"COUNTY\" TEXT," + // 16: County
                "\"TOWN\" TEXT," + // 17: Town
                "\"TOWN1\" TEXT," + // 18: Town1
                "\"PROVINCE1\" TEXT," + // 19: Province1
                "\"CITY1\" TEXT," + // 20: City1
                "\"COUNTY1\" TEXT," + // 21: County1
                "\"CARRIER\" TEXT," + // 22: Carrier
                "\"CARRIER_PHONE\" TEXT," + // 23: Carrier_phone
                "\"HIGHWAY\" TEXT," + // 24: Highway
                "\"FSMEMO1\" TEXT," + // 25: FSmemo1
                "\"RAILWAY\" TEXT," + // 26: Railway
                "\"WATERWAY\" TEXT," + // 27: Waterway
                "\"AVIATION\" TEXT," + // 28: Aviation
                "\"QCPYUN_ZAI\" TEXT," + // 29: QCPYunZai
                "\"VEHICLE_MARK\" TEXT," + // 30: Vehicle_mark
                "\"DISINFECT\" TEXT," + // 31: Disinfect
                "\"ETA\" TEXT," + // 32: ETA
                "\"YEAR\" TEXT," + // 33: Year
                "\"MONTH\" TEXT," + // 34: Month
                "\"DATE\" TEXT," + // 35: Date
                "\"DATE_QF\" TEXT," + // 36: DateQF
                "\"REMARK\" TEXT," + // 37: Remark
                "\"PVETERINARY\" TEXT," + // 38: PVeterinary
                "\"SUPERVISE__TELEPHONE\" TEXT," + // 39: Supervise_Telephone
                "\"NAME_DZ\" TEXT," + // 40: NameDZ
                "\"IS_PRANT\" TEXT," + // 41: IsPrant
                "\"FSMEMO2\" TEXT," + // 42: FSmemo2
                "\"FSMEMO3\" TEXT);"); // 43: FSmemo3
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ProductA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Product_A entity) {
        stmt.clearBindings();
 
        Long tId = entity.getTId();
        if (tId != null) {
            stmt.bindLong(1, tId);
        }
 
        String zt = entity.getZt();
        if (zt != null) {
            stmt.bindString(2, zt);
        }
 
        String Id = entity.getId();
        if (Id != null) {
            stmt.bindString(3, Id);
        }
        stmt.bindLong(4, entity.getGlid());
 
        String Shipper = entity.getShipper();
        if (Shipper != null) {
            stmt.bindString(5, Shipper);
        }
 
        String Shipper_phone = entity.getShipper_phone();
        if (Shipper_phone != null) {
            stmt.bindString(6, Shipper_phone);
        }
 
        String Product_name = entity.getProduct_name();
        if (Product_name != null) {
            stmt.bindString(7, Product_name);
        }
 
        String Product_name1 = entity.getProduct_name1();
        if (Product_name1 != null) {
            stmt.bindString(8, Product_name1);
        }
 
        String Product_name2 = entity.getProduct_name2();
        if (Product_name2 != null) {
            stmt.bindString(9, Product_name2);
        }
 
        String Product_name3 = entity.getProduct_name3();
        if (Product_name3 != null) {
            stmt.bindString(10, Product_name3);
        }
 
        String PQuantity = entity.getPQuantity();
        if (PQuantity != null) {
            stmt.bindString(11, PQuantity);
        }
 
        String input_PDanWei = entity.getInput_PDanWei();
        if (input_PDanWei != null) {
            stmt.bindString(12, input_PDanWei);
        }
 
        String TZGFSYQZ = entity.getTZGFSYQZ();
        if (TZGFSYQZ != null) {
            stmt.bindString(13, TZGFSYQZ);
        }
 
        String Province = entity.getProvince();
        if (Province != null) {
            stmt.bindString(14, Province);
        }
 
        String PUnitName = entity.getPUnitName();
        if (PUnitName != null) {
            stmt.bindString(15, PUnitName);
        }
 
        String City = entity.getCity();
        if (City != null) {
            stmt.bindString(16, City);
        }
 
        String County = entity.getCounty();
        if (County != null) {
            stmt.bindString(17, County);
        }
 
        String Town = entity.getTown();
        if (Town != null) {
            stmt.bindString(18, Town);
        }
 
        String Town1 = entity.getTown1();
        if (Town1 != null) {
            stmt.bindString(19, Town1);
        }
 
        String Province1 = entity.getProvince1();
        if (Province1 != null) {
            stmt.bindString(20, Province1);
        }
 
        String City1 = entity.getCity1();
        if (City1 != null) {
            stmt.bindString(21, City1);
        }
 
        String County1 = entity.getCounty1();
        if (County1 != null) {
            stmt.bindString(22, County1);
        }
 
        String Carrier = entity.getCarrier();
        if (Carrier != null) {
            stmt.bindString(23, Carrier);
        }
 
        String Carrier_phone = entity.getCarrier_phone();
        if (Carrier_phone != null) {
            stmt.bindString(24, Carrier_phone);
        }
 
        String Highway = entity.getHighway();
        if (Highway != null) {
            stmt.bindString(25, Highway);
        }
 
        String FSmemo1 = entity.getFSmemo1();
        if (FSmemo1 != null) {
            stmt.bindString(26, FSmemo1);
        }
 
        String Railway = entity.getRailway();
        if (Railway != null) {
            stmt.bindString(27, Railway);
        }
 
        String Waterway = entity.getWaterway();
        if (Waterway != null) {
            stmt.bindString(28, Waterway);
        }
 
        String Aviation = entity.getAviation();
        if (Aviation != null) {
            stmt.bindString(29, Aviation);
        }
 
        String QCPYunZai = entity.getQCPYunZai();
        if (QCPYunZai != null) {
            stmt.bindString(30, QCPYunZai);
        }
 
        String Vehicle_mark = entity.getVehicle_mark();
        if (Vehicle_mark != null) {
            stmt.bindString(31, Vehicle_mark);
        }
 
        String Disinfect = entity.getDisinfect();
        if (Disinfect != null) {
            stmt.bindString(32, Disinfect);
        }
 
        String ETA = entity.getETA();
        if (ETA != null) {
            stmt.bindString(33, ETA);
        }
 
        String Year = entity.getYear();
        if (Year != null) {
            stmt.bindString(34, Year);
        }
 
        String Month = entity.getMonth();
        if (Month != null) {
            stmt.bindString(35, Month);
        }
 
        String Date = entity.getDate();
        if (Date != null) {
            stmt.bindString(36, Date);
        }
 
        String DateQF = entity.getDateQF();
        if (DateQF != null) {
            stmt.bindString(37, DateQF);
        }
 
        String Remark = entity.getRemark();
        if (Remark != null) {
            stmt.bindString(38, Remark);
        }
 
        String PVeterinary = entity.getPVeterinary();
        if (PVeterinary != null) {
            stmt.bindString(39, PVeterinary);
        }
 
        String Supervise_Telephone = entity.getSupervise_Telephone();
        if (Supervise_Telephone != null) {
            stmt.bindString(40, Supervise_Telephone);
        }
 
        String NameDZ = entity.getNameDZ();
        if (NameDZ != null) {
            stmt.bindString(41, NameDZ);
        }
 
        String IsPrant = entity.getIsPrant();
        if (IsPrant != null) {
            stmt.bindString(42, IsPrant);
        }
 
        String FSmemo2 = entity.getFSmemo2();
        if (FSmemo2 != null) {
            stmt.bindString(43, FSmemo2);
        }
 
        String FSmemo3 = entity.getFSmemo3();
        if (FSmemo3 != null) {
            stmt.bindString(44, FSmemo3);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Product_A entity) {
        stmt.clearBindings();
 
        Long tId = entity.getTId();
        if (tId != null) {
            stmt.bindLong(1, tId);
        }
 
        String zt = entity.getZt();
        if (zt != null) {
            stmt.bindString(2, zt);
        }
 
        String Id = entity.getId();
        if (Id != null) {
            stmt.bindString(3, Id);
        }
        stmt.bindLong(4, entity.getGlid());
 
        String Shipper = entity.getShipper();
        if (Shipper != null) {
            stmt.bindString(5, Shipper);
        }
 
        String Shipper_phone = entity.getShipper_phone();
        if (Shipper_phone != null) {
            stmt.bindString(6, Shipper_phone);
        }
 
        String Product_name = entity.getProduct_name();
        if (Product_name != null) {
            stmt.bindString(7, Product_name);
        }
 
        String Product_name1 = entity.getProduct_name1();
        if (Product_name1 != null) {
            stmt.bindString(8, Product_name1);
        }
 
        String Product_name2 = entity.getProduct_name2();
        if (Product_name2 != null) {
            stmt.bindString(9, Product_name2);
        }
 
        String Product_name3 = entity.getProduct_name3();
        if (Product_name3 != null) {
            stmt.bindString(10, Product_name3);
        }
 
        String PQuantity = entity.getPQuantity();
        if (PQuantity != null) {
            stmt.bindString(11, PQuantity);
        }
 
        String input_PDanWei = entity.getInput_PDanWei();
        if (input_PDanWei != null) {
            stmt.bindString(12, input_PDanWei);
        }
 
        String TZGFSYQZ = entity.getTZGFSYQZ();
        if (TZGFSYQZ != null) {
            stmt.bindString(13, TZGFSYQZ);
        }
 
        String Province = entity.getProvince();
        if (Province != null) {
            stmt.bindString(14, Province);
        }
 
        String PUnitName = entity.getPUnitName();
        if (PUnitName != null) {
            stmt.bindString(15, PUnitName);
        }
 
        String City = entity.getCity();
        if (City != null) {
            stmt.bindString(16, City);
        }
 
        String County = entity.getCounty();
        if (County != null) {
            stmt.bindString(17, County);
        }
 
        String Town = entity.getTown();
        if (Town != null) {
            stmt.bindString(18, Town);
        }
 
        String Town1 = entity.getTown1();
        if (Town1 != null) {
            stmt.bindString(19, Town1);
        }
 
        String Province1 = entity.getProvince1();
        if (Province1 != null) {
            stmt.bindString(20, Province1);
        }
 
        String City1 = entity.getCity1();
        if (City1 != null) {
            stmt.bindString(21, City1);
        }
 
        String County1 = entity.getCounty1();
        if (County1 != null) {
            stmt.bindString(22, County1);
        }
 
        String Carrier = entity.getCarrier();
        if (Carrier != null) {
            stmt.bindString(23, Carrier);
        }
 
        String Carrier_phone = entity.getCarrier_phone();
        if (Carrier_phone != null) {
            stmt.bindString(24, Carrier_phone);
        }
 
        String Highway = entity.getHighway();
        if (Highway != null) {
            stmt.bindString(25, Highway);
        }
 
        String FSmemo1 = entity.getFSmemo1();
        if (FSmemo1 != null) {
            stmt.bindString(26, FSmemo1);
        }
 
        String Railway = entity.getRailway();
        if (Railway != null) {
            stmt.bindString(27, Railway);
        }
 
        String Waterway = entity.getWaterway();
        if (Waterway != null) {
            stmt.bindString(28, Waterway);
        }
 
        String Aviation = entity.getAviation();
        if (Aviation != null) {
            stmt.bindString(29, Aviation);
        }
 
        String QCPYunZai = entity.getQCPYunZai();
        if (QCPYunZai != null) {
            stmt.bindString(30, QCPYunZai);
        }
 
        String Vehicle_mark = entity.getVehicle_mark();
        if (Vehicle_mark != null) {
            stmt.bindString(31, Vehicle_mark);
        }
 
        String Disinfect = entity.getDisinfect();
        if (Disinfect != null) {
            stmt.bindString(32, Disinfect);
        }
 
        String ETA = entity.getETA();
        if (ETA != null) {
            stmt.bindString(33, ETA);
        }
 
        String Year = entity.getYear();
        if (Year != null) {
            stmt.bindString(34, Year);
        }
 
        String Month = entity.getMonth();
        if (Month != null) {
            stmt.bindString(35, Month);
        }
 
        String Date = entity.getDate();
        if (Date != null) {
            stmt.bindString(36, Date);
        }
 
        String DateQF = entity.getDateQF();
        if (DateQF != null) {
            stmt.bindString(37, DateQF);
        }
 
        String Remark = entity.getRemark();
        if (Remark != null) {
            stmt.bindString(38, Remark);
        }
 
        String PVeterinary = entity.getPVeterinary();
        if (PVeterinary != null) {
            stmt.bindString(39, PVeterinary);
        }
 
        String Supervise_Telephone = entity.getSupervise_Telephone();
        if (Supervise_Telephone != null) {
            stmt.bindString(40, Supervise_Telephone);
        }
 
        String NameDZ = entity.getNameDZ();
        if (NameDZ != null) {
            stmt.bindString(41, NameDZ);
        }
 
        String IsPrant = entity.getIsPrant();
        if (IsPrant != null) {
            stmt.bindString(42, IsPrant);
        }
 
        String FSmemo2 = entity.getFSmemo2();
        if (FSmemo2 != null) {
            stmt.bindString(43, FSmemo2);
        }
 
        String FSmemo3 = entity.getFSmemo3();
        if (FSmemo3 != null) {
            stmt.bindString(44, FSmemo3);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Product_A readEntity(Cursor cursor, int offset) {
        Product_A entity = new Product_A( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // tId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // zt
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Id
            cursor.getInt(offset + 3), // glid
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Shipper
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Shipper_phone
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Product_name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // Product_name1
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // Product_name2
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // Product_name3
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // PQuantity
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // input_PDanWei
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // TZGFSYQZ
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // Province
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // PUnitName
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // City
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // County
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // Town
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // Town1
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // Province1
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // City1
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // County1
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // Carrier
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // Carrier_phone
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // Highway
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // FSmemo1
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // Railway
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // Waterway
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // Aviation
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // QCPYunZai
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // Vehicle_mark
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // Disinfect
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // ETA
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // Year
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // Month
            cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // Date
            cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36), // DateQF
            cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37), // Remark
            cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38), // PVeterinary
            cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39), // Supervise_Telephone
            cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40), // NameDZ
            cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41), // IsPrant
            cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42), // FSmemo2
            cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43) // FSmemo3
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Product_A entity, int offset) {
        entity.setTId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setZt(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGlid(cursor.getInt(offset + 3));
        entity.setShipper(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setShipper_phone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setProduct_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setProduct_name1(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setProduct_name2(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setProduct_name3(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPQuantity(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setInput_PDanWei(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setTZGFSYQZ(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setProvince(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setPUnitName(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCity(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setCounty(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setTown(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setTown1(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setProvince1(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setCity1(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setCounty1(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setCarrier(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setCarrier_phone(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setHighway(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setFSmemo1(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setRailway(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setWaterway(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setAviation(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setQCPYunZai(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setVehicle_mark(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setDisinfect(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setETA(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setYear(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setMonth(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setDate(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setDateQF(cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36));
        entity.setRemark(cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37));
        entity.setPVeterinary(cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38));
        entity.setSupervise_Telephone(cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39));
        entity.setNameDZ(cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40));
        entity.setIsPrant(cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41));
        entity.setFSmemo2(cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42));
        entity.setFSmemo3(cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Product_A entity, long rowId) {
        entity.setTId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Product_A entity) {
        if(entity != null) {
            return entity.getTId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Product_A entity) {
        return entity.getTId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
