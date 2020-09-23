package pl.javorex.pm.wbsdiagram.application.adapter;

import pl.javorex.pm.wbsdiagram.domain.model.Task;
import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;
import pl.javorex.pm.wbsdiagram.domain.repository.WbsDiagramRepository;

import java.util.*;
import java.util.stream.Collectors;

public class WbsDiagramRepositoryInMemoryImpl implements WbsDiagramRepository {
    private static long currentTaskId = 1;
    private final Map<String, WbsDiagram> wbsDiagrams = new HashMap<>();

    public WbsDiagramRepositoryInMemoryImpl() {
        for (int i = 1; i < 20; ++i){
            WbsDiagram diagram = new WbsDiagram("" + i, "Project " + i);
            Task subtask1 = new Task("Subtask 1 of " + i);
            subtask1.assignId(currentTaskId++);
            diagram.getTaskDivision()
                    .addTask(subtask1);

            Task subtask2 = new Task("Subtask 2 of " + i);
            subtask2.assignId(currentTaskId++);
            diagram.getTaskDivision()
                    .addTask(subtask2);
            wbsDiagrams.put("" + i, diagram);
        }
    }

    @Override
    public WbsDiagram save(WbsDiagram project) {
        return wbsDiagrams.put(project.getProjectId(), project);
    }

    @Override
    public List<WbsDiagram> findAll() {
        return wbsDiagrams.values().stream()
                .sorted(Comparator.comparing(WbsDiagram::getProjectId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WbsDiagram> findWbsDiagramByID(String projectID) {
        if (wbsDiagrams.containsKey(projectID)) {
            return Optional.of(wbsDiagrams.get(projectID));
        }

        return Optional.empty();
    }
}
