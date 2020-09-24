package pl.javorex.pm.project.application.api;

import pl.javorex.pm.project.application.command.AddProjectCmd;

public interface ProjectCommandFacade {
    void addProject(AddProjectCmd cmd);
}
