package pl.javorex.pm.project.application.adapter;

import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectRepositoryInMemoryImpl implements ProjectRepository {
    private final Map<String, Project> projects = new HashMap<>();

    public ProjectRepositoryInMemoryImpl() {
        for (int i = 1; i < 20; ++i){
            projects.put("" + i, new Project("" + i, "Projekt " + i, "Opis projektu " + i));
        }
    }
    @Override
    public Project save(Project project) {
        return projects.put(project.getId(), project);
    }

    @Override
    public List<Project> findAll() {
        return projects.values().stream()
                .sorted(Comparator.comparing(Project::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> findProjectByID(String projectID) {
        if (projects.containsKey(projectID)) {
            return Optional.of(projects.get(projectID));
        }

        return Optional.empty();
    }
}
