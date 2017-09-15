package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.CrashItemView;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/7.
 * 储值
 */

public class CrashActivity extends BaseDemoActivity {

    @BindView(R.id.toollbar)
    ToolTitle mToollbar;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.civ_item)
    CrashItemView mCivItem;
    @BindView(R.id.tv_chuzhi)
    TextView mTvChuzhi;
    @BindView(R.id.tv_plan_title)
    TextView mTvPlanTitle;
    @BindView(R.id.tv_plan_content)
    TextView mTvPlanContent;


    @Override
    public void initView(Bundle savedInstanceState) {

        mToollbar.setBackListener(this)
                .setToolTitle("储值")
                .setToolRightTwoVisable(false)
                .setToolRightOneVisiable(false);

    }

    @Override
    public void initData() {

    }

    @Override
    protected int getInflaterView() {
        return R.layout.avtivity_crash;
    }

    @Override
    public void setListener() {
        //储值
        mTvChuzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,XiaoFeiDetailActivity.class));
            }
        });
        //条目
        mCivItem.setClickTwoListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,TiXianActivity.class));
            }
        });
    }
}
