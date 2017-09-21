package dfy.demo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dfy.demo.bean.DetailBean;
import dfy.demo.presenter.HomeView;
import dfy.networklibrary.base.BasePresenter;
import dfy.networklibrary.net.ConstantNet;

/**
 * Created by Admin on 2017/9/19.
 */

public class TestFragment extends BaseFragment {
    @BindView(R.id.tv_context)
    TextView mTvContext;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;


    @Override
    public int setInflaterView() {
        return R.layout.fragment_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

    }

    private void getData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", "1");
        hashMap.put("areaId", "");
        hashMap.put("dataId", "");
        hashMap.put("year", "");
        new BasePresenter<HomeView, DetailBean>()
                .setURL(ConstantNet.LAW_DETAIL)
                .setHashMap(hashMap)
                .setClazz(DetailBean.class)
                .setSuccessResponse(new BasePresenter.SuccessResponse<DetailBean>() {
                    @Override
                    public void success(DetailBean baseBean) {
//                        loadSuccess(baseBean);
                        getSuccess(baseBean);
                    }
                })
                .CommonNetRequest();

        mRefresh.setRefreshing(false);
    }


    public void getSuccess(DetailBean baseBean){
        mTvContext.setText(baseBean.getData().toString());
    }

}
