package com.mingnong.xizangphone.bean;

/**
 * Created by wyw on 2016/11/1.
 */

public class GetHomeBean extends BaseArrayObjectEntity<GetHomeBean.Data> {
    public static class Data {
        /**
         * FStId : 4
         * FmParent : 0
         * FmName : 无害化处理
         * FmOrder : 5
         * img : icon/jycz.PNG
         */
        private String FStId;
        private String FmParent;
        private String FmName;
        private String FmOrder;
        private String img;

        public String getFStId() {
            return FStId;
        }

        public void setFStId(String FStId) {
            this.FStId = FStId;
        }

        public String getFmParent() {
            return FmParent;
        }

        public void setFmParent(String fmParent) {
            FmParent = fmParent;
        }

        public String getFmName() {
            return FmName;
        }

        public void setFmName(String fmName) {
            FmName = fmName;
        }

        public String getFmOrder() {
            return FmOrder;
        }

        public void setFmOrder(String fmOrder) {
            FmOrder = fmOrder;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
