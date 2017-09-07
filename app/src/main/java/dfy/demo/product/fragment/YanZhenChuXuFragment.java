package dfy.demo.product.fragment;

import android.os.Bundle;

import dfy.demo.R;
import dfy.networklibrary.widget.FragmentLazyLoad;

/**
 * Created by Admin on 2017/9/7.
 */

public class YanZhenChuXuFragment extends FragmentLazyLoad {

    public static YanZhenChuXuFragment newInstance(){
        return new YanZhenChuXuFragment();
    }

    @Override
    public int setInflaterView() {
        return R.layout.fragment_yanzhenchuxu;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
