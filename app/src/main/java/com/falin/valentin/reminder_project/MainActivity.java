package com.falin.valentin.reminder_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.falin.valentin.reminder_project.presenter.Presenter;
import com.falin.valentin.reminder_project.view.ReminderAdapter;

public class MainActivity extends AppCompatActivity {
    private Presenter mPresenter;

    ReminderAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new Presenter();
        mPresenter.attachContext(this);
        initUIComponents();
    }

    private void initUIComponents() {
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        FloatingActionButton mFAB = findViewById(R.id.fab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addReminder();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        mLayoutManager = new LinearLayoutManager(this);
        RecyclerView mRecyclerView = findViewById(R.id.content_recycler);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ReminderAdapter(mPresenter.getModelList());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void updateReminderList() {
        int size = mPresenter.getModelList().size();
        mAdapter.updateList(mPresenter.getModelList().get(size - 1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Toast.makeText(this, "SEARCH", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
