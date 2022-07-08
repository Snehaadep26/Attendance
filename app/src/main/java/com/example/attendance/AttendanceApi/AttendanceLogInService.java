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
    String token = "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTY0MSwicGhvbmUiOiIrOTE4OTg5ODk4OTg5IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJkZXZpY2VMb2dpbkNvZGUiOm51bGwsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE4OTg5ODk4OTg5MTY0MWUwNWQzNWZjLTM1NzgtNDRlMy1hNmMxLTNmYjg4MzJmYzdmYyIsImlhdCI6MTY1NjY2Mjk5OX0.Vi5zC575QdSPo2pOhehr6RhDvy5hRnI8GaQNLJobwNY";
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
    @GET("attendancev2/profile-tabs/1768")
    Call<GetProfileTabsResponse> getProfileTabsCall();



    @Headers({token,link})
    @DELETE("attendancev2/delete-request")
    Call<DeleteAttendanceRequest> deleteAttendanceCall(@Query("id") int id);


}
