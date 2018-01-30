package cn.bpzzr.change.bean.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cn.bpzzr.change.net.download.ResInfo;

import cn.bpzzr.change.bean.gen.ResInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig resInfoDaoConfig;

    private final ResInfoDao resInfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        resInfoDaoConfig = daoConfigMap.get(ResInfoDao.class).clone();
        resInfoDaoConfig.initIdentityScope(type);

        resInfoDao = new ResInfoDao(resInfoDaoConfig, this);

        registerDao(ResInfo.class, resInfoDao);
    }
    
    public void clear() {
        resInfoDaoConfig.clearIdentityScope();
    }

    public ResInfoDao getResInfoDao() {
        return resInfoDao;
    }

}
