package com.mingnong.xizangphone.bean;

/**
 * Created by wyw on 2017/5/19.
 */

public class UploadBean {
    private String printId;
    private String tableName;
    private String userId;
    private String json;

    public UploadBean(String tableName, String userId, String json) {
        this.tableName = tableName;
        this.userId = userId;
        this.json = json;
    }

    public UploadBean() {
    }

    public String getPrintId() {
        return printId;
    }

    public void setPrintId(String printId) {
        this.printId = printId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
