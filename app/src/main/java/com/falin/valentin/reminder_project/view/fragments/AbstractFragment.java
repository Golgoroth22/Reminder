package com.falin.valentin.reminder_project.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.falin.valentin.reminder_project.R;
import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.adapters.ReminderAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

abstract public class AbstractFragment extends Fragment {
    static final String PRESENTER_KEY = "PRESENTER_KEY";

    @BindView(R.id.content_recycler)
    RecyclerView mRecyclerView;
    ReminderAdapter mAdapter;

    Presenter mPresenter;

    public AbstractFragment() {
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
        initRecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    protected abstract void initRecyclerAdapter();

    public void updateReminderList(String newReminder) {
        mAdapter.addReminder(newReminder);
    }

    public void searchReminderBy(String text) {
        mAdapter.searchReminderBy(text);
    }
}
