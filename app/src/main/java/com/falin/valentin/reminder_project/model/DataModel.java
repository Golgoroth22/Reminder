package com.falin.valentin.reminder_project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataModel {
    private static final DataModel ourInstance = new DataModel();

    private List<String> list;
    private Random random;

    public static DataModel getInstance() {
        return ourInstance;
    }

    private DataModel() {
        list = new ArrayList<>();
        random = new Random();
    }

    public List<String> getList() {
        return list;
    }

    public String addReminder() {
        String result = random.nextInt(100) + "";
        list.add(result);
        return result;
    }
}
