package dfy.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.bean.DetailBean;
import dfy.demo.presenter.HomeView;
import dfy.demo.presenter.homepresenter;
import dfy.demo.product.CarItemActiviy;
import dfy.demo.product.ChuZhiActivity;

import static dfy.demo.ApplictionDemo.getActivityManager;


public class MainActivity extends BaseDemoActivity implements HomeView {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.button)
    TextView mButton;
    @BindView(R.id.but)
    TextView mBut;
    @BindView(R.id.lin)
    LinearLayout mLin;
    @BindView(R.id.tv_context)
    TextView mTvContext;

    private homepresenter mHomepresenter;


    @Override
    public void initView(Bundle savedInstanceState) {

        getActivityManager().pushActivity(this);
//        mHomepresenter = new homepresenter(this);
//        mHomepresenter.homeIndex();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, CarItemActiviy.class));
            }
        });

    }

    @Override
    public boolean isNetLoading() {
        return true;
    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_main;
    }


    @Override
    public void initData() {
        mHomepresenter = new homepresenter(this);
        mHomepresenter.homeIndex();
    }


    @Override
    public void getIndex(DetailBean homeBean) {
        System.out.println("加载成功了");
        loadSuccessView();
        mTvContext.setText(homeBean.getData().toString());

    }

    @Override
    public void fail() {
        loadingErrorView();
    }

    @Override
    public void setListener() {
        //储值
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ChuZhiActivity.class));
//                loadSuccessView();
//                mHomepresenter.homeIndex();
            }
        });
    }


}
