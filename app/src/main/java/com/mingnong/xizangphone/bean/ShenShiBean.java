package com.mingnong.xizangphone.bean;

/**
 * Created by HUANG on 2017/7/7.
 */
public class ShenShiBean extends BaseArrayObjectEntity<ShenShiBean.DataListBean>{

    /**
     * errorCode : 0
     * errorMsg : success
     * dataList : [{"tid":"2","uname":"湖北省","utype":"省","uparent":"1"},{"tid":"3","uname":"武汉市","utype":"市","uparent":"2"}]
     */
    public static class DataListBean {
        /**
         * tid : 2
         * uname : 湖北省
         * utype : 省
         * uparent : 1
         */

        private String tid;
        private String uname;
        private String utype;
        private String uparent;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUtype() {
            return utype;
        }

        public void setUtype(String utype) {
            this.utype = utype;
        }

        public String getUparent() {
            return uparent;
        }

        public void setUparent(String uparent) {
            this.uparent = uparent;
        }
    }
}
