package com.falin.valentin.reminder_project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataModel {
    private static final DataModel ourInstance = new DataModel();

    private List<String> mTabOnelist;
    private List<String> mTabTwoList;
    private Random random;

    public static DataModel getInstance() {
        return ourInstance;
    }

    private DataModel() {
        mTabOnelist = new ArrayList<>();
        mTabOnelist.add("11");
        mTabTwoList = new ArrayList<>();
        mTabTwoList.add("22");
        random = new Random();
    }

    public List<String> getTabOnelist() {
        return mTabOnelist;
    }

    public List<String> getTabTwoList() {
        return mTabTwoList;
    }

    public String addReminder() {
        String result = random.nextInt(100) + "";
        mTabOnelist.add(result);
        return result;
    }
}
