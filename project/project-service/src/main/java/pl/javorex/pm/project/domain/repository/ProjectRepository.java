package pl.javorex.pm.project.domain.repository;

import pl.javorex.pm.project.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);
    List<Project> findAll();
    Optional<Project> findProjectByID(String projectID);
}
