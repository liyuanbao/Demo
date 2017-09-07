package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/6.
 */

public class ChuZhiActivity extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.rb_wechat)
    RadioButton mRbWechat;
    @BindView(R.id.rb_alipay)
    RadioButton mRbAlipay;
    @BindView(R.id.et_money)
    EditText mEtMoney;
    @BindView(R.id.tv_chongzhi)
    TextView mTvChongzhi;
    @BindView(R.id.lin_activity)
    LinearLayout mLinActivity;


    @Override
    protected int getInflaterView() {
        return R.layout.activity_chuzhi;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setToolTitle("储值")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

        mTvChongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,TelYanZhenActivity.class));
            }
        });
    }


}
