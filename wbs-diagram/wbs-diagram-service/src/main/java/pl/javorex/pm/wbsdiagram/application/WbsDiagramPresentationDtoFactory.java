package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbs.diagram.application.api.response.TaskPresentationDto;
import pl.javorex.pm.wbs.diagram.application.api.response.WbsDiagramPresentationDto;
import pl.javorex.pm.wbsdiagram.domain.model.Task;
import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;

import java.util.List;

final class WbsDiagramPresentationDtoFactory {
    private final TaskPresentationDtoFactory taskDtoFactory = new TaskPresentationDtoFactory();

    WbsDiagramPresentationDto fromProject(WbsDiagram diagram) {
        Task taskDivision = diagram.getTaskDivision();
        return new WbsDiagramPresentationDto() {
            @Override
            public String getName() {
                return taskDivision.getName();
            }

            @Override
            public List<TaskPresentationDto> getTasks() {
                return taskDtoFactory
                        .fromTaskList( taskDivision.getChildren() );
            }
        };
    }
}
