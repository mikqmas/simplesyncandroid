package com.samqkim.simplesync;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by samuel.kim on 1/12/18.
 */

public class TodoLoader extends AsyncTaskLoader<List<Todo>> {
    public TodoLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Todo> loadInBackground() {
        return QueryUtils.extractTodo(false,null);
    }
}
