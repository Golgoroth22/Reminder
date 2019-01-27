package com.falin.valentin.reminder_project.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.falin.valentin.reminder_project.R;

import java.util.ArrayList;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {
    private List<String> mList;

    public ReminderAdapter(List<String> modelList) {
        mList = new ArrayList<>();
        mList.addAll(modelList);
    }

    @Override
    public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_card, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReminderViewHolder holder, int position) {
        holder.reminderText.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mList.size() != 0) return mList.size();
        return 0;
    }

    public void updateList(List<String> modelList) {
        mList = new ArrayList<>();
        mList.addAll(modelList);
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
