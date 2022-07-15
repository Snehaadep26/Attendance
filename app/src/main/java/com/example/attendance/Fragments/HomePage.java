package com.example.attendance.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.GetDashboardResponse;
import com.example.attendance.AttendanceApi.PostClockInOutRequest;
import com.example.attendance.AttendanceApi.PostClockInOutResponse;
import com.example.attendance.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePage extends Fragment {
    TextView attendanceSummary,holidays,leaveReq,forgetClickIn,viewProfile;
    AppCompatButton clockIn,clockOut;
    PostClockInOutRequest clockInOutRequest;
    PostClockInOutResponse clockInOutResponse;
    ArrayList<String> set1;
    Retrofit retrofit;
    int count;
    AttendanceLogInService attendanceLogInService;
    HashMap<String, ArrayList<GetDashboardResponse>>
            listHashMap;

    GetDashboardResponse getDashboardResponse;
    TextView clockInTime;
    TextView clockOutTime;
    TextView geofenceLoc;
    TextView dateTv;
    TextView presentDays;
    TextView absentays;
    String absentday;
    TextView overallPer;
    TextView totalWorkinghrs;
    TextView averageWorkingHrs;
    TextView totalLeaves,totalworkingClocktime;
    private HashMap<String, String> headers;


    public HomePage() {
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
        View v= inflater.inflate(R.layout.attendance_fragment_home_page, container, false);
        NavController navController = NavHostFragment.findNavController(this);
        attendanceSummary=v.findViewById(R.id.attendanceSummaryTv);
        holidays=v.findViewById(R.id.holidayText);
        leaveReq=v.findViewById(R.id.upcomingTv);
        forgetClickIn=v.findViewById(R.id.forgotClockInTv);
        viewProfile=v.findViewById(R.id.view_profile_Tv);
        clockIn=v.findViewById(R.id.clockmein_btn);
        clockOut=v.findViewById(R.id.clockmeout_btn);
        clockInTime=v.findViewById(R.id.clock_in_time);
        clockOutTime=v.findViewById(R.id.clock_out_text);
        geofenceLoc=v.findViewById(R.id.geofence_location_Tv);
        dateTv=v.findViewById(R.id.sincedatetext);
        presentDays=v.findViewById(R.id.present_days_Tv);
        absentays=v.findViewById(R.id.absent_days_Tv);
        overallPer=v.findViewById(R.id.overall_per_Tv);
        totalWorkinghrs=v.findViewById(R.id.total_working_hrs);
        averageWorkingHrs=v.findViewById(R.id.average_working_hrs);
        totalLeaves=v.findViewById(R.id.total_leaves);
        totalworkingClocktime=v.findViewById(R.id.total_working_hrs_clocktext);

        apiInIt();
        clockInOut();

        dashBoardApi();

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)v.findViewById(R.id.refreshLayoutAttendanceHome);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
        attendanceSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections nav1=HomePageDirections.actionHomePageToAttendanceSummary();
                navController.navigate(nav1);
            }
        });
        holidays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections nav3=HomePageDirections.actionHomePageToHolidayFragment();
                navController.navigate(nav3);
            }
        });
        leaveReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections=HomePageDirections.actionHomePageToLeavesFragment();
                navController.navigate(navDirections);
            }
        });
        forgetClickIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections nav2=HomePageDirections.actionHomePageToRequestAttendance();
                navController.navigate(nav2);
            }
        });
        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections=HomePageDirections.actionHomePageToFragmentAttendanceReviewViewProfile();
                navController.navigate(navDirections);
            }
        });
        return  v;
    }
    public void apiInIt()
    {
        retrofit= AttendanceApiClient.getRetrofit();
        attendanceLogInService= AttendanceApiClient.getLoginService();
    }
    public void clockInOut()
    {
        clockInOutRequest = new PostClockInOutRequest("12.9002122","77.650777");
        Call<PostClockInOutResponse> call=attendanceLogInService.postClockInOutCall(clockInOutRequest);
        call.enqueue(new Callback<PostClockInOutResponse>() {
            @Override
            public void onResponse(Call<PostClockInOutResponse> call, Response<PostClockInOutResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                clockInOutResponse = response.body();
                clockIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count++;
                        Toast.makeText(getContext(), clockInOutResponse.show.message, Toast.LENGTH_SHORT).show();
                        if(count==1) {
                            clockIn.setVisibility(View.GONE);
                            clockOut.setVisibility(View.VISIBLE);
                            dashBoardApi();
                        }
                        else
                        {
                            clockIn.setVisibility(View.GONE);
                            clockOut.setVisibility(View.VISIBLE);
                        }
                     //   Log.e("Starttime",getDashboardResponse.attendanceToday.startTime);
                       clockInTime.setText(getDashboardResponse.attendanceToday.getStartTime());
                    }
                });
                clockOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Time time= Time.valueOf(getDashboardResponse.attendanceToday.startTime);
                        Log.e("Total working", String.valueOf(time));

//                        clockIn.setVisibility(View.VISIBLE);
                        clockOutTime.setText(getDashboardResponse.attendanceToday.endTime);
                    }
                });
            }
            @Override
            public void onFailure(Call<PostClockInOutResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error while clocking", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void dashBoardApi()
    {
        Call<GetDashboardResponse> call = attendanceLogInService.dashBoardCall();
//        call.enqueue(new Callback<HashMap<String, ArrayList<GetDashboardResponse>>>() {
//            @Override
//            public void onResponse(Call<HashMap<String, ArrayList<GetDashboardResponse>>> call, Response<HashMap<String, ArrayList<GetDashboardResponse>>> response) {
//                if(response.isSuccessful())
//                {
//                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
//                }
//                listHashMap=response.body();
//                Set<String> arrayList=listHashMap.keySet();
//                set1=new ArrayList<>();
//                for(String s:
//                             arrayList){
//                    set1.add(s);
//                }
//                for (int i = 0; i < set1.size(); i++) {
//                    for (int j = 0; j < listHashMap.get(set1.get(i)).size(); j++) {
//                        {
//                            absentday=String.valueOf(listHashMap.get(set1.get(i)).get(j).attendanceOverview.getAbsentCount());
//
//                            Log.i("Absent",absentays.toString());
//                            Log.i("sent",String.valueOf(listHashMap.get(0).get(0).attendanceOverview.absentCount));
//                            absentays.setText((CharSequence)absentday);
////                            if (parentModelArrayList.get(position).getStdClass().equals(listHashMap.get(stdName.get(i)).get(j).getStd())) {
////                                arrayList.add(new ChildModelclass(listHashMap.get(stdName.get(i)).get(j).getSection(), String.valueOf(listHashMap.get(stdName.get(i)).get(j).getStudentsCount()),listHashMap.get(stdName.get(i)).get(j).getId(),listHashMap.get(stdName.get(i)).get(j).getStd()));
////                            }
//                          //  listHashMap.get(stdName.get(i)).get(j).getId(),listHashMap.get(stdName.get(i)).get(j).getStd()));
//                        }
//                    }
//                }
//                Toast.makeText(getContext(),"", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<HashMap<String, ArrayList<GetDashboardResponse>>> call, Throwable t) {
//
//            }
//        });
        call.enqueue(new Callback<GetDashboardResponse>() {
            @Override
            public void onResponse(Call<GetDashboardResponse> call, Response<GetDashboardResponse> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }

                HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                Set values=new HashSet(hashMap.values());
                Log.i("hashset", String.valueOf(values));
                hashMap.put("presentcount",values.size());
               // hashMap.put("absent",getDashboardResponse.attendanceOverview.absentCount);

                Log.e("hashmap", String.valueOf(hashMap));

                getDashboardResponse=response.body();
                Log.i("present",String.valueOf(getDashboardResponse.attendanceOverview.getAbsentCount()));
                Log.i("Geofence",getDashboardResponse.attendanceToday.geoFenceTitle);
                Log.i("dataaaaa", String.valueOf(getDashboardResponse));
                Log.i("starttime",getDashboardResponse.attendanceToday.startTime);
                Log.i("endtime",getDashboardResponse.attendanceToday.endTime);
                Log.i("average",getDashboardResponse.attendanceOverview.averageWorkingHoursTillDate);
                Log.i("total leaves",getDashboardResponse.attendanceOverview.totalLeaves);
                Log.i("totalworking",getDashboardResponse.attendanceOverview.totalWorkingHoursTillDate);
                Log.i("overallper", String.valueOf(getDashboardResponse.attendanceOverview.overallPercentage));
                Log.i("since",getDashboardResponse.since);
//                Log.i("holiday",getDashboardResponse.holidays.get(0).data.get(0).title);



                Toast.makeText(getContext(),getDashboardResponse.attendanceToday.geoFenceTitle, Toast.LENGTH_SHORT).show();
                geofenceLoc.setText(getDashboardResponse.attendanceToday.geoFenceTitle);
                dateTv.setText(getDashboardResponse.since);
                presentDays.setText(String.valueOf(getDashboardResponse.attendanceOverview.getPresentCount()));
                absentays.setText(String.valueOf(getDashboardResponse.attendanceOverview.getAbsentCount()));
                overallPer.setText(String.valueOf(getDashboardResponse.attendanceOverview.overallPercentage));
                totalWorkinghrs.setText(getDashboardResponse.attendanceOverview.totalWorkingHoursTillDate);
                averageWorkingHrs.setText(getDashboardResponse.attendanceOverview.averageWorkingHoursTillDate);
                totalLeaves.setText(getDashboardResponse.attendanceOverview.totalLeaves);
          //      clockInTime.setText(getDashboardResponse.attendanceToday.startTime);
            //    clockOutTime.setText(getDashboardResponse.attendanceToday.endTime);


                Log.e("dddddddddddd", String.valueOf(getDashboardResponse.attendanceOverview.getAbsentCount()));
            }

            @Override
            public void onFailure(Call<GetDashboardResponse> call, Throwable t) {
                Toast.makeText(getContext(), "error home dashboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
}