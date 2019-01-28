package com.falin.valentin.reminder_project;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

        mFAB.setOnClickListener( v -> mPresenter.addReminder());

        mLayoutManager = new LinearLayoutManager(this);
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
