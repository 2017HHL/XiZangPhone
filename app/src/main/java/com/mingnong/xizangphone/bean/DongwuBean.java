package com.mingnong.xizangphone.bean;

/**
 * Created by HUANG on 2017/7/5.
 */
public class DongwuBean extends BaseArrayObjectEntity<DongwuBean.DataListBean>{
    public static class DataListBean {
        /**
         * tId : 1
         * cParent : 1000
         * CName : 猪
         */

        private String tId;
        private String cParent;
        private String CName;

        public String getTId() {
            return tId;
        }

        public void setTId(String tId) {
            this.tId = tId;
        }

        public String getCParent() {
            return cParent;
        }

        public void setCParent(String cParent) {
            this.cParent = cParent;
        }

        public String getCName() {
            return CName;
        }

        public void setCName(String CName) {
            this.CName = CName;
        }
    }
}
