package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.command.AddProjectCmd;
import pl.javorex.pm.project.domain.model.Project;

final class ProjectFactory {
    Project fromAddProjectCmd(AddProjectCmd cmd) {
        return new Project( cmd.getId(), cmd.getName(), cmd.getDescription() );
    }
}
