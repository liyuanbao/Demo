package dfy.demo.product.goods;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/20.
 */

public class CarChoseActivity extends BaseDemoActivity {
    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.recy)
    RecyclerView mRecy;

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setToolTitle("车辆选择")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_carchose;
    }

}
