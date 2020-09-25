package pl.javorex.pm.wbsdiagram.domain.model;

public final class WbsDiagram {
    private final String projectId;
    private final Task rootTask;

    public WbsDiagram(String projectId, String name) {
        this.projectId = projectId;
        this.rootTask = new Task(name);
    }

    public String getProjectId() {
        return projectId;
    }

    public Task getRootTask() {
        return rootTask;
    }
}
