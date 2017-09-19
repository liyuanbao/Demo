package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.adapter.ChuZhiAdapter;
import dfy.demo.utils.LogUtils;
import dfy.demo.widget.CrashItemView;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/8.
 *
 */

public class XiaoFeiDetailActivity extends BaseDemoActivity {


    @BindView(R.id.toollbar)
    ToolTitle mToollbar;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.civ_item)
    CrashItemView mCivItem;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
    @BindView(R.id.ry_item)
    RecyclerView mRyItem;
    @BindView(R.id.coor)
    CoordinatorLayout mCoor;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    private ChuZhiAdapter mChuZhiAdapter;
    private int page = 1;
    RecyclerViewDivider mRecyclerViewDivider;


    List<BaseBean> mList;
    View inflate;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_xiaofeidetail;
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void initView(Bundle savedInstanceState) {

        mToollbar.setToolTitle("消费明细")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        //给页面设置工具栏
        mRyItem.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        inflate = getLayoutInflater().inflate(R.layout.su_view_empty, (ViewGroup) mRyItem.getParent(),false);
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BaseBean baseBean = new BaseBean();
            baseBean.setCode(i);
            mList.add(baseBean);
        }
        mChuZhiAdapter = new ChuZhiAdapter(R.layout.adapter_chuzhidetal, mList);
        mChuZhiAdapter.setEmptyView(inflate);
        mChuZhiAdapter.openLoadAnimation();
        mRecyclerViewDivider= new RecyclerViewDivider(mContext, DividerItemDecoration.HORIZONTAL, R.drawable.divider_recycler);
        mRyItem.addItemDecoration(mRecyclerViewDivider);
        mRyItem.setAdapter(mChuZhiAdapter);

        //adapter条目点击监听
        mChuZhiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        initRefresh();

    }

    private void initRefresh() {

        mRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                mChuZhiAdapter.setNewData(null);
                mRyItem.removeItemDecoration(mRecyclerViewDivider);
                mRefresh.finishRefresh();
//                mChuZhiAdapter.setEnableLoadMore(true);
            }
        });
        mRefresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                mChuZhiAdapter.addData(mList);
                mRefresh.finishLoadmore();
            }
        });
    }


    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        mCivItem.setClickTwoListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,OrderItemActivity.class));
            }
        });
    }
}
