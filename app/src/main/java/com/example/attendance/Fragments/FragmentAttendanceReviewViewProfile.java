package com.example.attendance.Fragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance.Adapters.MonthAdapterClass;
import com.example.attendance.AttendanceApi.AttendanceApiClient;
import com.example.attendance.AttendanceApi.AttendanceLogInService;
import com.example.attendance.AttendanceApi.PostDownloadReceiptRequest;
import com.example.attendance.AttendanceApi.PostDownloadReceiptResponse;
import com.example.attendance.ModelClass.MonthModalClass;
import com.example.attendance.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class FragmentAttendanceReviewViewProfile extends Fragment {

  View view;
  ImageView reqLeave;
  AutoCompleteTextView spinner;
  RecyclerView monthRecycler;
  RecyclerView.LayoutManager layoutManager;
  RecyclerView.Adapter adapter;
  ArrayList<MonthModalClass> monthModalClassArrayList;
  Retrofit retrofit;
  AttendanceLogInService attendanceLogInService;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    LinearLayout selectRangeLayout;
  TextView downloadReport;
  ArrayAdapter<String> selectAdapter;
  ArrayList<String> month;
  PostDownloadReceiptRequest postDownloadReceiptRequest;
  PostDownloadReceiptResponse postDownloadReceiptResponse;

    RadioGroup radioGroup;
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
        view= inflater.inflate(R.layout.attendance_fragment_attendance_review_view_profile, container, false);
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
                final View discountpopup = getLayoutInflater().inflate(R.layout.attendance_select_range_dialog, null);
                discountpopup.setClipToOutline(true);
                builder.setView(discountpopup);
                alertDialog = builder.create();
                alertDialog.show();

                //downloadReceipt();
                RadioButton button1,button2,button3,button4,button5,specificrange;

                selectRangeLayout=view.findViewById(R.id.layout_cal_range);
                specificrange=(RadioButton)view.findViewById(R.id.rb6_specific_datarange);

                button1= (RadioButton) view.findViewById(R.id.rb1);
                button2=view.findViewById(R.id.rb2);
                button3=view.findViewById(R.id.rb3);
                button4=view.findViewById(R.id.rb4);
                button5=view.findViewById(R.id.rb5);


            }
        });
        apiInIt();


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



    public void downloadReceipt()
    {
        postDownloadReceiptRequest=new PostDownloadReceiptRequest(430,"specificDateRange","2022-05-12","2022-05-15");
        Call<PostDownloadReceiptResponse> call=attendanceLogInService.postDownloadReceiptCall(postDownloadReceiptRequest);
        call.enqueue(new Callback<PostDownloadReceiptResponse>() {
            @Override
            public void onResponse(Call<PostDownloadReceiptResponse> call, Response<PostDownloadReceiptResponse> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                }
                postDownloadReceiptResponse=response.body();
                Toast.makeText(getContext(), postDownloadReceiptResponse.file, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostDownloadReceiptResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error in download receipt", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void apiInIt()
    {
        retrofit= AttendanceApiClient.getRetrofit();
        attendanceLogInService= AttendanceApiClient.getLoginService();
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