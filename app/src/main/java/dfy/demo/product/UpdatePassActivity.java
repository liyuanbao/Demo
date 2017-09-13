package dfy.demo.product;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/12.
 */

public class UpdatePassActivity extends BaseDemoActivity {

    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.tv_tel)
    TextView mTvTel;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.tv_yanzhen)
    TextView mTvYanzhen;
    @BindView(R.id.et_pass)
    EditText mEtPass;
    @BindView(R.id.et_yanzhenpass)
    EditText mEtYanzhenpass;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_updatepass;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setBackListener(this)
                .setToolTitle("修改支付密码")
                .setToolRightOneVisiable(false)
                .setRightTwoText("确定");

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

        //确定修改
        mToolbar.setRightTwoListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
