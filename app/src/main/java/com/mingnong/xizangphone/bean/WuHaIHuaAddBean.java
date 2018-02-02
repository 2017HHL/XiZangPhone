package com.mingnong.xizangphone.bean;


import java.io.Serializable;

/**
 * Created by song on 2017/6/14.
 */

public class WuHaIHuaAddBean  extends BaseArrayObjectEntity<WuHaIHuaAddBean.DataListBean>  {



    public static class DataListBean implements Serializable {
        /**
         * tId : 83
         * ShiName :
         * unitName :
         * sCorporateRe : 刘保国
         * sTel : 15896582236
         * sName : 养猪屠宰场
         */

        private String tId;
        private String ShiName;
        private String unitName;
        private String sCorporateRe;
        private String sTel;
        private String sName;

        public String getTId() {
            return tId;
        }

        public void setTId(String tId) {
            this.tId = tId;
        }

        public String getShiName() {
            return ShiName;
        }

        public void setShiName(String ShiName) {
            this.ShiName = ShiName;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getSCorporateRe() {
            return sCorporateRe;
        }

        public void setSCorporateRe(String sCorporateRe) {
            this.sCorporateRe = sCorporateRe;
        }

        public String getSTel() {
            return sTel;
        }

        public void setSTel(String sTel) {
            this.sTel = sTel;
        }

        public String getSName() {
            return sName;
        }

        public void setSName(String sName) {
            this.sName = sName;
        }
    }
}
