package com.knowledge.common.database.configure;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:数据库基本信息配置
 */
@Database(name =ConfigureAppDatabase.NAME,version = ConfigureAppDatabase.VERSION)
public class ConfigureAppDatabase {
    //数据库名称
    public static  final  String NAME="rgzl";
    //数据库版本号
    public static final  int VERSION=1;
}
