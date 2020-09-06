package com.lionelnkeoua.pluralsight1.view.fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionelnkeoua.pluralsight1.R;
import com.lionelnkeoua.pluralsight1.adapters.HourRecyclerAdapter;
import com.lionelnkeoua.pluralsight1.model.Hour;
import com.lionelnkeoua.pluralsight1.viewmodel.HoursViewModel;

import java.util.ArrayList;
import java.util.List;

public class HoursFragment extends Fragment {

    private HoursViewModel mViewModel;

    @BindView(R.id.hour_recycler)
    RecyclerView mRecyclerView;
    private View view;
    private List<Hour> hourList = new ArrayList<>();
    private HourRecyclerAdapter hourRecyclerAdapter;

    public static HoursFragment newInstance() {
        return new HoursFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.hours_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.hour_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadHours();
        return view;
    }


    public void loadHours() {

        mViewModel = ViewModelProviders.of(this).get(HoursViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getHours().observe(this, new Observer<List<Hour>>() {
            @Override
            public void onChanged(List<Hour> hours) {
                hourRecyclerAdapter = new HourRecyclerAdapter(getContext(), hours);
                mRecyclerView.setAdapter(hourRecyclerAdapter);
            }
        });
    }

}