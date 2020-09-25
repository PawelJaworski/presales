package pl.javorex.pm.wbsdiagram.application.adapter;

import pl.javorex.pm.wbsdiagram.domain.model.Task;
import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;
import pl.javorex.pm.wbsdiagram.domain.repository.WbsDiagramRepository;

import java.util.*;
import java.util.stream.Collectors;

import static java.math.BigDecimal.valueOf;

public class WbsDiagramRepositoryInMemoryImpl implements WbsDiagramRepository {
    private static long currentTaskId = 1;
    private final Map<String, WbsDiagram> wbsDiagrams = new HashMap<>();

    public WbsDiagramRepositoryInMemoryImpl() {
        for (int i = 1; i < 2; ++i){
            WbsDiagram diagram = new WbsDiagram("" + i, "Project " + i);
            Task devTask = generateTask("Development");
            devTask.addTask( generateTask("Backend Dev", "BACKEND", "REST") );
            devTask.addTask( generateTask("Frontend Dev", "FRONTEND") );
            diagram.getRootTask()
                    .addTask(devTask);

            Task devopsTask = generateTask("Devops", "DEVOPS");
            diagram.getRootTask()
                    .addTask(devopsTask);
            devopsTask.addTask(generateTask("Local ENV"));
            devopsTask.addTask(generateTask("Local TEST"));
            devopsTask.addTask(generateTask("Local PROD"));
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

    private Task generateTask(String name, String... category) {
        Task task = new Task(name);
        task.assignId(currentTaskId++);
        task.estimate(valueOf(new Random().nextInt(100) + 1));
        Arrays.stream(category)
                .forEach( it -> task.assignToCategory(it) );

        return task;
    }
}
