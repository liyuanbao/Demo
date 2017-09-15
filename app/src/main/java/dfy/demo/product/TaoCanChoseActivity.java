package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.adapter.TaoCanKuanAdapter;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/5.
 */

public class TaoCanChoseActivity extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.re_item)
    RecyclerView mReItem;
    @BindView(R.id.tv_totalmoney)
    TextView mTvTotalmoney;
    @BindView(R.id.tv_next)
    TextView mTvNext;
    @BindView(R.id.bottom)
    LinearLayout mBottom;

    private TaoCanKuanAdapter mKuanAdapter;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_taocanchose;
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar.setBackground(R.color.color_tool_bg_red)
                .setToolTitle("套餐选择")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        initRecyclerView();
    }

    @Override
    public void initData() {

    }

    /**
     * 初始化RecyclerViwe
     */
    private void initRecyclerView(){
        mReItem.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        mReItem.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        mKuanAdapter=new TaoCanKuanAdapter(mContext);
        mReItem.setAdapter(mKuanAdapter);
    }

    @Override
    public void setListener() {
        mTvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,OrderWriteActivity.class));
            }
        });
    }


}
