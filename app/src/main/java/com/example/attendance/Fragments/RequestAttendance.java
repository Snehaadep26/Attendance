package com.example.attendance.Fragments;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.PostAttendanceRequest;
import com.example.attendance.AttendanceApi.PostClockInOutResponse;
import com.example.attendance.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Timer;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RequestAttendance extends Fragment {


    View view;
    Retrofit retrofit;
    CalendarView calendarViewTwo;
    String start_date;
    int hours,hours1;
    int total;
    AttendanceLogInService attendanceLogInService;
    PostAttendanceRequest postAttendanceRequest;
    PostClockInOutResponse postAttendanceResponse;
    TextInputLayout calendar;
    TimePickerDialog timePickerDialog;
    AppCompatButton requestButton;

    TextInputEditText selectDate,clockin,clockout,totalHours,reasonForLeave;



    public RequestAttendance() {
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
        view= inflater.inflate(R.layout.fragment_request_attendance, container, false);
        apiInIt();
        calendar=view.findViewById(R.id.date_tv);
        selectDate=view.findViewById(R.id.datepick);
        clockin=view.findViewById(R.id.clock_et);
        clockout=view.findViewById(R.id.clockout_et);
        totalHours=view.findViewById(R.id.totalhours_et);
        reasonForLeave=view.findViewById(R.id.reason_et);
        requestButton=view.findViewById(R.id.request_button);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view=getLayoutInflater().inflate(R.layout.bottom_calendar,null);
                calendarViewTwo = view.findViewById(R.id.datePicker);
                BottomSheetDialog btn=new BottomSheetDialog(getActivity(),R.style.AppBottomSheetDialogTheme);
                btn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btn.setCanceledOnTouchOutside(true);
                btn.setContentView(view);
                btn.getWindow().setGravity(Gravity.BOTTOM);
                btn.setCanceledOnTouchOutside(true);
                btn.show();
                calendarViewTwo.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
                        if(selectDate.getText().length()<=0){
                            selectDate.requestFocus();
                           selectDate.setText((new StringBuilder().append(date).append("/").append(month + 1).append("/").append(year).toString()));
                            selectDate.setTypeface(Typeface.DEFAULT_BOLD);
                            start_date=selectDate.getText().toString();
                            Drawable verticalBar=calendarViewTwo.getSelectedDateVerticalBar(); // get the applied drawable for the vertical bar
                            calendarViewTwo.setSelectedDateVerticalBar(Color.CYAN);
                            calendarViewTwo.setFocusedMonthDateColor(Color.YELLOW);
                            calendarViewTwo.setMaxDate(System. currentTimeMillis()); //This should disable all future dates.23-Feb-2019

                        }
                        selectDate.setText(start_date);
                        btn.dismiss();


                    }
                });

            }
        });
        clockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePickerBottomSheet();
            }
        });
        clockout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePickerBottomSheet1();
            }
        });
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectDate.getText().length()!=0||clockin.getText().length()!=0||clockout.getText().length()!=0||totalHours.getText().length()!=0||reasonForLeave.getText().length()!=0)
                {
                    postAttendanceCall();
                    requestButton.clearFocus();


                }
                else
                {
                    Toast.makeText(getContext(), "Enter all details", Toast.LENGTH_SHORT).show();
                    requestButton.clearFocus();

                }
            }
        });




        return  view;
    }
    public void openTimePickerBottomSheet()
    {
        int hourOfDay=23;
        int minute=2;
        boolean is24HourView=true;


        timePickerDialog=new TimePickerDialog(getContext(),android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                clockin.setText(hr + ":" + min);
                Toast.makeText(getContext(), "hr=" + hr + " min=" + min, Toast.LENGTH_SHORT).show();
                hours=hr+min;
                Log.i("Time1",String.valueOf(hours));

            }
        },hourOfDay,minute,is24HourView);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.setTitle("Select a Time");
        timePickerDialog.show();

    }
    public void openTimePickerBottomSheet1()
    {
        int hourOfDay=2;
        int minute=2;
        boolean is24HourView=true;


        timePickerDialog=new TimePickerDialog(getContext(),android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hoursOfDay, int minutee) {
                clockout.setText(hoursOfDay + ":" + minute);
                hours1=hoursOfDay+minutee;
                Toast.makeText(getContext(), "i=" + hoursOfDay + " i1=" + minute, Toast.LENGTH_SHORT).show();
                Log.i("Total hours", String.valueOf(hours1));
                total=hours+hours1;

            }
        },hourOfDay,minute,is24HourView);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.setTitle("Select a Time");
        timePickerDialog.show();

    }
    public void apiInIt()
    {
        retrofit= AttendanceApiClient.getRetrofit();
        attendanceLogInService= AttendanceApiClient.getLoginService();
    }
    public void postAttendanceCall()
    {
        postAttendanceRequest=new PostAttendanceRequest("Attendance","2022-05-03","09:00","7:00","Forgot to Punch In");
        Call<PostClockInOutResponse> call=attendanceLogInService.postAttendanceCall(postAttendanceRequest);
        call.enqueue(new Callback<PostClockInOutResponse>() {
            @Override
            public void onResponse(Call<PostClockInOutResponse> call, Response<PostClockInOutResponse> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                postAttendanceResponse=response.body();
                if(getArguments().isEmpty())
                {
                    Toast.makeText(getContext(), postAttendanceResponse.show.message, Toast.LENGTH_SHORT).show();

                }
//                selectDate.setText(postAttendanceRequest.startDate);
//                Log.i("Select date",postAttendanceRequest.startDate);
//                clockin.setText(postAttendanceRequest.clockIn);
//                clockout.setText(postAttendanceRequest.clockOut);
//                reasonForLeave.setText(postAttendanceRequest.reason);



            }
            @Override
            public void onFailure(Call<PostClockInOutResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error in Request Attendance", Toast.LENGTH_SHORT).show();
            }
        });
    }

}