package pl.javorex.pm.wbs.diagram.application.api.response;

import java.util.List;

public interface TaskPresentationDto {
    long getId();
    String getName();
    List<TaskPresentationDto> getChildren();
}
