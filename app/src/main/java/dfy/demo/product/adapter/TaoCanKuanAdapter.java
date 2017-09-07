package dfy.demo.product.adapter;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.R;
import dfy.demo.widget.RecyclerViewDivider;

/**
 * Created by Admin on 2017/9/5.
 */

public class TaoCanKuanAdapter extends RecyclerView.Adapter<TaoCanKuanAdapter.TKViewHolder> {



    private Context mContext;
    private List mList;

    public TaoCanKuanAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public TKViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_taocan, parent, false);
        return new TKViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(TKViewHolder holder, int position) {
        setData(holder,position);
    }

    private void setData(TKViewHolder holder, int position) {
        initRecyclerView(holder);
    }

    private void initRecyclerView(TKViewHolder holder){

        holder.mRcAdaItem.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
//        holder.mRcAdaItem.addItemDecoration(new RecyclerViewDivider(mContext,RecyclerViewDivider.VERTICAL_LIST,1,));
        TaoCanItemAdapter mTaoCanAdapter=new TaoCanItemAdapter(mContext);
        holder.mRcAdaItem.setAdapter(mTaoCanAdapter);
    }
    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 4;
    }

    class TKViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_typeone)
        TextView mTvTypeone;
        @BindView(R.id.tv_timeone)
        TextView mTvTimeone;
        @BindView(R.id.rc_ada_item)
        RecyclerView mRcAdaItem;
        @BindView(R.id.tv_total)
        TextView mTvTotal;
        public TKViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
