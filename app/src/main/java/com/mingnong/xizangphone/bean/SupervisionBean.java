package com.mingnong.xizangphone.bean;

/**
 * Created by wyw on 2016/11/7.
 * 动物申报 获取卫生监督所信息
 */

public class SupervisionBean extends BaseArrayObjectEntity<SupervisionBean.Data>{
    public static class Data {
        private String FLName;
        private String GPSunitUstrId;

        public String getFLName() {
            return FLName;
        }

        public void setFLName(String FLName) {
            this.FLName = FLName;
        }

        public String getGPSunitUstrId() {
            return GPSunitUstrId;
        }

        public void setGPSunitUstrId(String GPSunitUstrId) {
            this.GPSunitUstrId = GPSunitUstrId;
        }
    }
}
