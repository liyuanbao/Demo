package dfy.demo.product.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dfy.demo.R;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/8.
 */

public class ChuZhiAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder>{

    public ChuZhiAdapter(@LayoutRes int layoutResId, @Nullable List<BaseBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {

    }
}





