package dfy.demo.product.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dfy.demo.R;
import dfy.demo.product.listener.OnClickListener;

/**
 * Created by Admin on 2017/9/4.
 */

public class CarItemAdapter extends RecyclerView.Adapter<CarItemAdapter.CIViewHolder> implements View.OnClickListener {
    private Context mContext;
    private OnClickListener mOnClickListener;
    private List mList;

    public CarItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(List list) {
        mList = list;
    }

    public List getList() {
        return mList;
    }

    @Override
    public CIViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_caritem, parent, false);
        inflate.setOnClickListener(this);
        return new CIViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(CIViewHolder holder, int position) {
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 6;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mOnClickListener != null) {
            mOnClickListener.OnClickListener(view, (Integer) view.getTag());
        }
    }

    class CIViewHolder extends RecyclerView.ViewHolder {
        public CIViewHolder(View itemView) {
            super(itemView);
        }
    }
}
