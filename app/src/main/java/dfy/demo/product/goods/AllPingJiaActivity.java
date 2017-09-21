package dfy.demo.product.goods;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.adapter.AllPingJiaAdapter;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/20.
 */

public class AllPingJiaActivity extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;

    private AllPingJiaAdapter mPJAdapter;
    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar.setBackListener(this)
                .setToolTitle("点评")
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecy.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        mPJAdapter=new AllPingJiaAdapter(null);
        mPJAdapter.setEmptyView(R.layout.adapter_allpingjia, (ViewGroup) mRecy.getParent());
        mRecy.addItemDecoration(new RecyclerViewDivider(mContext,LinearLayoutManager.HORIZONTAL,R.drawable.divider_recycler));
        ArrayList<BaseBean> arrayList=new ArrayList<>();
        arrayList.add(new BaseBean());
        arrayList.add(new BaseBean());
        arrayList.add(new BaseBean());
        mPJAdapter.setNewData(arrayList);
        mRecy.setAdapter(mPJAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_allpingjia;
    }

}
