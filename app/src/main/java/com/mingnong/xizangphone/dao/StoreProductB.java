package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.mingnong.xizangphone.dao.local.DaoSession;
import com.mingnong.xizangphone.dao.local.Product_BDao;
import com.mingnong.xizangphone.dao.local.StoreProductBDao;

/**
 * Created by wyw on 2017/2/21.
 */

@Entity(nameInDb = "StoreProductB")
public class StoreProductB {
    @Id(autoincrement = true)
    private Long id;
    private Long beanId;
    private String userId;
    private String tableName;
    @ToOne(joinProperty = "beanId")
    private Product_B bean;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1466851756)
    private transient StoreProductBDao myDao;
    @Generated(hash = 780703854)
    public StoreProductB(Long id, Long beanId, String userId, String tableName) {
        this.id = id;
        this.beanId = beanId;
        this.userId = userId;
        this.tableName = tableName;
    }
    @Generated(hash = 1553649421)
    public StoreProductB() {
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
    @Generated(hash = 1083888300)
    public Product_B getBean() {
        Long __key = this.beanId;
        if (bean__resolvedKey == null || !bean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            Product_BDao targetDao = daoSession.getProduct_BDao();
            Product_B beanNew = targetDao.load(__key);
            synchronized (this) {
                bean = beanNew;
                bean__resolvedKey = __key;
            }
        }
        return bean;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 494430864)
    public void setBean(Product_B bean) {
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
    @Generated(hash = 1582885605)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStoreProductBDao() : null;
    }
}
