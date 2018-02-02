package com.mingnong.xizangphone.bean;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */

public class Permission {
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
        private ImageView IMG;
        private String TNAME;
        private String TYPE;
        private String FSM1;

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

        public ImageView getIMG() {
            return IMG;
        }

        public void setIMG(ImageView IMG) {
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
}
