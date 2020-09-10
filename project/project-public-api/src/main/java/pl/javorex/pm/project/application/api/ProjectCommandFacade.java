package pl.javorex.pm.project.application.api;

import pl.javorex.pm.project.application.api.command.AddProjectCmd;

public interface ProjectCommandFacade {
    void addProject(AddProjectCmd cmd);
}
