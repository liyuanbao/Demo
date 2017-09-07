package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.adapter.CarItemAdapter;
import dfy.demo.product.listener.OnClickListener;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.base.BaseActivity;
import dfy.networklibrary.widget.RecyclerViewEmptyView;
import okhttp3.MultipartBody;

/**
 * Created by Admin on 2017/9/4.
 */

public  class CarItemActiviy extends BaseDemoActivity {

    private ToolTitle mToolbar;
    private SmartRefreshLayout mRefrash;
    private RecyclerViewEmptyView mRcItemShow;
    private LinearLayout mEmpty;
    private CarItemAdapter mCarItemAdapter;


    /**
     * 初始化RewcyclerView
     */
    private void initRecyclerView() {
        mRcItemShow.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRcItemShow.setEmptyView(mEmpty);
        mCarItemAdapter=new CarItemAdapter(this);
        mRcItemShow.setAdapter(mCarItemAdapter);
        mRcItemShow.addItemDecoration(new RecyclerViewDivider(mContext,RecyclerViewDivider.VERTICAL_LIST));
        mCarItemAdapter.setOnClickListener(new OnClickListener() {
            @Override
            public void OnClickListener(View view, int position) {
                startActivity(new Intent(mContext,CarDetailAcitivity.class));
            }
        });
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar = (ToolTitle) findViewById(R.id.toolbar);
        mRefrash = (SmartRefreshLayout) findViewById(R.id.refrash);
        mRcItemShow = (RecyclerViewEmptyView) findViewById(R.id.rc_item_show);
        mEmpty = (LinearLayout) findViewById(R.id.empty);

        mToolbar.setBackground(R.color.color_tool_bg_red);
        mToolbar.setToolTitle("自驾租车");
        mToolbar.setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        initRecyclerView();
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //返回上一级
        mToolbar.setBackListener(this);
    }

    @Override
    protected int getInflaterView() {
        return R.layout.activiy_caritem;
    }

}
