package com.mingnong.xizangphone.dao;

import com.mingnong.xizangphone.dao.local.DaoSession;
import com.mingnong.xizangphone.dao.local.Product_ADao;
import com.mingnong.xizangphone.dao.local.StoreProductADao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by wyw on 2017/2/21.
 */

@Entity(nameInDb = "StoreProductA")
public class StoreProductA {
    @Id(autoincrement = true)
    private Long id;
    private Long beanId;
    private String userId;
    private String tableName;
    @ToOne(joinProperty = "beanId")
    private Product_A bean;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1653307514)
    private transient StoreProductADao myDao;
    @Generated(hash = 2095499535)
    public StoreProductA(Long id, Long beanId, String userId, String tableName) {
        this.id = id;
        this.beanId = beanId;
        this.userId = userId;
        this.tableName = tableName;
    }
    @Generated(hash = 178002082)
    public StoreProductA() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBeanId() {
        return this.beanId;
    }
    public void setBeanId(Long beanId) {
        this.beanId = beanId;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTableName() {
        return this.tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    @Generated(hash = 871179490)
    private transient Long bean__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 734427849)
    public Product_A getBean() {
        Long __key = this.beanId;
        if (bean__resolvedKey == null || !bean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            Product_ADao targetDao = daoSession.getProduct_ADao();
            Product_A beanNew = targetDao.load(__key);
            synchronized (this) {
                bean = beanNew;
                bean__resolvedKey = __key;
            }
        }
        return bean;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 766011464)
    public void setBean(Product_A bean) {
        synchronized (this) {
            this.bean = bean;
            beanId = bean == null ? null : bean.getTId();
            bean__resolvedKey = beanId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 349371482)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStoreProductADao() : null;
    }
}
