package com.example.attendance.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attendance.Adapters.ParentRecyclerViewAdapter;
import com.example.attendance.ModelClass.ParentModalClass;
import com.example.attendance.R;

import java.util.ArrayList;

public class HolidayFragment extends Fragment {

    View view;
    ArrayList<ParentModalClass> parentModalClassArrayList;
    RecyclerView parentRecyclerView;
    RecyclerView.LayoutManager parentLayoutManager;
    RecyclerView.Adapter parentAdapter;




    public HolidayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_holiday, container, false);
        createCard();
        buildRecyclerview();
        return view;
    }
    public void  createCard()
    {
        parentModalClassArrayList=new ArrayList<>();
        parentModalClassArrayList.add(new ParentModalClass("January"));
        parentModalClassArrayList.add(new ParentModalClass("Feb"));
        parentModalClassArrayList.add(new ParentModalClass("march"));
        parentModalClassArrayList.add(new ParentModalClass("April"));
        parentModalClassArrayList.add(new ParentModalClass("May"));
        parentModalClassArrayList.add(new ParentModalClass("June"));
        parentModalClassArrayList.add(new ParentModalClass("July"));


    }
    public void buildRecyclerview()
    {
        parentRecyclerView=view.findViewById(R.id.parent_recycler);
        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentAdapter=new ParentRecyclerViewAdapter(parentModalClassArrayList,getContext());
        parentRecyclerView.setAdapter(parentAdapter);
    }
}