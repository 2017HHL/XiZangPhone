package com.mingnong.xizangphone.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/8.
 */

public class ProductBUploadBean implements Serializable {

    public String DateQF;//签发日期
    public String IsPrant;//状态:保存/打印/报废
    public int UploadType;//上传标识符:0未上传,1已上传
    public int UploadTypeSheng;//上传标识符:0未上传,1已上传（区分省上传记录）
    public int SaveId;//数据的自增Id

    public String PBNumber;//编号
    public String PBCargoOwner;//货主
    public String PBName;//产品名称
    public String PBQuantity;//数量
    public String PBOrigin;//产地
    public String PBUnitName;//生产单位名称
    public String PBProductionunit;//生产单位地址
    public String PBDestinations;//目的地
    public String PBSign;//检疫标志号
    public String PBVeterinary;//官方兽医签字
    public String PBDanWei;//单位:至/个
    public int PBYouXiaoRi;//有效到达日                       1
    public String PBHzNumber;

    public int getSaveId() {
        return SaveId;
    }

    public void setSaveId(int saveId) {
        SaveId = saveId;
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

    public String getPBNumber() {
        return PBNumber;
    }

    public void setPBNumber(String PBNumber) {
        this.PBNumber = PBNumber;
    }

    public String getPBCargoOwner() {
        return PBCargoOwner;
    }

    public void setPBCargoOwner(String PBCargoOwner) {
        this.PBCargoOwner = PBCargoOwner;
    }

    public String getPBName() {
        return PBName;
    }

    public void setPBName(String PBName) {
        this.PBName = PBName;
    }

    public String getPBQuantity() {
        return PBQuantity;
    }

    public void setPBQuantity(String PBQuantity) {
        this.PBQuantity = PBQuantity;
    }

    public String getPBOrigin() {
        return PBOrigin;
    }

    public void setPBOrigin(String PBOrigin) {
        this.PBOrigin = PBOrigin;
    }

    public String getPBUnitName() {
        return PBUnitName;
    }

    public void setPBUnitName(String PBUnitName) {
        this.PBUnitName = PBUnitName;
    }

    public String getPBProductionunit() {
        return PBProductionunit;
    }

    public void setPBProductionunit(String PBProductionunit) {
        this.PBProductionunit = PBProductionunit;
    }

    public String getPBDestinations() {
        return PBDestinations;
    }

    public void setPBDestinations(String PBDestinations) {
        this.PBDestinations = PBDestinations;
    }

    public String getPBSign() {
        return PBSign;
    }

    public void setPBSign(String PBSign) {
        this.PBSign = PBSign;
    }

    public String getPBVeterinary() {
        return PBVeterinary;
    }

    public void setPBVeterinary(String PBVeterinary) {
        this.PBVeterinary = PBVeterinary;
    }

    public String getPBDanWei() {
        return PBDanWei;
    }

    public void setPBDanWei(String PBDanWei) {
        this.PBDanWei = PBDanWei;
    }

    public int getPBYouXiaoRi() {
        return PBYouXiaoRi;
    }

    public void setPBYouXiaoRi(int PBYouXiaoRi) {
        this.PBYouXiaoRi = PBYouXiaoRi;
    }

    public String getPBHzNumber() {
        return PBHzNumber;
    }

    public void setPBHzNumber(String PBHzNumber) {
        this.PBHzNumber = PBHzNumber;
    }
}
