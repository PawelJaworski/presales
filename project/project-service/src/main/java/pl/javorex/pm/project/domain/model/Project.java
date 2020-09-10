package pl.javorex.pm.project.domain.model;

public final class Project {
    private final String id;
    private final ProjectInfo info;

    public Project(String id, String name, String description) {
        this.id = id;
        this.info = new ProjectInfo(name, description);
    }

    public ProjectInfo getInfo() {
        return info;
    }

    public String getId() {
        return id;
    }
}
