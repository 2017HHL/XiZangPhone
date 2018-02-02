package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by wyw on 2016/10/31.
 * 省市县
 */
//@Keep
@Entity(nameInDb = "Unit")
public class Unit {


    /**
     * {"uCode":"000001","uName":"中国","uOrder":"1",
     * "uParent":"0101050","uStrid":"01","uId":1,"tId":"1"}
     */
    @Id
    @Property(nameInDb = "Uid")
    private Long uId;
    @Property(nameInDb = "uName")
    private String uName;
    @Property(nameInDb = "UParent")
    private String uParent;
    @Property(nameInDb = "UCode")
    private String uCode;
    @Property(nameInDb = "tId")
    private String tId;
    @Property(nameInDb = "UStrid")
    private String uStrid;
    @Property(nameInDb = "UOrder")
    private String uOrder;

    @Generated(hash = 1644502645)
    public Unit(Long uId, String uName, String uParent, String uCode, String tId,
                String uStrid, String uOrder) {
        this.uId = uId;
        this.uName = uName;
        this.uParent = uParent;
        this.uCode = uCode;
        this.tId = tId;
        this.uStrid = uStrid;
        this.uOrder = uOrder;
    }

    @Generated(hash = 1236212320)
    public Unit() {
    }

    public Long getUId() {
        return this.uId;
    }

    public void setUId(Long uId) {
        this.uId = uId;
    }

    public String getUName() {
        return this.uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUParent() {
        return this.uParent;
    }

    public void setUParent(String uParent) {
        this.uParent = uParent;
    }

    public String getUCode() {
        return this.uCode;
    }

    public void setUCode(String uCode) {
        this.uCode = uCode;
    }

    public String getTId() {
        return this.tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }

    public String getUStrid() {
        return this.uStrid;
    }

    public void setUStrid(String uStrid) {
        this.uStrid = uStrid;
    }

    public String getUOrder() {
        return this.uOrder;
    }

    public void setUOrder(String uOrder) {
        this.uOrder = uOrder;
    }

}
