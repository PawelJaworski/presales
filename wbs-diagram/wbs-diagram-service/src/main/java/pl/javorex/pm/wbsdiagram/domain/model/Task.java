package pl.javorex.pm.wbsdiagram.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class Task {
    private long id;
    private final String name;
    private List<String> categories = new ArrayList<>();
    private Optional<BigDecimal> estimation = Optional.empty();
    private final List<Task> children = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        children.add(task);
        categories.addAll(task.categories);
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

    public void estimate(BigDecimal estimation) {
        this.estimation = Optional.of(estimation);
    }

    public void assignToCategory(String category) {
        categories.add(category);
    }

    public List<String> getCategories() {
        return categories;
    }

    public Optional<BigDecimal> getEstimation() {
        return estimation;
    }
}
