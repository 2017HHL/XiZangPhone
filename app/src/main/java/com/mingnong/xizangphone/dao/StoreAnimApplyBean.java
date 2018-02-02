package com.mingnong.xizangphone.dao;

/**
 * Created by wyw on 2017/2/21.
 */

import com.mingnong.xizangphone.dao.local.AnimalApplyBeanDao;
import com.mingnong.xizangphone.dao.local.DaoSession;
import com.mingnong.xizangphone.dao.local.StoreAnimApplyBeanDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * 动物申报信息 用来上传使用
 * 包含了
 */
@Entity(nameInDb = "StoreAnimApplyBean")
public class StoreAnimApplyBean {

    @Id(autoincrement = true)
    private Long id;

    private String userId;

    private String type;

    private Long beanId;

    @ToOne(joinProperty = "beanId")
    private AnimalApplyBean bean;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 405947308)
    private transient StoreAnimApplyBeanDao myDao;

    @Generated(hash = 1174426436)
    public StoreAnimApplyBean(Long id, String userId, String type, Long beanId) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.beanId = beanId;
    }

    @Generated(hash = 238542960)
    public StoreAnimApplyBean() {
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
    @Generated(hash = 253618366)
    public AnimalApplyBean getBean() {
        Long __key = this.beanId;
        if (bean__resolvedKey == null || !bean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AnimalApplyBeanDao targetDao = daoSession.getAnimalApplyBeanDao();
            AnimalApplyBean beanNew = targetDao.load(__key);
            synchronized (this) {
                bean = beanNew;
                bean__resolvedKey = __key;
            }
        }
        return bean;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 790382007)
    public void setBean(AnimalApplyBean bean) {
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
    @Generated(hash = 825638462)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStoreAnimApplyBeanDao() : null;
    }



}
