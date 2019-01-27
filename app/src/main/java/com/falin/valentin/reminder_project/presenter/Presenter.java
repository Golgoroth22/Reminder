package com.falin.valentin.reminder_project.presenter;

import com.falin.valentin.reminder_project.MainActivity;
import com.falin.valentin.reminder_project.model.Model;

import java.util.List;
import java.util.Random;

public class Presenter {
    private Model mModel;
    private MainActivity mContext;

    public Presenter() {
        mModel = new Model();
    }

    public List<String> getModelList() {
        return mModel.getList();
    }

    public void addReminder() {
        mModel.getList().add(new Random().nextInt(6777) + "");
        mContext.updateReminderList();
    }

    public void attachContext(MainActivity context) {
        mContext = context;
    }
}
