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

public class LocalAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {

    public LocalAdapter(@Nullable List<BaseBean> data) {
        super(R.layout.adapter_caritem);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        helper.setText(R.id.tv_money,"￥ 16000");
        helper.setText(R.id.tv_title,"xxxx");
        helper.setText(R.id.tv_address,"xxxx");
        //加载网络图片
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505886473935&di=61c837f0de76967a65b8ab36ed70362a&imgtype=0&src=http%3A%2F%2Fscimg.jb51.net%2Fallimg%2F170319%2F106-1F31912035O46.jpg").crossFade().into((ImageView) helper.getView(R.id.iv_pic));
    }
}
