package dfy.demo.product.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dfy.demo.R;
import dfy.demo.utils.CircleTransform;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/20.
 */

public class AllPingJiaAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder> {

    public AllPingJiaAdapter(@Nullable List<BaseBean> data) {
        super(R.layout.adapter_allpingjia);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        helper.setText(R.id.tv_name,"xxxx");
        helper.setText(R.id.tv_date,"xxxx");
        helper.setText(R.id.tv_content,"xxx");
        RatingBar rb_live = helper.getView(R.id.rb_live);
        RatingBar rb_car = helper.getView(R.id.rb_car);
        RatingBar rb_play = helper.getView(R.id.rb_play);
        RatingBar rb_pr = helper.getView(R.id.rb_product);
        rb_live.setRating(3.5f);

        helper.setText(R.id.tv_live,"xxx");
        helper.setText(R.id.tv_car,"xxxx");
        helper.setText(R.id.tv_play,"xxx");
        helper.setText(R.id.tv_product,"xxx");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505886473935&di=61c837f0de76967a65b8ab36ed70362a&imgtype=0&src=http%3A%2F%2Fscimg.jb51.net%2Fallimg%2F170319%2F106-1F31912035O46.jpg").crossFade().transform(new CircleTransform(mContext)).into((ImageView) helper.getView(R.id.iv_head));
    }
}
