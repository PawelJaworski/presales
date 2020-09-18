package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.ProjectCommandFacade;
import pl.javorex.pm.project.application.api.command.AddProjectCmd;
import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

import java.util.Optional;

class ProjectCommandFacadeImpl implements ProjectCommandFacade {
    private final ProjectRepository projectRepository;
    private final ProjectFactory projectFactory;

    ProjectCommandFacadeImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        this.projectFactory = new ProjectFactory();
    }

    @Override
    public void addProject(AddProjectCmd cmd) {
        String projectID = cmd.getId();
        Optional<Project> existingProject = projectRepository.findProjectByID(projectID);
        if (existingProject.isPresent()) {
            throw new IllegalStateException("Cannot add project with ID " + projectID + ". Already exists.");
        }

        Project newProject = projectFactory.fromAddProjectCmd(cmd);
        projectRepository.save( newProject );
    }
}
