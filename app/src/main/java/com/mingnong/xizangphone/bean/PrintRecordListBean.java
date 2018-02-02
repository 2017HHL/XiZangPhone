package com.mingnong.xizangphone.bean;

/**
 * Created by wyw on 2016/11/30.
 */

public class PrintRecordListBean extends BaseArrayObjectEntity<PrintRecordListBean.DataListBean>{

    public static class DataListBean {
        private String FStId;
        private String ANumber;
        private String ACargoOwner;
        private String DateQF;
        private String IsPrant;

        public String getFStId() {
            return FStId;
        }

        public void setFStId(String FStId) {
            this.FStId = FStId;
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

        public String getDateQF() {
            return DateQF;
        }

        public void setDateQF(String DateQF) {
            this.DateQF = DateQF;
        }

        public String getIsPrant() {
            return IsPrant;
        }

        public void setIsPrant(String IsPrant) {
            this.IsPrant = IsPrant;
        }
    }
}
