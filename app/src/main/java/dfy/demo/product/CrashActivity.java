package dfy.demo.product;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/7.
 * 储值
 */

public class CrashActivity extends BaseDemoActivity {

    @BindView(R.id.toollbar)
    ToolTitle mToollbar;

    @Override
    public void initView(Bundle savedInstanceState) {

        mToollbar.setBackListener(this)
                .setToolTitle("储值")
                .setToolRightTwoVisable(false)
                .setToolRightOneVisiable(false);
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getInflaterView() {
        return R.layout.avtivity_crash;
    }

}
