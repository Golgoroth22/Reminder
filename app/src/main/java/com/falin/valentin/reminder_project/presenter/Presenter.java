package com.falin.valentin.reminder_project.presenter;

import com.falin.valentin.reminder_project.Constants;
import com.falin.valentin.reminder_project.MainActivity;
import com.falin.valentin.reminder_project.model.DataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements Serializable {
    private DataModel mModel;
    private MainActivity mContext;

    public Presenter() {
        mModel = DataModel.getInstance();
    }

    public List<String> getModelList(int tabId) {
        List<String> result = new ArrayList<>();
        switch (tabId) {
            case Constants.TAB_ONE:
                result = mModel.getTabOnelist();
                break;
            case Constants.TAB_TWO:
                result = mModel.getTabTwoList();
                break;
        }
        return result;
    }

    public void fabClicked() {
        mContext.updateReminderList(mModel.addReminder());
    }

    public void attachContext(MainActivity context) {
        mContext = context;
    }
}
