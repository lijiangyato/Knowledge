package com.knowledge.common.database.common;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public interface IWarehouseUserData  {

    /*增*/
     void increase(int id,String name,int age, boolean esx,IWarehouseGeneral iWarehouseGeneral) ;


    /*删*/
     void delete();



    /*改*/
     void change();



    /*查*/
     void check();

    /*更新*/
    void update();





}
