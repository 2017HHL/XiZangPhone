package com.mingnong.xizangphone.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */

public class QueryProductABean extends BaseArrayObjectEntity<QueryProductABean.DataListBean>  {

    public static class DataListBean implements Serializable {
        /**
         * TID : 4913
         * CTIME : /Date(1495160917200)/
         * UTIME : /Date(1495160917200)/
         * MEMO1 :
         * MEMO2 :
         * MEMO3 :
         * PNUMBER : 益菌多
         * PCARGOOWNER : 都好好的
         * PPHONE : 会打电话
         * PNAME : 畜产品其他畜产品
         * PQUANTITY : 1.0
         * PUNITNAME : 好的好的
         * PPRODUCTIONUNIT : 难道你
         * PSHENG : 西藏自治区
         * PSHI : 拉萨市
         * PXIAN : 城关区
         * PCARRIER : 你的电脑
         * PPHONECYR : 你的电脑
         * PTRADEMARK : 现酿酸奶
         * PDISINFECTION : 三氯异氰脲酸钠
         * PYOUXIAORI : 1
         * PVETERINARY :
         * PDWPHONE : 你寻寻觅觅
         * PDANWEI : 吨
         * PYUNZAI : 公路
         * DATEQF : /Date(1495160880000)/
         * PMEMO1 : 那些
         * PMEMO2 : 等你
         * PMEMO3 : 湖北省武汉市江岸区
         * PMEMO4 : 好的好的难道你
         * ISPRANT : 保存
         * SAVEID : 1
         * PDIDIAN : 难道你
         * UPLOADTYPE : 1
         * UPLOADTYPESHENG : 1
         * M1 :
         * M2 :
         * M3 :
         * M4 :
         * M5 :
         * PQYSHENG : null
         * PQYSHI : null
         * PQYXIAN : null
         */

        private int TID;
        private String CTIME;
        private String UTIME;
        private String MEMO1;
        private String MEMO2;
        private String MEMO3;
        private String PNUMBER;
        private String PCARGOOWNER;
        private String PPHONE;
        private String PNAME;
        private double PQUANTITY;
        private String PUNITNAME;
        private String PPRODUCTIONUNIT;
        private String PSHENG;
        private String PSHI;
        private String PXIAN;
        private String PCARRIER;
        private String PPHONECYR;
        private String PTRADEMARK;
        private String PDISINFECTION;
        private int PYOUXIAORI;
        private String PVETERINARY;
        private String PDWPHONE;
        private String PDANWEI;
        private String PYUNZAI;
        private String DATEQF;
        private String PMEMO1;
        private String PMEMO2;
        private String PMEMO3;
        private String PMEMO4;
        private String ISPRANT;
        private int SAVEID;
        private String PDIDIAN;
        private int UPLOADTYPE;
        private int UPLOADTYPESHENG;
        private String M1;
        private String M2;
        private String M3;
        private String M4;
        private String M5;
        private Object PQYSHENG;
        private Object PQYSHI;
        private Object PQYXIAN;

        public int getTID() {
            return TID;
        }

        public void setTID(int TID) {
            this.TID = TID;
        }

        public String getCTIME() {
            return CTIME;
        }

        public void setCTIME(String CTIME) {
            this.CTIME = CTIME;
        }

        public String getUTIME() {
            return UTIME;
        }

        public void setUTIME(String UTIME) {
            this.UTIME = UTIME;
        }

        public String getMEMO1() {
            return MEMO1;
        }

        public void setMEMO1(String MEMO1) {
            this.MEMO1 = MEMO1;
        }

        public String getMEMO2() {
            return MEMO2;
        }

        public void setMEMO2(String MEMO2) {
            this.MEMO2 = MEMO2;
        }

        public String getMEMO3() {
            return MEMO3;
        }

        public void setMEMO3(String MEMO3) {
            this.MEMO3 = MEMO3;
        }

        public String getPNUMBER() {
            return PNUMBER;
        }

        public void setPNUMBER(String PNUMBER) {
            this.PNUMBER = PNUMBER;
        }

        public String getPCARGOOWNER() {
            return PCARGOOWNER;
        }

        public void setPCARGOOWNER(String PCARGOOWNER) {
            this.PCARGOOWNER = PCARGOOWNER;
        }

        public String getPPHONE() {
            return PPHONE;
        }

        public void setPPHONE(String PPHONE) {
            this.PPHONE = PPHONE;
        }

        public String getPNAME() {
            return PNAME;
        }

        public void setPNAME(String PNAME) {
            this.PNAME = PNAME;
        }

        public double getPQUANTITY() {
            return PQUANTITY;
        }

        public void setPQUANTITY(double PQUANTITY) {
            this.PQUANTITY = PQUANTITY;
        }

        public String getPUNITNAME() {
            return PUNITNAME;
        }

        public void setPUNITNAME(String PUNITNAME) {
            this.PUNITNAME = PUNITNAME;
        }

        public String getPPRODUCTIONUNIT() {
            return PPRODUCTIONUNIT;
        }

        public void setPPRODUCTIONUNIT(String PPRODUCTIONUNIT) {
            this.PPRODUCTIONUNIT = PPRODUCTIONUNIT;
        }

