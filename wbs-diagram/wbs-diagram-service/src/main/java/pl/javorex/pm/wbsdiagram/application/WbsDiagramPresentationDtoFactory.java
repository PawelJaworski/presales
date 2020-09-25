package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbsdiagram.application.response.TaskPresentationDto;
import pl.javorex.pm.wbsdiagram.application.response.WbsDiagramPresentationDto;
import pl.javorex.pm.wbsdiagram.domain.model.Task;
import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;

final class WbsDiagramPresentationDtoFactory {
    private final TaskPresentationDtoFactory taskDtoFactory = new TaskPresentationDtoFactory();

    WbsDiagramPresentationDto fromProject(WbsDiagram diagram) {
        Task rootTask = diagram.getRootTask();
        return new WbsDiagramPresentationDto() {
            @Override
            public String getProjectId() {
                return diagram.getProjectId();
            }

            @Override
            public String getName() {
                return rootTask.getName();
            }

             @Override
            public TaskPresentationDto getRootTask() {
                return taskDtoFactory
                        .fromTask( rootTask );
            }
        };
    }
}
