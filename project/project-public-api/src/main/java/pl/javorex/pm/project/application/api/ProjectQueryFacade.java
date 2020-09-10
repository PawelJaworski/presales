package pl.javorex.pm.project.application.api;

import pl.javorex.pm.project.application.api.response.ProjectInfoDto;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryFacade {
    Optional<ProjectInfoDto> findProjectInfo(String projectID);

    List<ProjectInfoDto> findAll();
}
