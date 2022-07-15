package com.example.attendance.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;

import com.example.attendance.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;


public class RequestLeaves extends Fragment {

    View view;
    TextInputEditText startDate,endDate;
    String start_date, end_date;
    AutoCompleteTextView requestLeaves;
    CalendarView datePickerDialog;


    public RequestLeaves() {
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
        view= inflater.inflate(R.layout.attendance_fragment_request_leaves, container, false);
        startDate=view.findViewById(R.id.startdate_et);
        endDate=view.findViewById(R.id.endate_et);
        requestLeaves=view.findViewById(R.id.spinnerLeavesReq);

        ArrayAdapter<String> adapterRelation = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.Leaves));
        requestLeaves.setAdapter(adapterRelation);
        requestLeaves.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                requestLeaves.showDropDown();

                return false;

            }
        });

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view=getLayoutInflater().inflate(R.layout.attendance_bottom_calendar,null);
                datePickerDialog=view.findViewById(R.id.datePicker);
                BottomSheetDialog btn=new BottomSheetDialog(getActivity(),R.style.AppBottomSheetDialogTheme);
                btn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btn.setContentView(view);
                btn.setCanceledOnTouchOutside(true);
                btn.getWindow().setGravity(Gravity.BOTTOM);
                btn.setCanceledOnTouchOutside(true);
                btn.show();

            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view=getLayoutInflater().inflate(R.layout.attendance_bottom_calendar,null);
                datePickerDialog=view.findViewById(R.id.datePicker);
                BottomSheetDialog btn=new BottomSheetDialog(getActivity(),R.style.AppBottomSheetDialogTheme);
                btn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btn.setContentView(view);
                btn.setCanceledOnTouchOutside(true);
                btn.getWindow().setGravity(Gravity.BOTTOM);
                btn.setCanceledOnTouchOutside(true);
                btn.show();
            }
        });
        return view;
    }
//    private void customdateRangebottomsheet() {
//        view = getLayoutInflater().inflate(R.layout.bottom_calendar, null);
//        calendarViewTwo = view.findViewById(R.id.datePicker);
//        BottomSheetDialog btn = new BottomSheetDialog(getActivity(), R.style.AppBottomSheetDialogTheme);
//        btn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        btn.setContentView(view);
//        btn.setCanceledOnTouchOutside(true);
//        btn.getWindow().setGravity(Gravity.BOTTOM);
//        btn.setCanceledOnTouchOutside(true);
//        btn.show();
//        calendarViewTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//
//
////        calendarViewTwo.callOnClick(new CalendarView.OnDateChangeListener() {
////            @Override
////            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
////                if (startDate.getText().length() <= 0) {
////                    startDate.requestFocus();
////                    startDate.setText((new StringBuilder().append(date).append("/").append(month + 1).append("/").append(year).toString()));
////                    startDate.setTypeface(Typeface.DEFAULT_BOLD);
////                    start_date = startDate.getText().toString();
////                    Log.i("Date", String.valueOf(start_date));
////                    //startDate.setText(String.valueOf(start_date));
////
////                } else if (startDate.getText().length() != 0 && endDate.getText().length() <= 0) {
////                    endDate.requestFocus();
////                    endDate.setText((new StringBuilder().append(date).append("/").append(month + 1).append("/").append(year).toString()));
//////                    endDate.setTextColor(Color.parseColor(String.valueOf(Color.TRANSPARENT)));
////                    endDate.setTypeface(Typeface.DEFAULT_BOLD);
////                    end_date = endDate.getText().toString();
////                    //allTimeText.setText(String.valueOf("-"+end_date));
////                }
////                //endDate.setText(String.valueOf(end_date));
////            }
////        });
//    }

}