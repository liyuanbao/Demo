package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/5.
 */

public  class OrderWriteActivity extends BaseDemoActivity {
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
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.rb_man)
    RadioButton mRbMan;
    @BindView(R.id.rb_woman)
    RadioButton mRbWoman;
    @BindView(R.id.rg_sex)
    RadioGroup mRgSex;
    @BindView(R.id.et_tel)
    EditText mEtTel;
    @BindView(R.id.et_email)
    EditText mEtEmail;
    @BindView(R.id.et_youke_name)
    EditText mEtYoukeName;
    @BindView(R.id.lin_add)
    LinearLayout mLinAdd;
    @BindView(R.id.cb_check)
    CheckBox mCbCheck;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;
    @BindView(R.id.tv_totalmoney)
    TextView mTvTotalmoney;
    @BindView(R.id.tv_order_submit)
    TextView mTvOrderSubmit;
    @BindView(R.id.bottom)
    LinearLayout mBottom;

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setToolTitle("填写订单")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        String s = "<font color='#666'>已阅读并同意</font><font color='#D43839'>爱自驾旅游协议</font>";
        mTvXieyi.setText(Html.fromHtml(s));
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //提交订单
        mTvOrderSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,QueRenOrderActivity.class));
            }
        });
    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_orderwrite;
    }
}
