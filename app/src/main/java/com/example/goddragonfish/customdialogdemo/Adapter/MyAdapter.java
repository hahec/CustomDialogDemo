package com.example.goddragonfish.customdialogdemo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goddragonfish.customdialogdemo.Entity.Item;
import com.example.goddragonfish.customdialogdemo.R;

import java.util.List;

/**
 * Created by GodDragonFish on 2017/12/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Item> itemList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        View v;

        public ViewHolder(View view){
            super(view);
            tv=(TextView)view.findViewById(R.id.text);
            v=(View)view.findViewById(R.id.a);
        }
    }

    public MyAdapter(List<Item> list){
        this.itemList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Item i=itemList.get(position);
        holder.tv.setText(i.getTextView());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
