package dfy.demo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dfy.demo.R;

/**
 * Created by Admin on 2017/9/5.
 */

public class AddShopView extends LinearLayout {

    private View mRootView;
    private Context mContext;

    private TextView mTvTitle;
    private TextView mTvAdd;
    private TextView mTvNum;
    private TextView mTvJian;
    private TextView mTvMoney;

    public AddShopView(Context context) {
        super(context);
        mContext=context;
        initView(mContext);
    }

    public AddShopView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView(mContext);

    }

    public AddShopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initView(mContext);
    }

    public void initView(Context mContext) {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.item_chose, this, true);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvMoney = (TextView) findViewById(R.id.tv_money);
        mTvAdd = (TextView) findViewById(R.id.tv_add);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        mTvJian = (TextView) findViewById(R.id.tv_jian);
    }

    /**
     * @param title
     * @return
     */
    public AddShopView setTitleType(String title){
        mTvTitle.setText(title);
        return this;
    }
    public AddShopView setTitleMoney(String title){
        mTvMoney.setText(title);
        return this;
    }
    public AddShopView setNumber(String title){
        mTvNum.setText(title);
        return this;
    }


    public AddShopView addClickListener(OnClickListener onClickListener){
       mTvAdd.setOnClickListener(onClickListener);
        return this;
    }
    public AddShopView jianClickListener(OnClickListener onClickListener){
        mTvJian.setOnClickListener(onClickListener);
        return this;
    }

    /**
     * 返回数量
     * @return
     */
    public int getNumber(){
        String trim = mTvNum.getText().toString().trim();
        int i = Integer.parseInt(trim);
        return i;
    }



}
