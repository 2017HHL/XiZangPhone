package com.mingnong.xizangphone.bean;

/**
 * Created by wyw on 2016/11/1.
 */

public class BaseMsgBean extends BaseObjectEntity<BaseMsgBean.Data> {
    public static class Data{
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }

}
