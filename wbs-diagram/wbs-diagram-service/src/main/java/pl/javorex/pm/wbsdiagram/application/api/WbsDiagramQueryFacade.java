package pl.javorex.pm.wbsdiagram.application.api;

import pl.javorex.pm.wbsdiagram.application.response.WbsDiagramPresentationDto;

import java.util.List;
import java.util.Optional;

public interface WbsDiagramQueryFacade {
    Optional<WbsDiagramPresentationDto> findDiagramByProjectId(String projectId);

    List<WbsDiagramPresentationDto> findAll();
}
