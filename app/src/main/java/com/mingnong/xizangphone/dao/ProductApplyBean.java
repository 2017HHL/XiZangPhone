package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by wyw on 2016/11/8.
 */
@Entity(nameInDb = "ProductApplyBean")
public class ProductApplyBean implements Serializable {
    private static final long serialVersionUID = -2798543214878934593L;

    @Id(autoincrement = true)
    private Long id;
    /**
     * IsPrant : 已保存
     * QCPType : 省内
     * FStId : 305
     * QCPNumber : 201610271058032409
     * FGlid :
     * QCPCargoOwner : 货主黄思
     * QCPPhone : 11111111111
     * QCProduct : 胚胎
     * QCProductOne : 其它产品
     * QCProductTwo : 胚胎
     * QCProductThree :
     * QCPQuantity : 111.00
     * QCPDanWei : 枚
     * QCPsource : 来源
     * QCPShengQy : 湖南省
     * QCPShiQy : 长沙市
     * QCPXianQy : 芙蓉区
     * QCPDiZhiQy : 启运地
     * QCPShengDd : 湖南省
     * QCPShiDd : 长沙市
     * QCPXianDd : 芙蓉区
     * QCPDiZhiDd : 到达地
     * QCPChengYunRen : 承运人
     * QCPCyrDianHua : 22222222222
     * QCPYunZai : 水路
     * FSmemo1 : 其它产品,胚胎
     * QCPDisinfection : 消毒
     * DateQF : 2016-10-27 申报时间
     * DateQy : 2016-10-27
     * QCPTrademark : 车牌
     */
    public String FStId = "-2";
    public String QCPType;	/// 区分（省内动物产品申报/出省动物产品申报）
    public String QCPNumber;		/// 编号
    public String FGlid;	/// 入场查验关联id
    public int FTZGlid;	/// 屠宰场关联id
    public String QCPCargoOwner	;	/// 填写货主
    public String QCPPhone;	/// 联系电话
    public String QCProduct;   	/// 产品种类
    public String QCProductOne;	/// 产品种类1
    public String QCProductTwo;	/// 产品种类2
    public String QCProductThree;	/// 产品种类3
    public Double QCPQuantity;		/// 数量
    public String QCPDanWei;		/// 单位
    public String QCPsource;		/// 来源
    public String QCPShengQy; 		/// 省【起运地】
    public String QCPShiQy;			/// 市【起运地】
    public String QCPXianQy;		/// 县【起运地】
    public String QCPDiZhiQy;	/// 详细地址【起运地】
    public String QCPShengDd;	 /// 省【到达地】
    public String QCPShiDd;		/// 市【到达地】
    public String QCPXianDd;		 /// 县【到达地】\
    public String QCPDiZhiDd;		/// 详细【到达地】
    public String QCPChengYunRen;	// 承运人
    public String QCPCyrDianHua;		/// 承运人联系电话\
    public String QCPYunZai;		/// 运载方式
    public String QCPTrademark;	/// 运载工具牌号
    public String QCPDisinfection;		 /// 装运前消毒方式
    private String DateQy;
    public String DateQF;
    public String Highway;		//公路
    public String Railway; //铁路
    public String Waterway; 	//水路
    public String Aviation; //航空
    public String FSmemo1;
    public String QCPAccepted;	/// 申报受理结果【受理、不受理】
    public String QCPAddress;	// 受理地点【受理】
    public String DateNpy;	// 检疫日期【受理】
    public String QCPLiYou;	// 不受理理由【不受理】
    public String QCPAttn;		//官方兽医
    public String QCPJBRDianHua;	//官方兽医电话
    public String DateJL;		// (处理日期)
    public String IsPrant;	// 信息状态【已保存、已打印、已报废】
    public String Remarks;		// 备注
    public String QResults;			// 检疫结果
    public String FSuserName;    //申报人姓名

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1771867800)
    public ProductApplyBean(Long id, String FStId, String QCPType, String QCPNumber,
            String FGlid, int FTZGlid, String QCPCargoOwner, String QCPPhone,
            String QCProduct, String QCProductOne, String QCProductTwo,
            String QCProductThree, Double QCPQuantity, String QCPDanWei,
            String QCPsource, String QCPShengQy, String QCPShiQy, String QCPXianQy,
            String QCPDiZhiQy, String QCPShengDd, String QCPShiDd, String QCPXianDd,
            String QCPDiZhiDd, String QCPChengYunRen, String QCPCyrDianHua,
            String QCPYunZai, String QCPTrademark, String QCPDisinfection,
            String DateQy, String DateQF, String Highway, String Railway,
            String Waterway, String Aviation, String FSmemo1, String QCPAccepted,
            String QCPAddress, String DateNpy, String QCPLiYou, String QCPAttn,
            String QCPJBRDianHua, String DateJL, String IsPrant, String Remarks,
            String QResults, String FSuserName) {
        this.id = id;
        this.FStId = FStId;
        this.QCPType = QCPType;
        this.QCPNumber = QCPNumber;
        this.FGlid = FGlid;
        this.FTZGlid = FTZGlid;
        this.QCPCargoOwner = QCPCargoOwner;
        this.QCPPhone = QCPPhone;
        this.QCProduct = QCProduct;
        this.QCProductOne = QCProductOne;
        this.QCProductTwo = QCProductTwo;
        this.QCProductThree = QCProductThree;
        this.QCPQuantity = QCPQuantity;
        this.QCPDanWei = QCPDanWei;
        this.QCPsource = QCPsource;
        this.QCPShengQy = QCPShengQy;
        this.QCPShiQy = QCPShiQy;
        this.QCPXianQy = QCPXianQy;
        this.QCPDiZhiQy = QCPDiZhiQy;
        this.QCPShengDd = QCPShengDd;
        this.QCPShiDd = QCPShiDd;
        this.QCPXianDd = QCPXianDd;
        this.QCPDiZhiDd = QCPDiZhiDd;
        this.QCPChengYunRen = QCPChengYunRen;
        this.QCPCyrDianHua = QCPCyrDianHua;
        this.QCPYunZai = QCPYunZai;
        this.QCPTrademark = QCPTrademark;
        this.QCPDisinfection = QCPDisinfection;
        this.DateQy = DateQy;
        this.DateQF = DateQF;
        this.Highway = Highway;
        this.Railway = Railway;
        this.Waterway = Waterway;
        this.Aviation = Aviation;
        this.FSmemo1 = FSmemo1;
        this.QCPAccepted = QCPAccepted;
        this.QCPAddress = QCPAddress;
        this.DateNpy = DateNpy;
        this.QCPLiYou = QCPLiYou;
        this.QCPAttn = QCPAttn;
        this.QCPJBRDianHua = QCPJBRDianHua;
        this.DateJL = DateJL;
        this.IsPrant = IsPrant;
        this.Remarks = Remarks;
        this.QResults = QResults;
        this.FSuserName = FSuserName;
    }

    @Generated(hash = 412058424)
    public ProductApplyBean() {
    }

    public String getFSuserName() {
        return FSuserName;
    }

    public void setFSuserName(String FSuserName) {
        this.FSuserName = FSuserName;
    }

    public int getFTZGlid() {
        return FTZGlid;
    }

    public void setFTZGlid(int FTZGlid) {
        this.FTZGlid = FTZGlid;
    }

    public String getHighway() {
        return Highway;
    }

    public void setHighway(String highway) {
        Highway = highway;
    }

    public String getRailway() {
        return Railway;
    }

    public void setRailway(String railway) {
        Railway = railway;
    }

    public String getWaterway() {
        return Waterway;
    }

    public void setWaterway(String waterway) {
        Waterway = waterway;
    }

    public String getAviation() {
        return Aviation;
    }

    public void setAviation(String aviation) {
        Aviation = aviation;
    }

    public String getQCPAccepted() {
        return QCPAccepted;
    }

    public void setQCPAccepted(String QCPAccepted) {
        this.QCPAccepted = QCPAccepted;
    }

    public String getQCPAddress() {
        return QCPAddress;
    }

    public void setQCPAddress(String QCPAddress) {
        this.QCPAddress = QCPAddress;
    }

    public String getDateNpy() {
        return DateNpy;
    }

    public void setDateNpy(String dateNpy) {
        DateNpy = dateNpy;
    }

    public String getQCPLiYou() {
        return QCPLiYou;
    }

    public void setQCPLiYou(String QCPLiYou) {
        this.QCPLiYou = QCPLiYou;
    }

    public String getQCPAttn() {
        return QCPAttn;
    }

    public void setQCPAttn(String QCPAttn) {
        this.QCPAttn = QCPAttn;
    }

    public String getQCPJBRDianHua() {
        return QCPJBRDianHua;
    }

    public void setQCPJBRDianHua(String QCPJBRDianHua) {
        this.QCPJBRDianHua = QCPJBRDianHua;
    }

    public String getDateJL() {
        return DateJL;
    }

    public void setDateJL(String dateJL) {
        DateJL = dateJL;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getQResults() {
        return QResults;
    }

    public void setQResults(String QResults) {
        this.QResults = QResults;
    }

    public String getIsPrant() {
        return IsPrant;
    }

    public void setIsPrant(String IsPrant) {
        this.IsPrant = IsPrant;
    }

    public String getQCPType() {
        return QCPType;
    }

    public void setQCPType(String QCPType) {
        this.QCPType = QCPType;
    }

    public String getFStId() {
        return FStId;
    }

    public void setFStId(String FStId) {
        this.FStId = FStId;
    }

    public String getQCPNumber() {
        return QCPNumber;
    }

    public void setQCPNumber(String QCPNumber) {
        this.QCPNumber = QCPNumber;
    }

    public String getFGlid() {
        return FGlid;
    }

    public void setFGlid(String FGlid) {
        this.FGlid = FGlid;
    }

    public String getQCPCargoOwner() {
        return QCPCargoOwner;
    }

    public void setQCPCargoOwner(String QCPCargoOwner) {
        this.QCPCargoOwner = QCPCargoOwner;
    }

    public String getQCPPhone() {
        return QCPPhone;
    }

    public void setQCPPhone(String QCPPhone) {
        this.QCPPhone = QCPPhone;
    }

    public String getQCProduct() {
        return QCProduct;
    }

    public void setQCProduct(String QCProduct) {
        this.QCProduct = QCProduct;
    }

    public String getQCProductOne() {
        return QCProductOne;
    }

    public void setQCProductOne(String QCProductOne) {
        this.QCProductOne = QCProductOne;
    }

    public String getQCProductTwo() {
        return QCProductTwo;
    }

    public void setQCProductTwo(String QCProductTwo) {
        this.QCProductTwo = QCProductTwo;
    }

    public String getQCProductThree() {
        return QCProductThree;
    }

    public void setQCProductThree(String QCProductThree) {
        this.QCProductThree = QCProductThree;
    }

    public Double getQCPQuantity() {
        return QCPQuantity;
    }

    public void setQCPQuantity(Double QCPQuantity) {
        this.QCPQuantity = QCPQuantity;
    }

    public String getQCPDanWei() {
        return QCPDanWei;
    }

    public void setQCPDanWei(String QCPDanWei) {
        this.QCPDanWei = QCPDanWei;
    }

    public String getQCPsource() {
        return QCPsource;
    }

    public void setQCPsource(String QCPsource) {
        this.QCPsource = QCPsource;
    }

    public String getQCPShengQy() {
        return QCPShengQy;
    }

    public void setQCPShengQy(String QCPShengQy) {
        this.QCPShengQy = QCPShengQy;
    }

    public String getQCPShiQy() {
        return QCPShiQy;
    }

    public void setQCPShiQy(String QCPShiQy) {
        this.QCPShiQy = QCPShiQy;
    }

    public String getQCPXianQy() {
        return QCPXianQy;
    }

    public void setQCPXianQy(String QCPXianQy) {
        this.QCPXianQy = QCPXianQy;
    }

    public String getQCPDiZhiQy() {
        return QCPDiZhiQy;
    }

    public void setQCPDiZhiQy(String QCPDiZhiQy) {
        this.QCPDiZhiQy = QCPDiZhiQy;
    }

    public String getQCPShengDd() {
        return QCPShengDd;
    }

    public void setQCPShengDd(String QCPShengDd) {
        this.QCPShengDd = QCPShengDd;
    }

    public String getQCPShiDd() {
        return QCPShiDd;
    }

    public void setQCPShiDd(String QCPShiDd) {
        this.QCPShiDd = QCPShiDd;
    }

    public String getQCPXianDd() {
        return QCPXianDd;
    }

    public void setQCPXianDd(String QCPXianDd) {
        this.QCPXianDd = QCPXianDd;
    }

    public String getQCPDiZhiDd() {
        return QCPDiZhiDd;
    }

    public void setQCPDiZhiDd(String QCPDiZhiDd) {
        this.QCPDiZhiDd = QCPDiZhiDd;
    }

    public String getQCPChengYunRen() {
        return QCPChengYunRen;
    }

    public void setQCPChengYunRen(String QCPChengYunRen) {
        this.QCPChengYunRen = QCPChengYunRen;
    }

    public String getQCPCyrDianHua() {
        return QCPCyrDianHua;
    }

    public void setQCPCyrDianHua(String QCPCyrDianHua) {
        this.QCPCyrDianHua = QCPCyrDianHua;
    }

    public String getQCPYunZai() {
        return QCPYunZai;
    }

    public void setQCPYunZai(String QCPYunZai) {
        this.QCPYunZai = QCPYunZai;
    }

    public String getFSmemo1() {
        return FSmemo1;
    }

    public void setFSmemo1(String FSmemo1) {
        this.FSmemo1 = FSmemo1;
    }

    public String getQCPDisinfection() {
        return QCPDisinfection;
    }

    public void setQCPDisinfection(String QCPDisinfection) {
        this.QCPDisinfection = QCPDisinfection;
    }

    public String getDateQF() {
        return DateQF;
    }

    public void setDateQF(String DateQF) {
        this.DateQF = DateQF;
    }

    public String getDateQy() {
        return DateQy;
    }

    public void setDateQy(String DateQy) {
        this.DateQy = DateQy;
    }

    public String getQCPTrademark() {
        return QCPTrademark;
    }

    public void setQCPTrademark(String QCPTrademark) {
        this.QCPTrademark = QCPTrademark;
    }
}
