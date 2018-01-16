package com.samqkim.simplesync;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Todo>>{
    private TodoAdapter todoAdapter = null;
    private SubTaskAdapter subTaskAdapter= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            getLoaderManager().initLoader(0, null, this);
        }

        FloatingActionButton fab = findViewById(R.id.add_todo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTodo();
//                Snackbar.make(findViewById(R.id.todo_list),"hello",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void addTodo() {
        new AsyncTask<Void, Void, List<Todo>>() {
            @Override
            protected List<Todo> doInBackground(Void... voids) {
                return QueryUtils.extractTodo(true, null);
            }

            @Override
            protected void onPostExecute(List<Todo> todos) {
                super.onPostExecute(todos);
                updateUI(todos);
                Todo lastTodo = todos.get(todos.size()-1);
                Snackbar sb = Snackbar.make(findViewById(R.id.todo_list), "Added: " + lastTodo.getTitle(), Snackbar.LENGTH_SHORT);
                sb.setAction("undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // undo
                    }
                });
                sb.show();
            }
        }.execute();
    }

    @Override
    public Loader<List<Todo>> onCreateLoader(int id, Bundle args) {
        return new TodoLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Todo>> loader, List<Todo> data) {
        if(data.isEmpty()) {
            //no data view;
        }
        updateUI(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Todo>> loader) {
        updateUI(new ArrayList<Todo>());
    }

    private void updateUI(final List<Todo> listTodo) {
        final ListView todoList = findViewById(R.id.todo_list);
        if(todoAdapter == null) {
            todoAdapter = new TodoAdapter(this, listTodo);
        }
        todoList.setAdapter(todoAdapter);
        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Subtask Loader
                getLoaderManager().initLoader(1, null, new LoaderManager.LoaderCallbacks<List<SubTask>>() {
                    @Override
                    public Loader<List<SubTask>> onCreateLoader(int id, Bundle args) {
                        return new SubTaskLoader(MainActivity.this, "http://localhost:3000/api/todos/" + listTodo.get(position).getId() + "/sub_tasks");
                    }

                    @Override
                    public void onLoadFinished(Loader<List<SubTask>> loader, List<SubTask> data) {
                        if(subTaskAdapter == null) {
                            subTaskAdapter = new SubTaskAdapter(MainActivity.this, data);
                        }
                        ((ListView) findViewById(R.id.subtask_list)).setAdapter(subTaskAdapter);
                    }

                    @Override
                    public void onLoaderReset(Loader<List<SubTask>> loader) {
                        //null
                    }
                });
            }
        });

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();

                if(direction == (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)) {
                    todoAdapter.remove(todoAdapter.getItem(position));
                }
            }
        };

        ItemTouchHelper ith = new ItemTouchHelper(simpleCallback);
//        ith.attachToRecyclerView(listView);
    }
}
