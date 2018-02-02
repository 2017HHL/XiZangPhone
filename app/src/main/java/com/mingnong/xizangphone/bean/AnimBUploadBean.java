package com.mingnong.xizangphone.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/8.
 */

public class AnimBUploadBean implements Serializable {

    private String DateQF;//签发日期
    private String IsPrant;//状态:保存/打印/报废
    private int UploadType;//上传标识符:0未上传,1已上传
    private int UploadTypeSheng;//上传标识符:0未上传,1已上传（区分省上传记录）
    private int SaveId;//数据的自增Id

    private String AQNumber;//编号
    private String AQCargoOwner;//货主
    private String AQPhone;//联系电话
    private int AQQuantity;//数量
    private String AQShiQy;//市/州
    private String AQXianQy;//县/市/区
    private String AQDiQuQy;//保存启运地-县/市/区
    private String AQXiangQy;//乡(镇)
    private String AQCunQy;//村
    private String AQPlace;//保存起运地-养殖场
    private String AQTypeQy;//养殖场/交易市场
    private String AQShiDd;//市/州
    private String AQXianDd;//县/市/区
    private String AQDiQuDd;//保存到达地 县/市/区
    private String AQXiangDd;//乡/镇
    private String AQCunDd;//村
    private String AQArr;//保存到达地-养殖场
    private String AQTypeDd;//养殖场/屠宰场/交易市场
    private String AQVeterinary;//官方兽医签字
    private String AQEarTag;//牲畜耳标号
    private String AQXuZhong;//动物种类
    private String AQDanWei;//单位:只/个
    private String AQYongTu;//用途
    private String AQMemo1;//备注
    private String AQMemo2;//拼接启运地
    private String AQMemo3;//拼接到达地
    private int AQYouXiaoRi;//有效到达日


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

    public int getUploadType() {
        return UploadType;
    }

    public void setUploadType(int uploadType) {
        UploadType = uploadType;
    }

    public int getUploadTypeSheng() {
        return UploadTypeSheng;
    }

    public void setUploadTypeSheng(int uploadTypeSheng) {
        UploadTypeSheng = uploadTypeSheng;
    }

    public int getSaveId() {
        return SaveId;
    }

    public void setSaveId(int saveId) {
        SaveId = saveId;
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

    public String getAQDiQuDd() {
        return AQDiQuDd;
    }

    public void setAQDiQuDd(String AQDiQuDd) {
        this.AQDiQuDd = AQDiQuDd;
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

    public String getAQMemo1() {
        return AQMemo1;
    }

    public void setAQMemo1(String AQMemo1) {
        this.AQMemo1 = AQMemo1;
    }

    public String getAQMemo2() {
        return AQMemo2;
    }

    public void setAQMemo2(String AQMemo2) {
        this.AQMemo2 = AQMemo2;
    }

    public String getAQMemo3() {
        return AQMemo3;
    }

    public void setAQMemo3(String AQMemo3) {
        this.AQMemo3 = AQMemo3;
    }

    public int getAQYouXiaoRi() {
        return AQYouXiaoRi;
    }

    public void setAQYouXiaoRi(int AQYouXiaoRi) {
        this.AQYouXiaoRi = AQYouXiaoRi;
    }
}
