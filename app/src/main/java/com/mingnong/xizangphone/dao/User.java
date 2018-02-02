package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by wyw on 2016/10/31.
 * 用户 本地存储使用
 */
@Keep
@Entity(nameInDb = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 13;
    /**
     * USERID : 1
     * FSGUIDID : cea3bdc4-be3c-4d22-8b77-4233eb858acd
     * FSCTIME : /Date(1392022309333)/
     * FSUTIME : /Date(1392022309333)/
     * FSUSERID : 1
     * FSUSERNAME : 超级管理员
     * FSUNITID : 1
     * FSUNITUSTRID : 01
     * FSUNITNAME : 湖南省
     * FSENTERPRISEID : 1
     * FSENTERPRISENAME : 超级管理员单位
     * FSAUDIT : 0
     * FSREVIEWER : 0
     * FSMEMO1 : 0
     * FSMEMO2 : 0
     * FSMEMO3 : 0
     * FUQUANXIAN : admin
     * FUACCOUNT : admin
     * FUPASSWORD : mnkj2016
     * FRID : 1
     * FRNAME : 超级管理员
     * FUSEEID : 1
     * FUSEENAME : 超级管理员单位
     * FUNAME : 超级管理员
     * FUSEX : false
     * FUPOSITION : 通讯地址
     * FUPHONE : 13501981516
     * FUEMAIL : 906975387@qq.com
     * FUQQ : 0
     * FUCODE : 0
     * FUNUMBER : 0
     * FUPOSTCODE : 0
     * FUREMARK : 0
     * FUDWTYPE : xzdw
     * FSDEL : 0
     * FULOGOFF : 0
     * FSM1 : 0
     * FSM2 : 1
     * FSM3 : 0
     * FSM4 : 0
     * FSM5 : 0
     * SFRID : 0
     * SFRNAME : 0
     * CODE : 430000
     */
    @Id(autoincrement = true)
    private Long cId; //主键
    /**
     * 用户id
     */
    @Property(nameInDb = "userId")
    private int USERID = -1;
    /**
     *  Guid
     */
    @Property(nameInDb = "FSGUIDID")
    private String FSGUIDID;
    /**
     * 系统默认记录日期
     */
    @Property(nameInDb = "FSCTIME")
    private String FSCTIME;

    /**
     * 系统默认记录日期—修改时更新
     */
    @Property(nameInDb = "FSUTIME")
    private String FSUTIME;
    /**
     * 用户id
     */
    @Property(nameInDb = "FSUSERID")
    private int FSUSERID;
    /**
     * 用户名
     */
    @Property(nameInDb = "FSUSERNAME")
    private String FSUSERNAME;
    /**
     *  行政id
     */
    @Property(nameInDb = "FSUNITID")
    private int FSUNITID;
    /**
     *  行政等级id如01、001、0001
     */
    @Property(nameInDb = "FSUNITUSTRID")
    private String FSUNITUSTRID;
    /**
     * 行政名称
     */
    @Property(nameInDb = "FSUNITNAME")
    private String FSUNITNAME;
    /**
     * 企业/单位id
     */
    @Property(nameInDb = "FSENTERPRISEID")
    private int FSENTERPRISEID;
    /**
     * 企业/单位名称
     */
    @Property(nameInDb = "FSENTERPRISENAME")
    private String FSENTERPRISENAME;

    /**
     *  审核（0未审核，1审核）
     */
    @Property(nameInDb = "FSAUDIT")
    private String FSAUDIT;
    /**
     * 审核人
     */
    @Property(nameInDb = "FSREVIEWER")
    private String FSREVIEWER;
    /**
     * 预留备注1
     */
    @Property(nameInDb = "FSMEMO1")
    private String FSMEMO1;
    /**
     * 预留备注2
     */
    @Property(nameInDb = "FSMEMO2")
    private String FSMEMO2;
    /**
     * 预留备注3
     */
    @Property(nameInDb = "FSMEMO3")
    private String FSMEMO3;

    /**
     * 备注5
     */
    @Property(nameInDb = "FSDEL")
    private String FSDEL;
    /**
     * 权限
     */
    @Property(nameInDb = "FUQUANXIAN")
    private String FUQUANXIAN;
    /**
     * 用户账号
     */
    @Property(nameInDb = "FUACCOUNT")
    private String FUACCOUNT;

    /**
     * 用户密码
     */
    @Property(nameInDb = "FUPASSWORD")
    private String FUPASSWORD;
    /**
     * 角色id
     */
    @Property(nameInDb = "FRID")
    private String FRID;

    /**
     * 角色名
     */
    @Property(nameInDb = "FRNAME")
    private String FRNAME;
    /**
     * 单位id
     */
    @Property(nameInDb = "FUSEEID")
    private int FUSEEID;
    /**
     * 单位名称
     */
    @Property(nameInDb = "FUSEENAME")
    private String FUSEENAME;
    /**
     * 用户姓名
     */
    @Property(nameInDb = "FUNAME")
    private String FUNAME;
    /**
     * 用户性别
     */
    @Property(nameInDb = "FUSEX")
    private boolean FUSEX;
    /**
     * 通讯地址
     */
    @Property(nameInDb = "FUPOSITION")
    private String FUPOSITION;
    /**
     * 联系电话
     */
    @Property(nameInDb = "FUPHONE")
    private String FUPHONE;
    /**
     * 邮箱
     */
    @Property(nameInDb = "FUEMAIL")
    private String FUEMAIL;
    /**
     * QQ
     */
    @Property(nameInDb = "FUQQ")
    private String FUQQ;
    /**
     * 用户代码
     */
    @Property(nameInDb = "FUCODE")
    private int FUCODE;
    /**
     * 身份证号码
     */
    @Property(nameInDb = "FUNUMBER")
    private String FUNUMBER;
    /**
     * 邮政编码
     */
    @Property(nameInDb = "FUPOSTCODE")
    private String FUPOSTCODE;
    /**
     * 备注
     */
    @Property(nameInDb = "FUREMARK")
    private String FUREMARK;
    /**
     * 动物种类
     */
    @Property(nameInDb = "FUDWTYPE")
    private String FUDWTYPE;

    /**
     * 注销用户
     */
    @Property(nameInDb = "FULOGOFF")
    private String FULOGOFF;

    /**
     * 备注1
     */
    @Property(nameInDb = "FSM1")
    private String FSM1;
    /**
     * 备注2
     */
    @Property(nameInDb = "FSM2")
    private String FSM2;
    /**
     * 备注3
     */
    @Property(nameInDb = "FSM3")
    private String FSM3;
    /**
     * 备注4
     */
    @Property(nameInDb = "FSM4")
    private String FSM4;
    /**
     * 备注5
     */
    @Property(nameInDb = "FSM5")
    private String FSM5;
    /**
     *  APP角色id
     */
    @Property(nameInDb = "SFRID")
    private String SFRID;
    /**
     * app角色名
     */
    @Property(nameInDb = "SFRNAME")
    private String SFRNAME;
    /**
     * 用户代码
     */
    @Property(nameInDb = "CODE")
    private String CODE;

    @Generated(hash = 1415141756)
    public User(Long cId, int USERID, String FSGUIDID, String FSCTIME,
                String FSUTIME, int FSUSERID, String FSUSERNAME, int FSUNITID,
                String FSUNITUSTRID, String FSUNITNAME, int FSENTERPRISEID,
                String FSENTERPRISENAME, String FSAUDIT, String FSREVIEWER,
                String FSMEMO1, String FSMEMO2, String FSMEMO3, String FSDEL,
                String FUQUANXIAN, String FUACCOUNT, String FUPASSWORD, String FRID,
                String FRNAME, int FUSEEID, String FUSEENAME, String FUNAME,
                boolean FUSEX, String FUPOSITION, String FUPHONE, String FUEMAIL,
                String FUQQ, int FUCODE, String FUNUMBER, String FUPOSTCODE,
                String FUREMARK, String FUDWTYPE, String FULOGOFF, String FSM1,
                String FSM2, String FSM3, String FSM4, String FSM5, String SFRID,
                String SFRNAME, String CODE) {
        this.cId = cId;
        this.USERID = USERID;
        this.FSGUIDID = FSGUIDID;
        this.FSCTIME = FSCTIME;
        this.FSUTIME = FSUTIME;
        this.FSUSERID = FSUSERID;
        this.FSUSERNAME = FSUSERNAME;
        this.FSUNITID = FSUNITID;
        this.FSUNITUSTRID = FSUNITUSTRID;
        this.FSUNITNAME = FSUNITNAME;
        this.FSENTERPRISEID = FSENTERPRISEID;
        this.FSENTERPRISENAME = FSENTERPRISENAME;
        this.FSAUDIT = FSAUDIT;
        this.FSREVIEWER = FSREVIEWER;
        this.FSMEMO1 = FSMEMO1;
        this.FSMEMO2 = FSMEMO2;
        this.FSMEMO3 = FSMEMO3;
        this.FSDEL = FSDEL;
        this.FUQUANXIAN = FUQUANXIAN;
        this.FUACCOUNT = FUACCOUNT;
        this.FUPASSWORD = FUPASSWORD;
        this.FRID = FRID;
        this.FRNAME = FRNAME;
        this.FUSEEID = FUSEEID;
        this.FUSEENAME = FUSEENAME;
        this.FUNAME = FUNAME;
        this.FUSEX = FUSEX;
        this.FUPOSITION = FUPOSITION;
        this.FUPHONE = FUPHONE;
        this.FUEMAIL = FUEMAIL;
        this.FUQQ = FUQQ;
        this.FUCODE = FUCODE;
        this.FUNUMBER = FUNUMBER;
        this.FUPOSTCODE = FUPOSTCODE;
        this.FUREMARK = FUREMARK;
        this.FUDWTYPE = FUDWTYPE;
        this.FULOGOFF = FULOGOFF;
        this.FSM1 = FSM1;
        this.FSM2 = FSM2;
        this.FSM3 = FSM3;
        this.FSM4 = FSM4;
        this.FSM5 = FSM5;
        this.SFRID = SFRID;
        this.SFRNAME = SFRNAME;
        this.CODE = CODE;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getCId() {
        return this.cId;
    }
    public void setCId(Long cId) {
        this.cId = cId;
    }
    public int getUSERID() {
        return this.USERID;
    }
    public void setUSERID(int USERID) {
        this.USERID = USERID;
    }
    public String getFSGUIDID() {
        return this.FSGUIDID;
    }
    public void setFSGUIDID(String FSGUIDID) {
        this.FSGUIDID = FSGUIDID;
    }
    public String getFSCTIME() {
        return this.FSCTIME;
    }
    public void setFSCTIME(String FSCTIME) {
        this.FSCTIME = FSCTIME;
    }
    public String getFSUTIME() {
        return this.FSUTIME;
    }
    public void setFSUTIME(String FSUTIME) {
        this.FSUTIME = FSUTIME;
    }
    public int getFSUSERID() {
        return this.FSUSERID;
    }
    public void setFSUSERID(int FSUSERID) {
        this.FSUSERID = FSUSERID;
    }
    public String getFSUSERNAME() {
        return this.FSUSERNAME;
    }
    public void setFSUSERNAME(String FSUSERNAME) {
        this.FSUSERNAME = FSUSERNAME;
    }
    public int getFSUNITID() {
        return this.FSUNITID;
    }
    public void setFSUNITID(int FSUNITID) {
        this.FSUNITID = FSUNITID;
    }
    public String getFSUNITUSTRID() {
        return this.FSUNITUSTRID;
    }
    public void setFSUNITUSTRID(String FSUNITUSTRID) {
        this.FSUNITUSTRID = FSUNITUSTRID;
    }
    public String getFSUNITNAME() {
        return this.FSUNITNAME;
    }
    public void setFSUNITNAME(String FSUNITNAME) {
        this.FSUNITNAME = FSUNITNAME;
    }
    public int getFSENTERPRISEID() {
        return this.FSENTERPRISEID;
    }
    public void setFSENTERPRISEID(int FSENTERPRISEID) {
        this.FSENTERPRISEID = FSENTERPRISEID;
    }
    public String getFSENTERPRISENAME() {
        return this.FSENTERPRISENAME;
    }
    public void setFSENTERPRISENAME(String FSENTERPRISENAME) {
        this.FSENTERPRISENAME = FSENTERPRISENAME;
    }
    public String getFSAUDIT() {
        return this.FSAUDIT;
    }
    public void setFSAUDIT(String FSAUDIT) {
        this.FSAUDIT = FSAUDIT;
    }
    public String getFSREVIEWER() {
        return this.FSREVIEWER;
    }
    public void setFSREVIEWER(String FSREVIEWER) {
        this.FSREVIEWER = FSREVIEWER;
    }
    public String getFSMEMO1() {
        return this.FSMEMO1;
    }
    public void setFSMEMO1(String FSMEMO1) {
        this.FSMEMO1 = FSMEMO1;
    }
    public String getFSMEMO2() {
        return this.FSMEMO2;
    }
    public void setFSMEMO2(String FSMEMO2) {
        this.FSMEMO2 = FSMEMO2;
    }
    public String getFSMEMO3() {
        return this.FSMEMO3;
    }
    public void setFSMEMO3(String FSMEMO3) {
        this.FSMEMO3 = FSMEMO3;
    }
    public String getFUQUANXIAN() {
        return this.FUQUANXIAN;
    }
    public void setFUQUANXIAN(String FUQUANXIAN) {
        this.FUQUANXIAN = FUQUANXIAN;
    }
    public String getFUACCOUNT() {
        return this.FUACCOUNT;
    }
    public void setFUACCOUNT(String FUACCOUNT) {
        this.FUACCOUNT = FUACCOUNT;
    }
    public String getFUPASSWORD() {
        return this.FUPASSWORD;
    }
    public void setFUPASSWORD(String FUPASSWORD) {
        this.FUPASSWORD = FUPASSWORD;
    }
    public String getFRID() {
        if (FRID == null) return "";
        return this.FRID;
    }
    public void setFRID(String FRID) {
        this.FRID = FRID;
    }
    public String getFRNAME() {
        return this.FRNAME;
    }
    public void setFRNAME(String FRNAME) {
        this.FRNAME = FRNAME;
    }
    public int getFUSEEID() {
        return this.FUSEEID;
    }
    public void setFUSEEID(int FUSEEID) {
        this.FUSEEID = FUSEEID;
    }
    public String getFUSEENAME() {
        return this.FUSEENAME;
    }
    public void setFUSEENAME(String FUSEENAME) {
        this.FUSEENAME = FUSEENAME;
    }
    public String getFUNAME() {
        return this.FUNAME;
    }
    public void setFUNAME(String FUNAME) {
        this.FUNAME = FUNAME;
    }
    public boolean getFUSEX() {
        return this.FUSEX;
    }
    public void setFUSEX(boolean FUSEX) {
        this.FUSEX = FUSEX;
    }
    public String getFUPOSITION() {
        return this.FUPOSITION;
    }
    public void setFUPOSITION(String FUPOSITION) {
        this.FUPOSITION = FUPOSITION;
    }
    public String getFUPHONE() {
        return this.FUPHONE;
    }
    public void setFUPHONE(String FUPHONE) {
        this.FUPHONE = FUPHONE;
    }
    public String getFUEMAIL() {
        return this.FUEMAIL;
    }
    public void setFUEMAIL(String FUEMAIL) {
        this.FUEMAIL = FUEMAIL;
    }
    public String getFUQQ() {
        return this.FUQQ;
    }
    public void setFUQQ(String FUQQ) {
        this.FUQQ = FUQQ;
    }
    public int getFUCODE() {
        return this.FUCODE;
    }
    public void setFUCODE(int FUCODE) {
        this.FUCODE = FUCODE;
    }
    public String getFUNUMBER() {
        return this.FUNUMBER;
    }
    public void setFUNUMBER(String FUNUMBER) {
        this.FUNUMBER = FUNUMBER;
    }
    public String getFUPOSTCODE() {
        return this.FUPOSTCODE;
    }
    public void setFUPOSTCODE(String FUPOSTCODE) {
        this.FUPOSTCODE = FUPOSTCODE;
    }
    public String getFUREMARK() {
        return this.FUREMARK;
    }
    public void setFUREMARK(String FUREMARK) {
        this.FUREMARK = FUREMARK;
    }
    public String getFUDWTYPE() {
        return this.FUDWTYPE;
    }
    public void setFUDWTYPE(String FUDWTYPE) {
        this.FUDWTYPE = FUDWTYPE;
    }
    public String getFSDEL() {
        return this.FSDEL;
    }
    public void setFSDEL(String FSDEL) {
        this.FSDEL = FSDEL;
    }
    public String getFULOGOFF() {
        return this.FULOGOFF;
    }
    public void setFULOGOFF(String FULOGOFF) {
        this.FULOGOFF = FULOGOFF;
    }
    public String getFSM1() {
        return this.FSM1;
    }
    public void setFSM1(String FSM1) {
        this.FSM1 = FSM1;
    }
    public String getFSM2() {
        return this.FSM2;
    }
    public void setFSM2(String FSM2) {
        this.FSM2 = FSM2;
    }
    public String getFSM3() {
        return this.FSM3;
    }
    public void setFSM3(String FSM3) {
        this.FSM3 = FSM3;
    }
    public String getFSM4() {
        return this.FSM4;
    }
    public void setFSM4(String FSM4) {
        this.FSM4 = FSM4;
    }
    public String getFSM5() {
        return this.FSM5;
    }
    public void setFSM5(String FSM5) {
        this.FSM5 = FSM5;
    }
    public String getSFRID() {
        return this.SFRID;
    }
    public void setSFRID(String SFRID) {
        this.SFRID = SFRID;
    }
    public String getSFRNAME() {
        return this.SFRNAME;
    }
    public void setSFRNAME(String SFRNAME) {
        this.SFRNAME = SFRNAME;
    }
    public String getCODE() {
        return this.CODE;
    }
    public void setCODE(String CODE) {
        this.CODE = CODE;
    }
}
