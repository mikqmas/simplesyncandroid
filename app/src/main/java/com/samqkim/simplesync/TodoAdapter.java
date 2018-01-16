package com.samqkim.simplesync;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by samuel.kim on 1/12/18.
 */

public class TodoAdapter extends ArrayAdapter<Todo> {
    private SubTaskAdapter subTaskAdapter = null;

    public TodoAdapter(@NonNull Context context, @NonNull List<Todo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View todoListView = convertView;
        if(todoListView == null) {
            todoListView = LayoutInflater.from(getContext()).inflate(R.layout.single_todo, parent, false);
        }

        Todo currentTodo = getItem(position);

        CheckedTextView todo = todoListView.findViewById(R.id.title);
        todo.setText(currentTodo.getTitle());
        todo.setChecked(currentTodo.getDone());
        ((TextView) todoListView.findViewById(R.id.owner)).setText(currentTodo.getOwner().getUsername());

        return todoListView;
    }
}
