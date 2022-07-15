package com.example.attendance.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.GetDashboardResponse;
import com.example.attendance.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AttendanceSummary extends Fragment {

    View view;
    Retrofit retrofit;
    AttendanceLogInService attendanceLogInService;
    GetDashboardResponse getDashboardResponse;
    ArrayAdapter<String> selectAdapter;
    ArrayList<String> month;
    TextView month_summary;
    AutoCompleteTextView summary_month_list;
    ProgressBar progressBar;

    public AttendanceSummary() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.attendance_fragment_attendance_summary, container, false);
        month_summary = view.findViewById(R.id.month_Summary);
        summary_month_list = view.findViewById(R.id.selectmonthSummary);
        progressBar = view.findViewById(R.id.progress_bar_attendanceSummary);
        ArrayAdapter<String> adapterRelation = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.Months));
        summary_month_list.setAdapter(adapterRelation);
        summary_month_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                summary_month_list.showDropDown();
                dashBoardApi1();

                return false;

            }
        });
//        Log.i("monthhhhhhhhh",summary_month_list.getText().toString());

//        month_summary.setText(summary_month_list.getText());

        apiInIt();

        return view;
    }

    public void apiInIt() {
        retrofit = AttendanceApiClient.getRetrofit();
        attendanceLogInService = AttendanceApiClient.getLoginService();
    }

    public void dashBoardApi1() {
        Call<GetDashboardResponse> call = attendanceLogInService.dashBoardCall();
        call.enqueue(new Callback<GetDashboardResponse>() {
            @Override
            public void onResponse(Call<GetDashboardResponse> call, Response<GetDashboardResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                getDashboardResponse = response.body();
                Toast.makeText(getContext(), getDashboardResponse.monthlyAttendance.month, Toast.LENGTH_SHORT).show();
                progressBar.setMax((int) getDashboardResponse.monthlyAttendance.totalWorkingDaysTillDate);
                progressBar.setProgress((int) (getDashboardResponse.monthlyAttendance.presentDays + getDashboardResponse.monthlyAttendance.absentDays));
                Log.e("dddddddddddd", String.valueOf(getDashboardResponse.monthlyAttendance.month));
            }

            @Override
            public void onFailure(Call<GetDashboardResponse> call, Throwable t) {
                Toast.makeText(getContext(), "error home summary", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
