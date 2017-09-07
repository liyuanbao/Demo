package dfy.demo.product.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.R;
import dfy.demo.widget.AddShopView;

/**
 * Created by Admin on 2017/9/5.
 */

public class TaoCanItemAdapter extends RecyclerView.Adapter<TaoCanItemAdapter.TIViewHolder> {

    private Context mContext;
    private List mList;

    public TaoCanItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public TIViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_taocanitem, parent, false);
        return new TIViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(TIViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 3;
    }

    class TIViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adv_shop)
        AddShopView mAdvShop;
        public TIViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            clickShop(itemView);
        }

        private void clickShop(View itemView){
            //添加
            mAdvShop.addClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = mAdvShop.getNumber() + 1;
                    mAdvShop.setNumber(i+"");
                }
            }).jianClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int number = mAdvShop.getNumber();
                    if (number<=0){
                        Toast.makeText(mContext,"没有商品可减!",Toast.LENGTH_LONG).show();
                    }else {
                        int i = mAdvShop.getNumber() -1;
                        mAdvShop.setNumber(i+"");
                    }
                }
            });
        }
    }
}
