package com.example.attendance.Fragments;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.attendance.Adapters.MonthAdapterClass;
import com.example.attendance.ModelClass.MonthModalClass;
import com.example.attendance.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class FragmentAttendanceReviewViewProfile extends Fragment {

  View view;
  ImageView reqLeave;
  AutoCompleteTextView spinner;
  RecyclerView monthRecycler;
  RecyclerView.LayoutManager layoutManager;
  RecyclerView.Adapter adapter;
  ArrayList<MonthModalClass> monthModalClassArrayList;

    AlertDialog alertDialog;

    AlertDialog.Builder builder;
  TextView downloadReport;

  ArrayAdapter<String> selectAdapter;
  ArrayList<String> month;


    public FragmentAttendanceReviewViewProfile() {
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
        view= inflater.inflate(R.layout.fragment_attendance_review_view_profile, container, false);
        NavController navController = NavHostFragment.findNavController(this);

        spinner=view.findViewById(R.id.selectClassET);

        downloadReport=view.findViewById(R.id.download_report);

        reqLeave=view.findViewById(R.id.requestLeavesImg);
        reqLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               NavDirections nav1=FragmentAttendanceReviewViewProfileDirections.actionFragmentAttendanceReviewViewProfileToRequestLeaves();
               navController.navigate(nav1);
            }
        });
        downloadReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder = new AlertDialog.Builder(getContext());
                final View discountpopup = getLayoutInflater().inflate(R.layout.select_range_dialog, null);
                discountpopup.setClipToOutline(true);
                builder.setView(discountpopup);
                alertDialog = builder.create();
                alertDialog.show();
            }
        });


       spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                view=getLayoutInflater().inflate(R.layout.months_list_bottomsheet,null);
//                monthRecycler=view.findViewById(R.id.monthsListRV);
//                createCard();
//                buildRecyclerView();
//                BottomSheetDialog btn=new BottomSheetDialog(getActivity(),R.style.AppBottomSheetDialogTheme);
//                btn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                btn.setContentView(view);
//                btn.setCanceledOnTouchOutside(true);
//                btn.getWindow().setGravity(Gravity.BOTTOM);
//                btn.setCanceledOnTouchOutside(true);
 //               btn.show();
                month=new ArrayList<>();
                month.add("January");
                month.add("February");
                month.add("March");
                month.add("April");
                month.add("May");
                month.add("June");
                month.add("July");
                month.add("August");
                month.add("September");
                month.add("October");
                month.add("November");
                month.add("December");

                selectAdapter(month);

            }
        });

        return view;
    }
    public void selectAdapter(ArrayList<String> months)
    {
        selectAdapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,months);
        spinner.setAdapter(selectAdapter);
        //spinner.setDropDownHeight(1700);
    }
    public void buildRecyclerView() {
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        monthRecycler.setLayoutManager(layoutManager);
        adapter=new MonthAdapterClass(monthModalClassArrayList,getContext());
        monthRecycler.setAdapter(adapter);
    }

    public void createCard() {
        monthModalClassArrayList=new ArrayList<>();
        monthModalClassArrayList.add(new MonthModalClass("January"));
        monthModalClassArrayList.add(new MonthModalClass("February"));
        monthModalClassArrayList.add(new MonthModalClass("March"));
        monthModalClassArrayList.add(new MonthModalClass("April"));
        monthModalClassArrayList.add(new MonthModalClass("May"));
        monthModalClassArrayList.add(new MonthModalClass("June"));
        monthModalClassArrayList.add(new MonthModalClass("July"));
        monthModalClassArrayList.add(new MonthModalClass("August"));
        monthModalClassArrayList.add(new MonthModalClass("September"));
        monthModalClassArrayList.add(new MonthModalClass("October"));
        monthModalClassArrayList.add(new MonthModalClass("November"));
        monthModalClassArrayList.add(new MonthModalClass("December"));



//        ArrayAdapter<String> adapterRelation = new ArrayAdapter<String>(
//                getActivity(), android.R.layout.simple_list_item_1, getResources()
//                .getStringArray(R.array.Months));
//        AutoCompleteTextView textViewRelation = (AutoCompleteTextView)
//                view. findViewById(R.id.spinner_month);
//        textViewRelation.setAdapter(adapterRelation);
//        textViewRelation.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                textViewRelation.showDropDown();
//                return false;
//            }
//        });

    }


}