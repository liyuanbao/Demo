package dfy.networklibrary.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import dfy.networklibrary.base.BaseView;


/**
 * Created by Administrator on 2017/7/5.
 */

public abstract class FragmentLazyLoad extends Fragment implements BaseView{
    /**
     * 视图是否已经初初始化
     */
    protected boolean isInit = false;
    protected boolean isLoad = false;
    protected final String TAG = "FragmentLazyLoad";
    private View view;
    private Toast mToast;
    private Context mContext;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setInflaterView(), container, false);
        isInit = true;
        mContext=getContext();
        /**初始化的时候去加载数据**/
        initView(savedInstanceState);
        setListener();

        isCanLoadData();
        return view;
    }

    /**
     * 视图Id
     * @return
     */
    public abstract int setInflaterView();

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }


    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 视图销毁的时候讲Fragment是否初始化的状态变为false
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;

    }

    protected void showToast(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 设置Fragment要显示的布局
     *
     * @return 布局的layoutId
     */


    /**
     * 获取设置的布局
     *
     * @return
     */
    protected View getContentView() {
        return view;
    }


//    public abstract int setContentView();

    public abstract void initView(Bundle savedInstanceState);

    public  void initData(){

    }

    @Override
    public void setListener() {

    }

    @Override
    public void toastLong(String msg) {
        if (mToast==null) mToast=Toast.makeText(getContext(),msg,Toast.LENGTH_LONG);
        mToast.setText(msg);
        mToast.show();
    }

    @Override
    public void toastShort(String msg) {
        if (mToast==null) mToast=Toast.makeText(getContext(),msg,Toast.LENGTH_LONG);
        mToast.setText(msg);
        mToast.show();
    }

    @Override
    public void netRequestOk() {

    }

    @Override
    public void netRequestFail() {

    }

    /**
     * 找出对应的控件
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewById(int id) {

        return (T) getContentView().findViewById(id);
    }

    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected abstract void lazyLoad();

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {
    }


}
