package com.samqkim.simplesync;

import java.util.List;

/**
 * Created by samuel.kim on 1/11/18.
 */

public class Todo {
    private int id;
    private String title;
    private User owner;
    private Boolean done;
    private List<User> team;
    private List<SubTask> subTasks;

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }

    public List<User> getTeam() {
        return team;
    }

    public Boolean getDone() {
        return done;
    }

    public int getId() {
        return id;
    }

    Todo(int id, String title, User owner, List<User> team, Boolean done) {
        this.title = title;
        this.owner = owner;
        this.team = team;
        this.id = id;
        this.done = done;
//        this.subTasks = subTasks;
    }
}
