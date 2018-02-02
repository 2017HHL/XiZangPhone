package com.mingnong.xizangphone.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/8.
 */

public class AnimAUploadBean implements Serializable {

    private String DateQF;//签发日期
    private String IsPrant;//状态:保存/打印/报废
    private int UploadType;//上传标识符:0未上传,1已上传
    private int UploadTypeSheng;//上传标识符:0未上传,1已上传（区分省上传记录）
    private int SaveId;//数据的自增Id
    private String ANumber;//编号
    private String ACargoOwner;//货主
    private String APhone;//联系电话
    private int AQuantity;//数量
    private String AShengQy;//省-市/州
    private String AShiQy;//市-州
    private String AXianQy;//县-市/区
    private String ADiQuQy;//保存启运地--县/市/区
    private String AXiangQy;//乡(镇)
    private String ACunQy;//村
    private String APlace;//保存起运地
    private String ATypeQy;//养殖场/交易市场
    private String AShengDd;//省
    private String AShiDd;//市/州
    private String AXianDd;//县/市/区
    private String ADiQuDd;//保存到达地--县/市/区
    private String AXiangDd;//乡/镇
    private String ACunDd;//村
    private String AArr;//保存到达地 某某 养殖场信息等
    private String ATypeDd;//养殖场/屠宰场/交易市场
    private String ACarrier;//承运人
    private String APhoneCyr;//联系电话
    private String ATrademark;//运载工具牌号
    private String ADisinfection;//装运前消毒情况
    private int AYouXiaoRi;//有效到达日
    private String AVeterinary;//官方兽医签字
    private String ADwPhone;//动物卫生监督所联系电话
    private String AXuZhong;//动物种类
    private String ADanWei;//单位-只/个
    private String AYongTu;//用途
    private String AYunZai;//运载方式
    private String AMemo1;//备注
    private String AMemo2;//拼接启运地
    private String AMemo3;//拼接到达地

    private String AEarTag;// 牲畜耳标号

    public String getAEarTag() {
        return AEarTag;
    }

    public void setAEarTag(String AEarTag) {
        this.AEarTag = AEarTag;
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

    public String getANumber() {
        return ANumber;
    }

    public void setANumber(String ANumber) {
        this.ANumber = ANumber;
    }

    public String getACargoOwner() {
        return ACargoOwner;
    }

    public void setACargoOwner(String ACargoOwner) {
        this.ACargoOwner = ACargoOwner;
    }

    public String getAPhone() {
        return APhone;
    }

    public void setAPhone(String APhone) {
        this.APhone = APhone;
    }

    public int getAQuantity() {
        return AQuantity;
    }

    public void setAQuantity(int AQuantity) {
        this.AQuantity = AQuantity;
    }

    public String getAShengQy() {
        return AShengQy;
    }

    public void setAShengQy(String AShengQy) {
        this.AShengQy = AShengQy;
    }

    public String getAShiQy() {
        return AShiQy;
    }

    public void setAShiQy(String AShiQy) {
        this.AShiQy = AShiQy;
    }

    public String getAXianQy() {
        return AXianQy;
    }

    public void setAXianQy(String AXianQy) {
        this.AXianQy = AXianQy;
    }

    public String getADiQuQy() {
        return ADiQuQy;
    }

    public void setADiQuQy(String ADiQuQy) {
        this.ADiQuQy = ADiQuQy;
    }

    public String getAXiangQy() {
        return AXiangQy;
    }

    public void setAXiangQy(String AXiangQy) {
        this.AXiangQy = AXiangQy;
    }

    public String getACunQy() {
        return ACunQy;
    }

    public void setACunQy(String ACunQy) {
        this.ACunQy = ACunQy;
    }

    public String getAPlace() {
        return APlace;
    }

    public void setAPlace(String APlace) {
        this.APlace = APlace;
    }

    public String getATypeQy() {
        return ATypeQy;
    }

    public void setATypeQy(String ATypeQy) {
        this.ATypeQy = ATypeQy;
    }

    public String getAShengDd() {
        return AShengDd;
    }

    public void setAShengDd(String AShengDd) {
        this.AShengDd = AShengDd;
    }

    public String getAShiDd() {
        return AShiDd;
    }

    public void setAShiDd(String AShiDd) {
        this.AShiDd = AShiDd;
    }

    public String getAXianDd() {
        return AXianDd;
    }

    public void setAXianDd(String AXianDd) {
        this.AXianDd = AXianDd;
    }

    public String getADiQuDd() {
        return ADiQuDd;
    }

    public void setADiQuDd(String ADiQuDd) {
        this.ADiQuDd = ADiQuDd;
    }

    public String getAXiangDd() {
        return AXiangDd;
    }

    public void setAXiangDd(String AXiangDd) {
        this.AXiangDd = AXiangDd;
    }

    public String getACunDd() {
        return ACunDd;
    }

    public void setACunDd(String ACunDd) {
        this.ACunDd = ACunDd;
    }

    public String getAArr() {
        return AArr;
    }

    public void setAArr(String AArr) {
        this.AArr = AArr;
    }

    public String getATypeDd() {
        return ATypeDd;
    }

    public void setATypeDd(String ATypeDd) {
        this.ATypeDd = ATypeDd;
    }

    public String getACarrier() {
        return ACarrier;
    }

    public void setACarrier(String ACarrier) {
        this.ACarrier = ACarrier;
    }

    public String getAPhoneCyr() {
        return APhoneCyr;
    }

    public void setAPhoneCyr(String APhoneCyr) {
        this.APhoneCyr = APhoneCyr;
    }

    public String getATrademark() {
        return ATrademark;
    }

    public void setATrademark(String ATrademark) {
        this.ATrademark = ATrademark;
    }

    public String getADisinfection() {
        return ADisinfection;
    }

    public void setADisinfection(String ADisinfection) {
        this.ADisinfection = ADisinfection;
    }

    public int getAYouXiaoRi() {
        return AYouXiaoRi;
    }

    public void setAYouXiaoRi(int AYouXiaoRi) {
        this.AYouXiaoRi = AYouXiaoRi;
    }

    public String getAVeterinary() {
        return AVeterinary;
    }

    public void setAVeterinary(String AVeterinary) {
        this.AVeterinary = AVeterinary;
    }

    public String getADwPhone() {
        return ADwPhone;
    }

    public void setADwPhone(String ADwPhone) {
        this.ADwPhone = ADwPhone;
    }

    public String getAXuZhong() {
        return AXuZhong;
    }

    public void setAXuZhong(String AXuZhong) {
        this.AXuZhong = AXuZhong;
    }

    public String getADanWei() {
        return ADanWei;
    }

    public void setADanWei(String ADanWei) {
        this.ADanWei = ADanWei;
    }

    public String getAYongTu() {
        return AYongTu;
    }

    public void setAYongTu(String AYongTu) {
        this.AYongTu = AYongTu;
    }

    public String getAYunZai() {
        return AYunZai;
    }

    public void setAYunZai(String AYunZai) {
        this.AYunZai = AYunZai;
    }

    public String getAMemo1() {
        return AMemo1;
    }

    public void setAMemo1(String AMemo1) {
        this.AMemo1 = AMemo1;
    }

    public String getAMemo2() {
        return AMemo2;
    }

    public void setAMemo2(String AMemo2) {
        this.AMemo2 = AMemo2;
    }

    public String getAMemo3() {
        return AMemo3;
    }

    public void setAMemo3(String AMemo3) {
        this.AMemo3 = AMemo3;
    }
}
