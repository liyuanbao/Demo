package dfy.demo.product.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dfy.demo.BaseFragment;
import dfy.demo.R;
import dfy.demo.product.CrashActivity;
import dfy.demo.FragmentLazyLoad;

/**
 * Created by Admin on 2017/9/7.
 */

public class YanZhenChuXuFragment extends BaseFragment {

    @BindView(R.id.line_chuxu)
    LinearLayout mLineChuxu;
    @BindView(R.id.tv_yingdao)
    TextView mTvYingdao;
    Unbinder unbinder;

    public static YanZhenChuXuFragment newInstance() {
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
    public void loadingErrorView() {

    }

    @Override
    protected void lazyLoad() {
        mTvYingdao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CrashActivity.class));
            }
        });
    }
}
