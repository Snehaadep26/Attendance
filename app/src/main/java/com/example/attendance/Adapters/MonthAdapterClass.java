package com.example.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.ModelClass.MonthModalClass;
import com.example.attendance.R;

import java.util.ArrayList;

public class MonthAdapterClass extends RecyclerView.Adapter<MonthAdapterClass.ViewHolder>{
    ArrayList<MonthModalClass> attemptedModels;
    Context context;
    MonthModalClass testModel;
    public MonthAdapterClass(ArrayList<MonthModalClass> attemptedModels, Context context) {
        this.attemptedModels = attemptedModels;
        this.context = context;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_months_card, parent, false);
        ViewHolder subjectViewHolder = new ViewHolder(view);
        return subjectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        testModel = this.attemptedModels.get(position);
        holder.month.setText(String.valueOf(testModel.getMonth()));


    }

    @Override
    public int getItemCount() {
        return attemptedModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView month;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month_list_tv);
            imageView=itemView.findViewById(R.id.imgChecked);


        }
    }
}
