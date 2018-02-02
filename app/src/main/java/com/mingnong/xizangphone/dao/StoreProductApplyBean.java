package com.mingnong.xizangphone.dao;

import com.mingnong.xizangphone.dao.local.DaoSession;
import com.mingnong.xizangphone.dao.local.ProductApplyBeanDao;
import com.mingnong.xizangphone.dao.local.StoreProductApplyBeanDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by wyw on 2017/2/21.
 */
@Entity(nameInDb = "StoreProductApplyBean")
public class StoreProductApplyBean {
    @Id(autoincrement = true)
    private Long id;

    private String userId;

    private String type;

    private Long beanId;

    @ToOne(joinProperty = "beanId")
    private ProductApplyBean bean;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1387349291)
    private transient StoreProductApplyBeanDao myDao;

    @Generated(hash = 1139365093)
    public StoreProductApplyBean(Long id, String userId, String type, Long beanId) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.beanId = beanId;
    }

    @Generated(hash = 1744408349)
    public StoreProductApplyBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBeanId() {
        return this.beanId;
    }

    public void setBeanId(Long beanId) {
        this.beanId = beanId;
    }

    @Generated(hash = 871179490)
    private transient Long bean__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 653218313)
    public ProductApplyBean getBean() {
        Long __key = this.beanId;
        if (bean__resolvedKey == null || !bean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProductApplyBeanDao targetDao = daoSession.getProductApplyBeanDao();
            ProductApplyBean beanNew = targetDao.load(__key);
            synchronized (this) {
                bean = beanNew;
                bean__resolvedKey = __key;
            }
        }
        return bean;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 777237622)
    public void setBean(ProductApplyBean bean) {
        synchronized (this) {
            this.bean = bean;
            beanId = bean == null ? null : bean.getId();
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
    @Generated(hash = 1380551167)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStoreProductApplyBeanDao()
                : null;
    }
}
