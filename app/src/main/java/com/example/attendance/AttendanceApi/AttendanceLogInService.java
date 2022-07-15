package com.example.attendance.AttendanceApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AttendanceLogInService {
    String token = "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTg4NywicGhvbmUiOiIrOTE4MDczMDg5OTA3IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJkZXZpY2VMb2dpbkNvZGUiOm51bGwsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE4MDczMDg5OTA3MTg4NzU2OTg5ZjljLWYwYzQtNDM3MC1iN2Y1LTdlNThiMWU5YzBlYSIsImlhdCI6MTY1NzY5NDg4MH0.1JWflQ-H1PQWCOfPs_klH9Mr6qiNdTE8YMEyt9vK5is";
    String link = "orgurl:test.theclassroom.biz";

    @Headers({token, link})
    @POST("attendancev2/clock-in-out")
    Call<PostClockInOutResponse> postClockInOutCall(@Body PostClockInOutRequest postClockInOutRequest);

    @Headers({token, link})
    @GET("attendancev2/dashboard")
    Call<GetDashboardResponse> dashBoardCall();

    @Headers({token,link})
    @POST("attendancev2/request")
    Call<PostClockInOutResponse> postAttendanceCall(@Body PostAttendanceRequest postAttendanceRequest);

    @Headers({token,link})
    @POST("attendancev2/download-attendance-report")
    Call<PostDownloadReceiptResponse> postDownloadReceiptCall(@Body PostDownloadReceiptRequest postDownloadReceiptRequest);

    @Headers({token, link})
    @GET("attendancev2/profile-tabs/1882")
    Call<GetProfileTabsResponse> getProfileTabsCall();



    @Headers({token,link})
    @DELETE("attendancev2/delete-request")
    Call<DeleteAttendanceRequest> deleteAttendanceCall(@Query("id") int id);


}
