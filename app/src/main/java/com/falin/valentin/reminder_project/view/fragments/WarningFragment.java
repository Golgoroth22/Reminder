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
    private static final String TAB_ID = "TAB_ID";

    @BindView(R.id.content_recycler)
    RecyclerView mRecyclerView;
    private ReminderAdapter mAdapter;

    private Presenter mPresenter;
    private int mTabId;

    public WarningFragment() {
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mPresenter = (Presenter) getArguments().getSerializable(PRESENTER_KEY);
//            mTabId = getArguments().getInt(TAB_ID);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        ButterKnife.bind(this, view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ReminderAdapter(mPresenter.getModelList(mTabId));
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    public void updateReminderList(String newReminder) {
        mAdapter.addReminder(newReminder);
    }

    public void setArguments(Presenter presenter, int tabId) {
        mPresenter = presenter;
        mTabId = tabId;
    }
}
