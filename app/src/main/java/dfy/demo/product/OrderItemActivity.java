package dfy.demo.product;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import dfy.demo.product.adapter.OrderItemAdapter;
import dfy.demo.widget.BaseDilog;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.networklibrary.base.BasePresenter;
import dfy.networklibrary.net.BaseBean;
import dfy.networklibrary.net.ConstantNet;

/**
 * Created by Admin on 2017/9/13.
 */

public class OrderItemActivity extends BaseDemoActivity {


    @BindView(R.id.tool_back)
    TextView mToolBack;
    @BindView(R.id.rb_one)
    RadioButton mRbOne;
    @BindView(R.id.rb_two)
    RadioButton mRbTwo;
    @BindView(R.id.rb_three)
    RadioButton mRbThree;
    @BindView(R.id.rg_title)
    RadioGroup mRgTitle;
    @BindView(R.id.tv_all)
    TextView mTvAll;
    @BindView(R.id.tv_)
    TextView mTv;
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    private OrderItemAdapter mItemAdapter;
    private BaseDilog.Builder mDilogBuilder;
    private int page;
    private int end;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_orderitem;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mDilogBuilder = new BaseDilog.Builder(mContext);
        initRecyclerView();
        initRefresh();
    }

    private void initRefresh() {
        mRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

            }
        });
        mRefresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }
        });
    }


    private void initRecyclerView() {
        List<BaseBean> mList = new ArrayList<>();
        mList.add(new BaseBean());
        mList.add(new BaseBean());
        mList.add(new BaseBean());
        mRecy.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        mRecy.addItemDecoration(new RecyclerViewDivider(mContext, LinearLayoutManager.HORIZONTAL, R.drawable.divider_recycler));

        mItemAdapter = new OrderItemAdapter(0);
        mItemAdapter.setNewData(mList);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.su_view_empty, null, false);
        mItemAdapter.setEmptyView(inflate);
        mRecy.setAdapter(mItemAdapter);

        mItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_cancel://取消
                        mDilogBuilder.setMsgNotification()
                                .setMsg("确认取消订单")
                                .setOkListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                    }
                                }).setCancelListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mDilogBuilder.dismiss();
                            }
                        })
                                .show();
                        break;
                    case R.id.tv_sug://评价
                        toastLong("评价");
                        break;
                    case R.id.tv_pay://付款
                        toastLong("付款");
                        break;
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //返回上一级
        mToolBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
