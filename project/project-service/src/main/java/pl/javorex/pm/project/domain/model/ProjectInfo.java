package pl.javorex.pm.project.domain.model;

public final class ProjectInfo {
    private final String name;
    private final String description;

    public ProjectInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
