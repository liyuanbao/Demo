package dfy.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.flyco.dialog.widget.popup.BubblePopup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.bean.DetailBean;
import dfy.demo.presenter.HomeView;
import dfy.demo.presenter.homepresenter;
import dfy.demo.product.CarItemActiviy;
import dfy.demo.product.ChuZhiActivity;
import dfy.demo.test.ARShowActivity;
import dfy.demo.widget.BaseDilog;
import dfy.networklibrary.base.BasePresenter;
import dfy.networklibrary.base.BaseView;
import dfy.networklibrary.net.BaseBean;
import dfy.networklibrary.net.ConstantNet;

import static dfy.demo.ApplictionDemo.getActivityManager;


public class MainActivity extends BaseDemoActivity<DetailBean> implements HomeView {

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
    @BindView(R.id.test)
    TextView mTest;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.vp)
    ViewPager mVp;

    private homepresenter<BaseView, BaseBean<List<DetailBean.DataBean>>> mHomepresenter;


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


        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });


        final ArrayList<Fragment> mFragment=new ArrayList<>();

        mFragment.add(new TestFragment());
        mFragment.add(new TestFragment());
        mFragment.add(new TestFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment!=null?mFragment.size():0;
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
                        loadSuccess(baseBean);
                    }
                })
                .setLoadingFaild(new BasePresenter.LoadingFaild() {
                    @Override
                    public void loadFailed() {
                        fail();
                    }
                })
                .CommonNetRequest();

        mRefresh.setRefreshing(false);
    }

    @Override
    public boolean isNetLoading() {
        return false;
    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_main;
    }


    @Override
    public void initData() {

    }


    @Override
    public void getIndex(DetailBean homeBean) {
//        loadSuccessView();
        if (homeBean.getCode() == 10000) {
            mTvContext.setText(homeBean.getData().toString());
        }


    }

    @Override
    public void loadSuccess(DetailBean baseBean) {
        super.loadSuccess(baseBean);
        getIndex(baseBean);
    }

    @Override
    public void fail() {
        loadingErrorView();
        setOnRetryConnection(new OnRetryConnection() {
            @Override
            public void onRetryConnction() {
                getData();
            }
        });
    }


    @Override
    public void setListener() {
        //储值
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ChuZhiActivity.class));
//
            }
        });

        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ARShowActivity.class));
            }
        });
    }

    @Override
    public void entryItem(DetailBean baseBean) {

    }

    private void myDialog() {
        BaseDilog.Builder builder = new BaseDilog.Builder(mContext);
        builder.setMsg("ddd")
                .setTitle("sss")
                .show();
    }

    private void popupwindow() {
        View inflate = View.inflate(mContext, R.layout.rz_liucheng_layout, null);
        new BubblePopup(mContext, inflate)
                .anchorView(mBut)
                .bubbleColor(mContext.getResources().getColor(R.color.white))
                .gravity(Gravity.BOTTOM)
                .showAnim(null)
                .dismissAnim(null)
                .show();
        TextView viewById = inflate.findViewById(R.id.tv_tel);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastLong("sss");
            }
        });
    }


    private void itemDilog() {
        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(mContext, stringItems, null);
        dialog.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
                .titleTextSize_SP(14.5f)//
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                toastLong(stringItems[position]);
                dialog.dismiss();
            }
        });
    }

    private void Dialog() {
        NormalDialog materialDialog = new NormalDialog(mContext);
        materialDialog.content("yyyyy")
                .btnText("取消", "确定")
                .show();
        materialDialog.setOnBtnClickL(new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                toastLong("点击了取消");
            }
        }, new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                toastLong("点击了确定");
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
