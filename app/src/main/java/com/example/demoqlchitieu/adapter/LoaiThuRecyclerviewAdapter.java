package com.example.demoqlchitieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoqlchitieu.R;
import com.example.demoqlchitieu.entity.LoaiThu;

import java.util.List;

public class LoaiThuRecyclerviewAdapter extends RecyclerView.Adapter<LoaiThuRecyclerviewAdapter.LoaiThuViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<LoaiThu> mList;

    public LoaiThuRecyclerviewAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recyclerview_loai_thu_item, parent, false);
        return new LoaiThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHolder holder, int position) {
        if (mList != null) {
            holder.tvName.setText(mList.get(position).ten);
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    public void setList(List<LoaiThu> mList) {
        this.mList = mList;
    }

    public static class LoaiThuViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivEdit, ivView;
        public CardView cv;
        public LoaiThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            ivView = itemView.findViewById(R.id.ivView);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            cv = (CardView) itemView;
        }
    }
}
