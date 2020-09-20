package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.ProjectQueryFacade;
import pl.javorex.pm.project.application.api.response.ProjectInfoDto;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

final class ProjectQueryFacadeImpl implements ProjectQueryFacade {
    private final ProjectInfoDtoFactory projectInfoDtoMapper = new ProjectInfoDtoFactory();
    private final ProjectRepository projectRepository;

    public ProjectQueryFacadeImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<ProjectInfoDto> findProjectInfo(String projectID) {
        return projectRepository.findProjectByID(projectID)
                .map(projectInfoDtoMapper::fromProject);
    }

    @Override
    public List<ProjectInfoDto> findAll() {
        return projectRepository.findAll().stream()
                .map(projectInfoDtoMapper::fromProject)
                .collect(Collectors.toList());
    }
}
