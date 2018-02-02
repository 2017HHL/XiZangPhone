package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;

/**
 * Created by wyw on 2017/2/17.
 * 离线缓存数据的table
 * 将数据库中的数据 与 shareperference中的进行比较符合的拿出来
 * 根据用户id和type 确定是哪个界面
 * type 是当前类的名字
 * value 是json数据
 */
@Keep
@Entity
public class CacheTable {
    @Id(autoincrement = true)
    public Long id;

    public String type;

    public String userId;

    public String value;

    @Generated(hash = 618105642)
    public CacheTable(Long id, String type, String userId, String value) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.value = value;
    }

    @Generated(hash = 19984151)
    public CacheTable() {
    }

    public Long getId() {
        return id;
    }

    public CacheTable setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public CacheTable setType(String type) {
        this.type = type;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public CacheTable setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public CacheTable setValue(String value) {
        this.value = value;
        return this;
    }
}
