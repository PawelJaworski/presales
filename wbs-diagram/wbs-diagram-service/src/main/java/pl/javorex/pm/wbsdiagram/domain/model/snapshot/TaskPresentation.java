package pl.javorex.pm.wbsdiagram.domain.model.snapshot;

import java.util.List;

public class TaskPresentation {
    private final String name;
    private final List<TaskPresentation> children;

    public TaskPresentation(String name, List<TaskPresentation> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public List<TaskPresentation> getChildren() {
        return children;
    }
}
