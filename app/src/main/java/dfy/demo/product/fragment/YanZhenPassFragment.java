package dfy.demo.product.fragment;

import android.os.Bundle;

import dfy.demo.R;
import dfy.networklibrary.widget.FragmentLazyLoad;

/**
 * Created by Admin on 2017/9/7.
 */

public class YanZhenPassFragment extends FragmentLazyLoad {

    public static YanZhenPassFragment newInstance(){
        return new YanZhenPassFragment();
    }

    @Override
    public int setInflaterView() {
        return R.layout.fragment_yanzhenpass;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void loadingErrorView() {

    }

    @Override
    protected void lazyLoad() {

    }
}
