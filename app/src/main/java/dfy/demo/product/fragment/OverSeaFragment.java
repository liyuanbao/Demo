package dfy.demo.product.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dfy.demo.BaseFragment;
import dfy.demo.R;
import dfy.demo.product.CarDetailAcitivity;
import dfy.demo.product.adapter.LocalAdapter;
import dfy.demo.product.adapter.OverSeaAdapter;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/19.
 */

public class OverSeaFragment extends BaseFragment {

    @BindView(R.id.rv_item)
    RecyclerView mRvItem;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;

    private OverSeaAdapter mOverSeaAdapter;
    private int page=1;
    private int end;

    public static OverSeaFragment newInstance() {
        return new OverSeaFragment();
    }

    @Override
    public int setInflaterView() {
        return R.layout.item_recy;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        initRecyclerView();
    }

    /**
     * 初始化RewcyclerView
     */
    private void initRecyclerView() {
        mRvItem.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        ArrayList<BaseBean> arrayList=new ArrayList<>();
        arrayList.add(new BaseBean());
        arrayList.add(new BaseBean());
        arrayList.add(new BaseBean());
        mOverSeaAdapter=new OverSeaAdapter(arrayList);
        mRvItem.setAdapter(mOverSeaAdapter);
        mOverSeaAdapter.setEmptyView(R.layout.su_view_empty, (ViewGroup) mRvItem.getParent());
        mRvItem.addItemDecoration(new RecyclerViewDivider(getContext(),LinearLayoutManager.VERTICAL));
        mOverSeaAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                beginActivity(CarDetailAcitivity.class);
            }
        });

        initRefresh();
    }

    /**
     * 刷新
     */
    private void initRefresh() {
        mRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page=1;
            }
        });
        mRefresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
            }
        });
    }

    @Override
    protected void lazyLoad() {

    }

}
