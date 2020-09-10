package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.ProjectCommandFacade;
import pl.javorex.pm.project.application.api.ProjectQueryFacade;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

public final class ProjectServiceConfig {
    public final ProjectQueryFacade projectQueryFacade;
    public final ProjectCommandFacade projectCommandFacade;

    public ProjectServiceConfig(ProjectRepository projectRepository) {
        this.projectQueryFacade = new ProjectQueryFacadeImpl(projectRepository);
        this.projectCommandFacade = new ProjectCommandFacadeImpl(projectRepository);
    }
}
