package com.samqkim.simplesync;

import java.util.List;

/**
 * Created by samuel.kim on 1/12/18.
 */

public class SubTask {
    private String body;
    private Boolean done;

    SubTask(String body, Boolean done) {
        this.body = body;
        this.done = done;
    }

    public String getBody() {
        return body;
    }

    public Boolean getDone() {
        return done;
    }
}
