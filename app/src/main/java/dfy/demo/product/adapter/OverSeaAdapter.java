package dfy.demo.product.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dfy.demo.R;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/20.
 */

public class OverSeaAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder> {

    public OverSeaAdapter(@Nullable List<BaseBean> data) {
        super(R.layout.adapter_caritem);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {

        helper.setText(R.id.tv_money,"￥ 16000");
        helper.setText(R.id.tv_title,"xxxx");
        helper.setText(R.id.tv_address,"xxxx");
        //加载网络图片
        Glide.with(mContext).load("aa").crossFade().into((ImageView) helper.getView(R.id.iv_pic));
    }
}
