package com.example.braintech.restrofitandroiddemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.braintech.restrofitandroiddemo.moedel.HealthList;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    private ArrayList<HealthList.Value> valueList;

    public RecyclerAdapter (ArrayList<HealthList.Value> valueList)
    {
        this.valueList = valueList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder viewHolder, int i) {
        viewHolder.eid.setText(String.valueOf(valueList.get(i).getID()));
        viewHolder.emp_name.setText(String.valueOf(valueList.get(i).getName()));

    }

    @Override
    public int getItemCount() {
        return valueList.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        TextView eid,emp_name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            eid = (TextView)itemView.findViewById(R.id.txtid);
            emp_name = (TextView)itemView.findViewById(R.id.txtname);
        }
    }
}
