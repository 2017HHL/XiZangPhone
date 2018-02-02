package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by HUANG on 2017/7/17.
 */
@Entity
public class XiaoXiDaoBean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "Tid")
    private String tid;
    @Property(nameInDb = "CidTongZhiName")
    private String CidTongZhiName;
    @Property(nameInDb = "Ism")
    private String ism;
    @Property(nameInDb = "FileNameList")
    private String fileNameList;
    @Property(nameInDb = "UrlList")
    private String urlList;
    @Generated(hash = 2032569813)
    public XiaoXiDaoBean(Long id, String tid, String CidTongZhiName, String ism,
            String fileNameList, String urlList) {
        this.id = id;
        this.tid = tid;
        this.CidTongZhiName = CidTongZhiName;
        this.ism = ism;
        this.fileNameList = fileNameList;
        this.urlList = urlList;
    }
    @Generated(hash = 280832945)
    public XiaoXiDaoBean() {
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
    public String getCidTongZhiName() {
        return this.CidTongZhiName;
    }
    public void setCidTongZhiName(String CidTongZhiName) {
        this.CidTongZhiName = CidTongZhiName;
    }
    public String getIsm() {
        return this.ism;
    }
    public void setIsm(String ism) {
        this.ism = ism;
    }
    public String getFileNameList() {
        return this.fileNameList;
    }
    public void setFileNameList(String fileNameList) {
        this.fileNameList = fileNameList;
    }
    public String getUrlList() {
        return this.urlList;
    }
    public void setUrlList(String urlList) {
        this.urlList = urlList;
    }
}
