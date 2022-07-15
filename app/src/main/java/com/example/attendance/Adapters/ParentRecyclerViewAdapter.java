package com.example.attendance.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.GetDashboardResponse;
import com.example.attendance.AttendanceApi.Holiday;
import com.example.attendance.ModelClass.ChildModalClass;
import com.example.attendance.ModelClass.ParentModalClass;
import com.example.attendance.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Retrofit;

public class ParentRecyclerViewAdapter extends RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>
{
    ArrayList<ParentModalClass> parentModalClassArrayList;
    ArrayList<ChildModalClass> childModalClassArrayList;
    Context context;
    Holiday holiday;
    Date date;
    Date dateFormat;
    GetDashboardResponse getDashboardResponse;
    Retrofit retrofit;
    AttendanceLogInService attendanceLogInService;



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

    public ParentRecyclerViewAdapter(ArrayList<ParentModalClass> parentModalClassArrayList, Context context,Holiday holiday) {

        this.parentModalClassArrayList = parentModalClassArrayList;
        this.context = context;
        this.holiday=holiday;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int ViewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_parent_recycler_card_holiday,parent,false);
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
//        ArrayList<String> data1=new ArrayList<>();
//        for (int i = 0; i <= holiday.data.size() - 1; i++) {
//            data1.add(holiday.data.get(i).title);
//        }
//        Log.e("zsize", String.valueOf(holiday.data.size()));
//        Set values = new HashSet(data1);
//        for ( int i = 0; i <= values.size() - 1; i++)
//        {
//            for ( int j = 0; j <= holiday.data.size() - 1; j++) {
//                if (!parentModalClassArrayList.get(position).getMonth().equals(holiday.data.get(j).title))
//                {
//                    Log.e("Month",getDashboardResponse.holidays.get(i).getMonth());
//                }
//                else {
//                    //date=getDashboardResponse.holidays.get(i).data.get(j).date.toString();
//                    dateFormat=getDashboardResponse.holidays.get(i).data.get(j).date;
//
//                    Log.i("Dateformat", String.valueOf(dateFormat));
//                    childModalClassArrayList.add(new ChildModalClass("tdfygh",getDashboardResponse.holidays.get(i).data.get(j).date.toString(),getDashboardResponse.holidays.get(i).data.get(j).title));
//
//                }
//            }
//
//        }

        ArrayList<String> standard = new ArrayList();
        try
        {
            for (int i = 0; i <= holiday.data.size() - 1; i++) {
                standard.add(holiday.data.get(i).title);
            }
            Set values = new HashSet(standard);
            Log.i("Sneha", values.toString());

            for ( int i = 0; i <= values.size() - 1; i++) ;
            {
                for ( int j = 0; j <= holiday.data.size() - 1; j++) {
                    if (!parentModalClassArrayList.get(position).getMonth().equals(holiday.data.get(j).title)) {

                    } else {
                        childModalClassArrayList.add(new ChildModalClass(holiday.data.get(j).getCreatedAt().toString(),holiday.data.get(j).getTitle(),holiday.data.get(j).getDate()));
                    }
                }
            }
            ChildRecyclerViewAdapter childRecyclerViewAdapter=new ChildRecyclerViewAdapter(childModalClassArrayList,holder.childRecyclerView.getContext());
            holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
            holder.childRecyclerView.setNestedScrollingEnabled(false);

        }catch (Exception e)
        {
            Toast.makeText(context.getApplicationContext(), "No holidays", Toast.LENGTH_SHORT).show();
        }
        
        
    }

    public void apiInIt()
    {
        retrofit= AttendanceApiClient.getRetrofit();
        attendanceLogInService= AttendanceApiClient.getLoginService();
    }
}
