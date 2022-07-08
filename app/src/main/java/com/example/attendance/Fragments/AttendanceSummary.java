package com.example.attendance.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attendance.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AttendanceSummary#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttendanceSummary extends Fragment {

    View view;

    public AttendanceSummary() {
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
        view= inflater.inflate(R.layout.fragment_attendance_summary, container, false);
        return view;
    }
}