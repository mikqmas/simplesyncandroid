package com.samqkim.simplesync;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by samuel.kim on 1/12/18.
 */

public class SubTaskLoader extends AsyncTaskLoader<List<SubTask>> {
    private String urlString;

    public SubTaskLoader(Context context, String url) {
        super(context);
        urlString = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<SubTask> loadInBackground() {
        return QueryUtils.extractSubtasks(urlString);
    }
}
