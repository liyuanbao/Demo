package dfy.demo.product;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.fragment.LocalFragment;
import dfy.demo.product.fragment.OverSeaFragment;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.widget.ViewPagerNoSlide;

/**
 * Created by Admin on 2017/9/4.
 */

public class CarItemActiviy extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.rb_one)
    RadioButton mRbOne;
    @BindView(R.id.rb_two)
    RadioButton mRbTwo;
    @BindView(R.id.rg_check)
    RadioGroup mRgCheck;
    @BindView(R.id.vp_item)
    ViewPagerNoSlide mVpItem;


    private ArrayList<Fragment> mFragments;
    private LocalFragment mLocalFragment;
    private OverSeaFragment mSeaFragment;



    @Override
    public void initView(Bundle savedInstanceState) {
        mLocalFragment=LocalFragment.newInstance();
        mSeaFragment =OverSeaFragment.newInstance();

        mFragments=new ArrayList<>();
        mFragments.add(mLocalFragment);
        mFragments.add(mSeaFragment);
        mVpItem.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments!=null?mFragments.size():0;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //返回上一级

        //查看更多评价


    }

    @Override
    protected int getInflaterView() {
        return R.layout.activiy_caritem;
    }
}
