package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by wyw on 2016/10/31.
 * 单位
 */
//@Keep
//@Entity(nameInDb = "Coder")
public class Coder {
    //{"cId":1,"cParent":7,"cName":"头","cDelete":"",
    // "cValue":"","cdIsPlay":0,"corder":0}
    @Id
    @Property(nameInDb = "CId")
    private Long cId;
    @Property(nameInDb = "FCPARENT")
    private String cParent;
    @Property(nameInDb = "FcName")
    private String cName;
    @Property(nameInDb = "cdIsPlay")
    private String cdIsPlay;
    @Property(nameInDb = "cDelete")
    private String cDelete;
    @Property(nameInDb = "corder")
    private String corder;
    @Property(nameInDb = "cValue")
    private String cValue;
    @Generated(hash = 1618437435)
    public Coder(Long cId, String cParent, String cName, String cdIsPlay,
                 String cDelete, String corder, String cValue) {
        this.cId = cId;
        this.cParent = cParent;
        this.cName = cName;
        this.cdIsPlay = cdIsPlay;
        this.cDelete = cDelete;
        this.corder = corder;
        this.cValue = cValue;
    }
    @Generated(hash = 138515568)
    public Coder() {
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
    public String getCdIsPlay() {
        return this.cdIsPlay;
    }
    public void setCdIsPlay(String cdIsPlay) {
        this.cdIsPlay = cdIsPlay;
    }
    public String getCDelete() {
        return this.cDelete;
    }
    public void setCDelete(String cDelete) {
        this.cDelete = cDelete;
    }
    public String getCorder() {
        return this.corder;
    }
    public void setCorder(String corder) {
        this.corder = corder;
    }
    public String getCValue() {
        return this.cValue;
    }
    public void setCValue(String cValue) {
        this.cValue = cValue;
    }

}
