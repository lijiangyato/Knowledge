package com.knowledge.common.database.common.warehouse;


import android.content.Context;


import com.knowledge.common.database.common.IWarehouseGeneral;
import com.knowledge.common.database.common.IWarehouseUserData;
import com.knowledge.common.database.surface.SurfaceUserData;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class WarehouseUserData implements IWarehouseUserData {
    private Context mContext;
    private SurfaceUserData mSurfaceUserData;
    private IWarehouseGeneral mIWarehouseGeneral;
    private ModelAdapter<SurfaceUserData> mModelAdapter;

    public WarehouseUserData(Context context) {

        mSurfaceUserData = new SurfaceUserData();

    }

    /*增*/
    @Override
    public void increase(int id, String name, int age, boolean esx, IWarehouseGeneral iWarehouseGeneral) {
        mSurfaceUserData.id=id;
        mSurfaceUserData.setName(name);
        mSurfaceUserData.setAge(age);
        mSurfaceUserData.setSex(esx);
        mModelAdapter = FlowManager.getModelAdapter(SurfaceUserData.class);
        //增加
        mModelAdapter.insert(mSurfaceUserData);
        //保存
        mModelAdapter.save(mSurfaceUserData);

    }
     /*删*/
    @Override
    public void delete() {

    }
    /*改*/
    @Override
    public void change() {

    }
    /*查*/
    @Override
    public void check() {

    }

    @Override
    public void update() {

    }



/*

    mSurfaceUserData = new SurfaceUserData();
       */
/* mSurfaceUserData.id = 1;
        mSurfaceUserData.name = "张三";
        mSurfaceUserData.age = 20;
        mSurfaceUserData.sex = true;*//*



    ModelAdapter<SurfaceUserData> adapter = FlowManager.getModelAdapter(SurfaceUserData.class);
    //增
        adapter.insert(mSurfaceUserData);

    //mSurfaceUserData.name = "李四";
    //更新
        adapter.update(mSurfaceUserData);
    //删除
        adapter.delete(mSurfaceUserData);



       */
/* //增
        mSurfaceUserData.insert();
        //更新
        mSurfaceUserData.update();
        //删除
        mSurfaceUserData.delete();
        //保存
        mSurfaceUserData.save();
*//*



    //textView.setText(mSurfaceUserData.name);
*/

}
