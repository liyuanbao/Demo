package dfy.demo.product;

import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/12.
 */

public class TiXianActivity extends BaseDemoActivity {


    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_number)
    EditText mEtNumber;
    @BindView(R.id.et_blank)
    EditText mEtBlank;
    @BindView(R.id.et_tel)
    EditText mEtTel;
    @BindView(R.id.et_money)
    EditText mEtMoney;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_tixian;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setToolTitle("提现")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {


    }
}
