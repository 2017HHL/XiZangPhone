package com.mingnong.xizangphone.bean;

/**
 * Created by wyw on 2016/10/31.
 */

public class UpdateBean extends BaseArrayObjectEntity<UpdateBean.Data> {

    public static class Data{
        private String versionCode;
        private boolean needUpdate;
        private int type;

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public boolean isNeedUpdate() {
            return needUpdate;
        }

        public void setNeedUpdate(boolean needUpdate) {
            this.needUpdate = needUpdate;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
