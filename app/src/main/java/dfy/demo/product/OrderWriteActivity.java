package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.product.adapter.OrderWriteAdapter;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/9/5.
 */

public class OrderWriteActivity extends BaseDemoActivity {


    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.tv_add)
    TextView mTvAdd;
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_person)
    TextView mTvPerson;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.rb_man)
    RadioButton mRbMan;
    @BindView(R.id.rb_woman)
    RadioButton mRbWoman;
    @BindView(R.id.rg_sex)
    RadioGroup mRgSex;
    @BindView(R.id.et_tel)
    EditText mEtTel;
    @BindView(R.id.et_email)
    EditText mEtEmail;
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.cb_check)
    CheckBox mCbCheck;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;
    @BindView(R.id.tv_totalmoney)
    TextView mTvTotalmoney;
    @BindView(R.id.tv_order_submit)
    TextView mTvOrderSubmit;
    @BindView(R.id.bottom)
    LinearLayout mBottom;

    private OrderWriteAdapter mWriteAdapter;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_orderwrite;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar.setToolTitle("填写订单")
                .setBackListener(this)
                .setToolRightOneVisiable(false)
                .setToolRightTwoVisable(false);

        String s = "<font color='#666'>已阅读并同意</font><font color='#D43839'>爱自驾旅游协议</font>";
        mTvXieyi.setText(Html.fromHtml(s));

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecy.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mWriteAdapter = new OrderWriteAdapter(R.layout.orderwrite_youke);
        mRecy.setAdapter(mWriteAdapter);
        final View inflate = LayoutInflater.from(mContext).inflate(R.layout.orderwrite_youke, mRecy, false);
//        //子条目添加监听
//        mWriteAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//
//                if (view.getId() == R.id.lin_add) {
//
//                }
//            }
//        });

        View footerView = getFooterView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWriteAdapter.addFooterView(getFooterView(1, getRemoveFooterListener()), 0);
            }
        });
        mWriteAdapter.addFooterView(footerView, 0);

    }

    private View.OnClickListener getRemoveFooterListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWriteAdapter.removeFooterView(v);
            }
        };
    }

    private View getFooterView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.orderwrite_youke, (ViewGroup) mRecy.getParent(), false);

        LinearLayout imageView = view.findViewById(R.id.lin_add);

        imageView.setOnClickListener(listener);
        return view;
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //提交订单
        mTvOrderSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, QueRenOrderActivity.class));
            }
        });
    }


}
