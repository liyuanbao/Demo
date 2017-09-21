package dfy.demo.product.fragment;

import android.content.Intent;
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
import dfy.demo.product.adapter.CarItemAdapter;
import dfy.demo.product.adapter.LocalAdapter;
import dfy.demo.widget.RecyclerViewDivider;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/19.
 */

public class LocalFragment extends BaseFragment {

    @BindView(R.id.rv_item)
    RecyclerView mRvItem;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    Unbinder unbinder;

    private LocalAdapter mLocalAdapter;
    public static LocalFragment newInstance() {
        return new LocalFragment();
    }

    @Override
    public int setInflaterView() {
        return R.layout.item_recy;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        initRecyclerView();
    }

    @Override
    protected void lazyLoad() {

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
        mLocalAdapter=new LocalAdapter(arrayList);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.su_view_empty, (ViewGroup) mRvItem.getParent(), true);
        mLocalAdapter.setNewData(arrayList);
        mRvItem.setAdapter(mLocalAdapter);
        mLocalAdapter.setEmptyView(R.layout.su_view_empty, (ViewGroup) mRvItem.getParent());
//        mRvItem.addItemDecoration(new RecyclerViewDivider(getContext(),LinearLayoutManager.VERTICAL));
        mLocalAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                beginActivity(CarDetailAcitivity.class);
            }
        });
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

}
