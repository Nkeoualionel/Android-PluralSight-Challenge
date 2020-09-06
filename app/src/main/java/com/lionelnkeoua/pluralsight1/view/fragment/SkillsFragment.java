package com.lionelnkeoua.pluralsight1.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lionelnkeoua.pluralsight1.R;
import com.lionelnkeoua.pluralsight1.adapters.HourRecyclerAdapter;
import com.lionelnkeoua.pluralsight1.adapters.SkillsRecyclerAdapter;
import com.lionelnkeoua.pluralsight1.model.Hour;
import com.lionelnkeoua.pluralsight1.model.Skill;
import com.lionelnkeoua.pluralsight1.viewmodel.HoursViewModel;
import com.lionelnkeoua.pluralsight1.viewmodel.SkillsViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillsFragment extends Fragment {

    private SkillsViewModel mSkillsViewModel;


    RecyclerView mRecyclerView;
    private View view;
    private List<Skill> skillList = new ArrayList<>();
    private SkillsRecyclerAdapter skillsRecyclerAdapter;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_skills, container, false);
        mRecyclerView = view.findViewById(R.id.skill_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadSkills();
        return view;
    }

    public void loadSkills() {

        mSkillsViewModel = ViewModelProviders.of(this).get(SkillsViewModel.class);
        // TODO: Use the ViewModel
        mSkillsViewModel.getSkills().observe(this, new Observer<List<Skill>>() {
           @Override
           public void onChanged(List<Skill> skills) {
               skillsRecyclerAdapter = new SkillsRecyclerAdapter(getContext(), skills);
               mRecyclerView.setAdapter(skillsRecyclerAdapter);
           }
       });
    }
}
