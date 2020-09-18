package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.ProjectQueryFacade;
import pl.javorex.pm.project.application.api.response.ProjectInfoDto;
import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

final class ProjectQueryFacadeImpl implements ProjectQueryFacade {
    private static final ProjectInfoDtoFactory PROJECT_INFO_DTO_MAPPER = new ProjectInfoDtoFactory();
    private final ProjectRepository projectRepository;

    public ProjectQueryFacadeImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<ProjectInfoDto> findProjectInfo(String projectID) {
        return projectRepository.findProjectByID(projectID)
                .map(Project::getInfo)
                .map(PROJECT_INFO_DTO_MAPPER::fromProjectInfo);
    }

    @Override
    public List<ProjectInfoDto> findAll() {
        return projectRepository.findAll().stream()
                .map(Project::getInfo)
                .map(PROJECT_INFO_DTO_MAPPER::fromProjectInfo)
                .collect(Collectors.toList());
    }
}
