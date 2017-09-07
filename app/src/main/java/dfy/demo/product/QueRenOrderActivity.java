package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/5.
 */

public  class QueRenOrderActivity extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.tv_add)
    TextView mTvAdd;
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_person)
    TextView mTvPerson;
    @BindView(R.id.tv_order_date)
    TextView mTvOrderDate;
    @BindView(R.id.tv_order_num)
    TextView mTvOrderNum;
    @BindView(R.id.tv_order_status)
    TextView mTvOrderStatus;
    @BindView(R.id.tv_taocan_title)
    TextView mTvTaocanTitle;
    @BindView(R.id.lin_taocan_info)
    LinearLayout mLinTaocanInfo;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_tel_sex)
    TextView mTvTelSex;
    @BindView(R.id.tv_tel_tel)
    TextView mTvTelTel;
    @BindView(R.id.tv_tel_email)
    TextView mTvTelEmail;
    @BindView(R.id.tv_totalmoney)
    TextView mTvTotalmoney;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.bottom)
    LinearLayout mBottom;


    @Override
    protected int getInflaterView() {
        return R.layout.activity_querenorder;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar.setToolTitle("确认订单")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightOneVisiable(false);

    }


    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //确认支付
        mTvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,PayActivity.class));
            }
        });
    }


}
