package pl.javorex.pm.wbs.diagram.application.api;

import pl.javorex.pm.wbs.diagram.application.api.response.WbsDiagramPresentationDto;

import java.util.List;
import java.util.Optional;

public interface WbsDiagramQueryFacade {
    Optional<WbsDiagramPresentationDto> findDiagramByProjectId(String projectId);

    List<WbsDiagramPresentationDto> findAll();
}
