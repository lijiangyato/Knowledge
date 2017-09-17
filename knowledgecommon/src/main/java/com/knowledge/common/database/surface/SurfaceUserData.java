package com.knowledge.common.database.surface;

import com.knowledge.common.database.configure.ConfigureAppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:数据表蚂蚁女王
 */

@Table(database = ConfigureAppDatabase.class)
public class SurfaceUserData extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    /*姓名*/
    @Column
    private String name;
    /*年龄*/
    @Column
    private int age;
    /*性别*/
    @Column
    private boolean sex;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
