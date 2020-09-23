package pl.javorex.pm.wbs.diagram.application.api.response;

import java.util.List;

public interface WbsDiagramPresentationDto {
    String getName();
    List<TaskPresentationDto> getTasks();
}
