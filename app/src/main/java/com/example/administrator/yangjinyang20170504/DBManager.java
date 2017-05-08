package com.example.administrator.yangjinyang20170504;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.yangjinyang20170504.db.DaoMaster;
import com.example.administrator.yangjinyang20170504.db.DaoSession;
import com.example.administrator.yangjinyang20170504.db.car;
import com.example.administrator.yangjinyang20170504.db.carDao;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class DBManager {

    private final static String dbName = "car.db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /**
     * 插入数据
     */
    public long insertUser(car car) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        carDao userDao = daoSession.getCarDao();
        long l = userDao.insertOrReplace(car);
        return l;

    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 查询用户列表
     */
    public List<car> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        carDao userDao = daoSession.getCarDao();
        QueryBuilder<car> qb = userDao.queryBuilder();
        List<car> list = qb.list();
        return list;
    }


}
