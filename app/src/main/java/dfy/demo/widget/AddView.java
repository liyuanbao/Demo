package dfy.demo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import dfy.demo.R;

/**
 * Created by Admin on 2017/9/20.
 */

public class AddView extends LinearLayout {

    private View mRootView;
    private Context mContext;

    private TextView mTvType;
    private TextView mTvAdd;
    private TextView mTvNum;
    private TextView mTvJian;

    public AddView(Context context) {
        super(context);
        mContext = context;
        initView(mContext);
    }

    public AddView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView(mContext);

    }

    public AddView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView(mContext);
    }

    public void initView(Context mContext) {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.select_all, this, true);
        mTvType = (TextView) findViewById(R.id.tv_type);
        mTvAdd = (TextView) findViewById(R.id.tv_add);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        mTvJian = (TextView) findViewById(R.id.tv_jian);
    }


    /**
     * @param title
     * @return
     */
    public AddView setTitleType(String title) {
        mTvType.setText(title);
        return this;
    }

    public AddView setNumber(String title) {
        mTvNum.setText(title);
        return this;
    }


    public AddView addClickListener(OnClickListener onClickListener) {
        mTvAdd.setOnClickListener(onClickListener);
        return this;
    }

    public AddView jianClickListener(OnClickListener onClickListener) {
        mTvJian.setOnClickListener(onClickListener);
        return this;
    }

    /**
     * 返回数量
     *
     * @return
     */
    public int getNumber() {
        String trim = mTvNum.getText().toString().trim();
        int i = Integer.parseInt(trim);
        return i;
    }
}
