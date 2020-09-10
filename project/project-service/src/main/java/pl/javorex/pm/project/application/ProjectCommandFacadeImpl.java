package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.ProjectCommandFacade;
import pl.javorex.pm.project.application.api.command.AddProjectCmd;
import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

import java.util.Optional;

class ProjectCommandFacadeImpl implements ProjectCommandFacade {
    private final ProjectRepository projectRepository;

    ProjectCommandFacadeImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void addProject(AddProjectCmd cmd) {
        String projectID = cmd.getId();
        Optional<Project> existing = projectRepository
                .findProjectByID(projectID);
        if (existing.isPresent()) {
            throw new IllegalStateException("Cannot add project with ID " + projectID + ". Already exists.");
        }

        Project newProject = new Project(
                cmd.getId(),
                cmd.getName(),
                cmd.getDescription()
        );
        projectRepository.save(newProject);
    }
}
