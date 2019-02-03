package com.falin.valentin.reminder_project.presenter;

import com.falin.valentin.reminder_project.Constants;
import com.falin.valentin.reminder_project.MainActivity;
import com.falin.valentin.reminder_project.model.DataModel;
import com.falin.valentin.reminder_project.view.fragments.TODOFragment;
import com.falin.valentin.reminder_project.view.fragments.WarningFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements Serializable {
    private DataModel mModel;
    private int mCurrentFragmentId;
    private WarningFragment mWarningFragment;
    private TODOFragment mTODOFragment;

    public Presenter() {
        mModel = DataModel.getInstance();
    }

    public List<String> getModelList(int tabId) {
        switch (tabId) {
            case Constants.TAB_ONE:
                return mModel.getTabOneList();
            case Constants.TAB_TWO:
                return mModel.getTabTwoList();
        }
        return new ArrayList<>();
    }

    public void fabClicked() {
        mWarningFragment.updateReminderList(mModel.addReminder(mCurrentFragmentId));
    }

    public void setCurrentFragmentId(int fragmentId) {
        mCurrentFragmentId = fragmentId;
    }

    public void attachWarningFragmentContext(WarningFragment fragment) {
        mWarningFragment = fragment;
    }

    public void attachTODOFragmentContext(TODOFragment fragment) {
        mTODOFragment = fragment;
    }

    public void searchReminderBy(String text) {
        mWarningFragment.searchReminderBy(text);
    }
}
