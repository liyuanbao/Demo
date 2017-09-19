package dfy.networklibrary.base;

import android.os.Bundle;

import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/8/30.
 */

public interface BaseView<B extends BaseBean> {

    void initView(Bundle savedInstanceState);

    void initData();

    void setListener();

    void toastLong(String msg);

    void toastShort(String msg);

    void netRequestOk();

    void netRequestFail();

//    void entryItem(B baseBean);


    void loadingErrorView();


}
