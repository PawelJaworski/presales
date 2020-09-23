package pl.javorex.pm.wbsdiagram.domain.repository;

import pl.javorex.pm.wbsdiagram.domain.model.WbsDiagram;

import java.util.List;
import java.util.Optional;

public interface WbsDiagramRepository {
    WbsDiagram save(WbsDiagram project);
    List<WbsDiagram> findAll();
    Optional<WbsDiagram> findWbsDiagramByID(String projectID);
}
