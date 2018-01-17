package com.samqkim.simplesync;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by samuel.kim on 1/12/18.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Todo> mTodoList;
    private static Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleView;
        public TextView mOwnerView;
        public LinearLayout mSingleTodo;

        public ViewHolder(View v) {
            super(v);
            mTitleView = v.findViewById(R.id.title);
            mOwnerView = v.findViewById(R.id.owner);
            mSingleTodo = v.findViewById(R.id.single_todo);
        }
    }

    public TodoAdapter(@NonNull Context context, @NonNull List<Todo> objects) {
        mTodoList = objects;
        mContext = context;
    }

    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_todo, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TodoAdapter.ViewHolder holder, int position) {
        final Todo mTodo = mTodoList.get(position);

        holder.mTitleView.setText(mTodoList.get(position).getTitle());
        holder.mOwnerView.setText(mTodoList.get(position).getOwner().getUsername());

        holder.mSingleTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, (mTodo.getTitle() + " is clicked"), Snackbar.LENGTH_SHORT).show();



////                Subtask Loader
//                getLoaderManager().initLoader(1, null, new LoaderManager.LoaderCallbacks<List<SubTask>>() {
//                    @Override
//                    public Loader<List<SubTask>> onCreateLoader(int id, Bundle args) {
//                        return new SubTaskLoader(MainActivity.this, "http://localhost:3000/api/todos/" + listTodo.get(position).getId() + "/sub_tasks");
//                    }
//
//                    @Override
//                    public void onLoadFinished(Loader<List<SubTask>> loader, List<SubTask> data) {
//                        if (subTaskAdapter == null) {
//                            subTaskAdapter = new SubTaskAdapter(MainActivity.this, data);
//                        }
//                        ((ListView) findViewById(R.id.subtask_list)).setAdapter(subTaskAdapter);
//                    }
//
//                    @Override
//                    public void onLoaderReset(Loader<List<SubTask>> loader) {
//                        //null
//                    }
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

//    private SubTaskAdapter subTaskAdapter = null;
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View todoListView = convertView;
//        if(todoListView == null) {
//            todoListView = LayoutInflater.from(getContext()).inflate(R.layout.single_todo, parent, false);
//        }
//
//        Todo currentTodo = getItem(position);
//
//        CheckedTextView todo = todoListView.findViewById(R.id.title);
//        todo.setText(currentTodo.getTitle());
//        todo.setChecked(currentTodo.getDone());
//        ((TextView) todoListView.findViewById(R.id.owner)).setText(currentTodo.getOwner().getUsername());
//
//        return todoListView;
//    }
}
