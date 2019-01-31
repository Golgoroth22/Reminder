package com.falin.valentin.reminder_project.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.falin.valentin.reminder_project.R;
import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.adapters.ReminderAdapter;

public class WarningFragment extends Fragment {
    private static final String PRESENTER_KEY = "PRESENTER_KEY";

    @BindView(R.id.content_recycler)
    RecyclerView mRecyclerView;
    private ReminderAdapter mAdapter;

    private Presenter mPresenter;

    public WarningFragment() {
    }

    public static WarningFragment newInstance(Presenter presenter) {
        WarningFragment fragment = new WarningFragment();
        Bundle args = new Bundle();
        args.putSerializable(PRESENTER_KEY, presenter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPresenter = (Presenter) getArguments().getSerializable(PRESENTER_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        ButterKnife.bind(this, view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ReminderAdapter(mPresenter.getModelList());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    public void updateReminderList(String newReminder) {
        mAdapter.addReminder(newReminder);
    }

    public void searchReminderBy(String text) {
        mAdapter.searchReminderBy(text);
    }
}
