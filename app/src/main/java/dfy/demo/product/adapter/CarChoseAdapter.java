package dfy.demo.product.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dfy.demo.R;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/20.
 */

public class CarChoseAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder> {

    public CarChoseAdapter(@Nullable List<BaseBean> data) {
        super(R.layout.adapter_carchose);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {

    }
}
