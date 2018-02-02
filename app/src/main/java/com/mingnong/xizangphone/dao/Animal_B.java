package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * 动物B  离线使用
 */
@SuppressWarnings("serial")
@Entity(nameInDb = "AnimalB")
public class Animal_B implements Serializable {
    private static final long serialVersionUID = -2712345154878934593L;
    @org.greenrobot.greendao.annotation.Id(autoincrement = true)
    private Long id;
    public int FGlid;		//票证打印
    public String AQNumber;	 /// 编号
    public String AQCargoOwner;	/// 货主
    public String AQPhone;	/// 联系电话
    public int AQQuantity;			/// 数量
    public String AQShiQy;			/// 启运	市(州)
    public String AQXianQy;		/// XX县(市、区)
    public String AQDiQuQy;		 /// 保存启运地 县/市/区
    public String AQXiangQy;		 /// 乡(镇)
    public String AQCunQy;			/// 村
    public String AQPlace;			/// 保存起运地 某某 养殖场信息等
    public String AQTypeQy;		 /// (养殖场、交易市场)
    public String AQShiDd;		/// 到达	市(州)
    public String AQXianDd;		// XX县(市、区)
    public String AQXiangDd;		// 乡(镇)
    public String AQCunDd;			/// 村
    public String AQArr;			// 保存到达地 某某 养殖场信息等
    public String AQTypeDd;		/// (养殖场、屠宰场、交易市场)
    public String AQVeterinary;		// 官方兽医签字
    public String AQEarTag;			// 牲畜耳标号
    public String AQXuZhong;			// 动物种类
    public String AQXuZhongOne; // / 畜种【1】
    public String AQXuZhongTwo; // / 畜种【2】
    public String AQDanWei;			// 单位：只 个 头
    public String AQYongTu;			/// 用途
    public String DateQF;			// 签发日期
    public String IsPrant;		// 0未打印 1打印  默认为0
    public String FSmemo1;
    private String FSmemo2;		//出厂编号
    private String FSmemo3;		//机器码

    public Animal_B() {
        super();
    }

    @Generated(hash = 446864373)
    public Animal_B(Long id, int FGlid, String AQNumber, String AQCargoOwner,
            String AQPhone, int AQQuantity, String AQShiQy, String AQXianQy,
            String AQDiQuQy, String AQXiangQy, String AQCunQy, String AQPlace,
            String AQTypeQy, String AQShiDd, String AQXianDd, String AQXiangDd,
            String AQCunDd, String AQArr, String AQTypeDd, String AQVeterinary,
            String AQEarTag, String AQXuZhong, String AQXuZhongOne,
            String AQXuZhongTwo, String AQDanWei, String AQYongTu, String DateQF,
            String IsPrant, String FSmemo1, String FSmemo2, String FSmemo3) {
        this.id = id;
        this.FGlid = FGlid;
        this.AQNumber = AQNumber;
        this.AQCargoOwner = AQCargoOwner;
        this.AQPhone = AQPhone;
        this.AQQuantity = AQQuantity;
        this.AQShiQy = AQShiQy;
        this.AQXianQy = AQXianQy;
        this.AQDiQuQy = AQDiQuQy;
        this.AQXiangQy = AQXiangQy;
        this.AQCunQy = AQCunQy;
        this.AQPlace = AQPlace;
        this.AQTypeQy = AQTypeQy;
        this.AQShiDd = AQShiDd;
        this.AQXianDd = AQXianDd;
        this.AQXiangDd = AQXiangDd;
        this.AQCunDd = AQCunDd;
        this.AQArr = AQArr;
        this.AQTypeDd = AQTypeDd;
        this.AQVeterinary = AQVeterinary;
        this.AQEarTag = AQEarTag;
        this.AQXuZhong = AQXuZhong;
        this.AQXuZhongOne = AQXuZhongOne;
        this.AQXuZhongTwo = AQXuZhongTwo;
        this.AQDanWei = AQDanWei;
        this.AQYongTu = AQYongTu;
        this.DateQF = DateQF;
        this.IsPrant = IsPrant;
        this.FSmemo1 = FSmemo1;
        this.FSmemo2 = FSmemo2;
        this.FSmemo3 = FSmemo3;
    }

    public int getFGlid() {
        return FGlid;
    }

    public void setFGlid(int FGlid) {
        this.FGlid = FGlid;
    }

    public String getAQNumber() {
        return AQNumber;
    }

    public void setAQNumber(String AQNumber) {
        this.AQNumber = AQNumber;
    }

    public String getAQCargoOwner() {
        return AQCargoOwner;
    }

    public void setAQCargoOwner(String AQCargoOwner) {
        this.AQCargoOwner = AQCargoOwner;
    }

