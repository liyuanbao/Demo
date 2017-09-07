package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/4.
 */

public class CarDetailAcitivity extends BaseDemoActivity {


    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.iv_pic)
    ImageView mIvPic;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_comment)
    TextView mTvComment;
    @BindView(R.id.tv_laud)
    TextView mTvLaud;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_xc)
    TextView mTvXc;
    @BindView(R.id.tv_jg)
    TextView mTvJg;
    @BindView(R.id.tv_yd)
    TextView mTvYd;
    @BindView(R.id.tv_collect)
    TextView mTvCollect;
    @BindView(R.id.tv_chat)
    TextView mTvChat;
    @BindView(R.id.tv_)
    TextView mTv;
    @BindView(R.id.tv_bm)
    TextView mTvBm;
    @BindView(R.id.bottom)
    LinearLayout mBottom;

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setBackListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_cardetail;
    }

    @Override
    public void setListener() {
        mTvBm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvBm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(mContext,DateChoseActivity.class));
                    }
                });
            }
        });
    }
}
