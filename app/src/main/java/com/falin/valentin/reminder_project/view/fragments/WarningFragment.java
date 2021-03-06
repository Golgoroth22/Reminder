package com.falin.valentin.reminder_project.view.fragments;


import android.os.Bundle;

import com.falin.valentin.reminder_project.Constants;
import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.adapters.ReminderAdapter;

public class WarningFragment extends AbstractFragment {

    public static WarningFragment newInstance(Presenter presenter) {
        WarningFragment fragment = new WarningFragment();
        Bundle args = new Bundle();
        args.putSerializable(PRESENTER_KEY, presenter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRecyclerAdapter() {
        mAdapter = new ReminderAdapter(mPresenter.getModelList(Constants.TAB_ONE));
    }
}
