package pl.javorex.pm.wbsdiagram.application.rest;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import pl.javorex.pm.wbsdiagram.application.api.WbsDiagramQueryFacade;
import pl.javorex.pm.wbsdiagram.application.response.WbsDiagramPresentationDto;

import java.util.List;
import java.util.Optional;

@Controller("/wbsDiagrams")
public class WbsDiagramController {
    private final WbsDiagramQueryFacade queryFacade;

    WbsDiagramController(WbsDiagramQueryFacade queryFacade) {
        this.queryFacade = queryFacade;
    }

    @Get("/{diagramId}")
    public Optional<WbsDiagramPresentationDto> findDiagramByProjectId(@PathVariable String diagramId) {
        return queryFacade.findDiagramByProjectId(diagramId);
    }

    @Get
    public List<WbsDiagramPresentationDto> findAll() {
        return queryFacade.findAll();
    }
}
