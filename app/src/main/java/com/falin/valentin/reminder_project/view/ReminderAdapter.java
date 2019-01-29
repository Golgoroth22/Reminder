package com.falin.valentin.reminder_project.view;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.falin.valentin.reminder_project.R;

import java.util.ArrayList;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {
    private List<String> mMainList;
    private List<String> mFullList;

    public ReminderAdapter(List<String> inputList) {
        mMainList = new ArrayList<>();
        mFullList = new ArrayList<>();
        mFullList.addAll(inputList);
        mMainList.addAll(inputList);
    }

    @Override
    public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_card, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReminderViewHolder holder, int position) {
        holder.reminderText.setText(mMainList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mMainList.size() != 0) return mMainList.size();
        return 0;
    }

    public void addReminder(String newReminder) {
        mMainList.add(newReminder);
        mFullList.add(newReminder);
        notifyItemInserted(mMainList.size());
    }

    public void searchReminderBy(String searchText) {
        List<String> mTempList = new ArrayList<>();

        for (String s : mFullList) {
            if (s.contains(searchText)) mTempList.add(s);
        }

        mMainList = mTempList;
        notifyDataSetChanged();
    }

    class ReminderViewHolder extends RecyclerView.ViewHolder {
        TextView reminderText;

        ReminderViewHolder(View itemView) {
            super(itemView);
            reminderText = itemView.findViewById(R.id.reminder_card_text);
        }
    }
}
