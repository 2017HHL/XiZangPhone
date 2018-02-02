package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by wyw on 2016/10/31.
 * 产品检疫申报 表
 */
//@Keep
//@Entity(nameInDb = "CodeProduct")
public class CodeProduct {
    @Id
    @Property(nameInDb = "CId")
    private Long cId;
    @Property(nameInDb = "CPARENT")
    private String cParent;
    @Property(nameInDb = "cName")
    private String cName;
    @Property(nameInDb = "cValue")
    private String cValue;
    @Property(nameInDb = "tId")
    private String tId;
    @Property(nameInDb = "Fdw")
    private String fDw;
    @Generated(hash = 173274809)
    public CodeProduct(Long cId, String cParent, String cName, String cValue,
                       String tId, String fDw) {
        this.cId = cId;
        this.cParent = cParent;
        this.cName = cName;
        this.cValue = cValue;
        this.tId = tId;
        this.fDw = fDw;
    }
    @Generated(hash = 264577652)
    public CodeProduct() {
    }
    public Long getCId() {
        return this.cId;
    }
    public void setCId(Long cId) {
        this.cId = cId;
    }
    public String getCParent() {
        return this.cParent;
    }
    public void setCParent(String cParent) {
        this.cParent = cParent;
    }
    public String getCName() {
        return this.cName;
    }
    public void setCName(String cName) {
        this.cName = cName;
    }
    public String getCValue() {
        return this.cValue;
    }
    public void setCValue(String cValue) {
        this.cValue = cValue;
    }
    public String getTId() {
        return this.tId;
    }
    public void setTId(String tId) {
        this.tId = tId;
    }
    public String getFDw() {
        return this.fDw;
    }
    public void setFDw(String fDw) {
        this.fDw = fDw;
    }

}
