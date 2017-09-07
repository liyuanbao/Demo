package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;


/**
 * Created by Admin on 2017/9/6.
 */

public class PayOkActivity extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.tv_pay_status)
    TextView mTvPayStatus;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_mingcheng)
    TextView mTvMingcheng;
    @BindView(R.id.tv_order)
    TextView mTvOrder;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_miaoshu)
    TextView mTvMiaoshu;
    @BindView(R.id.tv_ordering)
    TextView mTvOrdering;


    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setBackListener(this)
                .setToolRightTwoVisable(false)
                .setToolRightOneVisiable(false)
                .setToolTitle("支付成功");
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        mTvOrdering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,CarItemActiviy.class));
                finish();
            }
        });
    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_payok;
    }
}