    public String getAQPhone() {
        return AQPhone;
    }

    public void setAQPhone(String AQPhone) {
        this.AQPhone = AQPhone;
    }

    public int getAQQuantity() {
        return AQQuantity;
    }

    public void setAQQuantity(int AQQuantity) {
        this.AQQuantity = AQQuantity;
    }

    public String getAQShiQy() {
        return AQShiQy;
    }

    public void setAQShiQy(String AQShiQy) {
        this.AQShiQy = AQShiQy;
    }

    public String getAQXianQy() {
        return AQXianQy;
    }

    public void setAQXianQy(String AQXianQy) {
        this.AQXianQy = AQXianQy;
    }

    public String getAQDiQuQy() {
        return AQDiQuQy;
    }

    public void setAQDiQuQy(String AQDiQuQy) {
        this.AQDiQuQy = AQDiQuQy;
    }

    public String getAQXiangQy() {
        return AQXiangQy;
    }

    public void setAQXiangQy(String AQXiangQy) {
        this.AQXiangQy = AQXiangQy;
    }

    public String getAQCunQy() {
        return AQCunQy;
    }

    public void setAQCunQy(String AQCunQy) {
        this.AQCunQy = AQCunQy;
    }

    public String getAQPlace() {
        return AQPlace;
    }

    public void setAQPlace(String AQPlace) {
        this.AQPlace = AQPlace;
    }

    public String getAQTypeQy() {
        return AQTypeQy;
    }

    public void setAQTypeQy(String AQTypeQy) {
        this.AQTypeQy = AQTypeQy;
    }

    public String getAQShiDd() {
        return AQShiDd;
    }

    public void setAQShiDd(String AQShiDd) {
        this.AQShiDd = AQShiDd;
    }

    public String getAQXianDd() {
        return AQXianDd;
    }

    public void setAQXianDd(String AQXianDd) {
        this.AQXianDd = AQXianDd;
    }

    public String getAQXiangDd() {
        return AQXiangDd;
    }

    public void setAQXiangDd(String AQXiangDd) {
        this.AQXiangDd = AQXiangDd;
    }

    public String getAQCunDd() {
        return AQCunDd;
    }

    public void setAQCunDd(String AQCunDd) {
        this.AQCunDd = AQCunDd;
    }

    public String getAQArr() {
        return AQArr;
    }

    public void setAQArr(String AQArr) {
        this.AQArr = AQArr;
    }

    public String getAQTypeDd() {
        return AQTypeDd;
    }

    public void setAQTypeDd(String AQTypeDd) {
        this.AQTypeDd = AQTypeDd;
    }

    public String getAQVeterinary() {
        return AQVeterinary;
    }

    public void setAQVeterinary(String AQVeterinary) {
        this.AQVeterinary = AQVeterinary;
    }

    public String getAQEarTag() {
        return AQEarTag;
    }

    public void setAQEarTag(String AQEarTag) {
        this.AQEarTag = AQEarTag;
    }

    public String getAQXuZhong() {
        return AQXuZhong;
    }

    public void setAQXuZhong(String AQXuZhong) {
        this.AQXuZhong = AQXuZhong;
    }

    public String getAQXuZhongOne() {
        return AQXuZhongOne;
    }

    public void setAQXuZhongOne(String AQXuZhongOne) {
        this.AQXuZhongOne = AQXuZhongOne;
    }

    public String getAQXuZhongTwo() {
        return AQXuZhongTwo;
    }

    public void setAQXuZhongTwo(String AQXuZhongTwo) {
        this.AQXuZhongTwo = AQXuZhongTwo;
    }

    public String getAQDanWei() {
        return AQDanWei;
    }

    public void setAQDanWei(String AQDanWei) {
        this.AQDanWei = AQDanWei;
    }

    public String getAQYongTu() {
        return AQYongTu;
    }

    public void setAQYongTu(String AQYongTu) {
        this.AQYongTu = AQYongTu;
    }

    public String getDateQF() {
        return DateQF;
    }

    public void setDateQF(String dateQF) {
        DateQF = dateQF;
    }

    public String getIsPrant() {
        return IsPrant;
    }

    public void setIsPrant(String isPrant) {
        IsPrant = isPrant;
    }

    public String getFSmemo1() {
        return FSmemo1;
    }

    public void setFSmemo1(String FSmemo1) {
        this.FSmemo1 = FSmemo1;
    }

    public String getFSmemo2() {
        return FSmemo2;
    }

    public void setFSmemo2(String FSmemo2) {
        this.FSmemo2 = FSmemo2;
    }

    public String getFSmemo3() {
        return FSmemo3;
    }

    public void setFSmemo3(String FSmemo3) {
        this.FSmemo3 = FSmemo3;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
