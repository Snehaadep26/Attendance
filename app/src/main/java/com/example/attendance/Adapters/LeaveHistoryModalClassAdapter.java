package com.example.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.attendance.ModelClass.LeaveHistoryModalClass;
import com.example.attendance.R;
import java.util.ArrayList;

public class LeaveHistoryModalClassAdapter extends RecyclerView.Adapter<LeaveHistoryModalClassAdapter.ViewHolder>{
    ArrayList<LeaveHistoryModalClass> attemptedModels;
    Context context;
    LeaveHistoryModalClass testModel;
    public LeaveHistoryModalClassAdapter(ArrayList<LeaveHistoryModalClass> attemptedModels, Context context) {
        this.attemptedModels = attemptedModels;
        this.context = context;


    }

    @NonNull
    @Override
    public LeaveHistoryModalClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leave_history_card, parent, false);
        LeaveHistoryModalClassAdapter.ViewHolder subjectViewHolder = new LeaveHistoryModalClassAdapter.ViewHolder(view);
        return subjectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveHistoryModalClassAdapter.ViewHolder holder, int position) {
        testModel = this.attemptedModels.get(position);
        holder.leave_days_count.setText(testModel.getDays_count_leave());
        holder.leave_start_date.setText(testModel.getLeave_start_date());
        holder.leave_end_date.setText(testModel.getLeave_end_date());
        holder.leave_type.setText(testModel.getLeave_type());
    }

    @Override
    public int getItemCount() {
        return attemptedModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView leave_days_count,leave_start_date,leave_end_date,leave_type;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leave_days_count=itemView.findViewById(R.id.days_count);
            leave_start_date=itemView.findViewById(R.id.leave_Start_date_Tv);
            leave_end_date=itemView.findViewById(R.id.leave_end_date_Tv);
            leave_type=itemView.findViewById(R.id.leave_type);
        }
    }
}
