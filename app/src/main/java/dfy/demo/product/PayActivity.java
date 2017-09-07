package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.base.BaseActivity;

/**
 * Created by Admin on 2017/9/5.
 */

public class PayActivity extends BaseDemoActivity {


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
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_timeone)
    TextView mTvTimeone;
    @BindView(R.id.tv_orderdetail)
    LinearLayout mTvOrderdetail;
    @BindView(R.id.tv_jifen)
    TextView mTvJifen;
    @BindView(R.id.cb_select)
    CheckBox mCbSelect;
    @BindView(R.id.lin_item)
    LinearLayout mLinItem;
    @BindView(R.id.tv_totalmoney)
    TextView mTvTotalmoney;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.bottom)
    LinearLayout mBottom;


    @Override
    protected int getInflaterView() {
        return R.layout.activity_pay;
    }
    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setToolTitle("支付")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        mTvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(mContext,PayOkActivity.class));
                    }
                });
            }
        });
    }

}
