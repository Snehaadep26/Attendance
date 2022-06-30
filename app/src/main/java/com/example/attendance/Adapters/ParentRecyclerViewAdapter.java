package com.example.attendance.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.ModelClass.ChildModalClass;
import com.example.attendance.ModelClass.ParentModalClass;
import com.example.attendance.R;

import java.util.ArrayList;

public class ParentRecyclerViewAdapter extends RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>
{
    ArrayList<ParentModalClass> parentModalClassArrayList;
    Context context;
    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView month;
        RecyclerView childRecyclerView;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            month=itemView.findViewById(R.id.month_tv);
            childRecyclerView=itemView.findViewById(R.id.child_recycler);
        }
    }

    public ParentRecyclerViewAdapter(ArrayList<ParentModalClass> parentModalClassArrayList, Context context) {

        this.parentModalClassArrayList = parentModalClassArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int ViewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recycler_card_holiday,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return parentModalClassArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint ("Recyclerview") int position) {

        ParentModalClass currentItem=parentModalClassArrayList.get(position);
        holder.month.setText(parentModalClassArrayList.get(position).getMonth());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);
        ArrayList<ChildModalClass> childModalClassArrayList=new ArrayList<>();
        childModalClassArrayList.add(new ChildModalClass("Mon","09","New Year Hoilday"));
        childModalClassArrayList.add(new ChildModalClass("tue","29","New Year Hoilday"));
        childModalClassArrayList.add(new ChildModalClass("weed","19","New Year Hoilday"));
        childModalClassArrayList.add(new ChildModalClass("thurs","20","New Year Hoilday"));

        ChildRecyclerViewAdapter childRecyclerViewAdapter=new ChildRecyclerViewAdapter(childModalClassArrayList,holder.childRecyclerView.getContext());
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
        holder.childRecyclerView.setNestedScrollingEnabled(false);

    }
}
