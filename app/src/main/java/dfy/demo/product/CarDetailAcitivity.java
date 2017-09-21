package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.goods.AllPingJiaActivity;
import dfy.demo.widget.BaseDilog;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/4.
 */

public class CarDetailAcitivity extends BaseDemoActivity {

    @BindView(R.id.iv_pic)
    ImageView mIvPic;
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_picedetail)
    TextView mTvPicedetail;
    @BindView(R.id.ln_xing)
    LinearLayout mLnXing;
    @BindView(R.id.rv_pj)
    RecyclerView mRvPj;
    @BindView(R.id.tv_pj)
    TextView mTvPj;
    @BindView(R.id.ln_pj)
    LinearLayout mLnPj;
    @BindView(R.id.ln_webview)
    LinearLayout mLnWebview;
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
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.rv_date)
    RecyclerView mRvDate;
    BaseDilog.Builder mBuilder;


    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setBackListener(this)
                .setToolTextVisiable(false)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);
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
        //
        mTvBm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, DateChoseActivity.class));
            }
        });

        //查看全部评论
        mTvPj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginActivity(AllPingJiaActivity.class);
            }
        });
        //查看价格明细
        mTvPicedetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuilder= new BaseDilog.Builder(mContext);
                mBuilder.setInflaterView(R.layout.dialog_pricedetail)
                        .setShowMatchLocation()
                        .setCancelTouch(true)
                        .show();
                initDialog();
            }
        });
    }

    private void initDialog() {

        final TextView cancel=mBuilder.findViewById(R.id.tv_cancel);
        TextView title=mBuilder.findViewById(R.id.tv_title);
        LinearLayout  item=mBuilder.findViewById(R.id.ln_item);
        TextView money=mBuilder.findViewById(R.id.tv_money);

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_ln_tv, null, false);
        item.addView(inflate);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuilder.dismiss();
            }
        });

    }
}
