package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by HUANG on 2017/7/6.
 */
@Entity
public class ShenShiXianBean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "Tid")
    private String tid;
    @Property(nameInDb = "Uname")
    private String uname;
    @Property(nameInDb = "Utype")
    private String utype;
    @Property(nameInDb = "Uparent")
    private String uparent;
    @Generated(hash = 552692203)
    public ShenShiXianBean(Long id, String tid, String uname, String utype,
            String uparent) {
        this.id = id;
        this.tid = tid;
        this.uname = uname;
        this.utype = utype;
        this.uparent = uparent;
    }
    @Generated(hash = 1773381302)
    public ShenShiXianBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTid() {
        return this.tid;
    }
    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getUname() {
        return this.uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUtype() {
        return this.utype;
    }
    public void setUtype(String utype) {
        this.utype = utype;
    }
    public String getUparent() {
        return this.uparent;
    }
    public void setUparent(String uparent) {
        this.uparent = uparent;
    }
}
