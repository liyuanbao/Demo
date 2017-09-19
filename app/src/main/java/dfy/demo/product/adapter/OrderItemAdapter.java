package dfy.demo.product.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dfy.demo.R;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/14.
 */

public class OrderItemAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder> {


    public OrderItemAdapter(@LayoutRes int layoutResId) {
        super(R.layout.adapter_orderitem);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {

        helper.setText(R.id.tv_ordernum,"订单编号");
        helper.setText(R.id.tv_orderdate,"日期");
        helper.setText(R.id.tv_title,"标题");
        helper.setText(R.id.tv_loacal,"境内");
        helper.setText(R.id.tv_oktime,"2017-08-05");
        helper.setText(R.id.tv_status,"支付状态");

        helper.addOnClickListener(R.id.tv_cancel)
                .addOnClickListener(R.id.tv_sug)
                .addOnClickListener(R.id.tv_pay);
    }
}
