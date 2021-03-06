package com.example.attendance.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.attendance.Adapters.LeaveHistoryModalClassAdapter;
import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.GetProfileTabsResponse;
import com.example.attendance.ModelClass.LeaveHistoryModalClass;
import com.example.attendance.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LeavesFragment extends Fragment {

    View view;
    ImageView reqLeaveImage;
    ArrayList<LeaveHistoryModalClass> leaveHistoryModalClassArrayList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Retrofit retrofit;
    AttendanceLogInService attendanceLogInService;
    GetProfileTabsResponse getProfileTabsResponse;

    public LeavesFragment() {
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
        view= inflater.inflate(R.layout.attendance_fragment_leaves, container, false);

        recyclerView=view.findViewById(R.id.leave_history_RV);
        apiInIt();
        getProfileTab();
        createCard();
        buildRecyclerview();
        return  view;
    }
    public void apiInIt()
    {
        retrofit= AttendanceApiClient.getRetrofit();
        attendanceLogInService= AttendanceApiClient.getLoginService();
    }
    public  void getProfileTab()
    {
        Call<GetProfileTabsResponse> call=attendanceLogInService.getProfileTabsCall();
        call.enqueue(new Callback<GetProfileTabsResponse>() {
            @Override
            public void onResponse(Call<GetProfileTabsResponse> call, Response<GetProfileTabsResponse> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                getProfileTabsResponse=response.body();
                Toast.makeText(getContext(),getProfileTabsResponse.attendanceTab.attendanceByTimesheet.averageWorkingHoursTillDate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GetProfileTabsResponse> call, Throwable t) {

            }
        });

    }
    public void createCard()
    {
        leaveHistoryModalClassArrayList=new ArrayList<>();
        leaveHistoryModalClassArrayList.add(new LeaveHistoryModalClass("2","2334445","234567","Sick leave"));
        leaveHistoryModalClassArrayList.add(new LeaveHistoryModalClass("2","2334445","234567","Sick leave"));
        leaveHistoryModalClassArrayList.add(new LeaveHistoryModalClass("2","2334445","234567","Sick leave"));
        leaveHistoryModalClassArrayList.add(new LeaveHistoryModalClass("2","2334445","234567","Sick leave"));
        leaveHistoryModalClassArrayList.add(new LeaveHistoryModalClass("2","2334445","234567","Sick leave"));
        leaveHistoryModalClassArrayList.add(new LeaveHistoryModalClass("2","2334445","234567","Sick leave"));

    }
    public void buildRecyclerview()
    {
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new LeaveHistoryModalClassAdapter(leaveHistoryModalClassArrayList,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);
    }
}