        public String getPSHENG() {
            return PSHENG;
        }

        public void setPSHENG(String PSHENG) {
            this.PSHENG = PSHENG;
        }

        public String getPSHI() {
            return PSHI;
        }

        public void setPSHI(String PSHI) {
            this.PSHI = PSHI;
        }

        public String getPXIAN() {
            return PXIAN;
        }

        public void setPXIAN(String PXIAN) {
            this.PXIAN = PXIAN;
        }

        public String getPCARRIER() {
            return PCARRIER;
        }

        public void setPCARRIER(String PCARRIER) {
            this.PCARRIER = PCARRIER;
        }

        public String getPPHONECYR() {
            return PPHONECYR;
        }

        public void setPPHONECYR(String PPHONECYR) {
            this.PPHONECYR = PPHONECYR;
        }

        public String getPTRADEMARK() {
            return PTRADEMARK;
        }

        public void setPTRADEMARK(String PTRADEMARK) {
            this.PTRADEMARK = PTRADEMARK;
        }

        public String getPDISINFECTION() {
            return PDISINFECTION;
        }

        public void setPDISINFECTION(String PDISINFECTION) {
            this.PDISINFECTION = PDISINFECTION;
        }

        public int getPYOUXIAORI() {
            return PYOUXIAORI;
        }

        public void setPYOUXIAORI(int PYOUXIAORI) {
            this.PYOUXIAORI = PYOUXIAORI;
        }

        public String getPVETERINARY() {
            return PVETERINARY;
        }

        public void setPVETERINARY(String PVETERINARY) {
            this.PVETERINARY = PVETERINARY;
        }

        public String getPDWPHONE() {
            return PDWPHONE;
        }

        public void setPDWPHONE(String PDWPHONE) {
            this.PDWPHONE = PDWPHONE;
        }

        public String getPDANWEI() {
            return PDANWEI;
        }

        public void setPDANWEI(String PDANWEI) {
            this.PDANWEI = PDANWEI;
        }

        public String getPYUNZAI() {
            return PYUNZAI;
        }

        public void setPYUNZAI(String PYUNZAI) {
            this.PYUNZAI = PYUNZAI;
        }

        public String getDATEQF() {
            return DATEQF;
        }

        public void setDATEQF(String DATEQF) {
            this.DATEQF = DATEQF;
        }

        public String getPMEMO1() {
            return PMEMO1;
        }

        public void setPMEMO1(String PMEMO1) {
            this.PMEMO1 = PMEMO1;
        }

        public String getPMEMO2() {
            return PMEMO2;
        }

        public void setPMEMO2(String PMEMO2) {
            this.PMEMO2 = PMEMO2;
        }

        public String getPMEMO3() {
            return PMEMO3;
        }

        public void setPMEMO3(String PMEMO3) {
            this.PMEMO3 = PMEMO3;
        }

        public String getPMEMO4() {
            return PMEMO4;
        }

        public void setPMEMO4(String PMEMO4) {
            this.PMEMO4 = PMEMO4;
        }

        public String getISPRANT() {
            return ISPRANT;
        }

        public void setISPRANT(String ISPRANT) {
            this.ISPRANT = ISPRANT;
        }

        public int getSAVEID() {
            return SAVEID;
        }

        public void setSAVEID(int SAVEID) {
            this.SAVEID = SAVEID;
        }

        public String getPDIDIAN() {
            return PDIDIAN;
        }

        public void setPDIDIAN(String PDIDIAN) {
            this.PDIDIAN = PDIDIAN;
        }

        public int getUPLOADTYPE() {
            return UPLOADTYPE;
        }

        public void setUPLOADTYPE(int UPLOADTYPE) {
            this.UPLOADTYPE = UPLOADTYPE;
        }

        public int getUPLOADTYPESHENG() {
            return UPLOADTYPESHENG;
        }

        public void setUPLOADTYPESHENG(int UPLOADTYPESHENG) {
            this.UPLOADTYPESHENG = UPLOADTYPESHENG;
        }

        public String getM1() {
            return M1;
        }

        public void setM1(String M1) {
            this.M1 = M1;
        }

        public String getM2() {
            return M2;
        }

        public void setM2(String M2) {
            this.M2 = M2;
        }

        public String getM3() {
            return M3;
        }

        public void setM3(String M3) {
            this.M3 = M3;
        }

        public String getM4() {
            return M4;
        }

        public void setM4(String M4) {
            this.M4 = M4;
        }

        public String getM5() {
            return M5;
        }

        public void setM5(String M5) {
            this.M5 = M5;
        }

        public Object getPQYSHENG() {
            return PQYSHENG;
        }

        public void setPQYSHENG(Object PQYSHENG) {
            this.PQYSHENG = PQYSHENG;
        }

        public Object getPQYSHI() {
            return PQYSHI;
        }

        public void setPQYSHI(Object PQYSHI) {
            this.PQYSHI = PQYSHI;
        }

        public Object getPQYXIAN() {
            return PQYXIAN;
        }

        public void setPQYXIAN(Object PQYXIAN) {
            this.PQYXIAN = PQYXIAN;
        }
    }
}
