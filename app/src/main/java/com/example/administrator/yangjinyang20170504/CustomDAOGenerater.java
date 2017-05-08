package com.example.administrator.yangjinyang20170504;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class CustomDAOGenerater {
    public static void main(String[] args) throws Exception {
        // 第一个参数为数据库版本
        //第二个参数为数据库的包名
        Schema schema = new Schema(1, "com.example.administrator.yangjinyang20170504.db");
        // 创建表,参数为表名
        Entity entity = schema.addEntity("car");
        // 为表添加字段
        entity.addIdProperty();// 该字段为id
        entity.addStringProperty("name");// String类型字段
        entity.addStringProperty("price");// String类型字段
        entity.addStringProperty("content");// String类型字段

        // 生成数据库相关类
        //第二个参数指定生成文件的本次存储路径,AndroidStudio工程指定到当前工程的java路径
        new DaoGenerator().generateAll(schema, "E:\\Teacher\\Yangjinyang20170504\\app\\src\\main\\java");
    }

}
