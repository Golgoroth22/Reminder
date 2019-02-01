package com.falin.valentin.reminder_project.presenter;

import com.falin.valentin.reminder_project.Constants;
import com.falin.valentin.reminder_project.MainActivity;
import com.falin.valentin.reminder_project.model.DataModel;
import com.falin.valentin.reminder_project.view.fragments.WarningFragment;

import java.io.Serializable;
import java.util.List;

public class Presenter implements Serializable {
    private DataModel mModel;
    private MainActivity mContext;
    private int mCurrentFragmentId;
    private WarningFragment mWarningFragment;

    public Presenter() {
        mModel = DataModel.getInstance();
    }

    public List<String> getModelList(int tabId) {
        return mModel.getTabOneList();
    }

    public void fabClicked() {
        mWarningFragment.updateReminderList(mModel.addReminder(mCurrentFragmentId));
    }

    public void attachContext(MainActivity context) {
        mContext = context;
    }

    public void setCurrentFragmentId(int fragmentId) {
        mCurrentFragmentId = fragmentId;
    }

    public void setFragmentContext(WarningFragment fragment) {
        mWarningFragment = fragment;
    }

    public void searchReminderBy(String text) {
        switch (mCurrentFragmentId) {
            case Constants.TAB_ONE:
                mWarningFragment.searchReminderBy(text);
                break;
        }
    }
}
