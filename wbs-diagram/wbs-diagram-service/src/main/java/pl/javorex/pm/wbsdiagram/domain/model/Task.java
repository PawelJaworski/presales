package pl.javorex.pm.wbsdiagram.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Task {
    private long id;
    private final String name;
    private final List<Task> children = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        children.add(task);
    }

    public String getName() {
        return name;
    }

    public List<Task> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void assignId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
