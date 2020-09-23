package pl.javorex.pm.wbsdiagram.application.rest;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import pl.javorex.pm.wbs.diagram.application.api.WbsDiagramQueryFacade;
import pl.javorex.pm.wbs.diagram.application.api.response.WbsDiagramPresentationDto;

import java.util.List;
import java.util.Optional;

@Controller("/wbsDiagrams")
public class ProjectController implements WbsDiagramQueryFacade {
    private final WbsDiagramQueryFacade queryFacade;

    ProjectController(WbsDiagramQueryFacade queryFacade) {
        this.queryFacade = queryFacade;
    }

    @Override
    public Optional<WbsDiagramPresentationDto> findDiagramByProjectId(String projectId) {
        return queryFacade.findDiagramByProjectId(projectId);
    }

    @Get
    @Override
    public List<WbsDiagramPresentationDto> findAll() {
        return queryFacade.findAll();
    }
}
