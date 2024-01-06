package com.example.maibaongoc_2080601143_kiemtragiuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Home> lstHome;


    public HomeAdapter(List<Home> lstHome)
    {
        this.lstHome=lstHome;
    }




    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View homeView = inflater.inflate(R.layout.item_home,parent,false);
        HomeAdapter.ViewHolder viewHolder = new HomeAdapter.ViewHolder(homeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        Home temp = lstHome.get(position);

        holder.t1.setText(temp.getMaso());
        holder.t2.setText(temp.getTen());
        holder.t3.setText(temp.getEmail());
        holder.t4.setText(temp.getKhoa());
        holder.t5.setText(temp.getHinhanh());

    }

    @Override
    public int getItemCount() {
        return lstHome.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1 , t2 , t3 , t4,t5;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.txvMsnv);
            t2 = itemView.findViewById(R.id.txvTennv);
            t3 = itemView.findViewById(R.id.txvEmail);
            t4 = itemView.findViewById(R.id.txvKhoa);
            t5 = itemView.findViewById(R.id.txvHinhAnh);


        }
    }
}
