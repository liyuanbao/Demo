package dfy.demo.product;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.fragment.YanZhenChuXuFragment;
import dfy.demo.product.fragment.YanZhenNameFragment;
import dfy.demo.product.fragment.YanZhenPassFragment;
import dfy.demo.product.fragment.YanZhenTelFragment;
import dfy.demo.widget.RZLiuChengView;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/6.
 */

public class TelYanZhenActivity extends BaseDemoActivity {

    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.rz_liuchen)
    RZLiuChengView mRzLiuchen;
    @BindView(R.id.vp_liuchen)
    ViewPager mVpLiuchen;

    private YanZhenTelFragment mTelFragment;
    private YanZhenPassFragment mPassFragment;
    private YanZhenNameFragment mNameFragment;
    private YanZhenChuXuFragment mChuXuFragment;

    private List<Fragment> mFragments;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_telyanzheng;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar.setToolTitle("手机验证")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        mTelFragment = YanZhenTelFragment.newInstance();
        mNameFragment = YanZhenNameFragment.newInstance();
        mPassFragment = YanZhenPassFragment.newInstance();
        mChuXuFragment = YanZhenChuXuFragment.newInstance();
        mFragments = new ArrayList<>();

        mFragments.add(mTelFragment);
        mFragments.add(mNameFragment);
        mFragments.add(mPassFragment);
        mFragments.add(mChuXuFragment);

        mVpLiuchen.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments != null ? mFragments.size() : 0;
            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

        mVpLiuchen.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==0){
                    mRzLiuchen.setTelColor(ContextCompat.getDrawable(mContext,R.mipmap.ic_launcher),R.color.color_tool_bg_red);
                }
                else if (position==1){
                    mRzLiuchen.setNameColor(ContextCompat.getDrawable(mContext,R.mipmap.ic_launcher),R.color.color_tool_bg_red);
                }
                else if (position==2){
                    mRzLiuchen.setPassColor(ContextCompat.getDrawable(mContext,R.mipmap.ic_launcher),R.color.color_tool_bg_red);
                }
                else if (position==3){
                    mRzLiuchen.setChuZhiColor(ContextCompat.getDrawable(mContext,R.mipmap.ic_launcher),R.color.color_tool_bg_red);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
