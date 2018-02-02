package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by wyw on 2016/10/31.
 * 动物检疫申报 表
 */
//@Keep
//@Entity(nameInDb = "CodeAnimal")
public class CodeAnimal {
    @Id
    @Property(nameInDb = "CId")
    private Long cId; //主键
    @Property(nameInDb = "CPARENT")
    private String cParent;
    @Property(nameInDb = "cName")
    private String cName;
    @Property(nameInDb = "ACode")
    private String aCode;
    @Property(nameInDb = "tId")
    private String tId;
    @Property(nameInDb = "Fdw")
    private String fDw;

    @Generated(hash = 9280794)
    public CodeAnimal(Long cId, String cParent, String cName, String aCode,
                      String tId, String fDw) {
        this.cId = cId;
        this.cParent = cParent;
        this.cName = cName;
        this.aCode = aCode;
        this.tId = tId;
        this.fDw = fDw;
    }
    @Generated(hash = 212397221)
    public CodeAnimal() {
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
    public String getACode() {
        return this.aCode;
    }
    public void setACode(String aCode) {
        this.aCode = aCode;
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
