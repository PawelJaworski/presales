package pl.javorex.pm.wbsdiagram.domain.model;

public final class WbsDiagram {
    private final String projectId;
    private final Task taskDivision;

    public WbsDiagram(String projectId, String name) {
        this.projectId = projectId;
        this.taskDivision = new Task(name);
    }

    public String getProjectId() {
        return projectId;
    }

    public Task getTaskDivision() {
        return taskDivision;
    }
}
