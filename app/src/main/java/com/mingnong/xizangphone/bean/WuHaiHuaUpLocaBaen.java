package com.mingnong.xizangphone.bean;

/**
 * Created by song on 2017/6/12.
 */

public class WuHaiHuaUpLocaBaen   extends BaseObjectEntity<WuHaiHuaUpLocaBaen.Data>{
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
