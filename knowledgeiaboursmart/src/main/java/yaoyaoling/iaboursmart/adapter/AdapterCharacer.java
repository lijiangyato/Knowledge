package yaoyaoling.iaboursmart.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yaoyaoling.iaboursmart.R;
import yaoyaoling.iaboursmart.adapter.holder.HolderHumanFace;
import yaoyaoling.iaboursmart.entity.EntityCharacer;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class AdapterCharacer extends BaseMultiItemQuickAdapter<EntityCharacer,BaseViewHolder> {
    private Context mContext;

    public AdapterCharacer(Context context,List<EntityCharacer> data) {
        super(data);
        this.mContext=context;
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case EntityCharacer.TYPE_ONE:
                return new HolderHumanFace(mLayoutInflater.inflate(R.layout.adapter_holder_human_face,parent,false));
        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityCharacer item) {

    }

}
