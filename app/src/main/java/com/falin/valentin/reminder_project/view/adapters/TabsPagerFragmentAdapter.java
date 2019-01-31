package com.falin.valentin.reminder_project.view.adapters;

import com.falin.valentin.reminder_project.Constants;
import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.fragments.WarningFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {
    private int mCurrentFragmentId = 0;
    private Presenter mPresenter;
    private String[] mTabs;

    public TabsPagerFragmentAdapter(FragmentManager fm, Presenter presenter) {
        super(fm);
        mPresenter = presenter;
        mTabs = new String[]{
                "Tab 1",
                "Tab 2"
        };
    }

    public int getCurrentFragmentId() {
        return mCurrentFragmentId;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                mCurrentFragmentId = Constants.TAB_ONE;
                WarningFragment fragment = new WarningFragment();
                fragment.setArguments(mPresenter, mCurrentFragmentId);
                return fragment;
            case 1:
                mCurrentFragmentId = Constants.TAB_TWO;
                WarningFragment fragment1 = new WarningFragment();
                fragment1.setArguments(mPresenter, mCurrentFragmentId);
                return fragment1;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }
}
