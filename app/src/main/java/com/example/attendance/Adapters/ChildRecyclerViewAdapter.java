package com.example.attendance.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.ModelClass.ChildModalClass;
import com.example.attendance.R;

import java.util.ArrayList;

public class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder> {
    public ArrayList<ChildModalClass> childModalClassArrayList;
    Context context;
    private  OnItemClickListener onItemClickListener;
    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView date,day,holiodayText;
        public MyViewHolder(View itemView, AdapterView.OnItemClickListener listener)
        {
            super(itemView);
            date=itemView.findViewById(R.id.date_tv);
            day=itemView.findViewById(R.id.day_tv);
            holiodayText=itemView.findViewById(R.id.holiday_tv);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(listener!=null){
//                        int position=getAdapterPosition();
//                        if(position!=RecyclerView.NO_POSITION){
//                            listener.onItemClickListener(position);
//
//                        }
//
//                    }
//                }
//            });
        }
    }
    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener=listener;
    }
    public ChildRecyclerViewAdapter(ArrayList<ChildModalClass> arrayList,Context mContext)
    {
        this.context=mContext;
        this.childModalClassArrayList=arrayList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_recycler_card_holiday, parent, false);
        return new MyViewHolder(view, (AdapterView.OnItemClickListener) onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("Recyclerview") int position)
    {
        ChildModalClass currentItem=childModalClassArrayList.get(position);
        holder.day.setText(childModalClassArrayList.get(position).getDay());
        holder.date.setText(childModalClassArrayList.get(position).getDate());
        holder.holiodayText.setText(childModalClassArrayList.get(position).getHolidayInfo());

    }
    @Override
    public int getItemCount()
    {
        return childModalClassArrayList.size();
    }
}
