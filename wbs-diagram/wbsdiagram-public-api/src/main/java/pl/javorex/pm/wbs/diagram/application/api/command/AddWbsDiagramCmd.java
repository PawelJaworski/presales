package pl.javorex.pm.wbs.diagram.application.api.command;

public class AddWbsDiagramCmd {
    private final String projectId;
    private final String name;

    public AddWbsDiagramCmd(String projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }
}
