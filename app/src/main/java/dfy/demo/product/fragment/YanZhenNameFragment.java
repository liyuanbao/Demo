package dfy.demo.product.fragment;

import android.os.Bundle;

import dfy.demo.R;
import dfy.networklibrary.widget.FragmentLazyLoad;

/**
 * Created by Admin on 2017/9/7.
 */

public class YanZhenNameFragment extends FragmentLazyLoad {

    public static YanZhenNameFragment newInstance(){
        return new YanZhenNameFragment();
    }
    @Override
    public int setInflaterView() {
        return R.layout.fragment_yanzhenname;
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
