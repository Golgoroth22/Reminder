package com.falin.valentin.reminder_project.presenter;

import com.falin.valentin.reminder_project.MainActivity;
import com.falin.valentin.reminder_project.model.DataModel;
import com.falin.valentin.reminder_project.model.Model;

import java.util.List;
import java.util.Random;

public class Presenter {
    private DataModel mModel;
    private MainActivity mContext;

    public Presenter() {
        mModel = DataModel.getInstance();
    }

    public List<String> getModelList() {
        return mModel.getList();
    }

    public void addReminder() {
        mModel.addReminder();
        mContext.updateReminderList();
    }

    public void attachContext(MainActivity context) {
        mContext = context;
    }
}
