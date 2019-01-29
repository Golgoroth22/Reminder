package com.falin.valentin.reminder_project;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.ReminderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Presenter mPresenter;

    ReminderAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFAB;
    @BindView(R.id.content_recycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new Presenter();
        mPresenter.attachContext(this);
        initUIComponents();
    }

    private void initUIComponents() {
        setSupportActionBar(mToolbar);

        mFAB.setOnClickListener(v -> mPresenter.fabClicked());

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ReminderAdapter(mPresenter.getModelList());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void updateReminderList(String newReminder) {
        mAdapter.addReminder(newReminder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.searchReminderBy(newText);
                return false;
            }
        });
        return true;
    }
}
