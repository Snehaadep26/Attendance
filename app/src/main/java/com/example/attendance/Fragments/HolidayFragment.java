package com.example.attendance.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.attendance.Adapters.ParentRecyclerViewAdapter;
import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.GetDashboardResponse;
import com.example.attendance.AttendanceApi.Holiday;
import com.example.attendance.ModelClass.ParentModalClass;
import com.example.attendance.R;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HolidayFragment extends Fragment {

    View view;
    ArrayList<ParentModalClass> parentModalClassArrayList;
    RecyclerView parentRecyclerView;
    RecyclerView.LayoutManager parentLayoutManager;
    RecyclerView.Adapter parentAdapter;
    Holiday holiday;
    GetDashboardResponse getDashboardResponse;
    Retrofit retrofit;
    AttendanceLogInService attendanceLogInService;




    public HolidayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.attendance_fragment_holiday, container, false);
       // createCard();
       // buildRecyclerview();
        apiInIt();
        dashBoardApi();
        return view;
    }
//    public void  createCard()
//    {
//        parentModalClassArrayList=new ArrayList<>();
//        parentModalClassArrayList.add(new ParentModalClass("January"));
//        parentModalClassArrayList.add(new ParentModalClass("Feb"));
//        parentModalClassArrayList.add(new ParentModalClass("march"));
//        parentModalClassArrayList.add(new ParentModalClass("April"));
//        parentModalClassArrayList.add(new ParentModalClass("May"));
//        parentModalClassArrayList.add(new ParentModalClass("June"));
//        parentModalClassArrayList.add(new ParentModalClass("July"));
//
//
//    }

    public void apiInIt()
    {
        retrofit= AttendanceApiClient.getRetrofit();
        attendanceLogInService= AttendanceApiClient.getLoginService();
    }
    public void dashBoardApi()
    {
        Call<GetDashboardResponse> call = attendanceLogInService.dashBoardCall();
        call.enqueue(new Callback<GetDashboardResponse>() {
            @Override
            public void onResponse(Call<GetDashboardResponse> call, Response<GetDashboardResponse> response) {

                    if(!response.isSuccessful())
                    {
                        Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                    }
                    getDashboardResponse=response.body();
                try{
                    ArrayList<String> standard = new ArrayList();
                    for (int i = 0; i <= getDashboardResponse.holidays.size() - 1; i++) {
                        standard.add(getDashboardResponse.holidays.get(i).month);
                    }
                    Set values = new HashSet(standard);
                    Log.i("tag", values.toString());

                    String[] shortMonths = new DateFormatSymbols().getMonths();
                    Log.i("tag", String.valueOf(shortMonths));


                    ArrayList<String> uni = new ArrayList<>(values);
                    parentModalClassArrayList = new ArrayList<>();
                    Collections.sort(uni);
                    for (int i = 0; i <= values.size() - 1; i++) {
                        parentModalClassArrayList.add(new ParentModalClass(uni.get(i)));
                    }

                    buildRecyclerview();

                }catch (Exception e){
                    Log.i(String.valueOf(getContext()), "onResponse:No data "+e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetDashboardResponse> call, Throwable t) {
                Toast.makeText(getContext(), "error home dashboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
        public void buildRecyclerview()
    {
        parentRecyclerView=view.findViewById(R.id.parent_recycler);
        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentAdapter=new ParentRecyclerViewAdapter(parentModalClassArrayList,getContext(),holiday );
        parentRecyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
        parentRecyclerView.setNestedScrollingEnabled(true);
    }
}