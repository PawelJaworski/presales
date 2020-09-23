package pl.javorex.pm.wbsdiagram.application;

import pl.javorex.pm.wbs.diagram.application.api.response.TaskPresentationDto;
import pl.javorex.pm.wbsdiagram.domain.model.Task;

import java.util.List;
import java.util.stream.Collectors;

final class TaskPresentationDtoFactory {
    List<TaskPresentationDto> fromTaskList(List<Task> tasks) {
        return tasks.stream()
                .map(this::fromTask)
                .collect(Collectors.toList());
    }
    TaskPresentationDto fromTask(Task task) {
        return new TaskPresentationDto() {
            @Override
            public long getId() {
                return task.getId();
            }

            @Override
            public String getName() {
                return task.getName();
            }

            @Override
            public List<TaskPresentationDto> getChildren() {
                return task.getChildren().stream()
                        .map(it -> fromTask(it))
                        .collect(Collectors.toList());
            }
        };
    }
}
