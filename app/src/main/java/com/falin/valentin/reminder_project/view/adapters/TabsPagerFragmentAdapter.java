package com.falin.valentin.reminder_project.view.adapters;

import com.falin.valentin.reminder_project.Constants;
import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.fragments.WarningFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constants.TAB_ONE:
                WarningFragment fragment = WarningFragment.newInstance(mPresenter);
                mPresenter.setCurrentFragmentId(Constants.TAB_ONE);
                mPresenter.setFragmentContext(fragment);
                return fragment;
            case Constants.TAB_TWO:
                return WarningFragment.newInstance(mPresenter);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }
}
