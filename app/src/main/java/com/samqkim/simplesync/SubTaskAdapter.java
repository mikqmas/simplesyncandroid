package com.samqkim.simplesync;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by samuel.kim on 1/12/18.
 */

public class SubTaskAdapter extends ArrayAdapter<SubTask> {
    public SubTaskAdapter(@NonNull Context context, @NonNull List<SubTask> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View subTaskListView = convertView;
        if(subTaskListView == null) {
            subTaskListView = LayoutInflater.from(getContext()).inflate(R.layout.single_subtask, parent, false);
        }

        SubTask currSubTask = getItem(position);

        CheckedTextView bodyView = subTaskListView.findViewById(R.id.body);
        bodyView.setText(currSubTask.getBody());
        bodyView.setChecked(currSubTask.getDone());

        return subTaskListView;
    }
}
