package com.mingnong.xizangphone.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wyw on 2016/11/1.
 * homeframgent 里面item的bean
 */

public class HomeBean extends BaseArrayObjectEntity<HomeBean.DataList> implements Serializable {
    public static class DataList implements Serializable {
        private String FStId;
        private String FmParent;
        private String FmName;
        private String FmOrder;
        private String img;
        private String TName;

        /**
         * TID : 1
         * FMPARENT : 39
         * FMNAME : 产品A
         * FMORDER : 1
         * IMG : icon/cpsb.png
         * TNAME :
         * TYPE : 0
         * FSM1 : 1
         */

        private String TID;
        private String FMPARENT;
        private String FMNAME;
        private String FMORDER;
        private String IMG;
        private String TNAME;
        private String TYPE;
        private String FSM1;

        /**
         * name : 编号
         * lx : ANumber
         */

        private List<LXBean> LX;

        public String getTID() {
            return TID;
        }

        public void setTID(String TID) {
            this.TID = TID;
        }

        public String getFMPARENT() {
            return FMPARENT;
        }

        public void setFMPARENT(String FMPARENT) {
            this.FMPARENT = FMPARENT;
        }

        public String getFMNAME() {
            return FMNAME;
        }

        public void setFMNAME(String FMNAME) {
            this.FMNAME = FMNAME;
        }

        public String getFMORDER() {
            return FMORDER;
        }

        public void setFMORDER(String FMORDER) {
            this.FMORDER = FMORDER;
        }

        public String getIMG() {
            return IMG;
        }

        public void setIMG(String IMG) {
            this.IMG = IMG;
        }

        public String getTNAME() {
            return TNAME;
        }

        public void setTNAME(String TNAME) {
            this.TNAME = TNAME;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getFSM1() {
            return FSM1;
        }

        public void setFSM1(String FSM1) {
            this.FSM1 = FSM1;
        }

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

        public List<LXBean> getLX() {
            return LX;
        }

        public String getTName() {
            return TName;
        }

        public void setTName(String TName) {
            this.TName = TName;
        }

        public void setLX(List<LXBean> LX) {
            this.LX = LX;
        }

        public static class LXBean implements Serializable {
            private String name;//编号 货主
            private String lx;//type Anumber

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLx() {
                return lx;
            }

            public void setLx(String lx) {
                this.lx = lx;
            }
        }
    }
}