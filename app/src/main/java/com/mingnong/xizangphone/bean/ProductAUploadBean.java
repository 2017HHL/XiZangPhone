package com.mingnong.xizangphone.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/8.
 */

public class ProductAUploadBean implements Serializable {

    public String DateQF;//签发日期
    public String IsPrant;//状态:保存/打印/报废
    public int UploadType;//上传标识符:0未上传,1已上传
    public int UploadTypeSheng;//上传标识符:0未上传,1已上传（区分省上传记录）
    public int SaveId;//数据的自增Id

    public String PNumber;//编号
    public String PCargoOwner;//货主
    public String PPhone;//联系电话
    public String PName;//产品名称
    public String PQuantity;//数量
    public String PUnitName;//生产单位名称
    public String PProductionunit;//生产单位地址
    public String PSheng;//省-市/州
    public String PShi;//市-州
    public String PXian;//县-市/区
    public String PCarrier;//承运人
    public String PPhoneCyr;//联系电话
    public String PTrademark;//运载工具牌号
    public String PDisinfection;//装运前消毒方式
    public int PYouXiaoRi;//有效到达日
    public String PVeterinary;//官方兽医签字
    public String PDwPhone;//动物卫生监督所联系电话
    public String PDanWei;//单位-只/个
    public String PYunZai;//运载方式
    public String PMemo1;//备注
    public String PMemo2;//目的地
    public String PMemo3;//保存-县/市/区
    public String PMemo4;//生产单位名称及地址
    public String PDiDian;//县区市后详细地点
    public String PQySheng;
    public String PQyShi;
    public String PQyXian;

    public String getPQySheng() {
        return PQySheng;
    }

    public void setPQySheng(String PQySheng) {
        this.PQySheng = PQySheng;
    }

    public String getPQyShi() {
        return PQyShi;
    }

    public void setPQyShi(String PQyShi) {
        this.PQyShi = PQyShi;
    }

    public String getPQyXian() {
        return PQyXian;
    }

    public void setPQyXian(String PQyXian) {
        this.PQyXian = PQyXian;
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

    public String getPNumber() {
        return PNumber;
    }

    public void setPNumber(String PNumber) {
        this.PNumber = PNumber;
    }

    public String getPCargoOwner() {
        return PCargoOwner;
    }

    public void setPCargoOwner(String PCargoOwner) {
        this.PCargoOwner = PCargoOwner;
    }

    public String getPPhone() {
        return PPhone;
    }

    public void setPPhone(String PPhone) {
        this.PPhone = PPhone;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPQuantity() {
        return PQuantity;
    }

    public void setPQuantity(String PQuantity) {
        this.PQuantity = PQuantity;
    }

    public String getPUnitName() {
        return PUnitName;
    }

    public void setPUnitName(String PUnitName) {
        this.PUnitName = PUnitName;
    }

    public String getPProductionunit() {
        return PProductionunit;
    }

    public void setPProductionunit(String PProductionunit) {
        this.PProductionunit = PProductionunit;
    }

    public String getPSheng() {
        return PSheng;
    }

    public void setPSheng(String PSheng) {
        this.PSheng = PSheng;
    }

    public String getPShi() {
        return PShi;
    }

    public void setPShi(String PShi) {
        this.PShi = PShi;
    }

    public String getPXian() {
        return PXian;
    }

    public void setPXian(String PXian) {
        this.PXian = PXian;
    }

    public String getPCarrier() {
        return PCarrier;
    }

    public void setPCarrier(String PCarrier) {
        this.PCarrier = PCarrier;
    }

    public String getPPhoneCyr() {
        return PPhoneCyr;
    }

    public void setPPhoneCyr(String PPhoneCyr) {
        this.PPhoneCyr = PPhoneCyr;
    }

    public String getPTrademark() {
        return PTrademark;
    }

    public void setPTrademark(String PTrademark) {
        this.PTrademark = PTrademark;
    }

    public String getPDisinfection() {
        return PDisinfection;
    }

    public void setPDisinfection(String PDisinfection) {
        this.PDisinfection = PDisinfection;
    }

    public int getPYouXiaoRi() {
        return PYouXiaoRi;
    }

    public void setPYouXiaoRi(int PYouXiaoRi) {
        this.PYouXiaoRi = PYouXiaoRi;
    }

    public String getPVeterinary() {
        return PVeterinary;
    }

    public void setPVeterinary(String PVeterinary) {
        this.PVeterinary = PVeterinary;
    }

    public String getPDwPhone() {
        return PDwPhone;
    }

    public void setPDwPhone(String PDwPhone) {
        this.PDwPhone = PDwPhone;
    }

    public String getPDanWei() {
        return PDanWei;
    }

    public void setPDanWei(String PDanWei) {
        this.PDanWei = PDanWei;
    }

    public String getPYunZai() {
        return PYunZai;
    }

    public void setPYunZai(String PYunZai) {
        this.PYunZai = PYunZai;
    }

    public String getPMemo1() {
        return PMemo1;
    }

    public void setPMemo1(String PMemo1) {
        this.PMemo1 = PMemo1;
    }

    public String getPMemo2() {
        return PMemo2;
    }

    public void setPMemo2(String PMemo2) {
        this.PMemo2 = PMemo2;
    }

    public String getPMemo3() {
        return PMemo3;
    }

    public void setPMemo3(String PMemo3) {
        this.PMemo3 = PMemo3;
    }

    public String getPMemo4() {
        return PMemo4;
    }

    public void setPMemo4(String PMemo4) {
        this.PMemo4 = PMemo4;
    }

    public String getPDiDian() {
        return PDiDian;
    }

    public void setPDiDian(String PDiDian) {
        this.PDiDian = PDiDian;
    }
}
