package com.falin.valentin.reminder_project.presenter;

import com.falin.valentin.reminder_project.MainActivity;
import com.falin.valentin.reminder_project.model.DataModel;

import java.util.List;

public class Presenter {
    private DataModel mModel;
    private MainActivity mContext;

    public Presenter() {
        mModel = DataModel.getInstance();
    }

    public List<String> getModelList() {
        return mModel.getList();
    }

    public void fabClicked() {
        mContext.updateReminderList(mModel.addReminder());
    }

    public void attachContext(MainActivity context) {
        mContext = context;
    }
}
