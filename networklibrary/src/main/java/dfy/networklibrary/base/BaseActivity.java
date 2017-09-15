package dfy.networklibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import dfy.networklibrary.App;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/1.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{
    private Toast mToast;
    public Context mContext;


    /**
     * 初始化View
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 设置监听
     */
    public void setListener(){

    }

    /**
     * 设置Toast,类型Long
     * @param msg
     */
    @Override
    public void toastLong(String msg) {
        if (mToast==null) mToast=Toast.makeText(mContext,msg,Toast.LENGTH_LONG);
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 设置Toast，类型Short
     * @param msg
     */
    @Override
    public void toastShort(String msg) {
        if (mToast==null) mToast=Toast.makeText(mContext,msg,Toast.LENGTH_LONG);
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 网络请求成功
     */
    @Override
    public void netRequestOk() {

    }

    /**
     * 请求失败
     */
    @Override
    public void netRequestFail() {

    }

    

}
