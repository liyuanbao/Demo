package dfy.demo.product.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dfy.demo.R;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/12.
 */

public class OrderWriteAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder> {

    public OrderWriteAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {

        helper.addOnClickListener(R.id.lin_add);
    }
}
