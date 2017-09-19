package dfy.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dfy.demo.bean.DetailBean;
import dfy.demo.utils.StatusBarUtils;
import dfy.demo.utils.SystemStatusManager;
import dfy.networklibrary.App;
import dfy.networklibrary.base.BaseActivity;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/5.
 */

public abstract class BaseDemoActivity<T> extends BaseActivity {

    private LinearLayout linearLayout;
    Unbinder mBind;
    private Bundle mBundle;

    private OnRetryConnection mOnRetryConnection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle=savedInstanceState;
        mContext=this;
        linearLayout=new LinearLayout(mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
        setContentView(linearLayout);
        App.getActivityManager().pushActivity(this);


        if (isNetLoading()) {
            linearLayout.removeAllViews();
            linearLayout.addView(loadingView());
        }else {
            linearLayout.removeAllViews();
            linearLayout.addView(setInflaterView(linearLayout));
            mBind=ButterKnife.bind(this, linearLayout);
            initView(savedInstanceState);
            setListener();
        }
        initData();

    }

    /**
     * 当前显示的页面
     * @param linearLayout
     * @return
     */
    public  View setInflaterView(LinearLayout linearLayout){
        View inflate = LayoutInflater.from(mContext).inflate(getInflaterView(), linearLayout, false);
        return inflate;
    }

    /**
     * 当前显示页面的布局
     * @return
     */
    protected abstract int getInflaterView();


    /**
     * 判断进入页面是否需要网络加载
     * @return
     */
    public boolean isNetLoading() {
        return false;
    }

    /**
     * 加载页
     * @return
     */
    protected View loadingView() {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.su_view_loading, linearLayout, false);
        return inflate;
    }


    public BaseDemoActivity setOnRetryConnection(OnRetryConnection onRetryConnection) {
        mOnRetryConnection = onRetryConnection;
        return this;
    }

    /**
     * 加载失败错误页
     * 点击后重新加载
     */
    public void loadingErrorView() {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.su_view_error_server, linearLayout, false);
        linearLayout.removeAllViews();
        linearLayout.addView(inflate);
        TextView textView = inflate.findViewById(R.id.btn_retry);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                App.getActivityManager().currentActivity().startActivity(new Intent(App.getActivityManager().currentActivity(),App.getActivityManager().currentActivity().getClass()));
//                finish();
               if (mOnRetryConnection!=null){
                   mOnRetryConnection.onRetryConnction();
               }
            }
        });
    }

    /**
     * 加载成功页面
     */
    protected void loadSuccessView(){
        linearLayout.removeAllViews();
        linearLayout.addView(setInflaterView(linearLayout));
        mBind=ButterKnife.bind(this, linearLayout);
        initView(mBundle);
        setListener();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind!=null){
            mBind.unbind();
        }
    }


    public void loadSuccess(T baseBean){
        loadSuccessView();
    }
    /**
     * 网络请求重连接口
     */
    public interface OnRetryConnection{

        void onRetryConnction();
    }
}
