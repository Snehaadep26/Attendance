package com.example.attendance.AttendanceApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AttendanceLogInService {
    String token = "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTA5OCwicGhvbmUiOiIrOTE4MDczMDg5OTA2IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJkZXZpY2VMb2dpbkNvZGUiOm51bGwsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE4MDczMDg5OTA2MTA5ODlkODRmNDcwLTg0ODktNGVjOS1hMDUzLTg0Y2IzMjQwOGUzMiIsImlhdCI6MTY1NjUwMDA0M30.ZsMIAhvLSloVY5YqqkZ5v5_2g9m3x988p-AK1SqGo2A";
    String link = "orgurl:test.theclassroom.biz";

    @Headers({token, link})
    @POST("attendancev2/clock-in-out")
    Call<PostClockInOutResponse> postClockInOutCall(@Body PostClockInOutRequest postClockInOutRequest);


    @Headers({token, link})
    @GET("attendancev2/dashboard")
    Call<HashMap<String, ArrayList<GetDashboardResponse>>> dashBoardCall(@HeaderMap Map<String,String> headers);

}
