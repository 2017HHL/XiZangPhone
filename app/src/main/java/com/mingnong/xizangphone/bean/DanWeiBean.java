package com.mingnong.xizangphone.bean;

/**
 * Created by HUANG on 2017/7/6.
 */
public class DanWeiBean extends BaseArrayObjectEntity<DanWeiBean.DataListBean>{
    public static class DataListBean {
        /**
         * tid : 347
         * cName : 屠宰
         */

        private String tid;
        private String cName;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getCName() {
            return cName;
        }

        public void setCName(String cName) {
            this.cName = cName;
        }
    }
}
