package com.example.attendance.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import com.example.attendance.ModelClass.LeaveHistoryModalClass;
import com.example.attendance.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveHistoryModalClassAdapter extends RecyclerView.Adapter<LeaveHistoryModalClassAdapter.ViewHolder>{
    ArrayList<LeaveHistoryModalClass> attemptedModels;
    Context context;
    BottomSheetDialog btn;
    TextView deleteLeave;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;

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
        ImageView delete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leave_days_count = itemView.findViewById(R.id.days_count);
            leave_start_date = itemView.findViewById(R.id.leave_Start_date_Tv);
            leave_end_date = itemView.findViewById(R.id.leave_end_date_Tv);
            leave_type = itemView.findViewById(R.id.leave_type);
            delete = itemView.findViewById(R.id.moreDelete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view = LayoutInflater.from(context).inflate(R.layout.delete, null);

                    btn = new BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme);
                    Log.i("String String", "");
                    btn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    btn.setCanceledOnTouchOutside(true);
                    btn.setContentView(view);
                    btn.getWindow().setGravity(Gravity.BOTTOM);
                    btn.setCanceledOnTouchOutside(true);
                    btn.show();
                    deleteLeave = view.findViewById(R.id.delete_leave_req);
                    deleteLeave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            builder = new AlertDialog.Builder(context);
                            final View discountpopup = LayoutInflater.from(context).inflate(R.layout.delete_dialog, null);
                            discountpopup.setClipToOutline(true);
                            builder.setView(discountpopup);
                            alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
                }
            });
        }
    }
}
